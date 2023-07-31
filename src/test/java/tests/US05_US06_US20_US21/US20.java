package tests.US05_US06_US20_US21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListingPage;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class US20  {
        ListingPage listingPage=new ListingPage();
    UserHomepage userHomepage=new UserHomepage();
    @Test
    public void TC01() {

        // As a registered user, I can reach the list page where the properties on the site are listed,
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userHomepage.signupButonu.click();
        userHomepage.usernamegiris.sendKeys(ConfigReader.getProperty("userMail"));
        userHomepage.passwordGiris.sendKeys(ConfigReader.getProperty("userPass"));
        listingPage.listSayfacookies.click();
        userHomepage.loginGiris.click();
        listingPage.listLink.click();
        ReusableMethods.waitFor(3);


        //As a registered user, I can reach the list page where the properties on the site are listed,
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.hauseheaven.com/properties?layout=sidebar";
        Assert.assertEquals(actualUrl,expectedUrl,"Url is different than expected");

        //The number of existing properties should be displayed on the list
        // page and the details of the displayed advertisements should be accessible.
        List<WebElement> ilanDetaylari=Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay")));
        for (WebElement eachilan:ilanDetaylari) {
           // softAssert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
            System.out.println(eachilan.getText());
        }

        listingPage.aramaSonucDetay.isDisplayed();


           // Kayıtlı kullanıcı olarak sitedeki mülklerin listelendiği list sayfasına ulaşabildiğimi,
           //         var olan mülk sayısının görüntülendiğini, görüntülenen ilanların ayrıntılarına
           // ulaşılabildiğini ve sayfada arama yaparak sonuç alınıp alınan sonuçların sayısının görüntülenip
           // ve çıkan sonuçların ayrıntılarına ulaşılabildiğini doğrulayabilmeliyim




    }}


