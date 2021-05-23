import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    private static final JFrame signUpFrame = new JFrame("登录或注册以进入游戏");
    public static final JPanel signUpPanel = new JPanel();
    private static final JLabel userName = new JLabel("用户名:");
    private static final JLabel password = new JLabel("密码：");
    private static final JLabel passwordConfirm = new JLabel("确认密码：");
    private static final JButton signUp = new JButton("注册");
    private static final JButton back = new JButton("返回");
    private static final JPasswordField passwordConfirmField = new JPasswordField(10);
    private static final JPasswordField passwordField = new JPasswordField(10);
    private static final JPasswordField userNameField = new JPasswordField(10);

    public SignUp() {
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getPassword() == null || userNameField.getPassword() == null || passwordConfirmField == null) {
                    SignUpError signUpError = new SignUpError(2);
                    //TODO 存储用户信息
                } else if (passwordField.getPassword() != passwordConfirmField.getPassword()) {
                    SignUpError signUpError = new SignUpError(1);
                } else {
                    signUpFrame.dispose();

                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
            }
        });
        userName.add(signUpPanel);
        passwordConfirmField.add(signUpPanel);
        password.add(signUpPanel);
        passwordField.add(signUpPanel);
        passwordConfirm.add(signUpPanel);
        signUp.add(signUpPanel);
        back.add(signUpPanel);

        signUpFrame.pack();
        signUpFrame.setSize(300, 300);
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signUpFrame.setContentPane(signUpPanel);
        signUpFrame.setVisible(true);
    }
}
