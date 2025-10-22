package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubmittingForm {

    private SelenideElement modalFormHeader = $(".modal-content #example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal"),
            header = $("h1");


    public SubmittingForm checkFormIsOpen() {
        modalFormHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public SubmittingForm checkFormIsNotOpen() {
        modalFormHeader.shouldNotBe(visible);
        return this;
    }

    public SubmittingForm checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public boolean isFormOpen(){
        return modalFormHeader.isDisplayed();
    }
    public boolean isFormNotOpen(){
        return !modalFormHeader.isDisplayed();
    }


    public String getValue(String fieldName){
        return $x("//td[text()='" + fieldName + "']/following-sibling::td").getText();
    }

    public SubmittingForm closeForm() {
        closeButton.click();
        header.shouldHave(text("Practice Form"));
        return this;
    }




}
