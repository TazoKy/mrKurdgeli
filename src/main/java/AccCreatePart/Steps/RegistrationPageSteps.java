package AccCreatePart.Steps;

import AccCreatePart.Pages.RegistrationPage;
import Common.Utility.DBSteps;
import Common.Utility.HelperFunctions;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPageSteps {
    RegistrationPage page = new RegistrationPage();
    HelperFunctions hf = new HelperFunctions();
    DBSteps steps=new DBSteps();

    public RegistrationPageSteps fillEmail() {
        page.emailField.setValue(hf.generateRandomEmail());
        return this;
    }

    public RegistrationPageSteps clickOnContinueButton() {
        page.continueButton.click();
        return this;
    }

    public String userName=hf.generateUsername();

    public RegistrationPageSteps fillUserName() {
        page.userNameField.setValue(userName);
        return this;
    }
    public String password=hf.generatePassword();
    public RegistrationPageSteps fillPassword() {
        page.passwordField.setValue(password);
        return this;
    }

    public RegistrationPageSteps clickOnRecaptcha() throws InterruptedException {
        hf.switchToRecaptcha();
        page.recaptcha.click();
        $x("//*[@id=\"recaptcha-audio-button\"]").click();
        return this;
    }
    public RegistrationPageSteps sendRegistrationInfoToDb(){
        try {
            steps.insertAcc(userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public RegistrationPageSteps clickOnAudioButton() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMillis(24000));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']")));
        return this;
    }
}
