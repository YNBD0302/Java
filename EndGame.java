import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class EndGame extends JFrame{
    public EndGame() {
        JFrame endFrame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(10,1,7,10));
        panel.add(new JLabel("评语",JLabel.CENTER));
        panel.add(new JLabel("您找出的雷数："));
        panel.add(new JTextField(1));
        panel.add(new JLabel("未找出的的雷数："));
        panel.add(new JTextField(1));
        panel.add(new JLabel("失误数："));
        panel.add(new JTextField(1));
        panel.add(new JLabel("用时："));
        panel.add(new JTextField(1));
        JButton renew = new JButton("再来一局");
        JButton back=new JButton("回到主页");
        renew.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        panel.add(renew);
        back.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即开关按钮本身）

            }
        });
        panel.add(back);
        endFrame.pack();
        endFrame.setLocationRelativeTo(null);
        endFrame.setSize(500, 600);
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setContentPane(panel);
        endFrame.setVisible(true);
    }
}
