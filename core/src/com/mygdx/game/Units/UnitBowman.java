package com.mygdx.game.Units;

import java.util.ArrayList;

public class UnitBowman extends UnitBase {

    protected int amounOfarrows=10; //кол стрел
    public UnitBowman(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        super(x, y, name, health, stamina, weapon, lead);
    }

    @Override
    public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {

        if(!death(UnitBowman.this )) return true;

        if(this.amounOfarrows>0){
            findТearУnemy(team);
            if(this.teamIndex == -1)return false;
            team.get(this.teamIndex).GetDamage(1);
            for(UnitBase unit :frteam){
                if (unit.getInfo().equals("Оруженосец")&&!((Peasant)unit).flag){
                    ((Peasant)unit).flag=true;
                    //System.out.println(this+" > attacks "+team.get(this.teamIndex)+" | оруженосец "+unit.name+" дал стрелу");
                    return true;
                }
            }

            this.amounOfarrows-=1;
            //System.out.println(this+" > attacks "+team.get(this.teamIndex)+" | оруженосец не найден");
        }else {
            for(UnitBase unit :frteam){
                if (unit.getInfo().equals("Оруженосец")&&!((Peasant)unit).flag){
                    ((Peasant)unit).flag=true;
                    this.amounOfarrows+=1;
                    //System.out.println(this+" | оруженосец "+unit.name+" дал стрелу");
                    return true;
                }
            }
        }

        return true;
    }
}
