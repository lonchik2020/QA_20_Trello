package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface AppManager {

    Logger logger = LoggerFactory.getLogger(AppManager.class);

    WebDriver driver = new ChromeDriver();

    Properties properties = new Properties();

    default void init() throws IOException {
        String target = System.getProperty("target","config1");
        properties.load(new FileReader(
                new File(String.format("C:/QA_Auto_Projects/QA_20/QA_20_Trello/src/test/resources/%s.properties",target))));


        driver.navigate().to(properties.getProperty("web.baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("URL " + properties.getProperty("web.baseUrl") + " Start testing --> " + LocalDateTime.now());
    }

    default String getEmail(){
        logger.info("used email -->"+properties.getProperty("web.email"));
        return properties.getProperty("web.email");
    }
    default String getPassword(){
        logger.info("used password -->"+properties.getProperty("web.password"));
        return properties.getProperty("web.password");
    }
    default void tearDown(){
        driver.quit();
        logger.info("Stop testing --> " + LocalDateTime.now());
    }

}
