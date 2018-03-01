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
public class BasicEnemy extends GameObject {

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.life = 100;
        this.dammage = this.life;

        Random r = new Random();

        velX = r.nextInt(10) - 5;
        velY = r.nextInt(10) - 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        //handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 16, 16, 0.02f, handler));
        super.collision();
        if (life <= 0){
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
