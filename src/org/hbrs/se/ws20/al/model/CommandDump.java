package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.ui.view.MemberView;

public class CommandDump implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) {
        String[] a = args.trim().split(" ");

        if(args.isEmpty()){


            MemberView m = new MemberView();
            m.dump(c.getCurrentList());
            return;
        }
        if (a.length <= 1) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        if(a[0].equals("status")){
            try {
                MemberView m = new MemberView();
                m.dumpStatus(c.getCurrentList(), a[1]);
            } catch (IllegalArgumentException e) {
                System.out.println("Status "+a[1] +" nicht vorhanden. Verfügbar: {todo, progress, done}");
            }
            return;
        }
    }

    @Override
    public void undo() {

    }
}
