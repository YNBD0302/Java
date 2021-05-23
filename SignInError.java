import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInError {
    private static final JFrame signInErrorFrame = new JFrame("错误");
    private static final JPanel signInErrorPanel = new JPanel();
    private static final JLabel report1 = new JLabel("请您重新输入");
    private static final JLabel report2 = new JLabel("如果您还没有账户，请您点击下方”注册“按钮注册");
    private static final JLabel error1 = new JLabel("用户名与密码不一致");
    private static final JLabel error2 = new JLabel("该用户不存在！");
    private static final JButton ok = new JButton("好的");

    public SignInError(int index) {
        errorType(index);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInErrorFrame.dispose();
            }
        });
        ok.add(signInErrorPanel);

        signInErrorFrame.pack();
        signInErrorFrame.setSize(300, 300);
        signInErrorFrame.setLocationRelativeTo(null);
        signInErrorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signInErrorFrame.setContentPane(signInErrorPanel);
        signInErrorFrame.setVisible(true);

    }

    public static void errorType(int index) {
        switch (index) {
            case (1) -> {
                error1.add(signInErrorPanel);
                report1.add(signInErrorPanel);
            }
            case (2) -> {
                error2.add(signInErrorPanel);
                report2.add(signInErrorPanel);
            }
        }
    }
}
