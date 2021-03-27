package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.al.entity.Userstory;

import java.text.DecimalFormat;


public class CommandAnalyze implements Command {
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);


        String[] a = args.trim().split(" ");
        if (a.length == 1) {
            //analyze 1
            if (a[0].matches("\\d")) {
                Userstory u = (Userstory) c.getMemberByID(Integer.valueOf(a[0]));

                System.out.println("Ihre User Story mit der ID "+a[0]+ " hat folgende Qualität:\n" +
                        df.format(calculateQuality(u,0) *100) + "%");

            //analyze all
            } else if (a[0].equals("all")) {
                float sum = 0;
                for(Member m : c.getCurrentList()){
                    sum += calculateQuality((Userstory) m,0);
                }
                sum /= c.getCurrentList().size();
                sum *= 100;
                System.out.println("Ihre "+c.getCurrentList().size()+" User Stories haben durchschnittlich folgende Qualität:\n" +
                        df.format(sum) + "%");
            }
        }

        if (a.length >= 2) {
            if (a[0].matches("\\d")) {
                //analyze 1 details
                if (a[1].equals("details")) {
                    Userstory u = (Userstory) c.getMemberByID(Integer.valueOf(a[0]));
                    System.out.println("Ihre User Story mit der ID "+a[0]+ " hat folgende Qualität:\n" +
                            df.format(calculateQuality(u,0) *100 )+ "%");

                    //Für die Ausgabe der Details
                    calculateQuality(u,1);
                    if(a.length == 3){
                        //analyze 1 details hints
                        if(a[2].equals("hints")){
                            //Für die Ausgabe der Hints
                            calculateQuality(u,2);
                        }
                    }
                }

            }
        }
    }

    @Override
    public void undo() {

    }

    private float calculateQuality(Userstory u, int mode){
        boolean hasActor = false;
        for(String s:Userstory.akteure){
            if(u.getBeschreibung().contains(s)) hasActor = true;
        }
        if(!hasActor){
            String temp = u.getBeschreibung().substring(u.getBeschreibung().indexOf(" "));
            int index = 0;

            for (int i = 0; i < temp.length(); i++){
                if (Character.isUpperCase(temp.charAt(i))) {
                    index = temp.charAt(i);
                    break;
                }
            }

            String firstNoun = temp.trim().substring(temp.indexOf(index)-1);
            firstNoun = firstNoun.substring(0,firstNoun.indexOf(" "));
//            System.out.println(firstNoun);

            if(u.getBeschreibung().contains(firstNoun)){
                if(Userstory.akteure.contains(firstNoun)) hasActor = true;
            }
            if(mode == 1){
                System.out.println("Kein registrierter Akteur gefunden. Akteur (\""+firstNoun+"\") ist nicht bekannt. (-20%)");
            }
            if(mode == 2){
                System.out.println("Registrieren Sie einen neuen Aktuer!");
            }
        }

        boolean hasValue = false;
        String[] keywords = {"damit","um","sodass","so dass","dass", "das soll", ", was", "deswegen", "darum", "weshalb"};
        for(String s:keywords){
            if(u.getBeschreibung().contains(s)) hasValue = true;
        }
        if(!hasValue){
            if(mode == 1){
                System.out.println("Kein schriftlicher Mehrwert erkannt. (-20%)");
            }
            if(mode == 2){
                System.out.println("Fügen Sie eine Beschreibung in natürlicher Sprache hinzu.");
            }
        }

        boolean hasMeaningfulPrio = false;
        if(u.getPrio() <=5) hasMeaningfulPrio = true;

        if(!hasMeaningfulPrio){
            if(mode == 1){
                System.out.println("Keine sinnvolle Priorität vorhanden. (-20%)");
            }
            if(mode == 2){
                System.out.println("Prioritätenskala von 1 - 5 verwenden.");
            }
        }

        boolean hasCriteria = false;
        if(u.getAkzeptanzkriterien().length > 0) hasCriteria = true;

        if(!hasCriteria){
            if (mode == 1){
                System.out.println("Keine Akzeptanzkriterien vorhanden. (-20%)");
            }
            if (mode == 2){
                System.out.println("Fügen sie Akzeptanzkriterien hinzu.");
            }
        }

        boolean hasAcceptedLength = false;
        if(u.getBeschreibung().length() > 50 && u.getBeschreibung().length() < 500) hasAcceptedLength = true;

        if(!hasAcceptedLength){
            if(mode == 1){
                System.out.println("Beschreibungslänge nicht angemessen. (-20%)");
            }
            if(mode == 2){
                System.out.println("Bleiben Sie in der Beschreibungslänge zwischen 50 und 500 Zeichen.");
            }
        }

        float sum = 0;
//        System.out.println(hasActor);
//        System.out.println(hasValue);
//        System.out.println(hasMeaningfulPrio);
//        System.out.println(hasCriteria);
//        System.out.println(hasAcceptedLength);
        sum += hasActor ? 0.2 : 0;
        sum += hasValue ? 0.2 : 0;
        sum += hasMeaningfulPrio ? 0.2 : 0;
        sum += hasCriteria ? 0.2 : 0;
        sum += hasAcceptedLength ? 0.2 : 0;

        return sum;
    }
}
