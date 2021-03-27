package org.hbrs.se.ws20.al;

import org.hbrs.se.ws20.in.PersistenceStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Container {
    private LinkedList<Member> list = new LinkedList<>();
    private PersistenceStrategy<Member> persistenceStrategy;

    private static Container container;

    private Container() {
    }

    public static Container getContainerInstance() {
        if (container == null) {
            container = new Container();
            return container;
        } else {
            return container;
        }
    }

    public void store() throws PersistenceException {
        persistenceStrategy.save(list);
    }

    public void load(int mode) throws PersistenceException, ContainerException {
        if (mode == 0) {
            LinkedList<Member> tempList = (LinkedList<Member>) persistenceStrategy.load();
            for(Member m : tempList){
                try {
                    addMember(m);
                } catch (ContainerException e) {
                    System.out.println("MERGE CONFLICT");
                    System.out.println(">>>>>>>>>>>>>>>>>>");
                    System.out.println("LOADED");
                    System.out.println(m);
                    System.out.println(">>>>>>>>>>>>>>>>>>");
                    System.out.println("CURRENT");
                    System.out.println(getMemberByID(m.getID()));
                    System.out.println(">>>>>>>>>>>>>>>>>>");
                    System.out.println("> Keep l or c?");
                    Scanner sc = new Scanner(System.in);
                    String s = sc.next();
                    if(s.equals("l")){
                        deleteMember(m.getID());
                        addMember(m);
                    }else if(s.equals("c")){
                        //Do nothing
                    }else{
                        System.out.println("Wrong argument. Merge aborted.");
                    }

                }
            }

        } else if (mode == 1) {
            list = (LinkedList<Member>) persistenceStrategy.load();
        }
        int maxid = 0;
        for(Member m : list){
            if(m.getID() > maxid) maxid = m.getID();
        }
        Userstory.idCounter = maxid+1;

    }

    public void addMember(Member member) throws ContainerException {
        if (member != null) {
            if (!contains(member.getID())) {
                list.add(member);
            } else {
                throw new ContainerException("Das Member-Objekt mit der ID [" + member.getID() + "] ist bereits vorhanden!");
            }
        }

    }

    public Member getMemberByID(int id){
        for (Member m : list) {
            if (m.getID().equals(id)) {
                return m;
            }
        } return null;
    }

    private boolean contains(int id) {
        for (Member m : list) {
            if (m.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String deleteMember(int id) {
        Member toDelete = null;
        for (Member m : list) {
            if (m.getID().equals(id)) {
                toDelete = m;
            }
        }
        if (toDelete != null) {
            list.remove(toDelete);
            return "Member (ID = [" + id + "]) deleted";
        }

        return "Member (ID = [" + id + "]) not found";

    }


    public void setPersistenceStrategy(PersistenceStrategy<Member> persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    /**
     * Welche Nachteile ergeben sich aus ihrer Sicht für ein solchen
     * Fehler- handling gegenüber einer Lösung mit Exceptions?
     * <p>
     * Beim Vergleichen von Strings können leicht Fehler auftreten.
     * Jeder unterschied im Vergleichs-String führt auch zu fehlerhaften Prüfung.
     * String vergleich mit == sind von gleicher Speicheradresse abhängig,
     * daher sollte die Rückgabe mit der equals-Methode erfolgen.
     */

    public void clearList() {
        list.clear();
    }

    public List<Member> getCurrentList() {
        return list;
    }

    public int size() {
        return list.size();
    }
}
