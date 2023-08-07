package tests.US05_US06_US20_US21;
import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import utilities.*;

import java.util.List;

public class US06  extends TestBaseReport{
      ListingPage listingPage=new ListingPage();
      SoftAssert softAssert=new SoftAssert();
      Actions actions=new Actions(Driver.getDriver());
      Faker faker=new Faker();

        @Test
    public void TC01() {
        listingPage=new ListingPage();
        softAssert=new SoftAssert();
        actions=new Actions(Driver.getDriver());
        faker=new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //As a visitor, the information details of the properties in the list link should be accessible.
        listingPage.listLink.click();
       ReusableMethods.waitFor(3);
       listingPage.listSayfacookies.click();
        List<WebElement> ilanDetaylari=Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay2")));
        for (WebElement eachilan:ilanDetaylari) {
            Assert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
            //extentTest.pass("ads viewed");
           // System.out.println(eachilan.getText());
        }
        ReusableMethods.waitFor(5 );
        //JSUtilities.scrollToElement(Driver.getDriver(),listingPage.scrollTime);
        ReusableMethods.waitFor(3);
        listingPage.houseclick.click();
        ReusableMethods.waitFor(3);


       // The ad must be shareable from the social media attachments on the Share link.

        softAssert.assertTrue(listingPage.facebookLink.isEnabled());
        softAssert.assertTrue(listingPage.twitter.isEnabled());
        softAssert.assertTrue(listingPage.linkedin.isEnabled());
        listingPage.wishlist.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);

        // The ad must be added to the wishlist.
        softAssert.assertTrue(listingPage.alertElement.isDisplayed());

        //Emlakciya mesaj gönderilebildigi dogrulanmalidir.
        listingPage.nameInput.sendKeys(faker.name().fullName());
        listingPage.phoneInput.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.waitFor(2);
        listingPage.emailInput.sendKeys(faker.internet().emailAddress());
       // listingPage.subjectInput.sendKeys(faker.name().name());
        listingPage.messageInput.sendKeys("Mesajınız iletildi");
        ReusableMethods.waitFor(2);
        listingPage.submitButton.sendKeys(Keys.ENTER);
        softAssert.assertTrue(listingPage.messageAlert.isEnabled());
        softAssert.assertAll();


      Driver.closeDriver();

    }

}








