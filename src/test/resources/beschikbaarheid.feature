# language: nl


Functionaliteit: Een trainer wordt toegevoegd en selecteert zijn beschikbare tijden 

Scenario: Er wordt een trainer aangemaakt
Als een Trainer wordt toegevoegd met naam "VDB", voornaam "Hans", accountnaam "hansvdb", email 'hans@vdb.com', rol "Trainer", wachtwoord "TestenIsGeweldig123", status "in gebruik" ;
Dan komt "hansvdb" voor in de lijst van trainers
En kan "hansvdb" inloggen met het wachtwoord "TestenIsGeweldig123"
En "hansvdb" komt voor in de lijst van de personen opgeslaan in de database 

Scenario: Een trainer voegt zijn beschikbaarheden toe en zorgt dat deze worden opgeslaan
Als "hansvdb" een beschikbaarheid toevoegd op "26/11/2016 14:00"
En nog een beschikbaarheid toevoegd op "31/11/2016 15:30"
Dan komt de beschikbaarheid "26/11/2016 14:00" en "31/11/2016 15:30" voor in de lijst die wordt opgevraagd

Scenario: Een fitnesser wordt aangemaakt en bekijkt de lijst met beschikbaarheden
Als een Fitnesser wordt toegevoegd met naam "De brabant", voornaam "Jan", accountnaam "jandb", email 'jan@db.com', rol "Fitnesser", wachtwoord "TestenIsGeweldig123", status "in gebruik" ;
Dan komt "jandb" voor in de lijst van fitnessers

Scenario: Een fitnesser selecteert een trainingsslot 
Als "jandb" het trainingsslot "31/11/2016 15:30" selecteert
Dan wordt een trainingsslot in naam van "jandb" aangemaakt met "hansvdb" als trainer, met programma "Sport", Status "Aangemaakt", op  "31/11/2016 15:30", met klanttevredenheid "1000%"
