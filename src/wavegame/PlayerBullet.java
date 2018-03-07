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

    protected Handler handler;

    public PlayerBullet(float x, float y, TYPE type, Handler handler, float mx, float my) {
        super(x, y, type);
        this.handler = handler;

        velX = (mx - x) / 20;
        velY = (my - y) / 20;
        //velX = 10;
        //velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = WaveGame.clamp(x, 0, WaveGame.WIDTH - 8);
        y = WaveGame.clamp(y, 0, WaveGame.HEIGHT - 8);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, 8, 8);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 8, 8);
    }
}
