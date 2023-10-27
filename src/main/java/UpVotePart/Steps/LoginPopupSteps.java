package UpVotePart.Steps;

import UpVotePart.Data.UserData;
import UpVotePart.Pages.LoginPopup;
@SuppressWarnings("All")

public class LoginPopupSteps {
    LoginPopup page = new LoginPopup();
    UserData userData = new UserData();

    public LoginPopupSteps fillUserName() {
        page.userNameField
                .setValue(userData.userName);
        return this;
    }

    public LoginPopupSteps fillPassword() {
        page.userPasswordField
                .setValue(userData.password);
        return this;
    }

}

