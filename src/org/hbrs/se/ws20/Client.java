package org.hbrs.se.ws20;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Client {


    private Container c = Container.getContainerInstance();

    public Client() throws ContainerException, PersistenceException, IOException {
        c.setPersistenceStrategy(new PersistenceStrategyStream<>());
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        while(sc.hasNext()){
            String cmd = sc.next();
            String args = sc.nextLine().trim();

            switch (cmd){
                case "enter":
                    if(args.length() != 0) throw new IOException("Wrong number of arguments.");
                    System.out.println("> Beschreibung: ");
                    String beschreibung = sc.nextLine();
                    System.out.println("> Akzeptanzkriterien mit ; getrennt eingeben:");
                    String[] kriterien = sc.nextLine().split(";");
                    System.out.println("> Kennzahlen der Priorisierung:");
                    System.out.println("> Mehrwert:");
                    int mehrwert = sc.nextInt();
                    System.out.println("> Aufwand:");
                    int aufwand = sc.nextInt();
                    System.out.println("> Strafe:");
                    int strafe = sc.nextInt();
                    System.out.println("> Risiko:");
                    int risiko = sc.nextInt();
                    double prio = (double)(mehrwert + strafe)/(double)(aufwand + risiko);
                    Userstory u = new Userstory(beschreibung, kriterien, prio);
                    c.addMember(u);
                    System.out.println("> Userstory erstellt.");

                    break;
                case "store":
                    if(args.length() != 0) throw new IOException("Wrong number of arguments.");
                    c.store();
                    break;
                case "load":
                    if(args.split(" ").length != 1) throw new IOException("Wrong number of arguments.");
                    if(args.equals("merge")){
                        c.load(0);
                    }else if(args.equals("force")){
                        c.load(1);
                    }
                    break;
                case "dump":
                    if(args.length() != 0) throw new IOException("Wrong number of arguments.");
                    MemberView m = new MemberView();
                    m.dump(c.getCurrentList());
                    break;
                case "exit": if(args.length() != 0) throw new IOException("Wrong number of arguments.");
                    System.exit(0);
                    break;
                case "help":
                    System.out.println("enter        Enter a new userstory.");
                    System.out.println("store        Store all current userstorys.");
                    System.out.println("load [mode]  merge/force to load saved userstorys.");
                    System.out.println("exit         Exit the program.");

                    break;
                default:
                    System.out.println("Command not found. Enter help.");
            }

            System.out.print("> ");
        }

    }

    public void addMember() throws ContainerException {

    }

    public void deleteMember(){

    }
}
