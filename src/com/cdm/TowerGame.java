package com.cdm;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL10;
import com.cdm.view.LevelScreen;
import com.cdm.view.Screen;

public class TowerGame extends InputAdapter implements ApplicationListener {
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private Screen screen;
	private boolean started = false;
	private float accum = 0;
	
	public void create() {
		running = true;
		setScreen(new LevelScreen());
		Gdx.input.setInputProcessor(this);
	}

	public void pause() {
		running = false;
	}

	public void resume() {
		running = true;
	}

	public void setScreen(Screen newScreen) {
		if (screen != null)
			screen.removed();
		screen = newScreen;
		if (screen != null)
			screen.wait(this);
	}

	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		accum += Gdx.graphics.getDeltaTime();
		while(accum > 1.0f / 60.0f) {			
			accum -= 1.0f / 60.0f;
		}
		screen.render();	
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	public boolean touchDown (int x, int y, int pointer, int button) {
		System.out.println("touchDown");
		System.out.println(x);
		return false;
	}

	public boolean touchUp (int x, int y, int pointer, int button) {
		System.out.println("touchUp");
		return false;
	}

	public boolean touchDragged (int x, int y, int pointer) {
		System.out.println("touchDrag");
		return false;
	}

	@Override public boolean touchMoved (int x, int y) {
		System.out.println("touchmoved");
		return false;
	}

	@Override public boolean scrolled (int amount) {
		System.out.println("scroll");
		return false;
	}

}
