import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpCorrect {
    private static final JFrame signInCorrectFrame = new JFrame("提交成功");
    private static final JPanel signInCorrectPanel = new JPanel();
    private static final JLabel correct = new JLabel("提交成功");
    private static final JLabel report = new JLabel("点击下方”返回“按钮返回登陆界面");
    private static final JButton back = new JButton("好的");

    public SignUpCorrect() {
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInCorrectFrame.dispose();
            }
        });
        correct.add(signInCorrectPanel);
        report.add(signInCorrectPanel);
        back.add(signInCorrectPanel);
        signInCorrectFrame.pack();
        signInCorrectFrame.setSize(300, 300);
        signInCorrectFrame.setLocationRelativeTo(null);
        signInCorrectFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signInCorrectFrame.setContentPane(signInCorrectPanel);
        signInCorrectFrame.setVisible(true);

    }}