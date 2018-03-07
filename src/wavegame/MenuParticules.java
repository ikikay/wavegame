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
public class MenuParticules extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private Color colorParticule;
    
    public MenuParticules(float x, float y, TYPE type, Handler handler) {
        super(x, y, type);
        this.handler = handler;

        velX = (r.nextInt(10 - -10) +- 10);
        velY = (r.nextInt(10 - -10) +- 10);
        
        colorParticule = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= WaveGame.HEIGHT - 16) {
            velY *= -1;
        }
        if (x <= 0 || x >= WaveGame.WIDTH - 16) {
            velX *= -1;
        }

        handler.addObject(new Trail(x, y, TYPE.Trail, colorParticule, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(colorParticule);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
