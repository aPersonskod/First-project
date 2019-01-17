package com.andrew.info;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

/**
 * Created by Andrew on 11.01.2019.
 */

public class MyActor extends Actor {
    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("zaz.png")));
    public float STEP = 5, x=0;
//    Texture texture = new Texture(Gdx.files.internal("zaz.png"));


	public MyActor(){
		setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
		setTouchable(Touchable.enabled);

		addListener(new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {

				MoveByAction mba = new MoveByAction();

				if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

						x+=5;


					mba.setAmountX(50);
					mba.setDuration(2);

					MyActor.this.addAction(mba);

					System.out.println("X= " + sprite.getX() + " Y= " + sprite.getY() + " float x=" + x);
				}

				if (keycode == Input.Keys.LEFT){


					mba.setAmountX(-50);
					mba.setDuration(2);

					MyActor.this.addAction(mba);

					System.out.println("X= " + sprite.getX() + " Y= " + sprite.getY());
				}
				return true;
			}
		});



	}

	@Override
	protected void positionChanged() {
		sprite.setPosition(getX(),getY());
		super.positionChanged();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(sprite,sprite.getX(),sprite.getY());
		super.draw(batch, parentAlpha);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
		setTouchable(Touchable.enabled);

		addListener(new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {

				if(Gdx.input.isKeyPressed(Input.Keys.D))
					sprite.setPosition(sprite.getX() + STEP, sprite.getY());

				return super.keyDown(event, keycode);

			}
		});

//		Gdx.graphics.isContinuousRendering();
//
//				if(Gdx.input.isKeyPressed(Input.Keys.W))
//					sprite.setPosition(sprite.getX() * Gdx.graphics.getDeltaTime(), sprite.getY() + STEP * Gdx.graphics.getDeltaTime());
//				if(Gdx.input.isKeyPressed(Input.Keys.S))
//					sprite.setPosition(sprite.getX(), sprite.getY() - STEP);
//				if(Gdx.input.isKeyPressed(Input.Keys.A))
//					sprite.setPosition(sprite.getX() - STEP, sprite.getY());
//				if(Gdx.input.isKeyPressed(Input.Keys.D))
//					sprite.setPosition(sprite.getX() + STEP, sprite.getY());
//
//				System.out.println("X= " + sprite.getX() + " Y= " + sprite.getY());
//
//

	}

		//System.out.println("X= " + getX() + " Y= " + getY());


}
