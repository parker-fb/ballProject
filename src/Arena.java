import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arena extends JPanel{

    Ball pony = new Ball(0,100,10,5,30, Color.RED);
    Ball newBall = new Ball(50,80,4,4,30, Color.BLACK);
    private Ball balls[];
//        private int ballx = 0;
//        private int bally = 100;
    private Ball me = new Ball();
    public Arena(){
        setFocusable(true);

        setBackground(Color.LIGHT_GRAY);
        balls = new Ball[20];
        for (int i = 0; i < balls.length; i++){
            int x = (int)(Math.random()*350);
            int y = (int)(Math.random()*350);
            int size = (int)(Math.random()*20)+10;
            int xSpeed = (int)(Math.random()*10)+1;
            int ySpeed = (int)(Math.random()*10)+1;
//            int r = (int)(Math.random()*255);
//            int g = (int)(Math.random()*255);
//            int b = (int)(Math.random()*255);
            //Color color = new Color(r,g,b);
            balls[i] = new Ball(x,y,xSpeed,ySpeed,size,Color.BLACK);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode() == 68){
                    me.setX(me.getX()+4);
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //pony.draw(g);
        //pony.move();
        //g.fillOval(200,200,30,30);
        //g.setColor(Color.GREEN);
        me.draw(g);
        newBall.draw(g);
        newBall.move();
        for (int i = 0; i < balls.length; i++){
            balls[i].draw(g);
            balls[i].move();
            //b.bounce(this);
            balls[i].randBounce(this);
            for (int j = i + 1; j < balls.length; j++) {
                balls[i].bounceOff(balls[j]);
            }

        }
        //pony.randBounce(this);
        //g.fillRect(0,370,200,30);



        try {
            Thread.sleep(25);
        }
        catch(Exception e){

        }

        //looping paintComponent
        repaint();


    }


}
