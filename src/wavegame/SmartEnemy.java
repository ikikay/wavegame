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
 * @author ikika
 */
public class SmartEnemy extends GameObject {
    
    private Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, TYPE type, Handler handler) {
        super(x, y, type);
        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getType()== TYPE.Player) {
                player = handler.object.get(i);
            }
        }
        if (player.getType()!= TYPE.Player) {
            System.out.println("ERREUR PLAYER");
        }
    }

    public void tick() {
        x += velX;
        y += velY;
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);

        if (y <= 0 || y >= WaveGame.HEIGHT - 16) {
            velY *= -1;
        }
        if (x <= 0 || x >= WaveGame.WIDTH - 16) {
            velX *= -1;
        }

        //handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.02f, handler));z
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}