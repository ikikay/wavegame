/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import static wavegame.WaveGame.HEIGHT;
import wavegame.WaveGame.STATE;
import static wavegame.WaveGame.WIDTH;

/**
 *
 * @author Ikikay
 */
public class Menu extends MouseAdapter {

    private WaveGame game;
    private Handler handler;
    private Random r = new Random();

    public Menu(WaveGame game, Handler handler) {
        this.handler = handler;
        this.game = game;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font fntGrand = new Font("arial", 1, 50);
        Font fntmoyen = new Font("arial", 1, 30);
        Font fntPetit = new Font("arial", 1, 20);

        g.setColor(Color.white);
        g.setFont(fntGrand);

        if (game.gameState == STATE.Menu) {
            g.drawString("Menu", 240, 50);

            g.setFont(fntmoyen);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Jouer", 280, 190);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Aide", 280, 290);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quitter", 280, 390);
        } else if (game.gameState == STATE.Aide) {
            g.drawString("Help", 240, 50);

            g.setFont(fntmoyen);
            g.drawString("Utilisez les flèches directionnelles", 100, 200); // 100 = Largeur
            g.drawString("ou 'ZQSD' pour vous déplacer", 100, 250); // 250 = Hauteur
            g.drawRect(210, 350, 200, 64);
            g.drawString("Retour", 280, 390);
        } else if (game.gameState == STATE.Fin) {
            g.drawString("Game Over", 240, 50);

            g.setFont(fntPetit);
            g.drawString("Tu as perdu avec un score de : ", 100, 200);

            g.setFont(fntmoyen);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Menu (Essayez encore)", 280, 390);
        }
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == STATE.Menu) {
            //Jouer
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Jeu;
                handler.object.clear();
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, TYPE.Player, handler));

                for (int i = 0; i < 15; i++) {
                    handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), TYPE.BasicEnemy, handler));
                }
                // Aide
            } else if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = STATE.Aide;
                // Quitter
            } else if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
                return;
            }
        } else if (game.gameState == STATE.Aide) {
            // Retour
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
            }
        } else if (game.gameState == STATE.Fin) {
            // Retour
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
            }
        }
    }

    private Boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if ((mx > x) && (mx < x + width)) {
            if ((my > y) && (my < y + height)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
