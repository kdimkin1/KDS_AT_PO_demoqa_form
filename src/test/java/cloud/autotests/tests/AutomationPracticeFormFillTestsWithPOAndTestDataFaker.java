package cloud.autotests.tests;

import cloud.autotests.pages.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloud.autotests.tests.TestDataFaker.*;
import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormFillTestsWithPOAndTestDataFaker extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Description("AutomationPracticeFormFillTests")
    @DisplayName("AutomationPracticeFormFillTests(demoqa.com).")
    void apfSuccessFillTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });

        step("Заполнить поле First Name(Anton)", () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            registrationPage.setLastName(lastName);
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            registrationPage.setUserEmail(userEmail);
        });

        step("Заполнить поле Gender (Male)", () -> {
            registrationPage.setFieldWText(gender);
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            registrationPage.setUserNumber(userNumber);
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            registrationPage.setDateofBirth(dateOfBirthYear,dateOfBirthMonth,dateOfBirthDay);
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            registrationPage.setSubjects(subjectsInputFirst, subjectsInputSecond);
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            registrationPage.setFieldWText(hobbiesFirst);
            registrationPage.setFieldWText(hobbiesSecond);
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            registrationPage.setUploadPicture(fileWithPicture);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            registrationPage.adClose();
            registrationPage.setState(state);
        });

        step("Заполнить поле City (Karnal)", () -> {
            registrationPage.setCity(city);
        });

        step("Отправить форму (Submit)", () -> {
            registrationPage.setSubmit();
        });

        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            registrationPage.checkForm(firstName, lastName, userEmail,gender,userNumber,dateOfBirthDay,
                    dateOfBirthMonth,dateOfBirthYear,subjectsInputFirst,subjectsInputSecond,hobbiesFirst,
                    hobbiesSecond,fileWithPictureName,currentAddress,state,city);
        });
        step("Закрыть форму (Close)", () -> {
            registrationPage.setClose();
        });


    }

}