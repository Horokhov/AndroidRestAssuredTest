package org.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Calculator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroid {
    AndroidDriver androidDriver;
    AppiumDriverLocalService serviceBuilder;
    Calculator calculator;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("/OPT/HOMEBREW/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel 7 Pro API 34");
        uiAutomator2Options.setApp("/Users/max_horokhov/Desktop/Projects/Appium/Calculator_8.4.1 (520193683)_Apkpure.apk");
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);

    }

    @AfterTest
    public void shutDown(){
        androidDriver.quit();
        serviceBuilder.stop();
    }

    public Calculator passingDriver(){
        calculator = new Calculator(androidDriver);
        return calculator;
    }
}
