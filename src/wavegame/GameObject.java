/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Ikikay
 */
public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected Handler handler;
    protected float velX, velY;
    protected int life;
    protected int dammage;

    public GameObject(float x, float y, ID id, Handler handler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDammage() {
        return dammage;
    }

    public void setDammage(int dammage) {
        this.dammage = dammage;
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (hashCode()!= tempObject.hashCode()) {
                if (getId() == ID.Player || getId() == ID.PlayerBullet) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        life = life - tempObject.getDammage();
                    }
                } else {
                    if (tempObject.getId() == ID.Player || tempObject.getId() == ID.PlayerBullet) {
                        life = life - tempObject.getDammage();
                    } else if (getBounds().intersects(tempObject.getBounds())) {
                        velX *= -1;
                        velY *= -1;
                    }
                }
            }
        }
    }
}
