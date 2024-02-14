package org.example.calculator.calculate;

import org.example.calculator.PositiveNumber;

public class AdditionOperator implements InterfaceArithmeticOperator {
    @Override
    public boolean IsSupports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();
    }
}
