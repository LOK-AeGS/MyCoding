package DepartmentLecture;

import javax.swing.*;

class Simple{
    JFrame j;
    Simple(){
        j = new JFrame();
        j.setSize(400,500);
        JButton b = new JButton("Click");
        b.setBounds(100,130,100,40);
        j.add(b);
        j.setLayout(null);
        j.setVisible(true);
    }

}

class Simple2 extends JFrame{
    JFrame j;
    Simple2(){
        setSize(400,500);
        JButton b = new JButton("Click");
        b.setBounds(100,130,100,40);
        add(b);
        setLayout(null);
        setVisible(true);

    }

}

public class SwingTest {
    public static void main(String args[]){
//        JFrame f = new JFrame();
//        f.setSize(400,500);
//
//        JButton j = new JButton("Click");
//        j.setBounds(130,100,100,40);
//        f.add(j);
//        f.setLayout(null);
//        f.setVisible(true);
        Simple s1 = new Simple();
//        Simple2 s = new Simple2();



    }
}
