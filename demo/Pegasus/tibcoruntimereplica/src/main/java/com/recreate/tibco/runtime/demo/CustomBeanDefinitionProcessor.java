package com.recreate.tibco.runtime.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.recreate.tibco.runtime.demo.constants.ResourceTypes;
import com.recreate.tibco.runtime.demo.model.configuration.ComplexElement;
import com.recreate.tibco.runtime.demo.model.configuration.JDBCActivityConfig;
import com.recreate.tibco.runtime.demo.model.configuration.JDBCResourceConfig;
import com.recreate.tibco.runtime.demo.model.configuration.JDBCSelectActivityConfig;
import com.recreate.tibco.runtime.demo.model.configuration.JDBCUpdateActivityConfig;
import com.recreate.tibco.runtime.demo.model.configuration.LogActivityConfig;
import com.recreate.tibco.runtime.demo.model.configuration.SchemaResourcesConfig;
import com.recreate.tibco.runtime.demo.model.configuration.SharedVariableConfig;
import com.recreate.tibco.runtime.demo.model.configuration.TibcoRuntimeInput;
import com.recreate.tibco.runtime.demo.model.interfaces.Element;
import com.recreate.tibco.runtime.demo.model.interfaces.RunnableActivity;
import com.recreate.tibco.runtime.demo.model.runnable.DefaultVariable;
import com.recreate.tibco.runtime.demo.model.runnable.JDBCDataSource;
import com.recreate.tibco.runtime.demo.model.runnable.JDBCSelectActivity;
import com.recreate.tibco.runtime.demo.model.runnable.JDBCUpdateActivity;
import com.recreate.tibco.runtime.demo.model.runnable.LogActivity;
import com.recreate.tibco.runtime.demo.model.runnable.Process;
import com.recreate.tibco.runtime.demo.model.runnable.ProcessFlow;
import com.recreate.tibco.runtime.demo.model.runnable.SchemaResource;
import com.recreate.tibco.runtime.demo.model.runnable.SharedVariable;
import com.recreate.tibco.runtime.demo.utils.ResourceDependencyUtil;

public class CustomBeanDefinitionProcessor implements BeanDefinitionRegistryPostProcessor {

	private static final Logger logger = Logger.getLogger(CustomBeanDefinitionProcessor.class.getName());

	private TibcoRuntimeInput runtimeInput = new TibcoRuntimeInput();

	private class RegistryBeans {
		public String name;
		public BeanDefinition beanDefinition;

		public RegistryBeans(String name, BeanDefinition beanDefinition) {
			this.name = name;
			this.beanDefinition = beanDefinition;
		}
	}

	private List<RegistryBeans> generateDefaultVariableBeans() {
		return runtimeInput.getDefaultVariableConfigs().stream().map(defaultVariableConfig -> {
			BeanDefinition dynamicBean = BeanDefinitionBuilder.rootBeanDefinition(DefaultVariable.class) // here you
																											// define
																											// the class
					.addPropertyValue("value", defaultVariableConfig.getValue())
					// you can set factory method, constructor args using other methods of this
					// builder
					.getBeanDefinition();
			return new RegistryBeans(defaultVariableConfig.getAccessor(), dynamicBean);
		}).collect(Collectors.toList());
	}

	private List<RegistryBeans> generateSharedResources() {
		return runtimeInput.getResources().stream().map(sharedResource -> {
			if (sharedResource.getResourceType().equals(ResourceTypes.JDBC_RESOURCE)) {
				JDBCResourceConfig configuration = (JDBCResourceConfig) sharedResource;
				BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
						.rootBeanDefinition(JDBCDataSource.class);
				// TODO : Refactor Logic
				// TODO : Mark config match annotations inside pojo to establish relationship
				// between JDBCResourceConfig and JDBCDataSource objects
				ResourceDependencyUtil.addPropertyBinding(beanDefinitionBuilder, "driver", configuration.getDriver());
				ResourceDependencyUtil.addPropertyBinding(beanDefinitionBuilder, "jdbcUrl",
						configuration.getLocation());
				ResourceDependencyUtil.addPropertyBinding(beanDefinitionBuilder, "username", configuration.getUser());
				ResourceDependencyUtil.addPropertyBinding(beanDefinitionBuilder, "password",
						configuration.getPassword());
				return new RegistryBeans(sharedResource.getName(), beanDefinitionBuilder.getBeanDefinition());
			} else if (sharedResource.getResourceType().equals(ResourceTypes.SHARED_VARIABLE_RESOURCE)) {
				SharedVariableConfig config = (SharedVariableConfig) sharedResource;
				BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
						.rootBeanDefinition(SharedVariable.class);
				Element sharedElement = config.getSharedElement();
				// Under an assumption that all shared elements are complex
				HashMap<String, Element> map = (HashMap<String, Element>) sharedElement.getValue();
				for (Map.Entry<String, Object> entry : config.getInitialValues().entrySet()) {
					map.get(entry.getKey()).setValue(entry.getValue());
				}
				beanDefinitionBuilder.addPropertyValue("value", sharedElement);
				return new RegistryBeans(sharedResource.getName(), beanDefinitionBuilder.getBeanDefinition());
			} else if (sharedResource.getResourceType().equals(ResourceTypes.SCHEMA_RESOURCE)) {
				SchemaResourcesConfig config = (SchemaResourcesConfig) sharedResource;
				BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
						.rootBeanDefinition(SchemaResource.class);
				beanDefinitionBuilder.addPropertyValue("schema", config.getConfig());
				// TODO : Check is Repeated Simple element definition in schedule is not useful,
				// change in one affects all other keys?
				logger.info("Trying to get the element value of xmlSchema "
						+ ((ComplexElement) ((ComplexElement) config.getConfig()).getValueForKey("Body"))
								.getValueForKey("Schedule"));
				return new RegistryBeans(sharedResource.getName(), beanDefinitionBuilder.getBeanDefinition());
			}
			return null;
		}).collect(Collectors.toList());
	}

