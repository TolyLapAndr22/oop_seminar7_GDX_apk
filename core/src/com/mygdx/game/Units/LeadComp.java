package com.mygdx.game.Units;

import java.util.Comparator;

public class LeadComp implements Comparator<UnitBase> {
    @Override
    public int compare(UnitBase o1, UnitBase o2) {
        if (o1.lead < o2.lead)
            return 1;
        else if (o1.lead > o2.lead)
            return -1;
        else
            return 0;
        //return Integer.compare(o1.lead, o2.lead);
    }
}
