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
            ySpeed *= -1;
        }
        if (y < 0){
            ySpeed *= -1;
        }
    }



    public void randBounce(Arena a){
        if (x > a.getWidth() - size){
            ySpeed = (int)(Math.random()*0)+1;
            xSpeed *= -1;
        }
        if (x < 0){
            ySpeed = (int)(Math.random()*0)+1;
                xSpeed *= -1;
        }
        if (y > a.getWidth() - size){
            xSpeed = (int)(Math.random()*10)-5;
                ySpeed *= -1;

        }
        if (y > a.getHeight() - size){
            xSpeed = (int)(Math.random()*10)-5;
                ySpeed *= -1;
        }
        if (y < 0){
            xSpeed = (int)(Math.random()*0)+1;
                ySpeed *= -1;
        }

    }

    public void bounceOff(Ball b){
        int bx = b.x - this.x;
        int by = b.y - this.y;
        int dist2 = bx * bx + by * by;
        int radius = (this.size/2) + (b.size/2);
        if (dist2 <= radius * radius){
            int tempXSpeed = this.xSpeed;
            int tempYSpeed = this.ySpeed;
            this.xSpeed = b.xSpeed;
            this.ySpeed = b.ySpeed;
            b.xSpeed = tempXSpeed;
            b.ySpeed = tempYSpeed;

        }

    }

}
