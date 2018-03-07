/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Graphics;
import java.util.LinkedList;
import static wavegame.WaveGame.HEIGHT;
import static wavegame.WaveGame.WIDTH;

/**
 *
 * @author Ikikay
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void clearEnemys() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            if (tempObject.getType() == TYPE.Player || tempObject.getType() == TYPE.Wall) {
                object.clear();
                addObject(new Player(WaveGame.WIDTH / 2 - 32, WaveGame.HEIGHT / 2 - 32, TYPE.Player, this));
            }
        }
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
