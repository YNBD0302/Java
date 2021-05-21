import javax.swing.*;
import java.awt.*;

public class Main {
    private static final JFrame startFrame = new JFrame("扫雷");

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JLabel title = new JLabel("扫雷", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        title.setOpaque(false);
        JButton nonNetworkGame = new JButton("单机游戏");
        nonNetworkGame.setOpaque(false);
        nonNetworkGame.setBorder(null);
        nonNetworkGame.setForeground(Color.BLACK);
        nonNetworkGame.setFont(new Font("微软雅黑", Font.BOLD, 26));
        nonNetworkGame.addActionListener(e -> {
            ChoosePattern pattern = new ChoosePattern();
            pattern.setVisible(true);
        });

        JButton onlineGame = new JButton("继续游戏");
        onlineGame.setOpaque(false);
        onlineGame.setBorder(null);
        onlineGame.setForeground(Color.BLACK);
        onlineGame.setFont(new Font("微软雅黑", Font.BOLD, 26));
        onlineGame.addActionListener(e -> {
            OnlineGame online = new OnlineGame();
            online.setVisible(true);
        });

        JButton setting = new JButton("游戏设置");
        setting.setOpaque(false);
        setting.setBorder(null);
        setting.setForeground(Color.BLACK);
        setting.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        setting.addActionListener(e -> {
            SettingPanel settingPanel = new SettingPanel();
            settingPanel.setVisible(true);
        });
        startFrame.setSize(400, 600);
        StartPanel startPanel = new StartPanel(30, 40);
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