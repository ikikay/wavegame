/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Ikikay
 */
public class Trail extends GameObject {

    private float alpha = 1f;
    private float life;
    private Color color;
    private int width, height;

    public Trail(float x, float y, TYPE type, Color color, int width, int height, float life, Handler handler) {
        super(x, y, type, handler);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.001f);
        } else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x, (int)y, width, height);
        
        g2d.setComposite(makeTransparent(1));
    }
    
    public AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }
    
    public Rectangle getBounds(){
        return null;
    }
}
