package lesson_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCirclesWindow extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameCirclesWindow();
            }
        });
    }

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[10];
    private int spritesCount;
    private Background back;

    private GameCirclesWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);

        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int button = e.getButton();

                if(button == 1) {
                    addSprite(new Ball(e.getX(), e.getY()));
                }
                else if(button == 3){
                    removeSprite();
                }
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        add(gameCanvas, BorderLayout.CENTER);
        initGame();
        setVisible(true);
    }

    private void addSprite(Sprite sprite){
        if(sprites.length == spritesCount){
            Sprite newSprites[] = new Sprite[sprites.length + 5];
            System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
            sprites = newSprites;
            sprites[spritesCount] = sprite;
            spritesCount++;
        }else{
            sprites[spritesCount] = sprite;
            spritesCount++;
        }

    }
    private void removeSprite(){
        if(spritesCount > 0){
            spritesCount--;
        }
    }

    private void initGame(){
        back = new Background();
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime){
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    void update(GameCanvas gameCanvas, float deltaTime){
        for (int i = 0; i < spritesCount; i++) {
            if (sprites[i] != null) {
                sprites[i].update(gameCanvas, deltaTime);
            }
        }
        back.update();
    }

    void render(GameCanvas gameCanvas, Graphics g){
        for (int i = 0; i < spritesCount; i++) {
            if(sprites[i] != null) {
                sprites[i].render(gameCanvas, g);
            }
        }
        back.render(gameCanvas);
    }
}
