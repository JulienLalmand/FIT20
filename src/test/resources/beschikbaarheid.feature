# language: nl


Functionaliteit: Een trainer wordt toegevoegd en selecteert zijn beschikbare tijden 

Scenario: Er wordt een trainer aangemaakt
Als een Trainer wordt toegevoegd met naam "VDB", voornaam "Hans", accountnaam "hansvdb", email 'hans@vdb.com', rol "Trainer", wachtwoord "TestenIsGeweldig123", status "in gebruik" ;
Dan komt "hansvdb" voor in de lijst van trainers
En kan "hansvdb" inloggen met het wachtwoord "TestenIsGeweldig123"

