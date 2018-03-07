/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import wavegame.WaveGame.STATE;

/**
 *
 * @author Ikikay
 */
public class MouseInput extends MouseAdapter {

    private Handler handler;
    private WaveGame game;

    public MouseInput(WaveGame game, Handler handler) {
        this.handler = handler;
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        float mx = e.getX();
        float my = e.getY();

        if (game.gameState == STATE.Jeu) {
            System.out.println(e.getClickCount() + " click(s)");
            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);

                if (tempObject.getType() == TYPE.Player) {
                    handler.addObject(new PlayerBullet(tempObject.getX() + 16, tempObject.getY() + 16, TYPE.PlayerBullet, handler, mx, my));
                }
            }
        }
    }
}
