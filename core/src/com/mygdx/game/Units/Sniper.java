package com.mygdx.game.Units;

public class Sniper extends UnitBowman {
    protected int accuracy; //точность
    protected  int disguise; // маскировка


    public Sniper(int x,int y,String name, int health, int stamina, int weapon, int accuracy, int disguise) {
        super(x,y,name, health, stamina, weapon,3);
        this.accuracy = accuracy;
        this.disguise = disguise;
        //this.amounOfarrows=5; //кол стрел
    }
    public Sniper(int x,int y,String name) {
        super(x,y,name, 10, 4, 5,3);
        this.accuracy = 3;
        this.disguise = 4;
        //this.amounOfarrows=5; //кол стрел
    }
    @Override
    public String toString() {
        return getInfo() + " \'" +
                name + '\'' +" \u279c "+this.amounOfarrows+" \u2665 "+this.health
                ;
    }
    public String getInfo(){
        return  "Снайпер";
    };

}


