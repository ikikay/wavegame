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

    Handler handler;

    public PlayerBullet(float x, float y, ID id, Handler handler, float mx, float my) {
        super(x, y, id);
        this.handler = handler;
        
        velX = (mx - x) / 20;
        velY = (my - y) / 20;
        //velX = 10;
        //velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= WaveGame.HEIGHT) {
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
