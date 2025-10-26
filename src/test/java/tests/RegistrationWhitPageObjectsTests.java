package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;
import testData.GeneratorTestData;
import testData.Hobby;
import testData.RegistrationData;
import components.SubmittingForm;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import pages.RegistrationPage;


public class RegistrationWhitPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmittingForm submittingForm= new SubmittingForm();
    GeneratorTestData testData = new GeneratorTestData();


    @ParameterizedTest(name = "{0} - full data")
    @DisplayName("Проверка c данными через CsvFileSource")
    @CsvFileSource(resources = "/registration-data2.csv", numLinesToSkip = 1)
    public void fullRegistrationTestdataFromCSV(String firstName, String lastName, String email,
                                                String gender, String number,String day, String month,
                                                String year, String subjects, String hobbies,
                                                String picture, String address, String state, String city) {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubject(subjects)
                .setHobbies(hobbies)
                .setPictures(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(submittingForm.isFormOpen())
                .as("Форма открыта")
                .isTrue();

        soft.assertThat(submittingForm.getValue("Student Name"))
                .as("Student Name")
                .isEqualTo(firstName + " " + lastName);

        soft.assertThat(submittingForm.getValue("Student Email"))
                .as("Student Email")
                .isEqualTo(email);

        soft.assertThat(submittingForm.getValue("Gender"))
                .as("Gender")
                .isEqualTo(gender);

        soft.assertThat(submittingForm.getValue("Mobile"))
                .as("Mobile")
                .isEqualTo(number);

        soft.assertThat(submittingForm.getValue("Date of Birth"))
                .as("Date of Birth")
                .isEqualTo(day + " " +
                        month + "," + year);

        soft.assertThat(submittingForm.getValue("Subjects"))
                .as("Subjects")
                .isEqualTo(subjects);

        soft.assertThat(submittingForm.getValue("Hobbies"))
                .as("Hobbies")
                .isEqualTo(hobbies);

        soft.assertThat(picture)
                .as("Picture")
                .contains(submittingForm.getValue("Picture"));

        soft.assertThat(submittingForm.getValue("Address"))
                .as("Address")
                .isEqualTo(address);

        soft.assertThat(submittingForm.getValue("State and City"))
                .as("State and City")
                .isEqualTo(state + " " + city);

        soft.assertAll();

        submittingForm.closeForm();
    }



        @ParameterizedTest(name = "{0} - full data")
    @MethodSource("testData.ProviderRegistrationDataFromJson#registrationData")
    public void fullRegistrationTest(String caseName, RegistrationData data) {
        registrationPage.openPage()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setEmail(data.getEmail())
                .setGender(data.getGender())
                .setNumber(data.getPhoneNumber())
                .setDateOfBirth(
                        data.getDateOfBirth().getDay(),
                        data.getDateOfBirth().getMonth(),
                        data.getDateOfBirth().getYear()
                )
                .setSubject(data.getSubjects().get(0))
                .setHobbies(data.getHobbies().get(0))
                .setPictures(data.getPicture())
                .setAddress(data.getAddress())
                .setState(data.getState())
                .setCity(data.getCity())
                .pressSubmit();

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(submittingForm.isFormOpen())
                .as("Форма открыта")
                .isTrue();

        soft.assertThat(submittingForm.getValue("Student Name"))
                .as("Student Name")
                .isEqualTo(data.getFirstName() + " " +data.getLastName());

        soft.assertThat(submittingForm.getValue("Student Email"))
                .as("Student Email")
                .isEqualTo(data.getEmail());

        soft.assertThat(submittingForm.getValue("Gender"))
                .as("Gender")
                .isEqualTo(data.getGender());

        soft.assertThat(submittingForm.getValue("Mobile"))
                .as("Mobile")
                .isEqualTo(data.getPhoneNumber());

        soft.assertThat(submittingForm.getValue("Date of Birth"))
                .as("Date of Birth")
                .isEqualTo(data.getDateOfBirth().getDay() + " " +
                        data.getDateOfBirth().getMonth() + "," +
                        data.getDateOfBirth().getYear());

        soft.assertThat(submittingForm.getValue("Subjects"))
                .as("Subjects")
                .isEqualTo(data.getSubjects().get(0));

        soft.assertThat(submittingForm.getValue("Hobbies"))
                .as("Hobbies")
                .isEqualTo(data.getHobbies().get(0));

        soft.assertThat(data.getPicture())
                .as("Picture")
                .contains(submittingForm.getValue("Picture"));

        soft.assertThat(submittingForm.getValue("Address"))
                .as("Address")
                .isEqualTo(data.getAddress());

        soft.assertThat(submittingForm.getValue("State and City"))
                .as("State and City")
                .isEqualTo(data.getState() + " " + data.getCity());

        soft.assertAll();

        submittingForm.closeForm();

    }

    @ParameterizedTest(name = "{0} - partial data")
    @MethodSource("TestData.ProviderRegistrationDataFromJson#registrationData")
    public void partialRegistrationTest(String caseName, RegistrationData data) {
        registrationPage.openPage()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setEmail(data.getEmail())
                .setGender(data.getGender())
                .setNumber(data.getPhoneNumber())
                .pressSubmit();

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(submittingForm.isFormOpen())
                .as("Форма открыта")
                .isTrue();

        soft.assertThat(submittingForm.getValue("Student Name"))
                .as("Student Name")
                .isEqualTo(data.getFirstName() + " " +data.getLastName());

        soft.assertThat(submittingForm.getValue("Student Email"))
                .as("Student Email")
                .isEqualTo(data.getEmail());

        soft.assertThat(submittingForm.getValue("Gender"))
                .as("Gender")
                .isEqualTo(data.getGender());

        soft.assertThat(submittingForm.getValue("Mobile"))
                .as("Mobile")
                .isEqualTo(data.getPhoneNumber());

        soft.assertAll();

        submittingForm.closeForm();
    }



    @Test
    public void successfulRegistrationTestWithGenData(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phoneNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setAddress(testData.address)
                .setPictures(testData.picture)
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

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(submittingForm.isFormNotOpen())
                .as("Форма закрыта")
                .isTrue();
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
                .setNumber(number)
                .pressSubmit();

        submittingForm.checkFormIsOpen()
                .checkResult("Student Name", firstName+ " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .closeForm();
    }

    @ParameterizedTest
    @EnumSource(testData.Hobby.class)
    public void fillMinimalFormRegistrationHobbiesTest(Hobby hobbies){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phoneNumber)
                .setHobbies(hobbies.getDisplayName())
                .pressSubmit()
                .checkSubmitting();

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(submittingForm.getValue("Hobbies"))
                .as("Hobbies")
                .isEqualTo(hobbies.getDisplayName());

        soft.assertAll();

        submittingForm.closeForm();

    }


}
