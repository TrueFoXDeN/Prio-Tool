package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.exception.ContainerException;
import org.hbrs.se.ws20.al.entity.Userstory;
import org.hbrs.se.ws20.al.exception.PersistenceException;

public class CommandStatus implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) throws ContainerException, PersistenceException {
        String[] a = args.trim().split(" ");
        if (args.trim().split(" ").length <= 1) {
            System.out.println("> Falsche Anzahl an Argumenten.");
            return;
        }

        Userstory u = (Userstory) c.getMemberByID(Integer.valueOf(a[0]));
        u.setStatus(a[1]);
    }

    @Override
    public void undo() throws ContainerException, PersistenceException {

    }
}
