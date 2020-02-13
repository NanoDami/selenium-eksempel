#Prinsipper
##Don't Repeat Yourself (DRY)
Vår første objekt-orienterte designprinsipp er DRY, som betyr ikke skriv duplisert kode, men bruk heller
[Abstraksjon](http://javarevisited.blogspot.com/2010/10/abstraction-in-java.html) for å abstrahere felles ting i en plass.

Hvis du har en kodeblokk i mer enn 2 plasser, vurder å gjør det til en egen metode.
Eller hvis du bruker en hardkoda verdi mer enn en gang, gjør det til en variabel.
Fordelen med dette Objektorienterte designprinsippet ligger i vedlikehold.

Men man kan gå i en felle ved å følge dette for blindt.
Si man bruker en funksjon for å validere en OrdreID og en Personnummer, 
så vil det ikke bety at dette er det samme eller vil oppføre seg likt i fremtiden
Så ved å bruke felles kode for 2 forskjellige funksjonaliteter, så vil man knytte dem for tett, som vil si at hvis
OrdreID endrer formatet, så kan man samtidig risikere å brekke koden til Personnummer.

## SOLID
Et akronym for de fem første Objektorienterte designprinsippene som først ble introdusert av [Uncle Bob](https://en.wikipedia.org/wiki/Robert_Cecil_Martin).
SOLID er en arbeidsmåte som lar oss bygge [løst koblete programvareløsninger](https://en.wikipedia.org/wiki/Loose_coupling).
Å gjøre noe løst koblet, vil si at man kan skille og isolere moduler, sånn at hver modul vil ha en bestemt rolle.

Et eksempel på noe som var løst koblet, var de gamle telefonene: Dersom man trengte 
et nytt batteri, så kunne man bare bytte ut det defekte batteriet med et nytt ett.
Mens idag, har man et tett koblet system som gjør at man må kjøpe en ny telefon dersom batteriet er ødelagt.

Når vi snakker om moduler her, så kan en modul være alt fra en pakke til enkeltfunksjoner.
###S - Single responsibility prinsippet
Dette prinsippet sier at hver modul burde ha ansvar for en enkelt del av funksjonaliteten programvaren tilbyr.
Dette er praktiskt talt det samme som DRY, så her burde jeg skamme meg litt...
###O - Open Closed prinsippet
Dette prinsippet sier at enhver modul er åpen for utvidelser, men stengt for modifikasjoner.
###L - Liskov Substitution prinsippet
Dette prinsippet sier at objekter i et program skal kunne byttes ut med instanser
av deres subtyper uten å endre korrektheten til programmet.
###I - Interface segregeringsprinsippet
Dette prinsippet sier at ingen klient burde bli tvunget til å være avhengig av metoder den ikke bruker.
Ved å definere interfaces, så får man en fin abstraksjon av kode og bygger en barriere som forhindrer tett kobling.
###D - Dependency Inversion prinsippet
Dette prinsippet sier 2 ting:
* at høynivå-moduler ikke burde være avhengig av lavnivå-moduler;
de begge burde være avhengige av abstraksjoner.
* Abstraksjoner burde ikke være avhengig av detaljer. Detaljene burde være avhengig av abstraksjoner

Hvis man er flink og følger O og L, så vil man automatiskt også følge dette.

## Avsluttende ord 

Men man kan fint google disse prinsippene, de er ganske godt dokumentert og diskutert.
#Kilder
* https://blog.testproject.io/2019/04/23/rock-solid-test-automation/
* https://itnext.io/solid-principles-explanation-and-examples-715b975dcad4
* https://hackernoon.com/10-oop-design-principles-every-programmer-should-know-f187436caf65
