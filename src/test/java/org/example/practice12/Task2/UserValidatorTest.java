package org.example.practice12.Task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.example.practice12.Task2.UserValidator.validationEnabled;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator validator;

    @BeforeEach
    public void setup() {
        validator = new UserValidator();
        validationEnabled = true;
    }


    @Test
    @DisplayName("Все требования удовлетворены и validator enabled")
    public void shouldSuccessfullyValidateValidUserWithEnabledValidation() {
        User user = new User("Anna", 25, "anna17@gmail.com");
        assertDoesNotThrow(() -> validator.validate(user), "Исключение у пользователя  с валидными полями!");
    }


    @ParameterizedTest
    @ValueSource(strings = {
            //пустое имя
            "",
            //имя с маленькой буквы
            "anna"})
    public void shouldThrowExceptionWithInvalidName(String name) {
        User user = new User(name, 25, "anna17@gmail.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user), "Не вызвалось исключение с невалидным именем " + name);
    }

   @Test
    public void shouldThrowExceptionWithNullName() {
        User user = new User(null, 25, "anna17@gmail.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user), "Не вызвалось исключение с именем null");
    }

    @ParameterizedTest
    @ValueSource(ints = {
            //нижняя граница
            18,
            //верхняяграница
            100})
    public void shouldNotThrowExceptionWithValidAge(int age) {
        User user = new User("Anna", age, "anna17@gmail.com");
        assertDoesNotThrow(() -> validator.validate(user), "Исключение у пользователя  с валидным возрастом " + age);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            //меньше на 1 от нижней границы
            17,
            //больше на 1 от верхней границы
            101})
    public void shouldThrowExceptionWithInvalidAge(int age) {
        User user = new User("Anna", age, "anna17@gmail.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user), "Не вызвалось исключение с невалидным возрастом " + age);
    }

    @Test
    public void shouldThrowExceptionWithInvalidEmail() {
        User user = new User("Anna", 25, "anna17gmail.com");
        assertThrows(InvalidUserException.class, () -> validator.validate(user), "Не вызвалось исключение с невалидной почтой");
    }

    @Test
    public void shouldNotThrowExceptionWithDisabledValidator() {
        validationEnabled = false;
        User user = new User("anna", 12, "anna1gmailcom");
        assertDoesNotThrow(() -> validator.validate(user), "Исключение вызвалось с выключенным валидатором");
    }











}