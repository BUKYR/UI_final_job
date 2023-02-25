package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectLaunchConfig {
    static LaunchConfig cfg =  ConfigFactory.create(LaunchConfig.class, System.getProperties());

    public void launchConfig() {

        Configuration.pageLoadTimeout = 50000;
        Configuration.baseUrl = cfg.getBaseUrl();
        Configuration.browser = cfg.getBrowser();
        Configuration.browserSize = cfg.getResolution();
        Configuration.browserVersion = cfg.getBrowserVersion();

        if (cfg.isRemote()) {
            Configuration.remote = cfg.getSelenoideUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
