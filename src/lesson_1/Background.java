package lesson_1;

import java.awt.*;


public class Background{

    static float red = 105;
    static float green = 170;
    static float blue = 0;


    static void setRed(){
        red = 225;
        green = 0;
        blue = 80;
    }

    void update(){
        if(red > 105){
            float delta = (red - 105)/10;
            red -= delta;
            if(red - 105 < 1){
                red = 105;
            }
        }
        if(red < 105){
            float delta = (105 - red)/10;
            red += delta;
            if(105 - red < 1){
                red = 105;
            }
        }
        if(green > 170){
            float delta = (green - 170)/10;
            green -= delta;
            if(green - 170 < 1){
                green = 170;
            }
        }
        if(green < 170){
            float delta = (170 - green)/10;
            green += delta;
            if(170 - green < 1){
                green = 170;
            }
        }
        if(blue > 0) {
            float delta = blue / 10;
            blue -= delta;
            if (blue < 1) {
                blue = 0;
            }
        }
    }


    void render(GameCanvas gameCanvas){
        //System.out.println(red + ", " + green + ", " + blue);
        gameCanvas.setBackground(new Color((int)red, (int)green, (int)blue));
        //gameCanvas.setBackground(new Color(red/255, green/255, blue/255));
    }
}
