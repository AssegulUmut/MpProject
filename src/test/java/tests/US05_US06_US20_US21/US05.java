
package tests.US05_US06_US20_US21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import utilities.*;

import java.util.List;

public class US05 extends TestBaseReport {
    Actions action = new Actions(Driver.getDriver());

    // "As a visitor, you can see the list link at the top of the home page.
    //and when clicked it should verify that it is reachable"
    @Test
    public void TC01() {
        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        ListingPage listingPage = new ListingPage();

        extentTest = extentReports.createTest("Hauseheaven test", "On Home Page page ");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        softAssert.assertTrue(listingPage.listLink.isDisplayed(), "Listing link cannot be displayed");
        listingPage.listLink.click();
        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(3);
        extentTest = extentReports.createTest("HauseHeaven test sayfasi", "Sayfaya ulasildigi dogrulanmali");
        String expectedLink = "https://qa.hauseheaven.com/properties?layout=sidebar";
        String actualLink = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualLink.equals(expectedLink), "Listing Link");

        extentTest.pass("Listing sayfasina ulasildi");
        // The number of existing properties should be displayed on the listing page.
        listingPage.listAramaSonucElementi.isDisplayed();

        //Details of the displayed advertisements should be accessible.

        ReusableMethods.waitFor(3);
        List<WebElement> ilanDetaylari = Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay")));
        for (WebElement eachilan : ilanDetaylari) {
            softAssert.assertTrue(eachilan.isDisplayed());
            extentTest.pass("İlan detaylarina ulaşildi");
            System.out.println(eachilan.getText());

        }
        Driver.closeDriver();
    }
    //"You should be able to get results by searching the page.

    //The results should be able to be verified in details."

    @Test
    public void TC02() {
       action = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        ListingPage listingPage = new ListingPage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // softAssert.assertTrue(listingPage.listLink.isDisplayed(), "Listing link cannot be displayed");
        ReusableMethods.waitFor(3);
        listingPage.listLink.click();
        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(3);
        extentTest = extentReports.createTest("HouseHaven sayfasi", "Arama sonucları dogrulama");
        ReusableMethods.waitFor(3);
        listingPage.searchlocationbox.sendKeys("Newark");
        ReusableMethods.waitFor(3);
        JSUtilities.scrollToElement(Driver.getDriver(),listingPage.dropdownMax);

        action.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[2]")));
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        //action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        action.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[3]"))).perform();
        action.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        action.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[6]"))).perform();
        action.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(3);

        action.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[7]"))).perform();


        ReusableMethods.waitFor(3);
        listingPage.findNewHomeButton.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(listingPage.aramaSonucSayisi.isDisplayed());
        extentTest.pass("search results displayed");

        // The number of received results should be displayed.
        System.out.println(listingPage.aramaSonucSayisi);
        ReusableMethods.waitFor(3);
        // JSUtilities.scrollToElement(Driver.getDriver(), listingPage.foundOfResault);
        softAssert.assertTrue(listingPage.foundOfResault.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.pass("İlgili arama sonuclari goruntulendi");

       Driver.closeDriver();

    }

}

