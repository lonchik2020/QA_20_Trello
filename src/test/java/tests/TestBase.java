package tests;

import manager.AppManager;
import manager.TestNgListener;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestNgListener.class)
public class TestBase implements AppManager {
    @BeforeSuite(alwaysRun = true)
    public void start()  {
        try {
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterSuite(alwaysRun = true)
    public void stop(){
        //tearDown();
    }
}
