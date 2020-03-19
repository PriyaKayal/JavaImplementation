package com.recreate.tibco.runtime.demo.model.runnable;

import com.recreate.tibco.runtime.demo.model.configuration.Transition;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessFlow {
    private boolean processStarted;

    private Map<String, List<Transition>> flow;

    public String next(String currentProcess, Object processState) {
        // TODO : Process condition
        if (currentProcess == null) { // Start of process
            return flow.get("Start").get(0).getToActivity();
        }
        String next;
        List<Transition> transitions = flow.get(currentProcess);
        if (transitions.size() > 1) {
            Transition defaultTransition = transitions.stream().filter(transition -> transition.getCondition() == null).collect(Collectors.toList()).get(0);
            List<Transition> conditionalTransitions = transitions.stream()
                    .filter(transition -> {
                        if (transition.getCondition() != null) {
                            Object result = null;
                            try {
                              result = transition.getCondition().getResult();
                            } catch (Exception ex) {

                            }
                            return result != null && (boolean) result;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            if (conditionalTransitions.size() > 0) {
                next = conditionalTransitions.get(0).getToActivity();
            } else {
                next = defaultTransition.getToActivity();
            }
        } else {
            next = transitions.get(0).getToActivity();
        }
        return next.equals("End") ? null : next;
    }

    public static ProcessFlow newProcess(List<Transition> transitions) {
        ProcessFlow processFlow = new ProcessFlow();
        processFlow.flow = transitions.stream().collect(Collectors.groupingBy(
                Transition::getFromActivity,
                Collectors.mapping(
                        Transition::getTransition,
                        Collectors.toList()
                )
        ));
        return processFlow;
    }
}
