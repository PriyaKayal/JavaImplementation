package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Expression;
import com.recreate.tibco.runtime.demo.utils.ExpressionUtil;

public class UnaryExpression implements Expression {
    private Expression operand;
    private String operator;

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public Object getResult() throws Exception {
        return ExpressionUtil.executeUnaryExpression(operator, operand.getResult());
    }
}
