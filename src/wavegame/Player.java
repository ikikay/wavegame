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
    Handler handler;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
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

        x = WaveGame.clamp(x, 0, WaveGame.WIDTH - 37);
        y = WaveGame.clamp(y, 0, WaveGame.HEIGHT - 60);
        
        collision();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if ((tempObject.getId() == ID.BasicEnemy) || (tempObject.getId() == ID.FastEnemy) || (tempObject.getId() == ID.SmartEnemy)) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            } else if (tempObject.getId() == ID.BasicEnemy){
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH = 0;
                }
            }
        }
    }
}
