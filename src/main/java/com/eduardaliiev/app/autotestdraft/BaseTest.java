package com.eduardaliiev.app.autotestdraft;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eduard Aliiev on 11/16/16;
 */
public class BaseTest {
    String baseUrl = "https://login.live.com";
    protected WebDriver driver;
    private String BROWSER = System.getProperty("browser");
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static final String CHROME_PATH_MAC = "src/main/java/com/eduardaliiev/app/resources/drivers/chromedriver";
    private static final String CHROME_PATH_WIN = "src/main/java/com/eduardaliiev/app/resources/drivers/chromedriver.exe";

    @Before
    public void setUp() throws Exception {
        if (BROWSER == null || BROWSER.equalsIgnoreCase("Firefox") || BROWSER.equalsIgnoreCase("")) {
            this.driver = new FirefoxDriver();
        } else if (BROWSER.equalsIgnoreCase("Chrome")) {
            if (isWindows()) {
                System.setProperty("webdriver.chrome.driver", CHROME_PATH_WIN);
            } else if (isMac()) {
                System.setProperty("webdriver.chrome.driver", CHROME_PATH_MAC);
            }
            this.driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isMac() {
        return (OS.contains("mac"));
    }

}
