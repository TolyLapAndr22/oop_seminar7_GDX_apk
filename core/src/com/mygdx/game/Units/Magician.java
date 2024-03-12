package com.mygdx.game.Units;

public class Magician extends UnitMage {




    public Magician(int x,int y,String name) {
        super(x,y, name, 10, 4, 6,1);


    }

    @Override
    public String toString() {
        return getInfo() + " \'" +
                name + '\'' +" \u273f "+this.mana+" \u2665 "+this.health
                ;
    }

    public String getInfo(){
        return  "Волшебник";
    };

}
