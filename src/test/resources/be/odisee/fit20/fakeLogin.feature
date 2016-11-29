# language: nl

Functionaliteit: Een persoon logt zich aan met gegevens die niet bestaan

Achtergrond:
Gegeven een browser is open

Scenario: Een persoon gaat naar de loginpagina en probeert met verkeerde gegevens in te loggen
Als deze persoon naar de loginpagina gaat
Als deze een onbestaande gebruikersnaam "x" en een onbestaande wachtwoord "y" invoert
Dan is deze persoon nog steeds op de loginpagina
En kan hij zich steeds inloggen
En kan hij zich niet uitloggen

