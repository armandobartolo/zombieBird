package org.armandobartolo.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import org.armandobartolo.zbhelpers.AssetLoader;

/**
 * Created by armando on 25-03-2017.
 */
public class Bird {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation; // For handling bird rotation
    private int width;
    private int height;

    private Circle boundingCircle;
    private boolean alive;


    public Bird(float x, float y, int width, int height) {
        //create a bird in the position x,y with the given size
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
        boundingCircle = new Circle();
        alive = true;
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) { //200 is the top speed
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(delta));

        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }

        if (isFalling() || !alive) {
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }
        }


    }

    public void onClick() { //when a click happens, speed is set to 140 upwards
       if (alive) {
           AssetLoader.flap.play();
           velocity.y = -140;
       }
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return velocity.y > 70 || !alive;
    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
        velocity.y = 0;
    }

    public void decelerate() {
        acceleration.y = 0;
    }
}
