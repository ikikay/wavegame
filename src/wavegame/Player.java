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

    private Handler handler;
    Random r = new Random();

    public Player(float x, float y, TYPE type, Handler handler) {
        super(x, y, type);
        this.handler = handler;
    }

    public void tick() {

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

        x = WaveGame.clamp(x, 0, WaveGame.WIDTH - 31);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getType() == TYPE.BossEnemy) {
                y = WaveGame.clamp(y, 124, WaveGame.HEIGHT - 31);
            } else {
                y = WaveGame.clamp(y, 0, WaveGame.HEIGHT - 31);
            }

        }
        //handler.addObject(new Trail(x, y, TYPE.Trail, Color.white, 32, 32, 0.05f, handler));
        collision();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);

//        g.setColor(Color.red);
//        g.fillRect((int) x, (int) y, 50, 50);
//        g.fillRect((int) x + 50, (int) y + 50, 50, 50);
//        g.setColor(Color.white);
//        g.fillRect((int) x, (int) y + 50, 50, 50);
//
//        g.drawRect((int) x, (int) y, 50, 50);
//        g.drawRect((int) x, (int) y + 50, 50, 50);
//        g.drawRect((int) x, (int) y + 100, 50, 50);
//        g.drawRect((int) x + 50, (int) y, 50, 50);
//        g.drawRect((int) x + 50, (int) y + 50, 50, 50);
//        g.drawRect((int) x + 50, (int) y + 100, 50, 50);
//        g.drawRect((int) x + 100, (int) y, 50, 50);
//        g.drawRect((int) x + 100, (int) y + 50, 50, 50);
//        g.drawRect((int) x + 100, (int) y + 100, 50, 50);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            switch (tempObject.getType()) {
                case BasicEnemy:
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;
                    }
                    break;
                case FastEnemy:
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;
                    }
                    break;
                case SmartEnemy:
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;
                    }
                    break;
                case BossEnemy:
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 200;
                    }
                    break;

            }
        }

    }
}
