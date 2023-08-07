package tests.US05_US06_US20_US21;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.UserHomepage;
import utilities.*;

import java.util.List;

public class US21 extends TestBaseReport {

    @Test
    public void TC01() {
        extentTest = extentReports.createTest("posting test");
        ListingPage listingPage = new ListingPage();
        // Details of properties on the listing page should be able to reach
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        JSUtilities.scrollToElement(Driver.getDriver(), userHomepage.usernamegiris);
        ReusableMethods.waitFor(3);
        userHomepage.loginGiris.click();
        listingPage.listLink.click();
        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(3);
        //The registered user should be able to access the details of
        //the properties by clicking the listing link on the top bar of the homepage.

        List<WebElement> ilanDetaylari = Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay2")));
        for (WebElement eachilan : ilanDetaylari) {
            Assert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
            // System.out.println(eachilan.getText());

        }
        Driver.closeDriver();
    }

    @Test
    public void TC02() {
        ListingPage listingPage = new ListingPage();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        JSUtilities.scrollToElement(Driver.getDriver(), userHomepage.usernamegiris);
        ReusableMethods.waitFor(3);
        userHomepage.loginGiris.click();
        ReusableMethods.waitFor(5);
        listingPage.listLink.click();
        JSUtilities.scrollToElement(Driver.getDriver(), listingPage.scrollTime);
        ReusableMethods.waitFor(3);
        listingPage.houseclick.click();
        ReusableMethods.waitFor(3);
        //The ad must be shareable from the social media addons on the Share link.
        softAssert.assertTrue(listingPage.twitter.isEnabled());
        softAssert.assertTrue(listingPage.linkedin.isEnabled());
        listingPage.wishlist.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);
        // extentTest.info("your ad be shareable from the social media addons on the Share link.");
        // The ad must be added to the wishlist.
        softAssert.assertTrue(listingPage.alertElement.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void Test03() {
        ListingPage listingPage = new ListingPage();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        JSUtilities.scrollToElement(Driver.getDriver(), userHomepage.usernamegiris);
        ReusableMethods.waitFor(3);
        userHomepage.loginGiris.click();
        ReusableMethods.waitFor(5);
        listingPage.listLink.click();
        JSUtilities.scrollToElement(Driver.getDriver(), listingPage.scrollTime);
        ReusableMethods.waitFor(3);
        listingPage.houseclick.click();
        JSUtilities.scrollToElement(Driver.getDriver(), listingPage.messageTextBox);

        ReusableMethods.waitFor(2);
        listingPage.messageTextBox.sendKeys("Your message was created successfully");
        ReusableMethods.waitFor(2);
        //JSUtilities.scrollToElement(Driver.getDriver(),listingPage.messageTextBox);
        ReusableMethods.waitFor(2);
        listingPage.submitReviev.click();
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(listingPage.messageAlert.isDisplayed());
       // extentTest.info("your message has been sent successfully");

        Driver.closeDriver();
    }

}


