package org.hbrs.se.ws20.ui.view;

import org.hbrs.se.ws20.al.model.*;
import org.hbrs.se.ws20.al.control.ContainerException;
import org.hbrs.se.ws20.al.exception.PersistenceException;
import org.hbrs.se.ws20.al.entity.Userstory;
import org.hbrs.se.ws20.in.control.PersistenceStrategyStream;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Client {


    private Container c = Container.getContainerInstance();

    public void start() throws ContainerException, PersistenceException {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");

        HashMap<String, Command> commands = new HashMap();
        commands.put("help", new CommandHelp());
        commands.put("enter", new CommandEnter());
        commands.put("dump", new CommandDump());
        commands.put("load", new CommandLoad());
        commands.put("store", new CommandStore());
        commands.put("analyze", new CommandAnalyze());
        commands.put("addElement", new CommandAddElement());
        commands.put("status", new CommandStatus());
        commands.put("actors", new CommandActors());
        commands.put("exit", new CommandExit());

        Stack<String> history = new Stack<>();

        while (sc.hasNext()) {
            String cmd = sc.next();
            String args = sc.nextLine().trim();

            if(cmd.equals("undo")){
                if(!history.empty()){
                    commands.get(history.pop()).undo();
                }else{
                    System.out.println("Nichts zum Rückgängig machen.");
                }

            }else{
                Command command = commands.get(cmd);

                if(command != null){
                    history.push(cmd);
                    command.execute(args);

                }else{
                    System.out.println("Kommando nicht gefunden. help eingeben, um alle Kommandos aufzulisten.");
                }
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
