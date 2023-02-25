package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface LaunchConfig extends Config {


    @Key("baseUrl")
    @DefaultValue("https://rit-it.com")
    String getBaseUrl();

    @Key("selenoideUrl")
    String getSelenoideUrl();

    @Key("resolution")
    @DefaultValue("1920x1080")
    String getResolution();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("isRemote")
    boolean isRemote();
}
