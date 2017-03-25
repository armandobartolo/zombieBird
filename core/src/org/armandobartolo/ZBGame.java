package org.armandobartolo;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import org.armandobartolo.screen.GameScreen;
import org.armandobartolo.zbhelpers.AssetLoader;


public class ZBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
