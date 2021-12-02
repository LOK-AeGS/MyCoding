package Guajae;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Guajae.Calculator;

public class Cal_GUI extends JFrame {

    final int txtWidth = 70, lblWidth = 20, height = 20;
    final int btnWidth = 60, btnExtWidth = 90;

    JTextField txtNum1, txtNum2, txtResult;
    JLabel lblOp, lblEqual, Result;
    JButton btnAdd, btnSub, btnMul, btnDiv, btnComp, btnReset;

    Container c;

    private void txt_lbl_Layout() {
        txtNum1 = new JTextField("", 15);
        txtNum1.setLocation(10, 10);
        txtNum1.setSize(txtWidth, height);
        txtNum1.setHorizontalAlignment(JTextField.RIGHT);

        lblOp = new JLabel("?");
        lblOp.setLocation(85, 10);
        lblOp.setSize(lblWidth, height);

        txtNum2 = new JTextField("", 15);
        txtNum2.setLocation(100, 10);
        txtNum2.setSize(txtWidth, height);
        txtNum2.setHorizontalAlignment(JTextField.RIGHT);

        lblEqual = new JLabel("=");
        lblEqual.setLocation(180, 10);
        lblEqual.setSize(lblWidth, height);

        txtResult = new JTextField("0", 10);
        txtResult.setLocation(200, 10);
        txtResult.setSize(txtWidth, height);
        txtResult.setHorizontalAlignment(JTextField.RIGHT);
    }

    private void btn_Layout() {
        btnAdd = new JButton("+");
        btnAdd.setLocation(10, 40);
        btnAdd.setSize(btnWidth, height);

        btnSub = new JButton("-");
        btnSub.setLocation(80, 40);
        btnSub.setSize(btnWidth, height);

        btnMul = new JButton("*");
        btnMul.setLocation(150, 40);
        btnMul.setSize(btnWidth, height);

        btnDiv = new JButton("/");
        btnDiv.setLocation(220, 40);
        btnDiv.setSize(btnWidth, height);

        btnReset = new JButton("Reset");
        btnReset.setLocation(50, 70);
        btnReset.setSize(btnExtWidth, height);

        btnComp = new JButton("Compute");
        btnComp.setLocation(150, 70);
        btnComp.setSize(btnExtWidth, height);
    }

    private void GUI_Setup() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt_lbl_Layout();
        btn_Layout();

        c = getContentPane();
        c.setLayout(null);

        c.add(txtNum1);
        c.add(lblOp);
        c.add(txtNum2);
        c.add(lblEqual);
        c.add(txtResult);

        c.add(btnAdd);
        c.add(btnSub);
        c.add(btnMul);
        c.add(btnDiv);

        c.add(btnReset);
        c.add(btnComp);

        setSize(300, 150);
        setVisible(true);
    }

    public void addAction() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnComp == e.getSource()){
                    txtResult.setText(String.valueOf(Result));
                }
            }
        };
        btnComp.addActionListener(listener);
    }

    public void addListener2(){
//        JLabel Result;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator cal;
                String strFirstNum = txtNum1.getText();
                String strSecondNum = txtNum2.getText();

                double douFirstNum = Double.parseDouble(strFirstNum);
                double douSecondNum = Double.parseDouble(strSecondNum);
                double result = 0;//-> 이 result에는 값이 할당이 안됨.

                if (btnAdd.equals(e.getSource())) {
                    cal = new Calculator(douFirstNum, '+', douSecondNum);
                    result = cal.compute();//-> 버튼을 누르면 + txtResult에 뜨도록 만들었습니다,,
                    System.out.println(result);
//                    Result.setText(String.valueOf(result));
//                    txtResult.setText(String.valueOf(result));
                } else if (e.getSource() == btnMul) {
                    cal = new Calculator(douFirstNum, '*', douSecondNum);
                    result = cal.compute();
                    System.out.println(result);
//                    Result.setText(String.valueOf(cal.compute()));
//                    txtResult.setText(String.valueOf(result));
                } else if (e.getSource() == btnSub) {
                    cal = new Calculator(douFirstNum, '-', douSecondNum);
                    result = cal.compute();
//                    Result.setText(String.valueOf(cal.compute()));
                    System.out.println(result);
//                    txtResult.setText(String.valueOf(result));
                } else if (e.getSource() == btnDiv) {
                    cal = new Calculator(douFirstNum, '/', douSecondNum);
                    result = cal.compute();
                    System.out.println(result);
//                    Result.setText(String.valueOf(cal.compute()));
                    txtResult.setText(String.valueOf(result));
                }else if (e.getSource()==btnReset){
                    txtNum1.setText("");
                    txtNum2.setText("");
                    txtResult.setText("0");
                }
                if( e.getSource() == btnComp){
//                    String temp = Result.getText();//JLabel -> 저장하려고 저장소 느낌으로 했는데 NUll Point Exception
                    String temp = String.valueOf(result);
                    txtResult.setText(temp);
                }
//                if(e.getSource() == btn)
            }
        };

//        btnComp.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnReset.addActionListener(listener);
        btnSub.addActionListener(listener);

    }


    public Cal_GUI() {

        GUI_Setup();
        addListener2();
//        addAction();


    }


    public static void main(String[] args) {
        new Cal_GUI();

    }


}

