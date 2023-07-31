package tests.US05_US06_US20_US21;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US21 {
    ListingPage listingPage=new ListingPage();
    Faker faker=new Faker();
    @Test
    public void TC01() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //The registered user should be able to access the details of
        //the properties by clicking the listing link on the top bar of the homepage.

        listingPage.listLink.click();
       ReusableMethods.waitFor(3);
    List<WebElement> ilanDetaylari= Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay2")));
        for (WebElement eachilan:ilanDetaylari) {
        Assert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
        // System.out.println(eachilan.getText());

            //The ad must be shareable from the social media addons on the Share link.

            Assert.assertTrue(listingPage.facebookLink.isEnabled());
            Assert.assertTrue(listingPage.twitter.isEnabled());
            Assert.assertTrue(listingPage.linkedin.isEnabled());
            listingPage.wishlist.sendKeys(Keys.ENTER);
            ReusableMethods.waitFor(3);

            // The ad must be added to the wishlist.
            Assert.assertTrue(listingPage.alertElement.isDisplayed());


            //Kayıtlı kullanıcı olarak sitedeki mülklerin bilgi ayrıntılarına
            // ulaşıp ilgili ilanın sosyal medyada paylaşılabilir durumda olduğunu,
            // wishliste eklenebildiğini, puan verilebildiğini ve  yorum yazılabildiğini doğrulayabilmeliyim


        }
}}
