package org.hbrs.se.ws20.ui;

import org.hbrs.se.ws20.al.Member;
import org.hbrs.se.ws20.al.Userstory;

import java.util.Comparator;
import java.util.List;

public class MemberView {
    public void dump(List<Member> list){
        List<?> t = list;
        List<Userstory> l = (List<Userstory>) t;
        l.stream().sorted(Comparator.comparingDouble(Userstory::getPrio))
                .forEach(System.out::println);
    }

}
