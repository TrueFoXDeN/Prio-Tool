package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.entity.Userstory;

import java.util.Scanner;

public class CommandEnter implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) throws ContainerException {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("> Beschreibung: ");
        String beschreibung = sc.nextLine();
        System.out.println("> Akzeptanzkriterien mit ; getrennt eingeben:");
        String[] kriterien = sc.nextLine().split(";");
        System.out.println("> Kennzahlen der Priorisierung:");
        System.out.println("> Mehrwert:");
        int mehrwert = tryAcceptInt(sc);
        System.out.println("> Aufwand:");
        int aufwand = tryAcceptInt(sc);
        System.out.println("> Strafe:");
        int strafe = tryAcceptInt(sc);
        System.out.println("> Risiko:");
        int risiko = tryAcceptInt(sc);
        double prio = (double) (mehrwert + strafe) / (double) (aufwand + risiko);
        Userstory u = new Userstory(beschreibung, kriterien, prio);

        c.addMember(u);

        System.out.println("> Userstory erstellt.");
    }

    @Override
    public void undo() {

    }
    private int tryAcceptInt(Scanner sc) {
        boolean accepted = false;
        int a = 0;
        while (!accepted) {
            try {
                a = sc.nextInt();
                if(a >= 0){
                    accepted = true;
                }else{
                    System.out.println("> Bitte gültigen Wert eingeben:");
                    sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println("> Bitte gültigen Wert eingeben:");
                sc.nextLine();
            }
        }
        return a;
    }
}
