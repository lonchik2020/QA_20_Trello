package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{

    default void pause(int second){
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void click(By locator){

        driver.findElement(locator).click();
    }

    default void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        click(locator);
        element.clear();
        element.sendKeys(text);
    }

    default String isTextInElementPresent(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    default boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }
}
