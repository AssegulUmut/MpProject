package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserHomepage {

    public UserHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // HEADER
    // Home Link locate on header -- Header kismindaki home linki
    @FindBy(xpath = "//a[@href='https://qa.hauseheaven.com/properties?layout=sidebar']")
    public WebElement home;

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    public WebElement signupButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement usernamegiris;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordGiris;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginGiris;




    }

