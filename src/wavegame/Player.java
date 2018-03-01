/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Ikikay
 */
public class Player extends GameObject {

    Random r = new Random();

    public Player(float x, float y, TYPE type, Handler handler) {
        super(x, y, type, handler);
        this.life = 100;
        this.dammage = 0;
    }

    public void tick() {

        super.collision();

        x += velX;
        y += velY;

        if (handler.isUp()) {
            velY = -5;
        } else if (!handler.isDown()) {
            velY = 0;
        }

        if (handler.isDown()) {
            velY = 5;
        } else if (!handler.isUp()) {
            velY = 0;
        }

        if (handler.isLeft()) {
            velX = -5;
        } else if (!handler.isRight()) {
            velX = 0;
        }

        if (handler.isRight()) {
            velX = 5;
        } else if (!handler.isLeft()) {
            velX = 0;
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

//    public void collision() {
//        for (int i = 0; i < handler.object.size(); i++) {
//            GameObject tempObject = handler.object.get(i);
//            if ((tempObject.getType() == TYPE.BasicEnemy) || (tempObject.getType() == TYPE.FastEnemy) || (tempObject.getId() == TYPE.SmartEnemy)) {
//                if (getBounds().intersects(tempObject.getBounds())) {
//                    HUD.HEALTH -= 2;
//                }
//            } else if (tempObject.getType() == TYPE.EnemyBoss) {
//                if (getBounds().intersects(tempObject.getBounds())) {
//                    HUD.HEALTH = 0;
//                }
//            }
//        }
//    }
}
