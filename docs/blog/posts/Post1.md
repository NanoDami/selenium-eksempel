# Automatisering med Selenium
## Del 1. Automatisere vår første test
### Den vitenskapelige metode og test
Vitenskapeliga fakta er ikke bare tilfeldig informasjon som er bestemt av forskere på måfå.
Faktisk går det ikke an å fullstendig bevise noen vitenskapelige fakta.
Den vitenskapelige metode sin hovedmotivasjon er å motbevise andre folks teorier og hypoteser.
For å kunne gjøre det, så må man utføre en empirisk test som viser
et eksempel som ikke samsvarer med denne teorien.
Jo mer man utfører slike tester, jo mer "korrekt" blir denne påstanden man tester.

Når det kommer til et testcase, så prøver jeg å formulere det som 
en vitenskapelig påstand (Gjerne mer raffinert enn: Løsningen funker). Påstanden er en setning som kan være sann eller usann.
Denne påstanden prøver jeg så å motbevise med en test.

For appen vår, ville jeg skrevet påstanden slik:

`Når en person prøver å logge seg inn med et brukernavn og passord vi ikke har registrert på en bruker, 
så vil vedkommende få beskjed om at dette ikke går.`

#### Designe trinnene til testen
Siden jeg er stor tilhenger av den vitenskapelige metode (det er jo den beste og verste metoden vi har for å bli smartere)
så tenker jeg å designe trinnene til testen som trinnene til et vitenskapelig eksperiment.

I et vitenskapelig eksperiment, så ønsker man å isolere ting som er irrelevant for testen som kan påvirke utfallet på en måte
som ikke er relevant til påstanden vi ønsker å motbevise.

Vi ønsker også å gjøre eksperimentet, eller testen, 
så kort som mulig sånn at det er tydelig for alle som leser den hvordan de kan gå frem for å reprodusere den.

En forskjell man må merke seg her, er at den vitenskapelige metode funker på vår virkelige verden, mens automatiske tester funker på det digitale systemet vi jobber med.

Programvareløsningen vår endrer seg, så da må vi vedlikeholde testene våre deretter, mens den virkelige verdenen trenger ikke noe vedlikehold, siden fysikkens lover ikke kommer til å endre seg med det første <sup>(Mangler referanse).</sup>
Så vi må sikre at testene våre er vedlikeholdbare i tillegg.

Denne forskjellen er også reflektert i detaljnivået på testscenarioet vårt også, 
sånn at når vi kommer oss rundt til å skrive kode, 
så må vi fylle inn alle detaljene for å få det til funke også, men når vi skal beskrive testen vår, 
så bruker vi så minimalt med detaljer som mulig, men nok til at alle som leser
skjønner flyten i testen. Vi overlater alle findetaljene til implementasjonsdetaljene som datamaskinen trenger, siden dette
i seg selv ikke er viktig for testen.
I koden vår skal vi altså putte detaljene i gjenbrukbare, lavnivå komponenter som vi skal se på senere.

Testcasen vår kan altså da se slik ut:

```
Når en person prøver å logge seg inn med feil brukernavn og/eller passord vi ikke har registrert på en bruker, 
så vil vedkommende få en feilmelding.
-------------
1. Skriv inn et brukernavn og passord om ikke er registrert
2. Verifiser at man får en feilmelding
```

Det neste trinnet i arbeidsflyten vår vil altså da være å oversette denne testen til kode.
For å oversette dette til kode som både er lett å vedlikeholde og gjenbruke, så vil man at koden skal adlyde
[gode objekt-orienterte designprinsipper](prinsipper.md).
Jeg har tatt meg friheten til å flytte testcasen til [den nye testklassen vår](../../../java-app/src/test/java/LogInTest.java)
Hvor vi kommer til å jobbe videre med den.

###Kode vår første test
Nå skal vi ta testen vi beskrev i forrige avsnitt og og oversette den til gyldig Java-syntax i [LogInTest.java](../../../java-app/src/test/java/LogInTest.java).
Her antar jeg at vi starter med et helt nytt prosjekt, sånn at jeg kan vise hva jeg tenker når jeg starter med nye prosjekter.

Dette her er bare pseudokode og vil ikke kompilere dersom man forsøker, siden vi ikke har implementert noen av klassene vi beskriver enda.
For øyeblikket tenker ikke jeg å fokusere på å bruke selenium og starte automatiseringen helt enda.
```Java
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
        LoggInnPageObject loggInnSide = new LoggInnPageObject(driver);
        // Her setter jeg opp noe data jeg vil teste på
        String brukerNavn = "DMH002";
        String passord = "Nice try, foreign intelligence service...";

        //Her utfører jeg handlingen jeg ønsker
        loggInnSide.loggInnMed(brukerNavn, passord);

        //jUnit sin måte å verifisere. Det blir fine logger av å gjøre det på denne måten.
        //isDisplayed() er en funksjon som spesifiseres av Selenium sitt WebElement-interface.
        assertTrue(loggInnSide.hentFeilMelding().isDisplayed());

    }
}
```
Jeg dropper å vise setup og teardown her, siden det burde man kunne allerede.

