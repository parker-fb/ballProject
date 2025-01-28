import java.awt.*;

public class Ball {

    private int x, y, xSpeed, ySpeed, size;
    private Color color;

    public Ball(int x, int y, int xSpeed, int ySpeed, int size, Color color){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
        this.color = color;

    }

    public Ball(){
        x = 50;
        y = 50;
        xSpeed = 5;
        ySpeed = 5;
        size = 30;
        color = Color.GREEN;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(int ySpeed){
        this.ySpeed = ySpeed;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed(){
        return ySpeed;
    }

    public int getSize() {
        return size;
    }

    public Color getColor(){
        return color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void move(){
        x += xSpeed;
        y += ySpeed;
    }


    public void bounce(Arena a){
        if (x > a.getSize().getWidth() - size){
            xSpeed *= -1;
        }
        if (x < 0){
            xSpeed *= -1;
        }
        if (y > a.getSize().getWidth() - size){
            ySpeed *= -1;
        }
        if (y > a.getSize().getHeight() - size){
            //System.out.println("bounce");
            ySpeed *= -1;
        }
        if (y < 0){
            ySpeed *= -1;
        }
    }

    public void randBounce(){


    }

}
