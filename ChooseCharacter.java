import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChooseCharacter extends JFrame {
    private static int num;
    private static final JFrame characterFrame = new JFrame("扫雷");
    private static final JPanel singlePlayer = new JPanel();
    private static final JLabel chooseHero = new JLabel("请选择你的角色");
    private static final JButton confirm = new JButton("确认");
    private static final String[] heroList = new String[]{"乔纳森·乔斯达", "迪奥·布兰度", "乔瑟夫·乔斯达", "空条承太郎", "乔鲁诺·乔巴纳", "东方仗助", "吉良吉影"};
    private static final JComboBox<String> heroBox = new JComboBox<String>(heroList);
    private static final JSplitPane doublePlayer = new JSplitPane();

    public ChooseCharacter(int num) {
        switch (num) {
            case (0):
                initHero1();
            case (1):
                initHero2();
        }
    }

    public static void initHero1() {
        setConfirm();
        getHero();
        singlePlayer.add(chooseHero);
        singlePlayer.add(heroBox);
        singlePlayer.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //  GamePanel gamePanel = new GamePanel();
                //gamePanel.setVisible(true);
                //TODO 连接GamePanel的方法
                characterFrame.dispose();
            }
        });
        characterFrame.setContentPane(singlePlayer);
        setCharacterFrame();
    }

    public static void initHero2() {
        getHero();
        setConfirm();
        doublePlayer.setOneTouchExpandable(true);
        doublePlayer.setContinuousLayout(true);
        doublePlayer.setDividerLocation(250);
        doublePlayer.setLeftComponent(chooseHero);
        doublePlayer.setLeftComponent(heroBox);
        doublePlayer.setLeftComponent(confirm);
        doublePlayer.setRightComponent(chooseHero);
        doublePlayer.setRightComponent(heroBox);
        doublePlayer.setRightComponent(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO 连接GamePanel的方法
                characterFrame.dispose();
             // GamePanel gamePanel = new GamePanel();
            }
        });
        characterFrame.setContentPane(doublePlayer);
        setCharacterFrame();
    }

    public static void getHero() {
//TODO 连接选择角色的图片
        heroBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + heroBox.getSelectedIndex() + " = " + heroBox.getSelectedItem());
                }
            }
        });
    }

    public static void setConfirm() {
        confirm.setOpaque(false);
        confirm.setBorder(null);
        confirm.setForeground(Color.BLACK);
        confirm.setFont(new Font("微软雅黑", Font.BOLD, 26));
    }

    public static void setCharacterFrame() {
        characterFrame.pack();
        characterFrame.setLocationRelativeTo(null);
        characterFrame.setSize(500, 600);
        characterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterFrame.setVisible(true);
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        ChooseCharacter.num = num;
    }
}