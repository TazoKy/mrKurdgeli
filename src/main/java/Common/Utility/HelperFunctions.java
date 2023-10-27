package Common.Utility;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HelperFunctions {
    WebDriverWait wait;
    public String url;
    public String r_url;



    public void parseProperties(String path) {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        url = properties.getProperty("url");
        r_url = properties.getProperty("r_url");

    }

    String mainWindowHandle;

    public void switchToNewWindow() {
        mainWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        String newWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

        switchTo().window(newWindowHandle);
    }

    public void switchBack() {
        switchTo().window(mainWindowHandle);
    }

    public void pressEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void switchToRecaptcha(){
//        WebDriverRunner.getWebDriver().switchTo().frame(WebDriverRunner.getWebDriver().findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        wait=new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMillis(40000));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));


    }
    public void switchToDefault(){
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
    }
    public String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder randomEmail = new StringBuilder();

        // Generate a random username
        Random rand = new Random();
        int usernameLength = 10;  // You can adjust the length as needed
        for (int i = 0; i < usernameLength; i++) {
            int randomIndex = rand.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomEmail.append(randomChar);
        }

        randomEmail.append("@gmail.com");

        return randomEmail.toString();
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();


        for (int i = 0; i < 2; i++) {
            char capitalLetter = (char) (random.nextInt(26) + 'A');
            password.append(capitalLetter);
        }


        for (int i = 0; i < 2; i++) {
            int number = random.nextInt(10);
            password.append(number);
        }


        for (int i = 4; i < 10; i++) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(10) + '0');
            }
            password.append(randomChar);
        }


        char[] passwordChars = password.toString().toCharArray();
        for (int i = passwordChars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordChars[index];
            passwordChars[index] = passwordChars[i];
            passwordChars[i] = temp;
        }

        return new String(passwordChars);
    }

    public String generateUsername() {
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        // Generate 3 random capital letters
        for (int i = 0; i < 3; i++) {
            char capitalLetter = (char) (random.nextInt(26) + 'A');
            username.append(capitalLetter);
        }


        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(10);
            username.append(number);
        }


        for (int i = 6; i < 10; i++) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(10) + '0');
            }
            username.append(randomChar);
        }


        char[] usernameChars = username.toString().toCharArray();
        for (int i = usernameChars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = usernameChars[index];
            usernameChars[index] = usernameChars[i];
            usernameChars[i] = temp;
        }

        return new String(usernameChars);
    }
    public int generateRandomNumber(){
        Random random=new Random();
        return random.nextInt(100);
    }
    public boolean clickOrNot(){
        return generateRandomNumber() % 2 == 0;
    }
}
