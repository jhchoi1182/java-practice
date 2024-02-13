package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;


public class PasswordValidatorTest {
    @DisplayName("하드 코딩한 비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"password", "testpassword"})
    void validatePasswordTest(String value) {
        PasswordValidator passwordValidator = new PasswordValidator();

        assertThatCode(() -> passwordValidator.validatePassword(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("하드 코딩한 비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"assword", "testpassword1"})
    void validatePasswordTest2(String value) {
        PasswordValidator passwordValidator = new PasswordValidator();

        assertThatCode(() -> passwordValidator.validatePassword(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

    @DisplayName("자동 생성된 비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest2() {
        PasswordValidator passwordValidator = new PasswordValidator();

        assertThatCode(() -> passwordValidator.validateGeneratedPassword(new CorrectPasswordGenerator()))
                .doesNotThrowAnyException();
    }


    @DisplayName("자동 생성된 비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    void validatePasswordTest3() {
        PasswordValidator passwordValidator = new PasswordValidator();

        assertThatCode(() -> passwordValidator.validateGeneratedPassword(new WrongPasswordGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
