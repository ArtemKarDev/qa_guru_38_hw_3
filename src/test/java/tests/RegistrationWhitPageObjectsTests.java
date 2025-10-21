package tests;

import TestData.GeneratorTestData;
import components.SubmittingForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegistrationPage;


public class RegistrationWhitPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmittingForm submittingForm= new SubmittingForm();
    GeneratorTestData testData = new GeneratorTestData();

    @Test
    public void successfulRegistrationTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setAddress(testData.address)
                .uploadPictures(testData.picture)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit()
                .checkSubmitting();
    }


    @Test
    void fillNegativeFormTest() {
        registrationPage.openPage()
                .pressSubmit()
                .checkSubmitting();

        submittingForm.checkFormIsNotOpen();
    }
    @ParameterizedTest
    @CsvSource(value = {
                    "Alex, Egorov, Other, 1234567890",
                    "Evgen, Avakumov, Female, 1234567890",
                    "Salpuk, Heruvim, Male, 1111112222"
            })
    void fillMinimalFormRegistrationTest(String firstName, String lastName, String gender, String number) {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(number)
                .pressSubmit();

        submittingForm.checkFormIsOpen()
                .checkResult("Student Name", firstName+ " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .closeForm();
    }




}
