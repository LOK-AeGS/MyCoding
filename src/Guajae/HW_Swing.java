package Guajae;

import javax.swing.*;
import java.awt.*;

class Label extends JFrame{
    JLabel label;

    Label(){
        setSize(300,300);
        Container c = getContentPane();
        c.setLayout(null);
        for(int i = 0 ; i < 20 ; i ++) {
            label = new JLabel();
            int x = (int) (Math.random() * 200) + 50;
            int y = (int) (Math.random() * 200) + 50;
            label.setLocation(x, y);
            label.setSize(10, 10);
            label.setOpaque(true);
            label.setBackground(Color.blue);
            c.add(label);

        }
        setVisible(true);


    }


}

public class HW_Swing {

    public static void main(String args[]){
        Label label = new Label();



    }
}
