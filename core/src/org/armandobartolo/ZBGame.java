package org.armandobartolo;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import org.armandobartolo.screen.GameScreen;


public class ZBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		setScreen(new GameScreen());
	}
}
