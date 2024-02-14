package org.example.calculator;

import java.util.Arrays;

public enum EnumArithmeticOperator {
    // enum을 통해 연산 상수를 정의
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            if (operand2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return operand1 / operand2;
        }
    };

    // enum 내에 선언된 상수가 생성자를 통해 초기화되면서 operatorSymbol 필드에 값을 할당
    private final String operatorSymbol;
    // 열거형의 생성자는 항상 private으로 선언되며, 그렇기에 명시적으로 적을 필요가 없다.
    EnumArithmeticOperator(String operator) {
        this.operatorSymbol = operator;
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(final int operand1, final String operator, final int operand2) {
        // values()는 enum에 내장된 정적 메서드로 해당 열거형의 모든 상수를 포함하는 배열을 반환함
        EnumArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operatorSymbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }

}
