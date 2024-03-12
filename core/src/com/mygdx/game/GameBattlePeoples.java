package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Units.Crossbowman;
import com.mygdx.game.Units.LeadComp;
import com.mygdx.game.Units.Magician;
import com.mygdx.game.Units.Monk;
import com.mygdx.game.Units.Name;
import com.mygdx.game.Units.Outlaw;
import com.mygdx.game.Units.Peasant;
import com.mygdx.game.Units.Sniper;
import com.mygdx.game.Units.Spearman;
import com.mygdx.game.Units.UnitBase;

import java.util.ArrayList;
import java.util.Random;

public class GameBattlePeoples extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, CBM, MG,MK,OW,PT,SM,SR;
	Music music;
	public ArrayList<UnitBase> team1 ;
	public ArrayList<UnitBase> team2 ;
	public ArrayList<UnitBase> teamAll ;
	public int HealIndex;

	
	@Override
	public void create () {
		team1 = new ArrayList<>();
		team2 = new ArrayList<>();
		teamAll = new ArrayList<>();

		HealIndex = -1;


		init();
		teamAll.addAll(team1);
		teamAll.addAll(team2);
		//teamAll.sort(new LeadComp());
		teamAll.sort((u1,u2)->u2.position.getX()-u1.position.getX());
		batch = new SpriteBatch();
		fon = new Texture("fon/fon4.png");

		music=Gdx.audio.newMusic(Gdx.files.internal("music/music2.mp3"));
		music.setVolume(0.05f);
		music.play();
		this.CBM=new Texture("units/CBM.png");
		this.MG=new Texture("units/MG.png");
		this.MK=new Texture("units/MK.png");
		this.OW=new Texture("units/OW.png");
		this.PT=new Texture("units/PT.png");
		this.SM=new Texture("units/SM.png");
		this.SR=new Texture("units/SR.png");
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (UnitBase unit : teamAll) {
			if (unit.GetHealth() == 0) continue;
			int y = unit.position.getX() * Gdx.graphics.getWidth() / 18;
			int x = unit.position.getY() * Gdx.graphics.getHeight() / 9;
			int f = -1;
			if (team1.contains(unit)) f = 1;
			switch (unit.getInfo()) {
				case "Арбалетчик":
					batch.draw(CBM, x, y, CBM.getWidth() * f, CBM.getHeight());
					break;
				case "Волшебник":
					batch.draw(MG, x, y, MG.getWidth() * f, MG.getHeight());
					break;
				case "Монах":
					batch.draw(MK, x, y, MK.getWidth() * f, MK.getHeight());
					break;
				case "Разбойник":
					batch.draw(OW, x, y, OW.getWidth() * f, OW.getHeight());
					break;
				case "Оруженосец":
					batch.draw(PT, x, y, PT.getWidth() * f, PT.getHeight());
					break;
				case "Снайпер":
					batch.draw(SR, x, y, SR.getWidth() * f, SR.getHeight());
					break;
				case "Копейщик":
					batch.draw(SM, x, y, SM.getWidth() * f, SM.getHeight());
					break;
			}

		}


		batch.end();
		boolean flag =true;
		for (UnitBase unit: team1
			 ) {
			if(unit.GetHealth()>0)flag=false;
		}
		if(flag){
			Gdx.graphics.setTitle("2-я команда победила");
			return;
		}
		flag =true;
		for (UnitBase unit: team2
		) {
			if(unit.GetHealth()>0)flag=false;
		}
		if(flag){
			Gdx.graphics.setTitle("1-я команда победила");
			return;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isButtonJustPressed(Input.Keys.LEFT) ||
				Gdx.input.justTouched()) {
			for (UnitBase unit : teamAll) {
				if (team1.contains(unit)) {
					if (!unit.step(team2, team1)) {
						//winner=1;
						break;
					}
				} else {
					if (!unit.step(team1, team2)) {
						//winner=2;

						break;
					}
				}


			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		this.CBM.dispose();
		this.MG.dispose();
		this.MK.dispose();
		this.OW.dispose();
		this.PT.dispose();
		this.SM.dispose();
		this.SR.dispose();
		music.dispose();
	}

	private  void init() {
		for (int i = 1; i < 11; i++) {

			switch (MathUtils.random(6)) {
				case 0:
					team1.add(new Peasant(i, 1, getName()));
					break;
				case 1:
					team1.add(new Outlaw(i, 1, getName()));
					break;
				case 2:
					team1.add(new Magician(i, 1, getName()));
					break;
				case 3:
					team1.add(new Spearman(i, 1, getName()));
					break;
				case 4:
					team1.add(new Sniper(i, 1, getName()));
					break;
				case 5:
					team1.add(new Crossbowman(i, 1, getName()));
					break;
				case 6:
					team1.add(new Monk(i, 1, getName()));
					break;

			}
			switch (MathUtils.random(6)) {
				case 0:
					team2.add(new Peasant(i, 10, getName()));
					break;
				case 1:
					team2.add(new Outlaw(i, 10, getName()));
					break;
				case 2:
					team2.add(new Magician(i, 10, getName()));
					break;
				case 3:
					team2.add(new Spearman(i, 10, getName()));
					break;
				case 4:
					team2.add(new Sniper(i, 10, getName()));
					break;
				case 5:
					team2.add(new Crossbowman(i, 10, getName()));
					break;
				case 6:
					team2.add(new Monk(i, 10, getName()));
					break;

			}

		}
	}
	private String getName() {
		return String.valueOf(Name.values()[new Random().nextInt(Name.values().length - 1)]);
	}


}
