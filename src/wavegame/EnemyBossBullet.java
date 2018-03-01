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
 * @author ikika
 */
public class EnemyBossBullet extends GameObject {

    Random r = new Random();

    public EnemyBossBullet(float x, float y, TYPE type, Handler handler) {
        super(x, y, type, handler);
        this.life = 50;
        this.dammage = this.life;

        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= WaveGame.HEIGHT) {
            
        }
        if (y <= 0 || y >= WaveGame.HEIGHT - 47 || x <= 0 || x >= WaveGame.WIDTH - 16) {
            handler.removeObject(this);
        }
        //handler.addObject(new Trail(x, y, TYPE.Trail, Color.LIGHT_GRAY, 8, 8, 0.02f, handler));

        super.collision();
        if (life <= 0) {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval((int) x, (int) y, 8, 8);
    }
}
