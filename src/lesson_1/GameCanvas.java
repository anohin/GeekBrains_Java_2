package lesson_1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private GameCirclesWindow gameCirclesWindow;
    private long lastFrameTime;

    GameCanvas(GameCirclesWindow gameCirclesWindow){
        this.gameCirclesWindow = gameCirclesWindow;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        gameCirclesWindow.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    int getLeft(){
        return 0;
    }

    int getRight(){
        return getWidth() - 1;
    }

    int getBottom(){
        return getHeight() - 1;
    }

    int getTop(){
        return 0;
    }
}
