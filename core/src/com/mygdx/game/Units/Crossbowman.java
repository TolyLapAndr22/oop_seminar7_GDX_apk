package com.mygdx.game.Units;

public class Crossbowman extends UnitBowman {
    protected int accuracy; // точность


    public Crossbowman(int x,int y,String name  ) {
        super(x,y,name, 10, 5, 6,3);
        this.accuracy = 6;
        //this.amounOfarrows = 7;
    }
    public String toString() {
        return getInfo() + " \'" +
                name + '\'' +" \u279c "+this.amounOfarrows+" \u2665 "+this.health
                ;
    }



    public String getInfo(){
        return  "Арбалетчик";
    };

}
