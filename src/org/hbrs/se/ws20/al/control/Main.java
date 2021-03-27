package org.hbrs.se.ws20.al.control;

import org.hbrs.se.ws20.al.exception.PersistenceException;
import org.hbrs.se.ws20.al.model.Container;
import org.hbrs.se.ws20.in.control.PersistenceStrategyStream;
import org.hbrs.se.ws20.ui.view.Client;

public class Main {
    public static void main(String[] args)  {
        try {
            Client c = new Client();
            Container.getContainerInstance().setPersistenceStrategy(new PersistenceStrategyStream<>());
            c.start();
        } catch (ContainerException | PersistenceException e) {
            System.out.println("> "+e);
        }
    }


}
