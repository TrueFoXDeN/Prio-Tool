package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.exception.PersistenceException;

public interface Command {

    void execute(String args) throws ContainerException, PersistenceException;
    void undo();

}
