package com.recreate.tibco.runtime.demo.utils;

public class ExpressionUtil {

    private static final String GREATER_THAN = "greaterthan";

    private static final String ADDITION = "plus";

    public static Object executeUnaryExpression(String operator, Object operand) {
        return operand;
    }

    public static Object executeBinaryExpression(Object leftOperand, String operator, Object rightOperand) {
        if (GREATER_THAN.equals(operator)) { // Assuming operands are integer
            return (int) leftOperand > (int) rightOperand;
        } else if (ADDITION.equals(operator)) {
            return (int) leftOperand + (int) rightOperand;
        }
        return rightOperand;
    }
}
