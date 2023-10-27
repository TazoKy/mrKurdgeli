package Common.Utility;

import Common.Data.ProxyData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class TestConfig extends ProxyData {
    public void setUp(String baseUrl) {
        Random random=new Random();
        int proxyNum=random.nextInt(ProxyData.proxyListData().size()-1);

           Configuration.timeout = 27777;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyListData().get(proxyNum));
        proxy.setSslProxy(proxyListData().get(proxyNum));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);
        WebDriverRunner.setWebDriver(new ChromeDriver(chromeOptions));
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open(baseUrl);

    }

    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
