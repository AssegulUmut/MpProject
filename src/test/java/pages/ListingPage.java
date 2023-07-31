package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ListingPage {

    public ListingPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//a[normalize-space()='Listing'])[1]")
    public WebElement listLink;

    @FindBy(xpath = ("//div[@class='item-sorting clearfix']"))
    public WebElement listAramaSonucElementi;

    @FindBy(xpath = "//*[@class='js-cookie-consent-agree cookie-consent__agree']")
    public WebElement listSayfacookies;

    @FindBy(xpath =" //input[@placeholder='Search for a location']")
    public WebElement searchlocationbox;

    @FindBy(xpath = "//*[@id='select2-city_id-container']")
    public WebElement dropDownBoxCity;

    @FindBy(xpath = "//*[@id='select2-ptypes-container']")
    public WebElement dropDownBoxCategory;

    @FindBy(xpath = "//*[@id='select2-select-type-container']")
    public WebElement dropdownType;

    @FindBy(xpath ="//input[@placeholder='Min Area']")
    public WebElement dropdownMin;

    @FindBy(xpath ="//input[@placeholder='Max Area']")
    public WebElement dropdownMax;

    @FindBy(xpath = "//*[@id=\"features\"]/ul")
    public WebElement checkboxList;



    @FindBy(xpath = "//button[@class='btn btn btn-theme-light-2 rounded full-width mt-3']")
    public WebElement findNewHomeButton;


    @FindBy(xpath = "//div[@class='left-column pull-left']")
    public WebElement aramaSonucSayisi;


    @FindBy(xpath = "//h4[@class='m-0']")
    public WebElement aramaSonucDetay;

    @FindBy(xpath = "(//div[@class='listing-content'])[1]")
    public WebElement ilanDetay1;

    @FindBy(xpath = "(//div[@class='listing-content'])[1]")
    public WebElement ilanDetay2;
    @FindBy(xpath = "(//div[@class='listing-content'])[1]")
    public WebElement ilanDetay3;
    @FindBy(xpath = "(//div[@class='listing-content'])[1]")
    public WebElement ilanDetay4;

    @FindBy(xpath = "(//a[@href='https://qa.hauseheaven.com/properties/315-delaware-avenue'])[1]")
    public WebElement ilkIlanDetay;




    @FindBy(xpath = "//h4[@class='property_block_title']")
    public List<WebElement> propertyDetailsList;
    @FindBy(xpath = "//div[@class='slick-slide slick-current slick-active']")
    public List<WebElement> propertiesIlanlar;

//#################################US06

    @FindBy(xpath = "//div[@class='col-lg-6 col-md-12']")
    public List<WebElement> propertiesDetay;

    @FindBy(xpath = "//*[@class='lni-facebook']")
    public WebElement facebookLink;

    @FindBy(xpath = "//*[@class='lni-twitter']")
    public WebElement twitter;

    @FindBy(xpath = "//*[@class='lni-linkedin']")
    public WebElement linkedin;

    @FindBy(xpath = "//a[@class='btn btn-likes add-to-wishlist']")
    public WebElement wishlist;

    @FindBy(xpath = "//div[@id='alert-container']")
    public WebElement alertElement;

   @FindBy(xpath = "//*[@placeholder='Name *']")
    public WebElement nameInput;

   @FindBy(xpath = "//*[@placeholder='Phone *']")
    public WebElement phoneInput;

    @FindBy(xpath = "//*[@placeholder='Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@placeholder='Subject *']")
    public WebElement subjectInput;

    @FindBy(xpath = "//*[@placeholder='Message']")
    public WebElement messageInput;

    @FindBy(xpath = "//*[@class='btn btn-black btn-md rounded full-width']")
    public WebElement submitButton;

    @FindBy(xpath =  "//div[@id='alert-container']")
    public WebElement messageAlert;





}
