package org.armandobartolo.gameworld;

import org.armandobartolo.gameobjects.Bird;
import org.armandobartolo.gameobjects.Grass;
import org.armandobartolo.gameobjects.Pipe;
import org.armandobartolo.gameobjects.ScrollHandler;

/**
 * Created by armando on 25-03-2017.
 */
public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);

    }

    public void update(float delta) {

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird)) {

            scroller.stop();
        }

    }


    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

}
