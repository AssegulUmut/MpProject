package tests.US05_US06_US20_US21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.UserHomepage;
import utilities.*;

import java.util.List;


public class US20  extends TestBaseReport {

    @Test
    public void TC01() {
        ListingPage listingPage=new ListingPage();
        SoftAssert softAssert = new SoftAssert();
        UserHomepage userHomepage=new UserHomepage();
        // As a registered user, I can reach the list page where the properties on the site are listed,
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        JSUtilities.scrollToElement(Driver.getDriver(),userHomepage.usernamegiris);
        ReusableMethods.waitFor(3);
        userHomepage.loginGiris.click();


        listingPage.listLink.click();
        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(3);


        //As a registered user, I can reach the list page where the properties on the site are listed,
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.hauseheaven.com/properties?layout=sidebar";
        Assert.assertEquals(actualUrl,expectedUrl,"Url is different than expected");

        //The number of existing properties should be displayed on the list
        listingPage.aramaSonucDetay.isDisplayed();
        // page and the details of the displayed advertisements should be accessible.
        List<WebElement> ilanDetaylari=Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay")));
        for (WebElement eachilan:ilanDetaylari) {
            softAssert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
            System.out.println(eachilan.getText());
        }Driver.closeDriver();
    }


    @Test
    public void TC02(){
        ListingPage listingPage=new ListingPage();
        SoftAssert softAssert = new SoftAssert();
        UserHomepage userHomepage=new UserHomepage();
        Actions actions=new Actions(Driver.getDriver());
        // As a registered user, I can reach the list page where the properties on the site are listed,
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        JSUtilities.scrollToElement(Driver.getDriver(), userHomepage.usernamegiris);
        ReusableMethods.waitFor(3);
        userHomepage.loginGiris.click();
        listingPage.listLink.click();
        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(3);
        //"You should be able to get results by searching the page.

        //The results should be able to be verified in details."
        listingPage.searchlocationbox.sendKeys("Newark");

        ReusableMethods.waitFor(3);
        JSUtilities.scrollToElement(Driver.getDriver(),listingPage.dropdownMax);


        actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[2]")));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[3]"))).perform();
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[6]"))).perform();
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(3);


        actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[7]"))).perform();
        ReusableMethods.waitFor(2);
        listingPage.findNewHomeButton.sendKeys(Keys.ENTER);
        //actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(3);
      //  listingPage.findNewHomeButton.sendKeys(Keys.ENTER);
        softAssert.assertTrue(listingPage.aramaSonucSayisi.isDisplayed());
        // The number of received results should be displayed.
        System.out.println(listingPage.aramaSonucSayisi);
        softAssert.assertTrue(listingPage.foundOfResault.isDisplayed(),"The searched result was not found");
        ReusableMethods.waitFor(3);
        extentTest.pass("related search results displayed");

        Driver.closeDriver();

    }

}


