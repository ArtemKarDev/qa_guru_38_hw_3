package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.AdbDisabler;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;


public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),

            subjectInput = $("#subjectsInput"),
            loaderPictures = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        AdbDisabler.disableBanners();
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage disableAds(){
        AdbDisabler.disableBanners();
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject){
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies){
        $(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setPictures(String path){
        loaderPictures.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String address){
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state){
        stateInput.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city){
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage pressSubmit(){
        buttonSubmit.click();
        return this;
    }

    public RegistrationPage checkSubmitting() {
        $(".was-validated").shouldBe(visible);
        return this;
    }


}
