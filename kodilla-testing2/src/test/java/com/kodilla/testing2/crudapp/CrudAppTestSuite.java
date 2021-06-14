package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://ciembro.github.io/";
    private WebDriver driver;
    private Random random;

    @BeforeEach
    void initTest(){
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        random = new Random();
    }

    @AfterEach
    void cleanUp(){
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTaskToTrello(taskName);
        checkTaskExistsInTrello(taskName);
//        assertTrue(checkTaskExistsInTrello(taskName));
//        driver.navigate().refresh();
//        deleteTaskFromApp(taskName);
    }

//    private void deleteTaskFromApp(String taskName) throws InterruptedException {
//        getRowElements(taskName).stream()
//                .forEach(theForm -> {
//                    WebElement deleteButton = theForm.findElement(
//                            By.xpath("//form[@class=\"datatable__row\"]//fieldset[1]/button[4]"));
//                    deleteButton.click();
//                });
//        Thread.sleep(2000);
//        driver.navigate().refresh();
//    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("w.ciembroniewicz@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("Anything13");
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        Thread.sleep(4000);

        driverTrello.findElement(By.id("password")).sendKeys("Anything13");
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        //*[@id="content"]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[4]/div/div[2]/ul/li[1]/a/div/div[1]

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    private void sendTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath(("//select[1]"))).isDisplayed());

        getRowElements(taskName).stream()
                    .forEach(theForm -> {
                        WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                        Select select = new Select(selectElement);
                        select.selectByIndex(1);

                        WebElement buttonCreateCard = theForm.findElement
                                (By.xpath(".//button[contains(@class, \"card-creation\")]"));
                        buttonCreateCard.click();
                    });
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();Thread.sleep(5000);

    }

    private List<WebElement> getRowElements(String taskName){
        return driver.findElements
                (By.xpath("//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .collect(Collectors.toList());
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + random.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }
}
