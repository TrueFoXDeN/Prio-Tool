package org.hbrs.se.ws20.al;

import org.hbrs.se.ws20.al.Member;

import java.io.Serializable;

public class MemberObject implements Member, Serializable {
    private int id;

    public MemberObject(int id){
        this.id = id;
    }
    @Override
    public Integer getID() {
        return this.id;
    }
    @Override
    public String toString(){
        return "Member (ID = ["+getID()+"])";
    }
}
