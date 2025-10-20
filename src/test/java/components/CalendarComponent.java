package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement calendarInput = $("#dateOfBirthInput"),
    monthSelector = $(".react-datepicker__month-select"),
    yearSelector = $(".react-datepicker__year-select"),
    daySelector = $(".react-datepicker__month");
    public void setDate(String day, String month, String year) {
        calendarInput.click();
        monthSelector.$(byText(month)).click();
        yearSelector.$(byText(year)).click();
        daySelector.$(byText(day)).click();
    }
}
