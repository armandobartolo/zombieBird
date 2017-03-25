package org.armandobartolo.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import org.armandobartolo.gameobjects.Bird;

/**
 * Created by armando on 25-03-2017.
 */
public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {

        bird.update(delta);

    }

    public Bird getBird() {
        return bird;
    }
}
