package org.hbrs.se.ws20.ui.view;

import org.hbrs.se.ws20.al.model.Container;
import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.exception.PersistenceException;
import org.hbrs.se.ws20.al.entity.Userstory;
import org.hbrs.se.ws20.in.control.PersistenceStrategyStream;

import java.util.Scanner;

public class Client {


    private Container c = Container.getContainerInstance();

    public void start() throws ContainerException, PersistenceException {
        c.setPersistenceStrategy(new PersistenceStrategyStream<>());
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        while (sc.hasNext()) {
            String cmd = sc.next();
            String args = sc.nextLine().trim();

            switch (cmd) {
                case "enter":
                    if (!args.isEmpty()) {
                        System.out.println("Falsche Anzahl an Argumenten.");
                        break;
                    }
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

                    break;
                case "store":
                    if (!args.isEmpty()) {
                        System.out.println("Falsche Anzahl an Argumenten.");
                        break;
                    }
                    c.store();
                    break;
                case "load":
                    if (args.isEmpty() || args.trim().split(" ").length > 1) {
                        System.out.println("> Falsche Anzahl an Argumenten.");
                        break;
                    }
                    if (args.equals("merge")) {
                        c.load(0);
                    } else if (args.equals("force")) {
                        c.load(1);
                    } else {
                        System.out.println("> Falsches Argument.");
                    }
                    break;
                case "dump":
                    if (!args.isEmpty()) {
                        System.out.println("Falsche Anzahl an Argumenten.");
                        break;
                    }
                    MemberView m = new MemberView();
                    m.dump(c.getCurrentList());
                    break;
                case "exit":
                    if (!args.isEmpty()) {
                        System.out.println("Falsche Anzahl an Argumenten.");
                        break;
                    }
                    System.exit(0);
                    break;
                case "help":
                    if (!args.isEmpty()) {
                        System.out.println("Falsche Anzahl an Argumenten.");
                        break;
                    }
                    System.out.println("enter        Eingabe einer neuen Userstory.");
                    System.out.println("store        Speichert alle aktiven Userstorys.");
                    System.out.println("load [mode]  merge/force, um gespeicherte Userstorys zu laden.");
                    System.out.println("dump         Zeigt alle Userstorys an.");
                    System.out.println("exit         Beendet das Programm.");
                    break;
                default:
                    System.out.println("Kommando nicht gefunden. help eingeben, um alle Kommandos aufzulisten.");
            }

            System.out.print("> ");
        }
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
