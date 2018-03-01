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

    protected double id;
    protected float x, y;
    protected TYPE type;
    protected Handler handler;
    protected float velX, velY;
    protected int life;
    protected int dammage;

    public GameObject(float x, float y, TYPE type, Handler handler) {
        this.id = System.nanoTime();
        this.x = x;
        this.y = y;
        this.type = type;
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

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

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
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
            if (getType() != TYPE.Wall) { //Pas de collision pour les murs, ce sont les objets qui peuvent avoir une collision avec le murs
                if (getId() != tempObject.getId()) { //Si c'est pas le même objet
                    if (getType() == TYPE.Player) {
                        if ((tempObject.getType() == TYPE.Wall) && (getBounds().intersects(tempObject.getBounds()))) {
                            System.out.println("Colision joueur/wall " + getBounds() + " " + tempObject.getBounds());
                            //x= 600;

                            if (velX > 0) {
                                x -= 5;
                            } else if (velY > 0) {
                                y -= 5;
                            }

                            if (velX < 0) {
                                x += 5;
                            } else if (velY < 0) {
                                y += 5;
                            }
                            velX = 0;
                            velY = 0;
                        } else if (getBounds().intersects(tempObject.getBounds())) {
                            life = life - tempObject.getDammage();
                        }

                    } else if (getType() == TYPE.PlayerBullet) {
                        if ((tempObject.getType() != TYPE.Player) && (getBounds().intersects(tempObject.getBounds()))) {
                            life = life - tempObject.getDammage();
                            tempObject.setLife(tempObject.getLife() - getDammage());
                        }
                    } else {
                        if (getBounds().intersects(tempObject.getBounds())) {
                            velX *= -1.0f;
                            velY *= -1.0f;
                        }
                    }
                }
            }
        }
    }
}