Foreløpig vil jeg bare sørge for å få koden til å kompilere og se at modellen min holder mål, en modell her vil altså være strukturen
til klassene og funksjonene. Siden jeg fullfører modellen før jeg fullfører implementasjonen, så kan jeg raskt sjekke om jeg mangler noe eller
må gjøre noe mer.

I tillegg, dersom koden vår ikke kompilerer, så vil vi uansett ikke kunne kjøre testen for å verifisere at ting kjører som forventet.
Her så vil vi ta små skritt for å sikre at koden gjør nøyaktig det den sier den skal.
Derfor vil jeg holde meg til å sørge for at ting kompilerer.

For at funksjonene vi lager skal kunne kompilere, må de ha noe kode for å kunne
bli kompilert og vi kan kjøre på videre, så hver funksjon skal kun gjøre en ting i starten: Kaste en notImplementedException().
Senere vil man se at dette vil hjelpe oss på veien med å skrive god kode og peke oss i riktig retning sammen med feilmeldingene vi nå har i klassen vår.
 
#### Behandle feilmeldingene som en oppgaveliste
Nå har vi en del feilmeldinger i klassen vår og min fremgangsmåte er å behandle det som en TODO-liste vi skal jobbe oss nedover.

Det første vi må gjøre er å håndtere meldingen om at LoggInnPageObject ikke er definert, heldigvis har våre IDE'er gode løsninger for å håndtere dette og 
ved å lese feilmeldingen som vi får fra Eclipse/IntelliJ, så kan man se at den tilbyr seg å lage klassen for oss.
Når jeg gjør dette, får jeg dette fra IntelliJ:
```java
public class LoggInnPageObject {
    WebDriver driver;//Lagt til etter generering
    public LoggInnPageObject(WebDriver driver) {
        this.driver = driver;//Lagt til etter generering
    }
}
```
Den andre feilmeldingen klager på at LoggInnPageObject ikke har noen metode som heter _loggInnMed_
Etter å ha brukt IntelliJ til å hjelpe meg med dette, så får jeg dette i min klasse.
```java
public class LoggInnPageObject {
    WebDriver driver;
    public LoggInnPageObject(WebDriver driver) {
            this.driver = driver;//Lagt til etter generering
    }

    public void loggInnMed(String brukerNavn, String passord) {
        //Jeg har lagt til denne etter genereringen av metoden.
        throw new NotImplementedException();
    }
}
```

Den siste feilmeldingen vi får, er at LoggInnPageObject ikke har en metode som heter _hentFeilMelding_
Dette løser vi på samme måte og nå ser klassen vår slik ut:
```java
public class LoggInnPageObject {
    WebDriver driver;
    public LoggInnPageObject(WebDriver driver) {
            this.driver = driver;//Lagt til etter generering
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
```

Når alle feilmeldinger i testen vår er håndtert, så kan man faktisk kjøre testen ved å klikke på den grønne pilen vi er vant til.
Det som skjer da, er at java vil kompilere koden vår (uten feil, yay!) og vi får vår første feilmelding fra selve testen:
```
NotImplementedException
at LoggInnPageObject.java:9
at LogInTest.loggInnMedFeilBrukerNavn(LogInTest.java:27)
```
Hurra! Dette er veldig flott på grunn av 3 ting
1. Vi vet nå at koden vår kompilerer, som betyr at modellen vår stemmer og ser fremdeles ganske lesbar ut.
2. Vi vet nå at jUnit er konfigurert riktig på vår maskin og kan kjøre tester for oss.
3. Siden vi har lagt inn `NotImplementedException` i koden vår som skal brukes, vil vi alltid få en feilmelding der vi har glemt å skrive kode. Som praktiskt talt dobler som en dynamisk todo-liste.

#### Fikse vår første exception.
Nå er tiden endelig kommet for å skrive noe ordentlig kode som gjør ting.
Vårt første problem ligger i funksjonen loggInnMed(), så la oss implementere den!
Det denne funksjonen skal gjøre, er å logge inn med et brukernavn og passord.
```java
public void loggInnMed(String brukerNavn, String passord) {
        driver.findElement(By.id("username_field")).sendKeys(brukerNavn);
        driver.findElement(By.id("password_field")).sendKeys(passord);
        driver.findElement(By.id("Register")).click();
}
```
Kjører man testen igjen, vil man kunne se dette skje.

## Litteratur
* Arnon Axelrod, Complete Guide to Test Automation.
* https://blog.testlodge.com/scientific-method-software-testing/
* Ryan North, How to invent everything.
 
