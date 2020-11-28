package org.hbrs.se.ws20;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Client c = new Client();
        } catch (ContainerException | PersistenceException | IOException e) {
            e.printStackTrace();
        }
    }

}
