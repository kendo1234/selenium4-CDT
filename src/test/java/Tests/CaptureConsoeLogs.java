package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;

public class CaptureConsoeLogs {

        private static ChromeDriver driver;
        private static DevTools chromeDevTools;
        final static String PROJECT_PATH = System.getProperty("user.dir");

        public static void main(String[] args){
            System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver2");
            driver = new ChromeDriver();
            chromeDevTools = driver.getDevTools();
            chromeDevTools.createSession();

            chromeDevTools.send(Log.enable());
            chromeDevTools.addListener(Log.entryAdded(),
                    logEntry -> {
                        System.out.println("log: "+logEntry.getText());
                        System.out.println("level: "+logEntry.getLevel());
                    });
            driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
        }
    }
