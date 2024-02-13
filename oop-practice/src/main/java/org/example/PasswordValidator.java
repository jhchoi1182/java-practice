package org.example;

public class PasswordValidator {
    public void validatePassword(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
        }
    }

    public void validateGeneratedPassword(PasswordGeneratePolicy passwordGeneratePolicy) {
        String password = passwordGeneratePolicy.generatePassword();

        int length = password.length();
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
        }
    }

}
