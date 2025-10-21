package components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdbDisabler {

    public static void disableBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

}
