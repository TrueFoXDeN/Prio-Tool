package org.hbrs.se.ws20.al;

import org.hbrs.se.ws20.ui.Client;

public class Main {
    public static void main(String[] args)  {
        try {
            Client c = new Client();
            c.start();
        } catch (ContainerException | PersistenceException e) {
            System.out.println("> "+e.getMessage());
        }
    }


}
