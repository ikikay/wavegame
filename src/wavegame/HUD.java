/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ikikay
 */
public class HUD {
    public static int HEALTH = 100;
    public void tick(){
        HEALTH = WaveGame.clamp(HEALTH, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH *2, 32);
                
        g.setColor(Color.white);
        g.fillRect(15, 15, 200, 32);        
    }
}