	private List<RegistryBeans> generateProcesses() {
		return runtimeInput.getProcesses().stream().map(processConfig -> {
			BeanGenerator generator = new BeanGenerator();
			generator.setSuperclass(Process.class);
			generator.addProperty("dataSource", JDBCDataSource.class);
			Class ProcessDefinition = (Class) generator.createClass();
			for (final Method method : ProcessDefinition.getDeclaredMethods()) {
				logger.info("Method in process :: " + method);
			}
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.genericBeanDefinition(ProcessDefinition);
			beanDefinitionBuilder.addPropertyValue("name", processConfig.getName());
			beanDefinitionBuilder.addPropertyValue("processFlow",
					ProcessFlow.newProcess(processConfig.getTransitions()));
			HashMap<String, RunnableActivity> activityMap = new HashMap<>();
			processConfig.getActivities().forEach((s, activity) -> {
				if (activity instanceof JDBCSelectActivityConfig) {
					JDBCActivityConfig activityConfig = (JDBCActivityConfig) activity.getConfig();
					JDBCSelectActivity selectActivity = new JDBCSelectActivity();
					selectActivity.setOutputType(activityConfig.getOutputClass().getClassDefinition());
					selectActivity.setSelectQuery(activityConfig.getStatement());
					selectActivity.setParams(activityConfig.getPreparedParams());
					for (final Method method : selectActivity.getOutputType().getDeclaredMethods()) {
						logger.info("Method :: " + method);
					}
					beanDefinitionBuilder.addPropertyReference("dataSource", activityConfig.getDataSourceLink());
					activityMap.put(s, selectActivity);
				}

				else if (activity instanceof JDBCUpdateActivityConfig) {
					JDBCActivityConfig activityConfig = (JDBCActivityConfig) activity.getConfig();
					JDBCUpdateActivity updateActivity = new JDBCUpdateActivity();
					updateActivity.setInsertQuery(activityConfig.getStatement());
					updateActivity.setParams(activityConfig.getPreparedParams());
					beanDefinitionBuilder.addPropertyReference("dataSource", activityConfig.getDataSourceLink());
					activityMap.put(s, updateActivity);
				} 
				else if (activity instanceof LogActivityConfig) {
					LogActivityConfig activityConfig = (LogActivityConfig) activity.getConfig();
					LogActivity logActivity = new LogActivity();
					activityMap.put(s, logActivity);
				}

			});

			beanDefinitionBuilder.addPropertyValue("activityMap", activityMap);
			return new RegistryBeans(processConfig.getName(), beanDefinitionBuilder.getBeanDefinition());
		}).collect(Collectors.toList());
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		ApplicationContext runtimeContext = new ClassPathXmlApplicationContext("RuntimeInputBean.xml");
		runtimeInput = (TibcoRuntimeInput) runtimeContext.getBean("runtimeInput");
		// here you can fire your logic to get definition for your beans at runtime and
		// then register all beans you need (possibly inside a loop)
		// Arrays.asList(registry.getBeanDefinitionNames()).forEach(logger::info);

		List<RegistryBeans> registryBeans = generateDefaultVariableBeans();
		registryBeans.addAll(generateSharedResources());
		registryBeans.addAll(generateProcesses());

		registryBeans.forEach(registryBean -> {
			registry.registerBeanDefinition(registryBean.name, registryBean.beanDefinition);
		});
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
