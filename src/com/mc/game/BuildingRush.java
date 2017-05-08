
package com.mc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BuildingRush extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture menuBg, newgameButton, continueButton, tutorialButton, title;
	Rectangle newgameButtonArea, continueButtonArea, tutorialButtonArea;
	int page;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		page = 0;
		menuBg = new Texture("menuBg.jpg");
		title = new Texture("title.png");
		newgameButton = new Texture("newgameButton.png");
		newgameButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 100, newgameButton.getWidth(), newgameButton.getHeight());
		continueButton = new Texture("continueButton.png");
		continueButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - continueButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 300, continueButton.getWidth(), continueButton.getHeight());
		tutorialButton = new Texture("tutorialButton.png");
		tutorialButtonArea = new Rectangle((int) (Gdx.graphics.getWidth()*0.2 - tutorialButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500, tutorialButton.getWidth(), tutorialButton.getHeight());	
		Gdx.input.setInputProcessor(this);
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
			tutorial();
		}
		
		if (page == 2) {
			game();
		}
		
		if (page == 3) {
			pause();
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
		title.dispose();
	}
	
	
	public void menu () {
		batch.draw(menuBg, 0, 0);
		batch.draw(title, (int) (Gdx.graphics.getWidth()*0.75 - title.getWidth()*0.5), (int) (Gdx.graphics.getHeight()*0.2 - title.getHeight()));
		
		if(newgameButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 1;
		    }
		}
		else{
			batch.draw(newgameButton, (int) (Gdx.graphics.getWidth()*0.2 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 100);
		}
		
		if(continueButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 2;
		    }
		}
		else{
			batch.draw(continueButton, (int) (Gdx.graphics.getWidth()*0.2 - continueButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 300);
		}
		
		if(tutorialButtonArea.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			//batch.draw(pnewgameButton, (int) (Gdx.graphics.getWidth()*0.5 - newgameButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
			if(Gdx.input.isButtonPressed(Buttons.LEFT)){
		        page = 3;
		    }
		}
		else{
			batch.draw(tutorialButton, (int) (Gdx.graphics.getWidth()*0.2 - tutorialButton.getWidth()*0.5), Gdx.graphics.getHeight() - title.getHeight() - 500);
		}
		
		
	}
	public void tutorial () {
		
	}
	
	public void game () {
		
	}
	
	public void pause () {
		
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
