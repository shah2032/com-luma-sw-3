package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        // Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.linkText("Tops"));
        //Click on Jackets
        clickOnElement(By.linkText("Jackets"));
        //Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.xpath("//select[@id='sorter']"), "price");
        //Verify the products name display in alphabetical order
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        mouseHoverToElement(By.linkText("Tops"));

        clickOnElement(By.linkText("Jackets"));
        selectByValueFromDropDown(By.xpath("//select[@id='sorter']"), "price");

//Verify the products price display in Low to High
        List<WebElement> multiElement = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        System.out.println("Total Items are: " + multiElement.size());
        double tmpValue = 0;
        for (WebElement list : multiElement) {
            String name1 = list.getText().replaceAll("[$]", "");
            ;
            System.out.println(name1);
            double itemValue = Double.valueOf(name1);
            Assert.assertTrue("products price display not in Low to High.", itemValue >= tmpValue);
            tmpValue = itemValue;
        }
    }
    @After
    public void tearDown() {
        // closeBrowser();
}
}