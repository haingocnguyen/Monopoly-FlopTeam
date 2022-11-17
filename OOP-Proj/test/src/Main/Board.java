package Main;

import javax.swing.*;

public class Board extends JPanel {
    GamePanel gp;
    private JLayeredPane topLeft;
    private JLayeredPane bottomLeft;
    private JLayeredPane topRight;
    private JLayeredPane bottomRight;
    private JLayeredPane left_1;
    private JLayeredPane left_2;
    private JLayeredPane left_3;
    private JLayeredPane left_4;
    private JLayeredPane left_5;
    private JLayeredPane left_6;
    private JLayeredPane left_7;
    private JLayeredPane left_8;
    private JLayeredPane left_9;
    private JLayeredPane top_1;
    private JLayeredPane top_2;
    private JLayeredPane top_3;
    private JLayeredPane top_4;
    private JLayeredPane top_5;
    private JLayeredPane top_6;
    private JLayeredPane top_7;
    private JLayeredPane top_8;
    private JLayeredPane top_9;
    private JLayeredPane right_1;
    private JLayeredPane right_2;
    private JLayeredPane right_3;
    private JLayeredPane right_4;
    private JLayeredPane right_5;
    private JLayeredPane right_6;
    private JLayeredPane right_7;
    private JLayeredPane right_8;
    private JLayeredPane right_9;
    private JLayeredPane bottom_1;
    private JLayeredPane bottom_2;
    private JLayeredPane bottom_3;
    private JLayeredPane bottom_4;
    private JLayeredPane bottom_5;
    private JLayeredPane bottom_6;
    private JLayeredPane bottom_7;
    private JLayeredPane bottom_8;
    private JLayeredPane bottom_9;
    private JLabel bottomRightLabel;
    private JLabel bottom1Label;
    private JLabel bottom2Label;
    private JLabel bottom3Label;
    private JLabel bottom4Label;
    private JLabel bottom5Label;
    private JLabel bottom6Label;
    private JLabel bottom7Label;
    private JLabel bottom8Label;
    private JLabel bottom9Label;
    private JLabel bottomLeftLabel;
    private JLabel left1Label;
    private JLabel left2Label;
    private JLabel left3Label;
    private JLabel left4Label;
    private JLabel left5Label;
    private JLabel left6Label;
    private JLabel left7Label;
    private JLabel left8Label;
    private JLabel left9Label;
    private JLabel topLeftLabel;
    private JLabel top1Label;
    private JLabel top2Label;
    private JLabel top3Label;
    private JLabel top4Label;
    private JLabel top5Label;
    private JLabel top6Label;
    private JLabel top7Label;
    private JLabel top8Label;
    private JLabel top9Label;
    private JLabel topRightLabel;
    private JLabel right1Label;
    private JLabel right2Label;
    private JLabel right3Label;
    private JLabel right4Label;
    private JLabel right5Label;
    private JLabel right6Label;
    private JLabel right7Label;
    private JLabel right8Label;
    private JLabel right9Label;
    private JLabel buildingLabel0;
    private JLabel buildingLabel1;
    private JLabel buildingLabel2;
    private JLabel buildingLabel3;
    private JLabel buildingLabel4;
    private JLabel buildingLabel5;
    private JLabel buildingLabel6;
    private JLabel buildingLabel7;
    private JLabel buildingLabel8;
    private JLabel buildingLabel9;
    private JLabel buildingLabel10;
    private JLabel buildingLabel11;
    private JLabel buildingLabel12;
    private JLabel buildingLabel13;
    private JLabel buildingLabel14;
    private JLabel buildingLabel15;
    private JLabel buildingLabel16;
    private JLabel buildingLabel17;
    private JLabel buildingLabel18;
    private JLabel buildingLabel19;
    private JLabel buildingLabel20;
    private JLabel buildingLabel21;

    public Board(GamePanel gp){
        this.gp = gp;
    }

