package com.mygdx.game.Units;

import java.util.ArrayList;

/*
поля данных
- сила - strength
- ловкость - agility
 поля поведения
 - work
 */
public class Peasant extends UnitBase {
 int strength;//сила
 int agility;//ловкость
public boolean flag = false;//признак передачи стрелы. false - стрелу НЕ передал

 public Peasant(int x,int y,String name, int health, int stamina, int weapon, int strength, int agility) {
  super(x,y,name, health, stamina, weapon,0);
  this.strength = strength;
  this.agility = agility;
 }
 public Peasant(int x,int y,String name) {
  super(x,y,name, 10, 4, 3,0);
  this.strength = 5;
  this.agility = 3;
  this.flag = false;
 }



 @Override
 public String toString() {
  return getInfo() + " \'" +
          name + '\'' +" \u2665 "+this.health
          ;
 }

 @Override
 public boolean step(ArrayList<UnitBase> team, ArrayList<UnitBase> frteam) {
  if (getHp() <=0) return true;
   flag =false;

  return true;
 }

 public String getInfo(){
  return  "Оруженосец";
 };
}
