import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;


public class StartPanel extends JFrame {
    private static final JFrame startFrame = new JFrame("扫雷");
    private static final JPanel startPanel = new JPanel();
    public StartPanel(){init();}
    public static void init() {
        ImageIcon StartVideo = new ImageIcon();
        JLabel title = new JLabel("扫雷", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);
        JButton nonNetworkGame = new JButton("进入游戏");
        nonNetworkGame.setOpaque(false);
        nonNetworkGame.setBorder(null);
        nonNetworkGame.setIcon();
        nonNetworkGame.setForeground(Color.WHITE);
        nonNetworkGame.setFont(new Font("微软雅黑", Font.BOLD, 26));
        nonNetworkGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                ChoosePattern pattern = new ChoosePattern();
            }
        });

        JButton onlineGame = new JButton("继续游戏");
        onlineGame.setOpaque(false);
        onlineGame.setBorder(null);
        onlineGame.setForeground(Color.BLACK);
        onlineGame.setFont(new Font("微软雅黑", Font.BOLD, 26));
        onlineGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                OnlineGame online = new OnlineGame();
                online.setVisible(true);
            }
        });

        JButton setting = new JButton("游戏设置");
        setting.setOpaque(false);
        setting.setBorder(null);
        setting.setForeground(Color.BLACK);
        setting.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                SettingPanel settingPanel = new SettingPanel();
            }
        });

        startFrame.setSize(400, 600);
        startPanel.setSize(30, 40);
        startPanel.setLayout(new GridLayout(6, 1, 10, 40));
        startPanel.setPreferredSize(new Dimension(300, 500));
        startPanel.add(title);
        startPanel.add(nonNetworkGame);
        startPanel.add(onlineGame);
        startPanel.add(setting);

        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = startFrame.getContentPane();
        c.add(startPanel);
        startFrame.setVisible(true);
    }


}