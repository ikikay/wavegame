/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Ikikay
 */
public class Player extends GameObject{
    public Player(int x, int y, ID id){
        super(x, y, id);
        
        Random r = new Random();

        //velX = r.nextInt(10) -4;
        //velY = r.nextInt(10) -5;
    }
    
    public void tick(){
        x += velX;
        y += velY;
    }
    
    public void render(Graphics g){
        if(id == ID.Player) g.setColor(Color.white);
        else if(id == ID.Player2) g.setColor(Color.blue);
        else if(id == ID.Enemy) g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }
}
