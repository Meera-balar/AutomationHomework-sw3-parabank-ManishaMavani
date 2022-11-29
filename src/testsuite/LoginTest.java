package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid Username
        sendTextToElement(By.name("username"),"ManishaBalar");
        //Enter valid Password
        sendTextToElement(By.name("password"),"Mani12345");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify message 'Accounts Overview'
        String expectedMessage = "Accounts Overview";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Accounts Overview']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Enter Invalid Username
        sendTextToElement(By.name("username"),"abfy");
        //Enter Invalid Password
        sendTextToElement(By.name("password"),"pqr");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify message
        String expectedMessage = "The username and password could not be verified.";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//p[text()='The username and password could not be verified.']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid Username
        sendTextToElement(By.name("username"),"ManishaBalar");
        //Enter valid Password
        sendTextToElement(By.name("password"),"Mani12345");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Click on Log out button
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        //Verify 'Customer Login'
        String expectedMessage = "Customer Login";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h2[text()='Customer Login']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @After
    public void tearDown(){
       // closeBrowser();
    }
}
