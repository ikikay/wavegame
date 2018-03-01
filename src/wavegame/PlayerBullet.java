/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Ikikay
 */
public class PlayerBullet extends GameObject {

    public PlayerBullet(float x, float y, TYPE type, Handler handler, float mx, float my) {
        super(x, y, type, handler);
        this.life = 50;
        this.dammage = 100;

        velX = (mx - x) / 20;
        velY = (my - y) / 20;
        //velX = 10;
        //velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if ((tempObject.getType()!= TYPE.Player) || (tempObject.getType()!= TYPE.PlayerBullet)) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //handler.removeObject(this);
                }
            }
        }

        if (y <= 0 || y >= WaveGame.HEIGHT - 47 || x <= 0 || x >= WaveGame.WIDTH - 16) {
            handler.removeObject(this);
        }

        super.collision();
        if (life <= 0) {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, 8, 8);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 8, 8);
    }
}
