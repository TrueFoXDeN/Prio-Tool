package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.exception.PersistenceException;

public class CommandLoad implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) throws ContainerException, PersistenceException {

        if (args.isEmpty() || args.trim().split(" ").length > 1) {
            System.out.println("> Falsche Anzahl an Argumenten.");
            return;
        }

        if (args.equals("merge")) {
            c.storeBackup();
            c.load(0);
        } else if (args.equals("force")) {
            c.storeBackup();
            c.load(1);
        } else {
            System.out.println("> Falsches Argument.");
        }
        return;
    }

    @Override
    public void undo() throws ContainerException, PersistenceException {
        c.loadBackup();
    }
}
