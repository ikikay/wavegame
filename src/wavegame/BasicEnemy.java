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
public class BasicEnemy extends GameObject{
    Handler handler;
    
    public BasicEnemy(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        Random r = new Random();

        velX = r.nextInt(10) -5;
        velY = r.nextInt(10) -5;
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y <= 0 || y >= WaveGame.HEIGHT - 47) velY *= -1;
        if(x <= 0 || x >= WaveGame.WIDTH - 16) velX *= -1;
        
        //handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 16, 16, 0.02f, handler));
    }
    
    public void render(Graphics g){
        g.setColor(Color.pink);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
