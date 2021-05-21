import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingPanel extends JPanel {
    public static void main(String[] args) {
        JFrame settingFrame = new JFrame("设置");
        settingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.add(new JLabel("主题"));
        //TODO 横向滚动预览画面

        panel1.add(new JLabel("音效"));
        panel1.add(new JLabel("背景音乐："));

        final JTextField textField1 = new JTextField(1);
        textField1.setFont(new Font(null, Font.PLAIN, 20));
        panel1.add(textField1);
        //TODO 文本框的内容与音量正相关
        panel1.add(new JLabel("%"));
        JToggleButton bgm = new JToggleButton();
        JButton bgmSoundUp = new JButton();
        JButton bgmSoundDown = new JButton();
        bgm.setOpaque(false);
        bgm.setBorder(null);
        bgm.setForeground(Color.BLACK);
        bgm.setFont(new Font("微软雅黑", Font.BOLD, 15));
        bgm.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即开关按钮本身）
                JToggleButton toggleBtn = (JToggleButton) e.getSource();
                System.out.println(toggleBtn.getText() + " 是否选中: " + toggleBtn.isSelected());
            }
        });
        bgmSoundUp.setOpaque(false);
        bgmSoundUp.setBorder(null);
        bgmSoundUp.setForeground(Color.BLACK);
        bgmSoundUp.setFont(new Font("微软雅黑", Font.BOLD, 26));
        bgmSoundUp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        bgmSoundDown.setOpaque(false);
        bgmSoundDown.setBorder(null);
        bgmSoundDown.setForeground(Color.BLACK);
        bgmSoundDown.setFont(new Font("微软雅黑", Font.BOLD, 26));
        bgmSoundDown.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        panel1.add(new JLabel("游戏音效："));
        final JTextField textField2 = new JTextField(1);
        textField2.setFont(new Font(null, Font.PLAIN, 20));
        panel1.add(textField2);
        //TODO 文本框的内容与音量正相关
        panel1.add(new JLabel("%"));
        JToggleButton ae = new JToggleButton();
        JButton aeSoundUp = new JButton();
        JButton aeSoundDown = new JButton();
        ae.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即开关按钮本身）
                JToggleButton toggleBtn = (JToggleButton) e.getSource();
                System.out.println(toggleBtn.getText() + " 是否选中: " + toggleBtn.isSelected());
            }
        });
        aeSoundUp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        aeSoundDown.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        panel1.add(bgm);
        panel1.add(bgmSoundUp);
        panel1.add(bgmSoundDown);
        panel1.add(ae);
        panel1.add(aeSoundUp);
        panel1.add(aeSoundDown);
        //TODO 增减音量的方法

        panel1.add(new JLabel("动画"));
        panel1.add(new JLabel("过场动画"));
        JToggleButton cutscene = new JToggleButton();
        cutscene.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        panel1.add(new JLabel("游戏动画"));
        JToggleButton animation = new JToggleButton();
        animation.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO 联系上加减音量的方法
            }
        });
        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("关于我们"));

        settingFrame.setSize(250, 250);
        settingFrame.setLocationRelativeTo(null);
        settingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建文本区域组件
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);                         // 自动换行
        textArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));   // 设置字体
        //textArea.

        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        // JScrollPane scrollPane = new JScrollPane(
        //       textArea,
        //       ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        //      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        // );
        settingFrame.setContentPane(panel1);
        settingFrame.setVisible(true);
    }
}
