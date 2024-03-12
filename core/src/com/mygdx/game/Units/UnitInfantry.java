package com.mygdx.game.Units;

import java.util.ArrayList;

abstract public class UnitInfantry extends UnitBase {

    public UnitInfantry(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        super(x, y, name, health, stamina, weapon, lead);
    }

    @Override
    public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {

        if (health==0) return true;
        findТearУnemy(team);
        if(this.teamIndex == -1)return false;
        UnitBase unitTag =team.get(this.teamIndex);
        if(position.Distance(unitTag.position)<2){
            unitTag.GetDamage(1);
            //System.out.println(this+" >> attacks "+team.get(this.teamIndex)+" | Distance "+position.Distance(unitTag.position));
            return true;
        }
        Place diff = position.Difference(unitTag.position);
        Place newPosit = new Place(position.x,position.y);
        if (Math.abs(diff.x)> Math.abs(diff.y))
            newPosit.x+=diff.x < 0 ? 1: -1;
        else newPosit.y+=diff.y <0 ? 1 :-1;
        for (UnitBase unit :frteam) {
            if(unit.position.equal(newPosit) && unit.health>0) {
                //System.out.println(this+" svoi "+unit);
                return true;
            }
        }
        this.position=newPosit;
        //System.out.println(this+" > attacks "+team.get(this.teamIndex)+" | Distance "+position.Distance(unitTag.position));
return true;
    }

}
