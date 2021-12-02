package Guajae;

import javax.swing.*;
import java.awt.*;

class Calculate extends JFrame {
    Calculate(){
        setTitle("계산기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();

        JPanel pn = new JPanel();
        JPanel pc = new JPanel();
        JPanel ps = new JPanel();

        pn.setBackground(Color.GRAY);
        pc.setLayout(new GridLayout(4,4));
        ps.setBackground(Color.yellow);

        c.add(pn,BorderLayout.NORTH);
        c.add(pc);
        c.add(ps,BorderLayout.SOUTH);

        JLabel text1 = new JLabel("수식 입력");
        JTextField jtf1 = new JTextField(10);
        pn.add(text1);
        pn.add(jtf1);

        JLabel text2 = new JLabel("계산 결과");
        JTextField jtf2 = new JTextField(10);
        ps.add(text2);
        ps.add(jtf2);

        for(int i = 0 ; i < 16; i ++){
            JButton b = new JButton();
            String [] str = {"CE","계산","+","-","*","/"};
            pc.add(b);
            if(i<10){
                b.setText(Integer.toString(i));

            }else{
                b.setText(str[i - 10]);
            }
            if(i > 11){
                b.setOpaque(true);
                b.setBackground(Color.CYAN);
            }

        }
        setVisible(true);
        setSize(400,400);

    }

}




public class HW_Swing_Calcu {
    public static void main(String args[]){
        Calculate cal = new Calculate();

    }
}
