package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //This is from requirement
        String expectedMessage = "Signing up is easy!";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Manisha");
       //Enter last name
        sendTextToElement(By.id("customer.lastName"),"Mavani");
        //Enter address
        sendTextToElement(By.id("customer.address.street"),"Brighton Road");
        //Enter city
        sendTextToElement(By.id("customer.address.city"),"Birmingham");
        //Enter state
        sendTextToElement(By.id("customer.address.state"),"Birmingham");
        //Enter zip code
        sendTextToElement(By.id("customer.address.zipCode"),"B20 2LR");
        //Enter phone
        sendTextToElement(By.id("customer.phoneNumber"),"07842567485");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"),"123456");
        //Enter Username
        sendTextToElement(By.id("customer.username"),"ManishaBalar");
        //Enter password
        sendTextToElement(By.id("customer.password"),"Mani12345");
        //Enter confirm
        sendTextToElement(By.id("repeatedPassword"),"Mani12345");
        //Click on Register button
        clickOnElement(By.xpath("//input[@value='Register']"));
       //This is from Requirement
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
       //Validate actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}
