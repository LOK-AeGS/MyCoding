package practice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActionListenerEx extends JFrame  {

    private JLabel lblNum;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnReset;

    public ActionListenerEx() {
        init();
        setDisplay();
        addListener();
        showFrame();
    }

    // 구성
    private void init() {

        lblNum = new JLabel("0", JLabel.CENTER);
        lblNum.setText("0");
        lblNum.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        btnPlus = new JButton();
        btnPlus.setText("Plus");
        btnMinus = new JButton();
        btnMinus.setText("Minus");
        btnReset = new JButton();
        btnReset.setText("Reset");

    }
    // 배치
    private void setDisplay() {

        JPanel pnlSouth = new JPanel(new GridLayout(1,0));
        pnlSouth.add(btnPlus);
        pnlSouth.add(btnMinus);
        pnlSouth.add(btnReset);

        add(lblNum, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

    }

    private void addListener() {

        // ActionListener 객체를 생성하고
        // 인터페이스 안에 있는 메소드를 사용하기 위해
        // @Override을 사용합니다.
        // actionPerformed 라고 적힌 이 메소드안에
        // 해당 Component를 선택했을때, 실행되는
        // 코드를 작성하시면 됩니다.

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                // btnPlus를 선택했을때
                if(btnPlus.equals(ae.getSource())){

                    String strNum = lblNum.getText();
                    // 숫자를 증가시키기 위해서 문자형태인 strNum을
                    // 정수 형태로 변환시킵니다.
                    int num = Integer.parseInt(strNum);
                    num++;

                    // JLabel에 들어가는 파라미터값은 String이기 때문에
                    // int 형태인 num을 String의 형태로 변환합니다.
                    strNum = String.valueOf(num);
                    lblNum.setText(strNum);
                }

                if(btnMinus.equals(ae.getSource())){
                    String strNum = lblNum.getText();
                    int num = Integer.parseInt(strNum);
                    num--;
                    strNum = String.valueOf(num);
                    lblNum.setText(strNum);
                }

                if(btnReset.equals(ae.getSource())){
                    lblNum.setText("0");
                }
            }
        };

        // 위에서 해당 Component를 실행했을때,
        // 코드를 작성했다면 마무리로
        // addActionListener(listener); 추가 필요
        // 이를 추가하지 않을시에는 해당 액션이 발생하지 않습니다.

        btnPlus.addActionListener(listener);
        btnMinus.addActionListener(listener);
        btnReset.addActionListener(listener);

    }

    // 프레임 설정
    private void showFrame() {
        setTitle("Counter");
        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //
    public static void main(String[] args)  {
        new ActionListenerEx();
    }
}