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
    public BasicEnemy(int x, int y, ID id){
        super(x, y, id);
        
        Random r = new Random();

        velX = r.nextInt(10) -4;
        velY = r.nextInt(10) -5;
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y <= 0 || y >= WaveGame.HEIGHT - 48) velY *= -1;
        if(x <= 0 || x >= WaveGame.WIDTH - 16) velX *= -1;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
}
