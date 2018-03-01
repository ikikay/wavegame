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

    private int wallHeight;
    private int wallWidth;
    
    public Wall(float x, float y, TYPE type, Handler handler, int wallWidth, int wallHeight) {
        super(x, y, type, handler);
        this.wallHeight = wallHeight;        
        this.wallWidth = wallWidth;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, wallWidth, wallHeight) ;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, wallWidth, wallHeight);
    }

}
