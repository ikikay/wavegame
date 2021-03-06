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
public class BossEnemy extends GameObject {
    
    private Handler handler;
    Random r = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public BossEnemy(float x, float y, TYPE type, Handler handler) {
        super(x, y, type);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 96);
    }

    public void tick() {
        x += velX;
        y += velY;
        timer--;
        if (timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }
        if (timer <= 0) {
            timer2--;
        }
        if (timer2 <= 0) {
            if (velX == 0) {
                velX = 2;
            } else if (velX > 0) {
                velX += 0.005f;
            } else if (velX < 0) {
                velX -= 0.005f;
            }
            velX = WaveGame.clamp(velX, -10, 10);
            int spawn = r.nextInt(10);
            if (spawn == 0) {
                handler.addObject(new EnemyBossBullet(x, y, TYPE.BasicEnemy, handler));
            }
        }
        if (x <= 0 || x >= WaveGame.WIDTH - 96) {
            velX *= -1;
        }


    }

    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect((int) x, (int) y, 96, 96);
    }
}
