import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class UiAutomator {
    public static void UiAutomator() throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver();

        MobileElement element = (MobileElement) ((FindsByAndroidUIAutomator)driver)
                .findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")"); //From text field in the Inspector
        System.out.println(element.getText());

        element = (MobileElement) ((FindsByAndroidUIAutomator)driver)
                .findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2); //From class field in the Inspector
                        //more than one element have the same class name so need to use findElement's' instead of findElement and providing the index of element
        System.out.println(element.getText());

        element = (MobileElement) ((FindsByAndroidUIAutomator)driver)
                .findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")"); // From content-desc field in the inspector
        System.out.println(element.getText());

        element = (MobileElement) ((FindsByAndroidUIAutomator)driver)
                .findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")").get(1); // From resource-id field in the inspector
        System.out.println(element.getText());
    }
}
