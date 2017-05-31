
package com.mc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class BuildingRush extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture menuBg, newgameButton, continueButton, tutorialButton, title, map1, rightStat, topStat, 
	menuPane, musicPlayButton, musicStopButton, soundPlayButton, soundStopButton, menuButton, 
	buyTruckButton, sellTruckButton, truckStat, postOffPic, truckIcon, moneyIcon, profitIcon,
	oneStar, twoStar, threeStar, buildCostBox, moneyStatBox, timeBox;
	Rectangle newgameButtonArea, continueButtonArea, tutorialButtonArea, buildButtonArea, ProfitStatBox, BronzeBar, SilverBar, GoldBar;
	int page, money;
	BitmapFont font12, font32, fontCB20, fontAJ18;
	FreeTypeFontGenerator generator, coopBl, arJul;
	FreeTypeFontParameter parameter;
	ShapeRenderer shapeRenderer;
	Music menuMusic, themeMusic;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		page = 0;
		menuBg = new Texture("menuBg.jpg");
		title = new Texture("title2.png");
		newgameButton = new Texture("newgameButton.png");
		newgameButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500, newgameButton.getWidth(), newgameButton.getHeight());
		continueButton = new Texture("continueButton.png");
		continueButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - continueButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 250, continueButton.getWidth(), continueButton.getHeight());
		tutorialButton = new Texture("tutorialButton.png");
		tutorialButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - tutorialButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 350, tutorialButton.getWidth(), tutorialButton.getHeight());	
		rightStat = new Texture("rightStats.png");
		topStat = new Texture("topStats.png");
		menuPane = new Texture("mainButtonPane.png");
		musicPlayButton = new Texture("buttons3015.png");
		musicStopButton = new Texture("buttons3017.png");
		soundPlayButton = new Texture("buttons3018.png");
		soundStopButton = new Texture("buttons3019.png");
		menuButton = new Texture("buttons4002.png");
		buyTruckButton = new Texture("buttons2012.png");
		sellTruckButton = new Texture("buttons2004.png");
		truckStat = new Texture("buttons2017.png");
		postOffPic = new Texture("postOffIcon.png");
		truckIcon = new Texture("truckIcon2.png");
		moneyIcon = new Texture("moneyIcon.png");
		profitIcon = new Texture("profitIcon.png");
		oneStar = new Texture("buttons3021.png");
		twoStar = new Texture("buttons3022.png");
		threeStar = new Texture("buttons3023.png");
		buildCostBox = new Texture("BlackStatSmall.png");
		moneyStatBox = new Texture("BlackStatLong.png");
		timeBox = new Texture("BlackStatTime.png");
		
		
		Gdx.input.setInputProcessor(this);
		map1 = new Texture("map1.jpg");
		generator = new FreeTypeFontGenerator(Gdx.files.internal("RobotoCondensed-Regular.ttf"));
		coopBl = new FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
		arJul = new FreeTypeFontGenerator(Gdx.files.internal("ARJULIAN.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		font12 = generator.generateFont(parameter);
		parameter.size = 32;
		font32 = generator.generateFont(parameter);
		font12.setColor(Color.WHITE);
		font32.setColor(Color.RED);
		
		parameter.size = 20;
		fontCB20 = coopBl.generateFont(parameter);
		fontCB20.setColor(Color.WHITE);
		
		parameter.size = 18;
		fontAJ18 = arJul.generateFont(parameter);
		fontAJ18.setColor(Color.WHITE);
		
		shapeRenderer = new ShapeRenderer();
		money = 100;
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("[Drumstep] - Tristam & Braken - Flight [Monstercat Release].mp3"));
		themeMusic = Gdx.audio.newMusic(Gdx.files.internal("[Drumstep] - Tristam & Braken - Flight [Monstercat Release].mp3"));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		if (page == 0) {
			menu();
		}
		
		if (page == 1) {
			pause();
		}
		
		if (page == 2) {
			tutorial();
		}
		
		if (page == 3) {
			game();
		}
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		menuBg.dispose();
		newgameButton.dispose();
		continueButton.dispose();
		tutorialButton.dispose();
		rightStat.dispose();
		topStat.dispose();
		title.dispose();
		map1.dispose();
		generator.dispose();
		font12.dispose();
		font32.dispose();
		shapeRenderer.dispose();
	}
	
	
	public void menu () {
		batch.draw(menuBg, 0, 0);
		batch.draw(title, (int) (Gdx.graphics.getWidth()*0.75 - title.getWidth()*0.5), (int) (Gdx.graphics.getHeight()*0.2 - title.getHeight()));
		
		if(continueButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 1;
		    }
		}
		else{
			batch.draw(continueButton, (int) (Gdx.graphics.getWidth()*0.2 - continueButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 200);
		}
		
		if(tutorialButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 2;
		    }
		}
		else{
			batch.draw(tutorialButton, (int) (Gdx.graphics.getWidth()*0.2 - tutorialButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 350);
		}
		if(newgameButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 3;
		    }
		}
		else{
			batch.draw(newgameButton, (int) (Gdx.graphics.getWidth()*0.2 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
		}
		
		
		menuMusic.setLooping(true);
		menuMusic.play();
		
	}
	public void tutorial () {
		
	}
	
	public void game () {
		batch.draw(map1, 0, 0);
		batch.draw(rightStat,Gdx.graphics.getWidth() - rightStat.getWidth(),Gdx.graphics.getHeight()-rightStat.getHeight());
		batch.draw(topStat,0,Gdx.graphics.getHeight()-topStat.getHeight());
		batch.draw(menuPane,1178,728,100,100);
		batch.draw(moneyStatBox,1100,710,70,115);
		batch.draw(musicPlayButton,1184,778,43,43);
		//batch.draw(musicStopButton)
		batch.draw(soundPlayButton,1230,778,43,43);
		//batch.draw(soundStopButton)
		batch.draw(menuButton,1186,740,85,35);
		batch.draw(buyTruckButton,1110,520,75,75);
		batch.draw(sellTruckButton,1190,520,75,75);
		batch.draw(truckStat,1102,600,170,50);
		batch.draw(postOffPic,1195,660,60,60);
		batch.draw(truckIcon,1110,595,50,50);
		batch.draw(moneyIcon,1050,760,64,64);
		batch.draw(profitIcon,135,760,64,64);
		batch.draw(oneStar,560,750,55,55);
		batch.draw(twoStar,700,750,55,55);
		batch.draw(threeStar,800,750,55,55);
		batch.draw(buildCostBox,1110,665,70,35);
		//batch.draw(timeBox)
		
		//batch.draw(buildButton,(int) (Gdx.graphics.getWidth()*0.988),(int) (Gdx.graphics.getHeight()*0.9- buildButton.getHeight()), buildButton.getWidth()-480, buildButton.getHeight()-50);
		font32.draw(batch, "Hello World", 200, 200);
		fontCB20.draw(batch, "BUY", 1125, 580);
		fontCB20.draw(batch, "SELL", 1201, 580);
		fontAJ18.draw(batch, "MENU",1203,763);
		/*if(pauseButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 3;
		    }
		}
		else{
			batch.draw(pauseButton, (int) (Gdx.graphics.getWidth()*0.2 - pauseButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
		}*/
		
		font12.draw(batch, "$"+money, 200, 700);
	}
	
	public void pause () {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(0, 0, 0, (float) 0.5);
		shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		shapeRenderer.end();
	}
	
	public void save(){
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
