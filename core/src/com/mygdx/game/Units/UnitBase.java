package com.mygdx.game.Units;

import java.util.ArrayList;
import java.util.Random;

/*
UnitBase

№ приоритет категория название
  lead
1  0        Крестьянин Крестьянин peasant
2  2        пехота     Разбойник  Outlaw
3  1        маг        Колдун     Magician
4  2        пехота     Копейщик   Spearman
5  3        лучник     Снайпер    Sniper
6  3        лучник     Арбалетчик Crossbowman
7  1        маг        Монах      Monk

поля данных
-name
-health - здоровье
-stamina - выносливость
-weapon - оружие

поля поведения

-damage - повреждение
-attack - атака
-death - смерть

 */
public abstract class UnitBase implements Step {
    public Place position;
    protected String name;
    protected int health;
    protected  int stamina ;
    protected  int weapon;
    protected  int lead;
    protected int teamIndex=-1;


    protected static Random r = new Random();

    public void setHealth(int health) {
        this.health = health;
    }

    public UnitBase(int x, int y, String name, int health, int stamina, int weapon, int lead) {
        position= new Place(x,y);
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.weapon = weapon;
        this.lead = lead;
    }
    protected void  GetDamage(int damage){
        if(this.health -damage >0){
            this.health -=damage;
        }else this.health=0;
    }

    protected void attack(UnitBase target){
        int damage= 1;
        target.GetDamage(damage);
    }
    protected boolean death(UnitBase target){
        if(target.GetHealth() <  1){
            //System.out.println("You're dead");
        return false;
        }else {
            return true;
        }
    }
    public int GetHealth(){
        return health;
    }

    protected void findТearУnemy(ArrayList<UnitBase> team) {
        this.teamIndex = -1;
        double minDist = Double.MAX_VALUE;
        for (UnitBase team2 : team) {
            if (position.Distance(team2.position) < minDist && team2.health > 0) {
                minDist = position.Distance(team2.position);
                teamIndex = team.indexOf(team2);
            }
        }
    }


    public  int getHp(){
        return health;
    };

    public String getInfo(){
        return  "";
    };

    public int getLead() {
        return lead;
    }
}


