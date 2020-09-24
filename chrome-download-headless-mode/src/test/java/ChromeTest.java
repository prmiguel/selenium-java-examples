import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class ChromeTest {

    @Test
    public void downloadFileInHeadlessMode() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("chrome_preferences.directory_upgrade", true);
        prefs.put("chrome_preferences.prompt_for_download", false);
        prefs.put("chrome_preferences.profile.default_content_settings.popups", 0);

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("headless");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(caps);
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.partialLinkText("not_empty.txt")).click();
        driver.close();
    }
}