    public void initializeBoard(){
        topLeft = new JLayeredPane();
        topLeft.setBounds(0,0,gp.CardCornerSize,gp.CardCornerSize);

        left_1 = new JLayeredPane();
        left_1.setBounds(0,gp.CardCornerSize,gp.CardCornerSize,gp.CardNormalSize);

        left_2 = new JLayeredPane();
        left_2.setBounds(0,gp.CardCornerSize*2,gp.CardCornerSize,gp.CardNormalSize);

        left_3 = new JLayeredPane();
        left_3.setBounds(0,gp.CardCornerSize*3,gp.CardCornerSize,gp.CardNormalSize);

        left_4 = new JLayeredPane();
        left_4.setBounds(0,gp.CardCornerSize*4,gp.CardCornerSize,gp.CardNormalSize);

        left_5 = new JLayeredPane();
        left_5.setBounds(0,gp.CardCornerSize*5,gp.CardCornerSize,gp.CardNormalSize);

        left_6 = new JLayeredPane();
        left_6.setBounds(0,gp.CardCornerSize*6,gp.CardCornerSize,gp.CardNormalSize);

        left_7 = new JLayeredPane();
        left_7.setBounds(0,gp.CardCornerSize*7,gp.CardCornerSize,gp.CardNormalSize);

        left_8 = new JLayeredPane();
        left_8.setBounds(0,gp.CardCornerSize*8,gp.CardCornerSize,gp.CardNormalSize);

        left_9 = new JLayeredPane();
        left_9.setBounds(0,gp.CardCornerSize*9,gp.CardCornerSize,gp.CardNormalSize);

        bottomLeft = new JLayeredPane();
        bottomLeft.setBounds(0,930,gp.CardCornerSize,gp.CardCornerSize);

        top_1 = new JLayeredPane();
        top_1.setBounds(gp.CardCornerSize,0,gp.CardNormalSize,gp.CardCornerSize);

        top_2 = new JLayeredPane();
        top_2.setBounds(gp.CardCornerSize*2,0,gp.CardNormalSize,gp.CardCornerSize);

        top_3 = new JLayeredPane();
        top_3.setBounds(gp.CardCornerSize*3,0,gp.CardNormalSize,gp.CardCornerSize);

        top_4 = new JLayeredPane();
        top_4.setBounds(gp.CardCornerSize*4,0,gp.CardNormalSize,gp.CardCornerSize);

        top_5 = new JLayeredPane();
        top_5.setBounds(gp.CardCornerSize*5,0,gp.CardNormalSize,gp.CardCornerSize);

        top_6 = new JLayeredPane();
        top_6.setBounds(gp.CardCornerSize*6,0,gp.CardNormalSize,gp.CardCornerSize);

        top_7 = new JLayeredPane();
        top_7.setBounds(gp.CardCornerSize*7,0,gp.CardNormalSize,gp.CardCornerSize);

        top_8 = new JLayeredPane();
        top_8.setBounds(gp.CardCornerSize*8,0,gp.CardNormalSize,gp.CardCornerSize);

        top_9 = new JLayeredPane();
        top_9.setBounds(gp.CardCornerSize*9,0,gp.CardNormalSize,gp.CardCornerSize);

        topRight = new JLayeredPane();
        topRight.setBounds(930,0,gp.CardCornerSize,gp.CardCornerSize);

        right_1 = new JLayeredPane();
        right_1.setBounds(930,gp.CardCornerSize,gp.CardCornerSize,gp.CardNormalSize);

        right_2 = new JLayeredPane();
        right_2.setBounds(930,gp.CardCornerSize*2,gp.CardCornerSize,gp.CardNormalSize);

        right_3 = new JLayeredPane();
        right_3.setBounds(930,gp.CardCornerSize*3,gp.CardCornerSize,gp.CardNormalSize);

        right_4 = new JLayeredPane();
        right_4.setBounds(930,gp.CardCornerSize*4,gp.CardCornerSize,gp.CardNormalSize);

        right_5 = new JLayeredPane();
        right_5.setBounds(930,gp.CardCornerSize*5,gp.CardCornerSize,gp.CardNormalSize);

        right_6 = new JLayeredPane();
        right_6.setBounds(930,gp.CardCornerSize*6,gp.CardCornerSize,gp.CardNormalSize);

        right_7 = new JLayeredPane();
        right_7.setBounds(930,gp.CardCornerSize*7,gp.CardCornerSize,gp.CardNormalSize);

        right_8 = new JLayeredPane();
        right_8.setBounds(930,gp.CardCornerSize*8,gp.CardCornerSize,gp.CardNormalSize);

        right_9 = new JLayeredPane();
        right_9.setBounds(930,gp.CardCornerSize*9,gp.CardCornerSize,gp.CardNormalSize);

        bottom_1 = new JLayeredPane();
        bottom_1.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_2 = new JLayeredPane();
        bottom_2.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_3 = new JLayeredPane();
        bottom_3.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_4 = new JLayeredPane();
        bottom_4.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_5 = new JLayeredPane();
        bottom_5.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_6 = new JLayeredPane();
        bottom_6.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_7 = new JLayeredPane();
        bottom_7.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_8 = new JLayeredPane();
        bottom_8.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_9 = new JLayeredPane();
        bottom_9.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottomRight = new JLayeredPane();
        bottomRight.setBounds(930,930,gp.CardCornerSize,gp.CardCornerSize);

        buildingLabel0 = new JLabel();
        buildingLabel1 = new JLabel();
        buildingLabel2 = new JLabel();
        buildingLabel3 = new JLabel();
        buildingLabel4 = new JLabel();
        buildingLabel5 = new JLabel();
        buildingLabel6 = new JLabel();
        buildingLabel7 = new JLabel();
        buildingLabel8 = new JLabel();
        buildingLabel9 = new JLabel();
        buildingLabel10 = new JLabel();
        buildingLabel11 = new JLabel();
        buildingLabel12 = new JLabel();
        buildingLabel13 = new JLabel();
        buildingLabel14 = new JLabel();
        buildingLabel15 = new JLabel();
        buildingLabel16 = new JLabel();
        buildingLabel17 = new JLabel();
        buildingLabel18 = new JLabel();
        buildingLabel19 = new JLabel();
        buildingLabel20 = new JLabel();
        buildingLabel21 = new JLabel();

    }
}
