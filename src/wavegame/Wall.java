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
public class Wall extends GameObject {

    public Wall(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(5, 5, WaveGame.WIDTH - 15, WaveGame.HEIGHT - 39) ;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, WaveGame.HEIGHT, WaveGame.WIDTH);
    }

}
