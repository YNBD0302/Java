import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoosePattern extends JFrame {
    private static final JFrame chooseFrame = new JFrame("扫雷");

    public ChoosePattern() {

        String[] levelList = new String[]{"初级(方块数：9*9 雷数：10)", "中级(方块数：16*16 雷数：40)", "高级(方块数：16*30 雷数：99)"};
        String[] stepList = new String[]{"1", "2", "3", "4", "5"};
        String[] numList = new String[]{"1", "2"};
        String[] patternList = new String[]{"单机模式", "人机对战", "联机模式"};
        final JComboBox<String> levelBox = new JComboBox<String>(levelList);
        final JComboBox<String> stepBox = new JComboBox<String>(stepList);
        final JComboBox<String> numBox = new JComboBox<String>(numList);
        final JComboBox<String> patternBox = new JComboBox<String>(patternList);

        levelBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + levelBox.getSelectedIndex() + " = " + levelBox.getSelectedItem());
                }
            }
        });

        stepBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemStateChanged) {
                // 只处理选中的状态
                if (itemStateChanged.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + stepBox.getSelectedIndex() + " = " + stepBox.getSelectedItem());
                }
            }
        });

        numBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemStateChanged) {
                // 只处理选中的状态
                if (itemStateChanged.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + numBox.getSelectedIndex() + " = " + numBox.getSelectedItem());
                }
            }
        });

        patternBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemStateChanged) {
                // 只处理选中的状态
                if (itemStateChanged.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + patternBox.getSelectedIndex() + " = " + patternBox.getSelectedItem());
                }
            }
        });

        JButton nextStep = new JButton("下一步");
        nextStep.setOpaque(false);
        nextStep.setBorder(null);
        nextStep.setForeground(Color.BLACK);
        nextStep.setFont(new Font("微软雅黑", Font.BOLD, 26));
        nextStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFrame.dispose();
                ChooseCharacter chooseCharacter = new ChooseCharacter(numBox.getSelectedIndex());
            }
        });

        JButton back = new JButton("返回");
        back.setOpaque(false);
        back.setBorder(null);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("微软雅黑", Font.BOLD, 26));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFrame.dispose();
                StartPanel startPanel = new StartPanel();
            }
        });

        JPanel panel01 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel01.add(new JLabel("难度设置:"));
        panel01.add(levelBox);

        // 第 2 个 JPanel, 使用默认的浮动布局
        JPanel panel02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel02.add(new JLabel("步数:"));
        panel02.add(stepBox);

        // 第 3 个 JPanel, 使用浮动布局, 并且容器内组件居中显示
        JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel03.add(nextStep);

        JPanel panel04 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel04.add(new JLabel("游戏人数:"));
        panel04.add(numBox);

        JPanel panel05 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel05.add(new JLabel("游戏模式："));
        panel05.add(patternBox);
        JPanel panel06 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel06.add(back);

        // 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(panel05);
        vBox.add(panel04);
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(panel03);
        vBox.add(panel06);
        switch (numBox.getSelectedIndex()) {
            case (0):
              stepBox.setEnabled(false);
            case (1):
               stepBox.setEnabled(true);
        }

        chooseFrame.pack();
        chooseFrame.setLocationRelativeTo(null);
        chooseFrame.setSize(500, 600);
        chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chooseFrame.setContentPane(vBox);
        chooseFrame.setVisible(true);
    }
}
