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
public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getType() == TYPE.Player) {
                if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_Z)) {
                    handler.setUp(true);
                }
                if ((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_S)) {
                    handler.setDown(true);
                }
                if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_Q)) {
                    handler.setLeft(true);
                }
                if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)) {
                    handler.setRight(true);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getType() == TYPE.Player) {
                if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_Z)) {
                    handler.setUp(false);
                }
                if ((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_S)) {
                    handler.setDown(false);
                }
                if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_Q)) {
                    handler.setLeft(false);
                }
                if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)) {
                    handler.setRight(false);
                }
            }
        }
    }
}
