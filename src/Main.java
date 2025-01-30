

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400,400);

        Arena panel = new Arena();
        //panel.setBackground(Color.BLUE);

        frame.add(panel);



        frame.setVisible(true);


    }
}