import no.politiet.pageObjects.LoggInnPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInTest {
/*
    Når en person prøver å logge seg inn med feil brukernavn og/eller passord vi ikke har registrert på en bruker,
    så vil vedkommende få en feilmelding.
    -------------
    1. Skriv inn et brukernavn og passord om ikke er registrert
    2. Verifiser at man får en feilmelding
 */
    @Test //Sier at dette er en testfunksjon.
    @DisplayName("Se at man ikke kan logge inn med feil brukernavn") // Hvordan vi vil kunne se denne testen i logger.
    void loggInnMedFeilBrukerNavn() {

        // Instansierer et nytt LoggInnPageObject
        LoggInnPageObject loggInnSide = new LoggInnPageObject();
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
