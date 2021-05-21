import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoosePattern extends JPanel {

    public static void main(String[] args) {
        ;

        String[] levelList = new String[]{"初级(方块数：9*9 雷数：10)", "中级(方块数：16*16 雷数：40)", "高级(方块数：16*30 雷数：99)"};
        String[] stepList = new String[]{"1", "2", "3", "4", "5"};
        final JComboBox<String> levelBox = new JComboBox<String>(levelList);
        final JComboBox<String> stepBox = new JComboBox<String>(stepList);
        levelBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + levelBox.getSelectedIndex() + " = " + levelBox.getSelectedItem());
                }
            }
        });
        levelBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemStateChanged) {
                // 只处理选中的状态
                if (itemStateChanged.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + stepBox.getSelectedIndex() + " = " + stepBox.getSelectedItem());
                }
            }
        });

        JButton confirm = new JButton("确认");
        confirm.setOpaque(false);
        confirm.setBorder(null);
        confirm.setForeground(Color.BLACK);
        confirm.setFont(new Font("微软雅黑", Font.BOLD, 26));
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // GamePanel gamePanel = new GamePanel();
               // gamePanel.setVisible(true);
                //TODO 连接GamePanel的方法
            }
        });

        JFrame chooseFrame = new JFrame();
        JPanel panel01 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel01.add(new JLabel("难度设置:"));
        panel01.add(levelBox);

        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel02.add(new JLabel("步数:"));
        panel02.add(stepBox);

        // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
        JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel03.add(new JButton("开始游戏"));

        // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(panel03);

        chooseFrame.pack();
        chooseFrame.setLocationRelativeTo(null);
        chooseFrame.setSize(500, 600);
        chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chooseFrame.setContentPane(vBox);
        chooseFrame.setVisible(true);
    }
}
