package Foxy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fox {

    List<Punkty> foxPoints;
    int xDir, yDir;
    boolean isMoving;
    final int SRARTSIZE = 2, STARTX = 150, STARTY = 150;
    final BufferedImage iFox = ImageIO.read(new File(".\\fox2.png"));



    public Fox() throws IOException {
        foxPoints = new ArrayList<Punkty>();
        xDir = 0;
        yDir = 0;

        isMoving = false;

        foxPoints.add(new Punkty(STARTX, STARTY));


    }


    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        for (Punkty p : foxPoints) {
            g.drawImage(iFox,p.getX(), p.getY(), 20, 10,null);
        }

    }

    public void move() {

        if (isMoving) {
            Punkty temp = foxPoints.get(0);
            Punkty last = foxPoints.get(foxPoints.size() - 1);
            Punkty newStart = new Punkty(temp.getX() + xDir * 5, temp.getY() + yDir * 5);
            for (int i = foxPoints.size() - 1; i >= 1; i--) {
                foxPoints.set(i, foxPoints.get(i - 1));

            }
            foxPoints.set(0, newStart);

        }
    }

    public boolean FoxCollision() {
        int x = this.getX();
        int y = this.getY();

        for (int i = 1; i < foxPoints.size(); i++) {
            if (foxPoints.get(i).getX() == x && foxPoints.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean b) {
        isMoving = b;
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int x) {
        xDir = x;
    }

    public void setYDir(int y) {
        yDir = y;
    }

    public int getX() {
        return foxPoints.get(0).getX();
    }

    public int getY() {
        return foxPoints.get(0).getY();
    }

}

