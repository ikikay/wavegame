/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wavegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author Ikikay
 */
public class WaveGame extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    private Spawner spawner;
    private Menu menu;

    public enum STATE {
        Menu,
        Aide,
        Jeu,
        Pause,
        Fin;
    }
    public STATE gameState = STATE.Menu;

    private final double UPDATE_CAP = 1.0 / 60.0;

    public WaveGame() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(this, handler));

        new Window(WIDTH + 6, HEIGHT + 29, "Wave Game", this);
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        hud = new HUD();
        spawner = new Spawner(handler, hud);

        System.out.println(gameState);
        if (gameState == STATE.Menu) {
            //Décoration
            for (int i = 0; i < 10; i++) {
                handler.addObject(new MenuParticules(r.nextInt(WIDTH - 16), r.nextInt(HEIGHT - 16), TYPE.MenuParticules, handler));
            }
        }
    }

    public synchronized void start() {
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction de run sur 60 FPS trouvé sur internet
     */
    public void run() {
        this.requestFocus();

        // Majoolwip
        running = true;
        System.out.println("");

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        //test
        int testTick = 0;
        int testRender = 0;

        while (running) {
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                tick();
                testTick++;

                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    //System.out.println("FPS: " + fps);
                    System.err.println("Tick : " + testTick);
                    System.err.println("Render : " + testRender);
                    testTick = 0;
                    testRender = 0;
                }
            }

            if (render) {
                frames++;

                render();
                testRender++;

            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        stop();

//        // Code Julian
//        long lastTime = System.nanoTime();
//        double amountOfTicks = 60.0;
//        double ns = 1000000000.0 / amountOfTicks;
//        double delta = 0;
//        long timer = System.currentTimeMillis();
//        int frames = 0;
//        while (running) {
//            long now = System.nanoTime();
//            delta += (now - lastTime) / ns;
//            lastTime = now;
//            while (delta >= 1) {
//                tick();
//                delta--;
//            }
//            if (running) {
//                frames++;
//                render();
//            }
//            
//
//            if (System.currentTimeMillis() - timer > 1000) {
//                timer += 1000;
//                System.out.println("FPS: " + frames);
//                frames = 0;
//            }
//        }
//        stop();
    }

    private void tick() {
        handler.tick();
        if (gameState == STATE.Menu) {
            menu.tick();
        } else if (gameState == STATE.Jeu) {
            hud.tick();
            spawner.tick();
            if(HUD.HEALTH <= 0){
                HUD.HEALTH = 100;
                gameState = STATE.Fin;
                handler.object.clear();
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        try {
            handler.render(g);
        } catch (Exception e) {
        }
        if ((gameState == STATE.Menu) || (gameState == STATE.Aide) || (gameState == STATE.Fin)) {
            menu.render(g);
        } else if (gameState == STATE.Jeu) {
            hud.render(g);
        }
        g.dispose();
        bs.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new WaveGame();
    }

    public static float clamp(float position, float min, float max) {
        if (position >= max) {
            return position = max;
        } else if (position <= min) {
            return position = min;
        } else {
            return position;
        }
    }
}
