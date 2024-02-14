package org.example.calculator.calculate;

import org.example.calculator.PositiveNumber;

public interface InterfaceArithmeticOperator {

    boolean IsSupports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);

}
