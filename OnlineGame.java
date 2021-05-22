import javax.swing.*;

public class OnlineGame extends JFrame {
    private static final JFrame onlineFrame = new JFrame("扫雷");

    public OnlineGame(){
        JLabel label = new JLabel("本区域暂未开放，敬请期待");

        JPanel panel=new JPanel();
        panel.add(label);
        onlineFrame.pack();
        onlineFrame.setLocationRelativeTo(null);
        onlineFrame.setSize(500, 600);
        onlineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        onlineFrame.setContentPane(panel);
        onlineFrame.setVisible(true);
    }}

