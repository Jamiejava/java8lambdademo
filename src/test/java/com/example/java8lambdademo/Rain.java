package com.example.java8lambdademo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2021/1/15 11:12
 */
public class Rain extends JFrame implements ActionListener {

    private Random random = new Random();
    private Dimension screenSize;
    private JPanel graphicsPanel;
    private final static int gap = 20;
    //存放雨点顶部的位置信息(marginTop)
    private int[] posArr;//行数
    private int lines;//列数
    private int columns;
    public Rain() {
        initComponents();
    }
    private void initComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        lines = screenSize.height / gap;
        columns = screenSize.width / gap;
        posArr = new int[columns + 1];
        random = new Random();
        for (int i = 0; i < posArr.length; i++) {
            posArr[i] = random.nextInt(lines);
        }
        new Timer(200, this).start();//每秒10帧
        setLayout(new BorderLayout());
        graphicsPanel = new GraphicsPanel();
        add(graphicsPanel, BorderLayout.CENTER);
        //ESC键退出
        KeyPressListener keyPressListener = new KeyPressListener();
        this.addKeyListener(keyPressListener);
        //this.setAlwaysOnTop(true);
//        //去标题栏
       this.setUndecorated(true);
//        //全屏
       //this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
        int width,hight;
        width = (int)(screenSize.width-800)/2;
        hight = (int)(screenSize.height-500)/2;
        this.setSize(screenSize.width, screenSize.height);
        //this.setLocation(width, hight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private char getChr() {// @return 随机字符
        return (char) (random.nextInt(94) + 33);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        graphicsPanel.repaint();
        System.out.println("11111");
    }
    private class GraphicsPanel extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(getFont().deriveFont(Font.BOLD));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, screenSize.width, screenSize.height);
            //当前列
            int currentColumn = 0;
            for (int x = 0; x < screenSize.width; x += gap) {
                int endPos = posArr[currentColumn];
                g2d.setColor(Color.CYAN);
                g2d.drawString(String.valueOf(getChr()), x, endPos * gap);
                int cg = 0;
                for (int j = endPos - 15; j < endPos; j++) {
                    cg += 20;//颜色渐变
                    if (cg > 255) {
                        cg = 255;
                    }
                    g2d.setColor(new Color(0, cg, 0));
                    g2d.drawString(String.valueOf(getChr()), x, j * gap);
                }
                //每放完一帧，当前列上雨点的位置随机下移1~5行
                posArr[currentColumn] += random.nextInt(5);
                //当雨点位置超过屏幕高度时，重新产生一个随机位置
                if (posArr[currentColumn] * gap > getHeight()) {
                    posArr[currentColumn] = random.nextInt(lines);
                }
                currentColumn++;
                System.out.println(currentColumn);
            }
        }
    }
    private class KeyPressListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Rain();
    }
}
