package org.hbrs.se.ws20;

import java.io.Serializable;

public class Userstory implements Member, Serializable {
    String beschreibung;
    String[] akzeptanzkriterien;
    double prio;
    private int id;
    public static int idCounter = 0;

    public Userstory(String beschreibung, String[] akzeptanzkriterien, double prio) {
        this.beschreibung = beschreibung;
        this.akzeptanzkriterien = akzeptanzkriterien;
        this.prio = prio;
        id = idCounter++;
    }

    @Override
    public String toString() {
        String s = "Userstory [" + id + "]: \nBeschreibung: " + beschreibung + "\nAkzeptanzkriterien:\n";
        if (!(akzeptanzkriterien.length == 1 && akzeptanzkriterien[0].isEmpty())) {
            for (String a : akzeptanzkriterien) {
                s += "- " + a + "\n";
            }
        }
        s += "Priorität: " + prio;
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
}
