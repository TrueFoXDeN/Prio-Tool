package org.hbrs.se.ws20.al.model;

public class CommandHelp implements Command{
    @Override
    public void execute(String args) {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        System.out.println("enter        Eingabe einer neuen Userstory.");
        System.out.println("store        Speichert alle aktiven Userstorys.");
        System.out.println("load [mode]  merge/force, um gespeicherte Userstorys zu laden.");
        System.out.println("dump         Zeigt alle Userstorys an.");
        System.out.println("exit         Beendet das Programm.");
    }

    @Override
    public void undo() {

    }
}
