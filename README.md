# SE-Übung 4
von Laurenz Dilba (9037743) und Ron Autenrieb (9037538)

## Aufgabe 1
### a) Mindmap
![1](res/1.png)

### b) Userstorys
1. Student loggt sich im Portal ein
    + Aufwandsschätzung: 13
    + Mehrwertschätzung: 8
    + Akzeptanzkriterien
        + Userlogin ist Sicher
        + Logindaten können gespeichert werden
        
2. Student schaut sich verfügbare IT-Projekte
    + Aufwandsschätzung: 8
    + Mehrwertschätzung: 13
    + Akzeptanzkriterien
        + Design ist übersichtlich und verständlich
        + Alle Informationen sind vorhanden
        
3. Student kontaktiert Firma und gibt Projekt bei der Kontaktanfrage an
    + Aufwandsschätzung: 3
    + Mehrwertschätzung: 8
    + Akzeptanzkriterien
        + Firma wird über Kontaktanfrage benachrichtigt
        + Angegebenes Projekt wird Firma übermittelt
        
4. Student chattet mit Firma über Chatportal
    + Aufwandsschätzung: 13
    + Mehrwertschätzung: 5
    + Akzeptanzkriterien
        + Chat funktioniert in Echtzeit
        + Text, Bilder, Link und Dokumente können gesendet werden
        
5. Unternehmen legt IT-Projekt an
    + Aufwandsschätzung: 8
    + Mehrwertschätzung: 13
    + Akzeptanzkriterien
        + Projekt kann von Studenten gefunden werden
        + IT-Projekt kann im nachhinein bearbeitet werden
        + Designmöglichkeiten reichen für Firmen aus
        
6. Unternehmen entfernt abgelaufenes IT-Projekt
    + Aufwandsschätzung: 1
    + Mehrwertschätzung: 3
    + Akzeptanzkriterien
        + Projekt wird nicht mehr in der Suche angezeigt
        + Projekt bleibt gespeichert und kann später reaktiviert werden
        
7. Student löscht sein Konto
    + Aufwandsschätzung: 1
    + Mehrwertschätzung: 1
    + Akzeptanzkriterien
        + Kontodaten sind aus der Datenbank entfernt
        + Alle Bewerbungen des Studenten werden zurückgezogen
        
8. Student zieht seine Bewerbung zurück
    + Aufwandsschätzung: 2
    + Mehrwertschätzung: 3
    + Akzeptanzkriterien
        + Firma wird über Bewerbungsrückzug benachrichtigt
        + Bewerbung wird nicht mehr angezeigt

## Test Suite

### Tests
TestCase No. | Category | Äquivalenzklasse | Input | Output
--- | --- | --- | --- | --- |
1 | pos | Ä1 | help | enter: Enter a new userstory.<br><br>store: Store all current userstorys.<br><br>load \[mode\]: merge/force to load saved userstorys.<br><br>exit: Exit the program.
2 | pos | Ä1 | enter | \> Beschreibung:<br><br>\> Akzeptanzkriterien mit ; getrennt eingeben:<br><br> \> Kennzahlen der Priorisierung:<br> \> Mehrwert:<br> \> Aufwand:<br> \> Strafe:<br> \> Risiko:<br> \> Userstory erstellt.
3 | neg | Ä2 | load | \> Wrong number of arguments.
4 | pos | Ä1 | load merge | MERGE CONFLICT<br>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\><br>LOADED<br>Userstory \[0\]:<br>Beschreibung: Das ist eine Beschreibung<br>Akzeptanzkriterien:<br>- k1<br>- k2<br>- k3<br>- k4<br>Priorität: 0.6666666666666666<br>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\><br>CURRENT<br>Userstory \[0\]:<br>Beschreibung: Das ist eine Beschreibung<br>Akzeptanzkriterien:<br>- k1<br>- k2<br>- k3<br>- k4<br>Priorität: 0.6666666666666666<br>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\>\><br>\> Keep l or c?

### Zugehörige Äquivalenzklassen
Parameter | Äquivalenzklasse | Repräsentant
--- | --- | ---
console input | pos_Ä1 | help
console input | neg_Ä2 | load
