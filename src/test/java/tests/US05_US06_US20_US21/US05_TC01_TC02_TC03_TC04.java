package tests.US05_US06_US20_US21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import utilities.*;

import java.util.List;

public class US05_TC01_TC02_TC03_TC04 extends TestBaseReport {
     SoftAssert softAssert = new SoftAssert();
    ListingPage listingPage=new ListingPage();

    // "As a visitor, you can see the list link at the top of the home page.
    //and when clicked it should verify that it is reachable"
    @Test
    public void TC01() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        softAssert.assertTrue(listingPage.listLink.isDisplayed(),"Listing link cannot be displayed");
        listingPage.listLink.click();
        ReusableMethods.waitFor(3);
        String expectedLink= "https://qa.hauseheaven.com/properties?layout=sidebar";
        String actualLink=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualLink.equals(expectedLink),"Listing Link");
        Driver.closeDriver();

    }

    // The number of existing properties should be displayed on the listing page.
    @Test
    public void TC02(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        listingPage.listLink.click();
        ReusableMethods.waitFor(3);
        listingPage.listAramaSonucElementi.isDisplayed();
        Driver.closeDriver();
    }

    //Details of the displayed advertisements should be accessible.
    @Test
    public void TC03(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        listingPage.listLink.click();
        ReusableMethods.waitFor(3);
        List<WebElement>ilanDetaylari=Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay")));
        for (WebElement eachilan:ilanDetaylari) {
            softAssert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
            System.out.println(eachilan.getText());
        }
            Driver.closeDriver();

        }
    //"You should be able to get results by searching the page.
    // The number of received results should be displayed.
    //The results should be able to be verified in details."

        @Test
        public void TC04(){

            Driver.getDriver().get(ConfigReader.getProperty("url"));
            listingPage.listLink.click();
            ReusableMethods.waitFor(3);
            listingPage.listSayfacookies.click();
            JSUtilities.scrollToElement(Driver.getDriver(),Driver.getDriver().findElement(By.xpath("(//div[@class='list-img-slide'])[3]")));
            listingPage.searchlocationbox.sendKeys("Newark");
            ReusableMethods.waitFor(3);

            Actions actions=new Actions(Driver.getDriver());
           actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[2]"))).perform();
           actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[3]"))).perform();
            actions.sendKeys(Keys.ENTER).perform();
            actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[6]"))).perform();

                 actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN)
                   .sendKeys(Keys.ENTER).perform();

            actions.click(Driver.getDriver().findElement(By.xpath("(//span[@role='presentation'])[7]"))).perform();
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();


            ReusableMethods.waitFor(3);
            listingPage.findNewHomeButton.sendKeys(Keys.ENTER);
            softAssert.assertTrue(listingPage.aramaSonucSayisi.isDisplayed());

           System.out.println(listingPage.aramaSonucSayisi);


           // Driver.closeDriver();

        }

}
