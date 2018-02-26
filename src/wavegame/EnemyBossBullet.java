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
public class EnemyBossBullet extends GameObject{
    private Handler handler;
    Random r = new Random();
    
    public EnemyBossBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y >= WaveGame.HEIGHT){
            handler.removeObject(this);
        }
        handler.addObject(new Trail(x, y, ID.Trail, Color.LIGHT_GRAY, 16, 16, 0.02f, handler));
    }
    
    public void render (Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, 16, 16);
    }
}
