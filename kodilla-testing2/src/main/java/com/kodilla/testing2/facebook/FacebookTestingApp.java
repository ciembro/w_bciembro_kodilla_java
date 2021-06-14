package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//div[contains(@class, \"_9o-r\")]/button[2]";
    public static final String XPATH_CREATE_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a[@role = \"button\"]";
    public static final String XPATH_WAIT_FOR = "//div[contains(@class, \"_5k_5\")]/span/span";
    public static final String XPATH_BIRTH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement acceptCookiesButton = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES));
        acceptCookiesButton.click();

        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccountButton.click();

        new WebDriverWait(driver, 5).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_WAIT_FOR)));

        WebElement selectDayCombo = driver.findElement(By.xpath(XPATH_BIRTH_DAY));
        Select selectDay = new Select(selectDayCombo);
        selectDay.selectByValue("21");

        WebElement selectMonthCombo = driver.findElement(By.xpath(XPATH_MONTH_DAY));
        Select selectMonth = new Select(selectMonthCombo);
        selectMonth.selectByIndex(6);

        WebElement selectYearCombo = driver.findElement(By.xpath(XPATH_YEAR_DAY));
        Select selectYear = new Select(selectYearCombo);
        selectYear.selectByValue("1994");

    }
}
