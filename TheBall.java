package com.andrew.info;

//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.OrthographicCamera;
////https://www.gamefromscratch.com/post/2013/11/27/LibGDX-Tutorial-9-Scene2D-Part-1.aspx          - a site of code
//
//public class TheBall extends Game {
//	public float WIDTH;
//	public float HEIGHT;
//
//	@Override
//	public void create () {
//		AssetLoader.loader();
//		this.setScreen((Screen) new InputHandler());
//
//		WIDTH = Gdx.graphics.getWidth();
//		HEIGHT = Gdx.graphics.getHeight();
//	}
//
//	@Override
//	public void dispose() {
//		super.dispose();
//		AssetLoader.dispose();
//	}
//
//	public float getWIDTH() {
//		return WIDTH;
//	}
//
//	public float getHEIGHT() {
//		return HEIGHT;
//	}
//}


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TheBall extends ApplicationAdapter {
	//https://www.gamefromscratch.com/post/2013/11/27/LibGDX-Tutorial-9-Scene2D-Part-1.aspx
	Stage stage;

	@Override
	public void create() {
		ScreenViewport viewport = new ScreenViewport();
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);

		MyActor actor = new MyActor();
		stage.addActor(actor);
		stage.setKeyboardFocus(actor);

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}

//public class TheBall extends Actor {
//
//	Texture texture;
//	float actorX = 0, actorY = 0;
//
//	public TheBall(){
//		texture = new Texture(Gdx.files.internal("zaz.png"));
//		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
//		addListener(new InputListener(){
//			@Override
//			public boolean keyDown(InputEvent event, int keycode) {
//				if (keycode == Input.Keys.RIGHT){
//					MoveByAction mba = new MoveByAction();
//					mba.setAmount(100f,0f);
//					mba.setDuration(5f);
//
//					TheBall.this.addAction(mba);
//				}
//				return true;
//			}
//		});
//	}
//
//	@Override
//	public void draw(Batch batch, float parentAlpha) {
//		batch.draw(texture,actorX,actorY);
//		super.draw(batch, parentAlpha);
//	}
//
//	@Override
//	public void act(float delta) {
//		super.act(delta);
//	}
//}
