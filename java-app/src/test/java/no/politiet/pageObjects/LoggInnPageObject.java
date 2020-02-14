package no.politiet.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LoggInnPageObject {
    WebDriver driver;
    public LoggInnPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void loggInnMed(String brukerNavn, String passord) {

        //Jeg har lagt til denne etter genereringen av metoden.
        throw new NotImplementedException();
    }

    public WebElement hentFeilMelding() {
        //Jeg har lagt til denne etter genereringen av metoden.
        throw new NotImplementedException();
    }
}
