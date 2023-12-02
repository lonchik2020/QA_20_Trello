package manager;

import org.openqa.selenium.By;

public interface HelperLogin extends HelperBase{

    By buttonLogin = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");

    By fieldLogin = By.id("username");

    By buttonContinue = By.id("login-submit");

    By fieldPassword = By.xpath("//input[@id='password']");

    By buttonLoginForm = By.id("login-submit");

    By buttonAccount = By.xpath("//button[@data-testid='header-member-menu-button']");

    By emailAccount = By.xpath(
            "//div[@data-testid='account-menu-account-section']//div[@class='AS8ZlkEoqFiwD_']");

    By buttonSignUpForm = By.id("signup-submit");

    By buttonAlreadyHaveAcc = By.id("already-have-an-account");

    By messageIncorrectEmailPassword = By.xpath("//div[@data-testid='form-error--content']/span");


    default void clickButtonLogin(){
        click(buttonLogin);
    }

    default void typeLogin(String text){
        type(fieldLogin, text);
    }

    default void clickButtonContinue(){
        click(buttonContinue);
    }

    default void typePassword(String password){
        type(fieldPassword, password);
    }

    default void clickButtonLoginForm(){
        click(buttonLoginForm);
    }

    default void clickButtonAccount(){
        click(buttonAccount);
    }

    default String isTextInElementPresent_emailAccount(){
        return isTextInElementPresent(emailAccount);
    }

    default boolean isElementPresent_buttonSignUpForm(){
        return isElementPresent(buttonSignUpForm);
    }

    default void clickButtonAlreadyHaveAcc(){
        click(buttonAlreadyHaveAcc);
    }

    default boolean isElementPresent_buttonAlreadyHaveAcc(){
        return isElementPresent(buttonAlreadyHaveAcc);
    }

    default boolean isElementPresent_Incorrect_password(){
        return isElementPresent(messageIncorrectEmailPassword);
    }
}
