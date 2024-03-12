package com.mygdx.game.Units;

import java.util.ArrayList;

public interface Step {
    boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam);
}
