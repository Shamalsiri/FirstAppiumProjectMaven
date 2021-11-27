import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static void main(String[] args) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "10.0.0.223:3121");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "10.0.0.223:3121");
        caps.setCapability("newCommandTimeout", 300);
        String projectRootFolder = System.getProperty("user.dir"); // gives the path to the project root folder
        String appUrl = projectRootFolder + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "ApiDemos-debug.apk"; // use File.separator to make it system agnostic

        caps.setCapability("appPackage","io.appium.android.apis" );
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos"); // opens the API Demos Page
        //caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity"); //opens accessibility > custom view page
        //caps.setCapability(MobileCapabilityType.APP, appUrl); // Commented out because we will be attempting to open a specific app activity

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); // http not https
        AppiumDriver driver = new AndroidDriver(url, caps);

        System.out.println("session id: " + driver.getSessionId());
    }
}
