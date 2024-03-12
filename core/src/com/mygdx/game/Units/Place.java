package com.mygdx.game.Units;

public class Place {
    int x,y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double Distance ( Place other ) {
        return Math.sqrt( Math.pow(this.x - other.x, 2 ) + Math.pow( this.y - other.y, 2 ) );
    }

    @Override
    public String toString() {
        return
                " x=" + x +
                ", y=" + y
               ;
    }

    public Place Difference (Place target){

          Place dif=new Place(x-target.x, y- target.y);
        return dif;
    }
    public boolean equal (Place tag){
        return x== tag.x && y== tag.y;
    }
}
