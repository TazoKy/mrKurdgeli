import AccCreatePart.Steps.RegistrationPageSteps;
import UpVotePart.Data.FilePaths;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SuppressWarnings("All")
public class TestRunV1 extends TestConfig {
    HelperFunctions hf=new HelperFunctions();
    FilePaths fp=new FilePaths();
    RegistrationPageSteps stepsForRegistrationPage=new RegistrationPageSteps();
    @BeforeClass
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.r_url);
    }
    @Test
    public void createAccount() throws InterruptedException {
        stepsForRegistrationPage.fillEmail().clickOnContinueButton()
                .fillUserName().fillPassword().sendRegistrationInfoToDb();
        Thread.sleep(4444);
    }
//    @AfterClass
//    public void cleanUp() {
//        tearDown();
//    }


}
