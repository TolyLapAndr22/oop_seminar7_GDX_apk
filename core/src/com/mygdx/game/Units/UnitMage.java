package com.mygdx.game.Units;

import java.util.ArrayList;

public class UnitMage extends UnitBase {
    int mana, manaMax;
    boolean Mflag;

    public UnitMage(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        super(x, y, name, health, stamina, weapon, lead);
        mana=manaMax=10;
    }

   // @android.annotation.TargetApi(android.os.Build.VERSION_CODES.N)
    @Override
    public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {
        if (getHp() <=0) return true;
        int count=0;
        ArrayList<UnitBase> frList = new ArrayList<>(frteam);
        frList.sort((u1,u2)->u1.GetHealth() - u2.GetHealth());
        //System.out.println(this);
        //System.out.println(frList);
        for (UnitBase unit:frList) {
            if (!unit.death(unit)){
                count++;
            }
        }
        if(count>=3){
            Mflag=true;
        }
        if(Mflag && mana == manaMax){
          frList.get(0).setHealth(1);
           mana=0;
           Mflag=false;
            //System.out.println(this.getClass().getSimpleName()+this+" оживил"+ frList.get(0));
           return true;
          }
        if(Mflag && mana>=8){

            mana=manaMax;
            //System.out.println(this+" для оживления не хватило маны | добавил себе маны"+ this.mana);
            return true;
        }
        if(mana<2){
            mana++;
            //System.out.println(this+" для лечения не хватило маны | добавил себе маны"+ this.mana);

            return true;
        }

        if((frList.get(count).health+2)<=10 && frList.get(count).health>0) {

            frList.get(count).setHealth(frList.get(count).health+2); // лечим,  н+2
        } else if ((frList.get(count).health+2)>10){
            frList.get(count).setHealth(10);// лечим, если н+2>10, то  H=10
        }
        mana-=2;
        //System.out.println(this+" добавил здоровья "+ frList.get(count)+"| убавил себе маны "+ this.mana);

        return true;
    }
}
