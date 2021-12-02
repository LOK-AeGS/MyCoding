package Guajae;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;



class puzzle_Ex extends JFrame implements ActionListener {
    JPanel jp = new JPanel();
//    JButton []jbtn;
    LinkedList<JButton> jbtn;
    JButton lastbutton;

//    BufferedImage image[];
    LinkedList<BufferedImage> image;
    Image original;
    int cnt = 0, game[], row=4, col=3, list_cnt = 0, brow, bcol;
    //N, S, E, W
    int[] rowDir = {-80, 80, 0, 0};
    int[] colDir = {0, 0, 74, -74};
    int x, y;

    public puzzle_Ex() {


        MediaTracker tracker = new MediaTracker(this);
        original = Toolkit.getDefaultToolkit().getImage("image/football.jpg");
        tracker.addImage(original, 0);
        try {tracker.waitForAll();} catch(InterruptedException e) {;}
        int width = 74;
        int height = 80;
        setSize(new Dimension(width*col, height*row));

//        image = new BufferedImage[row*col];
        image = new LinkedList<BufferedImage>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
//                image[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                image.add(new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB));
//                Graphics g = image[cnt].getGraphics();
                Graphics g = image.get(cnt).getGraphics();
                g.drawImage(original, 0, 0, width, height, j*width, i*height, (j+1)*width, (i+1)*height, this);
                cnt++;
            }
        }

        game = new int[row*col];
//        jbtn = new JButton[row*col];
        jbtn = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
//                jbtn[list_cnt] = new JButton();
                jbtn.add(new JButton());
                if (i == 3 && j == 2) {
                    lastbutton = new JButton();
                    lastbutton.setContentAreaFilled(false);
                    lastbutton.putClientProperty("position", new Point(i, j));
                    brow = i;
                    bcol = j;
                    continue;
                }
//                jbtn[list_cnt].setBounds(j*width, i*height, 73, 79);
                jbtn.get(list_cnt).setBounds(j*width, i*height, 73, 79);
//                jbtn[list_cnt].setBorderPainted(false);
                jbtn.get(list_cnt).setBorderPainted(false);
//                jbtn[list_cnt].addActionListener(this);
                jbtn.get(list_cnt).addActionListener(this);
                add(jbtn.get(list_cnt));

                list_cnt += 1;
            }
        }

        shuffle();

      /*JButton restart = new JButton("재시작하기");
      restart.setBounds(240, 100, 80, 30);
      restart.addActionListener(this);
      add(restart);*/

        setTitle("puzzle game");
        setSize(350, 400);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void shuffle() {
        Random rnd = new Random();

        do {
            for (int i=0; i<row*col; i++) game[i] = 0;

            for (int i=0; i<row*col; i++) {
                int temp = 0;
                do {
                    temp = rnd.nextInt(row*col);
                }while(game[temp]!=0);
                game[temp] = i;
            }
        }while(endGame());

        for(int i=0; i<row*col; i++) {
//            jbtn.get(i).setIcon(new ImageIcon(image[game[i]]));
            jbtn.get(i).setIcon(new ImageIcon(image.get(game[i])));
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new puzzle_Ex();
    }

    private boolean endGame() {
        boolean endGame = true;
        for (int i=0; i<game.length; i++) {
            if(i!=game[i]) {
                endGame = false;
            }
        }return endGame;
    }

    public void actionPerformed(ActionEvent e) {
        JButton curBtn = (JButton)e.getSource();
      /*
      for(int i=0; i<jbtn.length; i++)
         if(curBtn.getIcon().equals(jbtn[i].getIcon())) {
            System.out.println("!");
            break;
         }*/

        for (int i=0; i<4; i++) {
            this.x = bcol + colDir[i];
            this.y = brow + rowDir[i];

            if (bcol>0 && bcol<224 && brow>0 && brow>320) {
                if (i==0) {

                    lastbutton.setContentAreaFilled(false);
                    lastbutton.putClientProperty("position", new Point(x, y));
                }
            }
        }


        if(endGame()) {
            JOptionPane.showMessageDialog(this, "게임을 성공하였습니다!!!");

            int re = JOptionPane.showConfirmDialog(this, "다시하기","종료하기",JOptionPane.YES_NO_OPTION);
            if(re == JOptionPane.YES_OPTION) {
                shuffle();
                repaint();
            } else System.exit(0);
        }

    }
}