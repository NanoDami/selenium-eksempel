import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        LoggInnPageObject loggInnSide = new LoggInnPageObject();
        String brukerNavn = "DMH002";
        String passord = "Nice try, foreign intelligence service...";
        loggInnSide.loggInnMed(brukerNavn, passord);
        assertTrue(loggInnSide.feilMelding.isVisible());

    }
}
