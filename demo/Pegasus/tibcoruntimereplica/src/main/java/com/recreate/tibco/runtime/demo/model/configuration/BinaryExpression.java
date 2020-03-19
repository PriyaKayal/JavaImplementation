package com.recreate.tibco.runtime.demo.model.configuration;

import com.recreate.tibco.runtime.demo.model.interfaces.Expression;
import com.recreate.tibco.runtime.demo.utils.ExpressionUtil;

public class BinaryExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;
    private String operator;

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public Object getResult() throws Exception {
        return ExpressionUtil.executeBinaryExpression(leftOperand.getResult(), operator, rightOperand.getResult());
    }
}
