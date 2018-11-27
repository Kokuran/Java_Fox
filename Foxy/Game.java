package Foxy;

import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.io.IOException;


public class Game extends Applet implements Runnable, KeyListener {

    Graphics grafic;
     Image img;
    Thread thread;
    Fox fox;
    boolean gameOver;
    Bunny bunny;
    double counter;
    Thread cd;
    private BufferedImage imgs;
    final BufferedImage iBlack = ImageIO.read(new File("D:\\Programowanie\\Java\\src\\Foxy\\1_max.jpg"));
    final BufferedImage iGrass = ImageIO.read(new File("D:\\Programowanie\\Java\\src\\Foxy\\grass.jpg"));






    public Game() throws IOException {
    }


    //  BufferedImage Backgroud_im = ImageIO.read(new File("max.png"));
   // Button Again;

    public void start() { // create thread

        counter = 120;
        cd = new Thread(this);
        cd.start();
        gameOver = false;

    }
    public void stop() {
        cd = null;
    }


    public void init(){
        this.resize(450,450);
         img = createImage(450,450);
        gameOver = false;
        grafic = img.getGraphics();
        this.addKeyListener(this);
        try {
            fox = new Fox();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bunny = new Bunny(fox);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cd = new Thread(this);
        thread = new Thread(this);
        thread.start();

        try{
            URL url = new URL(getCodeBase(), "data:image/jpeg;base64,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");
            imgs = ImageIO.read(url);
        } catch (IOException e) {
        }


    }
    public void paint(Graphics g){

        int tempCount = (int)(counter + 0.3d);



    //    grafic.setColor(Color.DARK_GRAY);
        //grafic.drawImage(imgs, 450, 450, null);
       grafic.drawImage(iBlack, 0, 0, 450, 450, null);
      //  grafic.setColor(Color.GREEN);
        grafic.drawImage(iGrass,20,20,410,410,null);
        grafic.setColor(Color.WHITE);
        grafic.drawString("Timer: "+String.valueOf(tempCount),10,10);
        grafic.drawString("Score: "+String.valueOf(bunny.getScore()),100,10);



        if(!gameOver){

                fox.draw(grafic);
                bunny.draw(grafic);
                bunny.drawDen(grafic);
                cd.stop();
        }
        else{
            grafic.setColor(Color.BLACK);
            grafic.fillRect(145,115,130,90);
            grafic.setColor(Color.BLUE);
            grafic.setColor(Color.WHITE);
            grafic.fillRect(150,120,120,80);
            grafic.setColor(Color.BLUE);
            grafic.drawString("Game Over",180,150);
            grafic.setColor(Color.BLACK);
            grafic.drawString("Score: "+bunny.getScore(),180,170);
        }

        g.drawImage(img,0,0,null);


    }

    public void repaint (Graphics g){
        paint(g);
    }


    public void run() {
        int speed = 18;
        for (; ; ) {

            if (!gameOver) {

                fox.move();
                this.checkGameOver();
                bunny.FoxCollision();
                //      this.Time();


            }

            this.repaint();

              if(changeSpeed(speed)==true){
                     speed-=3;
               }


            try {

                thread.sleep(speed);
                 cd.sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter-=0.03;

        }
    }
    public  void checkGameOver(){
        if(fox.getX()<20||fox.getX()>410){
            gameOver=true;
        }
        if(fox.getY()<20||fox.getY()>420){
            gameOver=true;
        }
        if(fox.FoxCollision()){
            gameOver=true;
        }
        if(counter<1){
            gameOver=true;
        }

    }

    public boolean changeSpeed(int speed){
        if((bunny.getPoints())%5==1){
            if(speed<5) {
                return false;
            }
            else{
                return true;
            }

        }

        else if((bunny.getScore())>20){
            if(speed<5) {
                return false;
            }
            else{
                return true;
            }

        }
        return false;
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(!fox.isMoving()){
            if(e.getKeyCode()== KeyEvent.VK_UP||e.getKeyCode()== KeyEvent.VK_DOWN||e.getKeyCode()== KeyEvent.VK_LEFT||e.getKeyCode()== KeyEvent.VK_RIGHT){
                fox.setIsMoving(true);
            }
        }

        if(e.getKeyCode()== KeyEvent.VK_UP){
                fox.setYDir(-1);
                fox.setXDir(0);

        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){

                fox.setYDir(1);
                fox.setXDir(0);

        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){

                fox.setXDir(-1);
                fox.setYDir(0);

        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){

                fox.setXDir(1);
                fox.setYDir(0);

        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
