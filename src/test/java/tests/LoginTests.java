package tests;

import manager.HelperLogin;
import models.UserDTO;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginTests extends TestBase implements HelperLogin {

    //private long timeStart, timeStop;
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        clickButtonLogin();
    }


    @Test(groups = {"positive", "smoke"})
    public void loginPositiveTest(Method method) {
        UserDTO user = UserDTO.builder()
                .email(getEmail())
                .password(getPassword())
                .build();
        //timeStart = System.currentTimeMillis();
        //logger.info("Start test --> "+method.getName());
        logger.info("Test data --> " + user.toString());

        typeLogin(user.getEmail());
        clickButtonContinue();
        typePassword(user.getPassword());
        clickButtonLoginForm();
        clickButtonAccount();
        Assert.assertEquals(isTextInElementPresent_emailAccount(), user.getEmail());
        //timeStop = System.currentTimeMillis();
        //logger.info("Method stop --> "+method.getName()+" method duration="+(timeStop-timeStart));
    }

    @Test(groups = {"negative"})
    public void loginNegativeTest_wrongEmail_WO_dot() {
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmailcom")
                .password("AlexMed123!")
                .build();
        logger.info("Test data --> " + user.toString());
        typeLogin(user.getEmail());
        clickButtonContinue();
        Assert.assertTrue(isElementPresent_buttonSignUpForm());
    }

    @Test(groups = {"negative"})
    public void loginNegativeTest_wrongPassword() {
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty@gmail.com")
                .password("lexMed123!")
                .build();
        logger.info("Test data --> " + user.toString());
        typeLogin(user.getEmail());
        clickButtonContinue();
        typePassword(user.getPassword());
        clickButtonLoginForm();
        Assert.assertTrue(isElementPresent_Incorrect_password());

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if (isElementPresent_buttonAlreadyHaveAcc())
            clickButtonAlreadyHaveAcc();
    }
}
