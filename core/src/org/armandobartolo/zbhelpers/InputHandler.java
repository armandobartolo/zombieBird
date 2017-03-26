package org.armandobartolo.zbhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.armandobartolo.gameobjects.Bird;
import org.armandobartolo.gameworld.GameWorld;

/**
 * Created by armando on 25-03-2017.
 */
public class InputHandler implements InputProcessor {

    private Bird bird;
    private GameWorld world;

    public InputHandler(GameWorld gameWorld) {
        bird = gameWorld.getBird();
        world = gameWorld;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (world.isReady()) {
                world.start();
            }
            bird.onClick();

            if (world.isGameOver() || world.isHighScore()) {
                world.restart();
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (world.isReady()) {
            world.start();
        }
        bird.onClick();

        if (world.isGameOver() || world.isHighScore()) {
            world.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
