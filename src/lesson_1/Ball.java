package lesson_1;

import java.awt.*;

public class Ball extends Sprite {

    private int vx = 250 + (int)(Math.random() * 200);
    private int vy = 250 + (int)(Math.random() * 200);
    private int vs = 30;//10 + (int)(Math.random() * 80);
    private int maxSize = 200;
    private int minSize = 0;


    private Color color = new Color(255,255,255, 100 + (int)(Math.random() * 155));
            //new Color((int)(Math.random() * 256f), (int)(Math.random() * 256f), (int)(Math.random() * 256f));

    Ball(){
        halfHeight = 20 + (int)(Math.random() * 50);
        halfWidth = halfHeight;
        System.out.println("halfWidth is" + halfWidth);
    }

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
        halfHeight = 20 + (int)(Math.random() * 50);
        halfWidth = halfHeight;
        //System.out.println("halfWidth is" + halfWidth);
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x = x + vx * deltaTime;
        y = y + vy * deltaTime;

        halfHeight = halfHeight + vs * deltaTime;
        if(halfHeight < minSize || halfHeight > maxSize){
            vs = -vs;
        }
        halfWidth = halfHeight;

        //System.out.println(halfWidth);


        if(getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
            vs = -vs;
            Background.setRed();
        }
        if(getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
            vs = -vs;
            Background.setRed();
        }
        if(getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
            vs = -vs;
            Background.setRed();
        }
        if(getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
            vs = -vs;
            Background.setRed();
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(), (int) getTop(), (int) getWidth(), (int)getHeight());
        //System.out.println(getWidth());
        //System.out.println(this.getLeft());
        //System.out.println(this.getTop());
    }
}
