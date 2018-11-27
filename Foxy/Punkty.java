package Foxy;

public class Punkty {

    private int x,y;

    public Punkty(){
        x=0;
        y=0;
    }

    public Punkty(int x, int y){
        this.x =x;
        this.y =y;

    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
