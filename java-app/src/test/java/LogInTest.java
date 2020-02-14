import io.github.bonigarcia.wdm.WebDriverManager;
import no.politiet.pageObjects.LoggInnPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInTest {
/*
    Når en person prøver å logge seg inn med feil brukernavn og/eller passord vi ikke har registrert på en bruker,
    så vil vedkommende få en feilmelding.
    -------------
    1. Skriv inn et brukernavn og passord om ikke er registrert
    2. Verifiser at man får en feilmelding
 */

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    WebDriver driver;
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test //Sier at dette er en testfunksjon.
    @DisplayName("Se at man ikke kan logge inn med feil brukernavn") // Hvordan vi vil kunne se denne testen i logger.
    void loggInnMedFeilBrukerNavn() {

        // Instansierer et nytt LoggInnPageObject
        LoggInnPageObject loggInnSide = new LoggInnPageObject(driver);
        // Her setter jeg opp noe data jeg vil teste på
        String brukerNavn = "DMH002";
        String passord = "Nice try, foreign intelligence service...";

        //Her utfører jeg handlingen jeg ønsker
        loggInnSide.loggInnMed(brukerNavn, passord);

        //jUnit sin måte å verifisere. Det blir fine logger av å gjøre det på denne måten.
        //isVisible er en funksjon som spesifiseres av Selenium sitt WebElement-interface.
        assertTrue(loggInnSide.hentFeilMelding().isDisplayed());

    }
}
