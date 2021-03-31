package org.hbrs.se.ws20.al.entity;

import org.hbrs.se.ws20.al.model.Member;

import java.io.Serializable;
import java.util.LinkedList;

public class Userstory implements Member, Serializable {
    String beschreibung;
    String[] akzeptanzkriterien;
    double prio;
    private int id;
    public static LinkedList<String> akteure = new LinkedList<>();
    public static int idCounter = 0;
    public enum statusWerte {done, progress, todo}
    private statusWerte status;

    public Userstory(String beschreibung, String[] akzeptanzkriterien, double prio) {
        this.beschreibung = beschreibung;
        this.akzeptanzkriterien = akzeptanzkriterien;
        this.prio = prio;
        id = idCounter++;
        status = statusWerte.todo;
    }

    @Override
    public String toString() {
        String s = "Userstory [" + id + "]: \nBeschreibung: " + beschreibung + "\nAkzeptanzkriterien:\n";
        if (!(akzeptanzkriterien.length == 1 && akzeptanzkriterien[0].isEmpty())) {
            for (String a : akzeptanzkriterien) {
                s += "- " + a + "\n";
            }
        }
        s += "Priorität: " + prio + "\n";
        s += "Status: " + status +"\n";
        s += "--------------";
        return s;
    }

    @Override
    public Integer getID() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String[] getAkzeptanzkriterien() {
        return akzeptanzkriterien;
    }

    public void setAkzeptanzkriterien(String[] akzeptanzkriterien) {
        this.akzeptanzkriterien = akzeptanzkriterien;
    }

    public double getPrio() {
        return prio;
    }

    public void setPrio(double prio) {
        this.prio = prio;
    }

    public statusWerte getStatus() {
        return status;
    }

    public void setStatus(String status) throws IllegalArgumentException{

        try {
            this.status = statusWerte.valueOf(status);
        } catch (IllegalArgumentException e) {
            System.out.println("Status "+status + " existiert nicht.");
        }
    }
}
