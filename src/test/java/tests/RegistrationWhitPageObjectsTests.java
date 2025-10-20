package tests;

import components.SubmittingForm;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWhitPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmittingForm submittingForm= new SubmittingForm();

    @Test
    public void successfulRegistrationTest(){
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Math")
                .setHobbies("Sports")
                .setAddress("Some address 1")
                .uploadPictures("pict.jpg")
                .setState("NCR")
                .setCity("Delhi")
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
    @Test
    void fillMinimalFormRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .pressSubmit();

        submittingForm.checkFormIsOpen()
                .checkResult("Student Name", "Alex Egorov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .closeForm();
    }




}
