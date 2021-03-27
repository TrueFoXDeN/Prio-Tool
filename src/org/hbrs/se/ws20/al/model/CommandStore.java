package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.exception.PersistenceException;

public class CommandStore implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) throws PersistenceException {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        c.store();
        return;
    }

    @Override
    public void undo() {

    }
}
