package Foxy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bunny {

    private  int x,y,score,den;
    private Fox fox;
    final BufferedImage iDen = ImageIO.read(new File(".\\cave.png"));
    final BufferedImage iRabbit = ImageIO.read(new File(".\\rabbit.png"));

    public Bunny(Fox s) throws IOException {
        x = 30+ (int)(Math.random()* 385);
        y = 30 +(int)(Math.random()* 385);
        fox = s;
    }

    public int getScore(){
        return den;
    }

    public int getPoints(){
        return den;
    }

    public void changePosition() {
        x = 30+ (int)(Math.random()* 370);
        y = 30 +(int)(Math.random()* 370);
    }

    public void Bunny_run(){

    }

    public void draw(Graphics g){
   //   g.setColor(Color.WHITE);
    //    g.fillRect(x,y,6,6);
        g.drawImage(iRabbit, x, y, 8, 8, null);

    }

    public void drawDen(Graphics g){
      //  g.setColor(Color.BLACK);
     //   g.fillRect(120,120,20,20);

        g.drawImage(iDen, 120, 120, 30, 30, null);

    }

    public boolean checkIfDen(){


        if(fox.getX()<=150 && fox.getX()>=100 &&fox.getY()<=150 && fox.getY()>=112){
            return true;
        }

        return false;
    }

    public boolean check(int x, int y){
        int foxX = fox.getX();
        int foxY = fox.getY() +4;

            if(foxX>=x && foxX<=(x+20) || foxX+20>=x && foxX+30<=(x+6)){
                if(foxY>=y && foxY<=y+6){
                    return  true;
                }

            }


        return false;
    }


    public  boolean FoxCollision(){
        int foxX = fox.getX() +4;
        int foxY = fox.getY() +4 ;


        // Rozkminic by na stykniecie

        if(foxX>=x-1 && foxX <= (x+7)) {
            if (foxY >= y - 1 && foxY <= (y + 7)) {
                changePosition();
                score++;
            }
        }


        //        if(check(x,y)){
          //          changePosition();
            //        score++;
              //  }




        if(foxX>=x-1 && foxX <= (x+7)){
            if(foxY>=y-1 && foxY<=(y+7)) {

                changePosition();
                score++;
            }
        }
        if(checkIfDen()==true){
            fox.isMoving=false;
            if(score>0){
                den+=score;
                score=0;
            }
            return true;
        }
        return false;
    }
}
