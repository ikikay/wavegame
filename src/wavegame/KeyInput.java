/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ikikay
 */
public class KeyInput extends KeyAdapter{
    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println(key);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_Z)){
                    tempObject.setVelY(- 5);
                    tempObject.setVelX(0);
                } else if((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_S)){
                    tempObject.setVelY(+ 5);
                    tempObject.setVelX(0);
                } else if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_Q)){
                    tempObject.setVelX(- 5);
                    tempObject.setVelY(0);
                } else if((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)){
                    tempObject.setVelX(+ 5);
                    tempObject.setVelY(0);
                }
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
    }
}
