import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FindElements {
    public static void findElements() throws Exception
    {
        AppiumDriver driver = CreateDriverSession.initializeDriver();

        //Finding Elements using different Locator Strategies

        MobileElement element = (MobileElement) driver.findElementByAccessibilityId("Accessibility"); // Get AccessibilityID from the Inspector
        // findElementByAccessibilityId is originally for web element, so need to be cast to mobile element
        System.out.println(element.getText()); // Prints Accessibility

        /*
        //incorrect way of using findElementById
        element = (MobileElement) driver.findElementById("android:id/text1"); // The resourceId from the inspector
        System.out.println(element.getText()); // Prints Access'ibility
        */

        //correct way of using findElementById  is by using a list of elements using findElementsById (notice 's')
        element = (MobileElement) driver.findElementsById("android:id/text1").get(1); // The resourceId from the inspector. the index value from the inspector is the parameter for get
        System.out.println(element.getText()); // Prints Accessibility

        /*
        //incorrect way of using findElementByClassName
        element = (MobileElement) driver.findElementByClassName("android.widget.TextView"); // The Class from the inspector
        System.out.println(element.getText()); // Prints API Demos
        */

        //correct way of using findElementByClassName  is by using a list of elements using findElementsByClassName (notice 's')
        element = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2); // The Class from the inspector. Assume API Demo is index 0, therefore we need 2
        System.out.println(element.getText()); // Prints API Demos

        //correct way of using findElementByXPath
        element = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(element.getText()); // Prints Accessibility

        /*
        //incorrect way of using findElementByName.
        element = (MobileElement) driver.findElementByName("Accessibility"); // The text value from the Inspector
        System.out.println(element.getText()); // error is thrown
        */

        //correct way of using findElementByName. Instead, using byName, use byXpath and use custom xpath with text attribute
        element = (MobileElement) driver.findElementByXPath("//*[@text=\"Accessibility\"]"); // The text value from the Inspector but in a custom xpath
        System.out.println(element.getText()); // Prints Accessibility

        /*
        // Can not use FindElementByTagName on Android
        element = (MobileElement) driver.findElementByTagName("Accessibility"); // The content-desc value from the Inspector
        System.out.println(element.getText()); // error is thrown
        */
    }
}
