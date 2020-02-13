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


## Litteratur
* Arnon Axelrod, Complete Guide to Test Automation.
* https://blog.testlodge.com/scientific-method-software-testing/
* Ryan North, How to invent everything.
 
