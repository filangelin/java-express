package org.example.practice12.Task2;

import java.util.regex.Pattern;

public class UserValidator {
    public static boolean validationEnabled = true;
    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$";

    public void validate(User user) {
        if (validationEnabled) {
            validateName(user.getName());
            validateAge(user.getAge());
            validateEmail(user.getEmail());
        }
    }

    private void validateEmail(String email) {
        if (!Pattern.compile(EMAIL_PATTERN)
                .matcher(email)
                .matches())
            throw new InvalidUserException("Email должен соответствовать стандартному формату электронной почты!");

    }

    private void validateAge(int age) {
        if (age < 18 || age > 100) throw new InvalidUserException("озраст должен быть в пределах от 18 до 100 лет!");
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) throw new InvalidUserException("Имя не должно быть пустым!");
        String fistSymbol = ((Character)name.charAt(0)).toString();
        if (fistSymbol.toLowerCase().equals(fistSymbol))
            throw new InvalidUserException("Имя должно начинаться с большой буквы!");
    }
}
