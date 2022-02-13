package cloud.autotests.pages;

import cloud.autotests.docs.SelenideSnippets;
import cloud.autotests.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            setUserEmail = $("#userEmail"),
            setUserNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            setSubjectsInput = $("div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            setCurrentAddress = $("#currentAddress"),
            adClose = $("#close-fixedban > img"),
            setState = $("#state"),
            setCity = $("#city"),
            submit = $("#submit"),
            resultWindow = $(".modal-header"),
            resultTable = $(".table"),
            resultClose = $("#closeLargeModal");

    // actions
    public void openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
    }
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setUserEmail(String userEmail) {
        setUserEmail.setValue(userEmail);
    }
    public void setUserNumber(String userNumber) {
        setUserNumber.setValue(userNumber);
    }
    public void setDateofBirth(String Year,
                               String Month,
                               Integer Day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(Year,Month,Day);
        ;
    }

    public void setSubjects(String subjectsInputFirst, String subjectsInputSecond) {
        setSubjectsInput.click();
        subjectsInput.setValue(subjectsInputFirst).pressEnter();
        subjectsInput.setValue(subjectsInputSecond).pressEnter();
    }
    public void setUploadPicture  (File fileWithPicture) {
        uploadPicture.uploadFile(fileWithPicture);
    }
    public void setCurrentAddress  (String currentAddress) {
        setCurrentAddress.setValue(currentAddress);
    }

    public void adClose () {
        if (adClose.exists() == true) {
            adClose.click();
        }
    }

    public void setState (String state) {
        setState.click();
        $(byText(state)).click();
    }
    public void setCity (String city) {
        setCity.click();
        $(byText(city)).click();
    }

    public void setFieldWText (String text) {
        $(byText(text)).click();
    }

    public void setSubmit () {
        submit.click();
    }

    public void checkForm (String firstName,
                           String lastName,
                           String userEmail,
                           String gender,
                           String userNumber,
                           Integer dateOfBirthDay,
                           String dateOfBirthMonth,
                           String dateOfBirthYear,
                           String subjectsInputFirst,
                           String subjectsInputSecond,
                           String hobbiesFirst,
                           String hobbiesSecond,
                           String fileWithPictureName,
                           String currentAddress,
                           String state,
                           String city) {
        //body > div.fade.modal.show > div > div > div.modal-header
        resultWindow.shouldHave(text("Thanks for submitting the form"));
        //body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody
        resultTable.shouldHave(
                text(firstName +" "+ lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text(dateOfBirthDay + " "+ dateOfBirthMonth +"," + dateOfBirthYear),
                text(subjectsInputFirst + ", " + subjectsInputSecond),
                text(hobbiesFirst + ", " + hobbiesSecond),
                text(fileWithPictureName),
                text(currentAddress),
                text(state + " " + city));
    }
    public void setClose () {
        resultClose.click();
    }

}
