package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.entity.Userstory;
import org.hbrs.se.ws20.al.exception.PersistenceException;

public class CommandAddElement implements Command{
    @Override
    public void execute(String args) throws ContainerException, PersistenceException {

        if (args.trim().split(" ").length <= 1) {
            System.out.println("> Falsche Anzahl an Argumenten.");
            return;
        }
        if(args.startsWith("actor")){
            Userstory.akteure.addLast(args.substring(6));
        }
    }

    @Override
    public void undo() throws ContainerException, PersistenceException {
        Userstory.akteure.removeLast();
    }
}
