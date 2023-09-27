package com.demoqa.utility;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtility {

    public static void sleep(int second) {

        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibilityOf(WebElement webElement){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitForInvisibility(WebElement webElement){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

    }


    public static void waitUntilUrlContains(String includedUrl){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(includedUrl));
    }



    public static void verifyIsPageLoaded(){

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        boolean  result=js.executeScript("return document.readyState").equals("complete");
        Assert.assertTrue("Page is not completely loaded",result);

    }


    public static void alertAccept(){
        Driver.getDriver().switchTo().alert().accept();
    }


    public static void alertDismiss(){
        Driver.getDriver().switchTo().alert().dismiss();
    }

    public static String  alertGetText(){
      return   Driver.getDriver().switchTo().alert().getText();
    }

    public static void   alertSendKeysAccept(String text){
      Alert alert=Driver.getDriver().switchTo().alert() ;
      alert.sendKeys(text);
      alert.accept();
    }

    public static void   alertSendKeysDismiss(String text){
        Alert alert=Driver.getDriver().switchTo().alert() ;
        alert.sendKeys(text);
        alert.accept();
    }


    public static void scrollByVertical(int pixel){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,"+pixel+")");

    }

    public static void scrollByVerticalAutomaticallyAndClick(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        int pixel=25;

        while (true) {
                try {
                    element.click();

                    return;
                } catch (RuntimeException e) {
                    js.executeScript("window.scrollBy(0," + pixel + ")");

                }
        }

    }


    public static void scrollByHorizontal(int pixel){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy("+pixel+",0)");

    }



}
