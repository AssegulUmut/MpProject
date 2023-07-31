package tests.US05_US06_US20_US21;
import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import utilities.*;

import java.util.List;

public class US06  {
      ListingPage listingPage=new ListingPage();
      Faker faker=new Faker();

    //Ziyaretçi olarak list linkinde cikan mülklerin bilgi ayrıntılarına ulaşılabilmelidir.
    //İlan Share linkinde cikan sosyal medya eklentilerinden paylaşılabilir durumda olmalıdır.
    //İlan wishliste eklenebilmelidir.
    //Emlakciya mesaj gönderilebildigi dogrulanmalidir.
    @Test
    public void TC01() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //As a visitor, the information details of the properties in the list link should be accessible.
        listingPage.listLink.click();
       ReusableMethods.waitFor(3);
        List<WebElement> ilanDetaylari=Driver.getDriver().findElements(By.xpath(ConfigReader.getProperty("ilanDetay2")));
        for (WebElement eachilan:ilanDetaylari) {
            Assert.assertTrue(eachilan.isDisplayed(), "Liste goruntulenemedi");
           // System.out.println(eachilan.getText());
        }


        listingPage.listSayfacookies.click();
        ReusableMethods.waitFor(2);
        listingPage.ilkIlanDetay.click();

       // The ad must be shareable from the social media attachments on the Share link.

        Assert.assertTrue(listingPage.facebookLink.isEnabled());
        Assert.assertTrue(listingPage.twitter.isEnabled());
        Assert.assertTrue(listingPage.linkedin.isEnabled());
        listingPage.wishlist.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);

        // The ad must be added to the wishlist.
        Assert.assertTrue(listingPage.alertElement.isDisplayed());

        //Emlakciya mesaj gönderilebildigi dogrulanmalidir.
        listingPage.nameInput.sendKeys(faker.name().fullName());
        listingPage.phoneInput.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.waitFor(2);
        listingPage.emailInput.sendKeys(faker.internet().emailAddress());
       // listingPage.subjectInput.sendKeys(faker.name().name());
        listingPage.messageInput.sendKeys("Mesajınız iletildi");
        ReusableMethods.waitFor(2);
        listingPage.submitButton.sendKeys(Keys.ENTER);
        Assert.assertTrue(listingPage.messageAlert.isEnabled());

      Driver.closeDriver();


    }
}








