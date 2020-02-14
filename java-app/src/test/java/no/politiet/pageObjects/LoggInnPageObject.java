package no.politiet.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LoggInnPageObject {
    WebDriver driver;
    public LoggInnPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void loggInnMed(String brukerNavn, String passord) {
        driver.findElement(By.id("username_field")).sendKeys(brukerNavn);
        driver.findElement(By.id("password_field")).sendKeys(passord);
        driver.findElement(By.id("Register")).click();
    }

    public WebElement hentFeilMelding() {
        //Jeg har lagt til denne etter genereringen av metoden.
        return driver.findElement(By.cssSelector("body > div.jumbotron > div > div > div > div.alert.alert-danger"));
    }
}
