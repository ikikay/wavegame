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

    public static float HEALTH = 100;
    private int level = 1;
    private int score = 0;
    
    private float greenValue = 255;

    public void tick() {
        HEALTH = WaveGame.clamp(HEALTH, 0, 100);
        
        greenValue = WaveGame.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score ++;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(14, 14, 201, 33);

        //g.setColor(Color.gray);
        //g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);
        
        g.setColor(Color.white);
        g.drawString("Level: " + level, 10, 64);
        g.drawString("Score: " + score, 10, 80);
    }
    
    public void score(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public int getLevel(){
        return level;
    }
}
