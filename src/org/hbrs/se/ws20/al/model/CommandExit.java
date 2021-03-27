package org.hbrs.se.ws20.al.model;

public class CommandExit implements Command{
    @Override
    public void execute(String args) {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        System.exit(0);
    }

    @Override
    public void undo() {

    }
}
