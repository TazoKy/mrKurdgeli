package AccCreatePart.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public SelenideElement emailField=$x("//*[@id=\"regEmail\"]"),
    continueButton=$x("//button[@class=\"AnimatedForm__submitButton m-full-width\"]"),
    userNameField=$x("//*[@id=\"regUsername\"]"),
    passwordField=$x("//*[@id=\"regPassword\"]"),
    recaptcha=$x("//*[@id=\"recaptcha-anchor-label\"]");

}