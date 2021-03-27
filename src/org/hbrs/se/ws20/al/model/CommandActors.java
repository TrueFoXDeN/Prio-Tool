package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.entity.Userstory;
import org.hbrs.se.ws20.al.exception.PersistenceException;

public class CommandActors implements Command{
    @Override
    public void execute(String args) throws ContainerException, PersistenceException {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }

        Userstory.akteure.forEach(e -> System.out.println(e));

    }

    @Override
    public void undo() throws ContainerException, PersistenceException {

    }
}
