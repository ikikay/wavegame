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
public class Player extends GameObject {
    Handler handler;
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        Random r = new Random();

        //velX = r.nextInt(10) -4;
        //velY = r.nextInt(10) -5;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = WaveGame.clamp(x, 0, WaveGame.WIDTH - 37);
        y = WaveGame.clamp(y, 0, WaveGame.HEIGHT - 60);
        collision();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
    
        public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }
        
    public void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
}
