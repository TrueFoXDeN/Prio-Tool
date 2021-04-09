package org.hbrs.se.ws20.al.model;

public class CommandHelp implements Command{
    @Override
    public void execute(String args) {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        System.out.println("enter                                   Eingabe einer neuen Userstory.");
        System.out.println("dump                                    Zeigt alle Userstorys an.");
        System.out.println("dump status [status]                    Zeigt alle Userstorys mit dem status an.");
        System.out.println("load [mode]                             merge/force, um gespeicherte Userstorys zu laden.");
        System.out.println("store                                   Speichert alle aktiven Userstorys.");
        System.out.println("analyze all                             Analysiert alle User Stories und liefert die Qualität in Prozent.");
        System.out.println("analyze [user story id] details         Analysiert die User Story mit id, liefert die Qualität in Prozent und zeigt details.");
        System.out.println("analyze [user story id] details hints   Analysiert die User Stories und liefert die Qualität in Prozent und zeigt details und hints.");
        System.out.println("addElement actor [akteur]               Registriert einen Aktuer in das Prio-Tool.");
        System.out.println("status [id] [status]                    Ändert den Status einer User Story.");
        System.out.println("actors                                  Zeigt alle registrierten Akteure.");
        System.out.println("undo                                    Letzten Befehl rückgängig machen.");
        System.out.println("exit                                    Beendet das Programm.");
    }

    @Override
    public void undo() {

    }
}
