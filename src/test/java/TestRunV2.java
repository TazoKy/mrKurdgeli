import UpVotePart.Data.FilePaths;
import UpVotePart.Steps.LoginPopupSteps;
import UpVotePart.Steps.RedditMainPageSteps;
import UpVotePart.Steps.SearchedUserPageSteps;
import UpVotePart.Steps.UserMainPageSteps;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import org.testng.annotations.*;


import java.awt.*;

import static com.codeborne.selenide.Selenide.*;
@SuppressWarnings("All")
public class TestRunV2 extends TestConfig {
    HelperFunctions hf = new HelperFunctions();
    FilePaths fp = new FilePaths();
    RedditMainPageSteps stepsForMainPage = new RedditMainPageSteps();
    LoginPopupSteps stepsForLoginPopup = new LoginPopupSteps();
    UserMainPageSteps stepsForUserMainPage = new UserMainPageSteps();
    SearchedUserPageSteps stepsForSearchedUser = new SearchedUserPageSteps();

    @BeforeClass
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.url);
    }

    @Test
    public void login() throws AWTException {
        stepsForMainPage.clickOnLogin();
        stepsForLoginPopup.fillUserName().fillPassword();
        hf.pressEnter();
        stepsForUserMainPage.waitForUserIcon();
    }


    @Test
    public void programEngine() throws InterruptedException {
        open(hf.url+"user/"+"Straight_Main_5189/");
        stepsForSearchedUser.clickOnPostsButton().upvoteAllPosts(7);
    }


//    @AfterClass
//    public void cleanUp(){
//        tearDown();
//    }

}

