/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.util.Random;

public class Spawner {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep > 500) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.FastEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.FastEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.SmartEnemy, handler));
            } else if (hud.getLevel() == 5) {
                handler.clearEnemys();
                handler.addObject(new BossEnemy(WaveGame.WIDTH / 2 - 64, -60, TYPE.BossEnemy, handler));
            } else if (hud.getLevel() >= 3) {
                boolean bossActif = false;

                for (int i = 0; i < handler.object.size(); i++) {
                    if (handler.object.get(i).getType()== TYPE.BossEnemy) {
                        bossActif = true;
                    }
                }

                if (bossActif == false) {
                    for (int i = 0; i < hud.getLevel() - 2; i++) {
                        handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.BasicEnemy, handler));
                        handler.addObject(new FastEnemy(r.nextInt(WaveGame.WIDTH - 16), r.nextInt(WaveGame.HEIGHT - 16), TYPE.FastEnemy, handler));
                    }
                }
            }
        }
    }
}
