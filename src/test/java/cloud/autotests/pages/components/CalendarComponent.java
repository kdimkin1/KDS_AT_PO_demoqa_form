package cloud.autotests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    //locators
    private SelenideElement
            setYear = $(".react-datepicker__year-select"),
            setMonth = $(".react-datepicker__month-select");
    //actions
    public void setDate(String Year,
                        String Month,
                        Integer Day) {
        setYear.selectOption(Year);
        setMonth.selectOption(Month);
        String DayOfBirthElement = ".react-datepicker__day--0"+Day;
        $(DayOfBirthElement).click();
    }
}
