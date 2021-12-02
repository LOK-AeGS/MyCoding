package DepartmentLecture;

import java.awt.*;

class First extends Frame{
    First(){

        setSize(300,300);
        Button b = new Button("click me");
        b.setBounds(30,100,80,30);
        add(b);

        setLayout(null);
        setVisible(true);



    }





}


public class AWTEx1 {
    public static void main(String args[]){
        //1단계
//        Frame f = new Frame("First AWT Example");
//        f.setSize(300,500);
//        f.setVisible(true);
//
        //2단계
//
//        Button b = new Button("Click");
//        b.setSize(100,200);
//        f.add(b);
//        f.setVisible(true);
    First f = new First();



    }

}
