
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
	Texture menuBg, newgameButton, continueButton, tutorialButton, title, map1, rightStat, topStat;
	Rectangle newgameButtonArea, continueButtonArea, tutorialButtonArea;
	int page, money;
	BitmapFont font12, font32;
	FreeTypeFontGenerator generator;
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
		
		
		Gdx.input.setInputProcessor(this);
		map1 = new Texture("map1.jpg");
		generator = new FreeTypeFontGenerator(Gdx.files.internal("RobotoCondensed-Regular.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		font12 = generator.generateFont(parameter);
		parameter.size = 32;
		font32 = generator.generateFont(parameter);
		font12.setColor(Color.RED);
		font32.setColor(Color.RED);
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
		font32.draw(batch, "Hello World", 200, 200);
		/*if(pauseButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 3;
		    }
		}
		else{
			batch.draw(pauseButton, (int) (Gdx.graphics.getWidth()*0.2 - pauseButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
		}*/
		
		font32.draw(batch, "$"+money, 200, 700);
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
