package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class Calculator {
    AndroidDriver driver;
    public Calculator(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void add(){
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
    }

    public void minus(){
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
    }

    public void multiply(){
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
    }

    public void divide(){
        driver.findElement(AppiumBy.accessibilityId("percent")).click();
    }

    public void equals(){
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
    }

    public void enterNumber(String number){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        for (int i = 0; i < number.length(); i++) {
            String accessibilityid = String.valueOf(number.charAt(i));
            driver.findElement(AppiumBy.accessibilityId(accessibilityid)).click();
        }
    }

    public String getAnswer(){
        String answer = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        return answer;
    }

}
