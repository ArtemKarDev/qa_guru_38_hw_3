import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        // BIO
        $("#firstName").setValue("Jimmy");
        $("#lastName").setValue("Recard");
        $("#userEmail").setValue("JimmyRecard@good.boy");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9997775533");

        // Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("10")).click();


        // Subject
        $("input#subjectsInput").setValue("co").pressEnter();

        // Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();

        //loading pict

        $("#uploadPicture").uploadFromClasspath("pict/pict1.jpg");

        //Address
        $("#currentAddress").setValue("Some street 1");

        //State
        $("#state").scrollTo();
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();

        //City
        $("#city").click();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Jimmy Recard"));
        $(".table-responsive").shouldHave(text("JimmyRecard@good.boy"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9997775533"));
        $(".table-responsive").shouldHave(text("12 June,2000"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("pict/pict1.jpg"));
        $(".table-responsive").shouldHave(text("Some street 1"));
        $(".table-responsive").shouldHave(text("NCR Noida"));

    }

}
