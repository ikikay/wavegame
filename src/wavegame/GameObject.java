package wavegame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

    protected float x, y;
    protected TYPE type;
    protected float velX, velY;

    public GameObject(float x, float y, TYPE type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}