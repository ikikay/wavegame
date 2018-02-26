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
public class FastEnemy extends GameObject {
    private Handler handler;
    
    public FastEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler= handler;
        
        Random r = new Random();

        velX = r.nextInt(20) -10;
        velY = r.nextInt(20) -10;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y <= 0 || y >= WaveGame.HEIGHT - 47) velY *= -1;
        if(x <= 0 || x >= WaveGame.WIDTH - 16) velX *= -1;
        
        //handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}