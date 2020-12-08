package org.hbrs.se.ws20;

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
