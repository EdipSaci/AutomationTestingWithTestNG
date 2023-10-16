package com.automationtesting.tests;

import com.automationtesting.pages.Homepage;
import com.automationtesting.utilities.ConfigurationReader;
import com.automationtesting.utilities.Driver;
import com.automationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_AddToBasketMoreBooks {

    @Test
    public void addToBasketMoreBook(){

        Homepage homepage = new Homepage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton,2);

        //4) Now click on Home menu button
        homepage.homePageButton.click();

        //5) Test whether the Home page has Three Arrivals only
        Assert.assertEquals(homepage.threeArrivals.size(),3);
        //6) The Home page must contains only three Arrivals

        //7) Now click the image in the Arrivals
        homepage.firstArrivals.click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://practice.automationtesting.in/product/selenium-ruby/");

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        // Driver.getDriver().navigate().back();
        //Assert.assertTrue(homepage.firstArrivals.isEnabled());

        //10) Click on the Add To Basket button which adds that book to your basket
        homepage.addToBasketBtn.click();

        //11) User can view that Book in the Menu item with price.
        String itemText = homepage.itemText.getText();
        Assert.assertEquals(itemText,"1 Item");
        String priceText = homepage.priceText.getText();
        Assert.assertEquals(priceText,"₹500.00");

        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        //14) Click the add to basket button
        //15) Now it throws an error prompt like you must enter a value between 1 and 20

    }
}
