package org.hbrs.se.ws20.al.model;

import org.hbrs.se.ws20.ui.view.MemberView;

public class CommandDump implements Command{
    private Container c = Container.getContainerInstance();
    @Override
    public void execute(String args) {
        if (!args.isEmpty()) {
            System.out.println("Falsche Anzahl an Argumenten.");
            return;
        }
        MemberView m = new MemberView();
        m.dump(c.getCurrentList());
        return;
    }

    @Override
    public void undo() {

    }
}
