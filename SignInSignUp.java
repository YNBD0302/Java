import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInSignUp {
    private static final JFrame signFrame = new JFrame("登录或注册以进入游戏");
    public static final JPanel signPanel = new JPanel();
    private static final JLabel title = new JLabel("进入游戏");
    private static final JLabel userName = new JLabel("用户名:");
    private static final JLabel password = new JLabel("密码：");
    private static final JButton signIn = new JButton("登录");
    private static final JButton signUp = new JButton("注册");
    private static final JPasswordField userNameField = new JPasswordField(10);
    private static final JPasswordField passwordField = new JPasswordField(10);

    public SignInSignUp() {
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isCorrect()) {
                    signFrame.dispose();
                    StartPanel startPanel = new StartPanel();
               // } else if () {
                //    SignUpError signInError = new SignUpError(1);
                //} else if () {
                  //  SignUpError signInError = new SignUpError(2);
                }
            }
        });
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            SignUp signUp=new SignUp();
            //TODO 添加可以使背后页面不可用的方法
            }
        });
        title.add(signPanel);
        userName.add(signPanel);
        userNameField.add(signPanel);
        password.add(signPanel);
        passwordField.add(signPanel);
        signIn.add(signPanel);
        signUp.add(signPanel);

        signFrame.pack();
        signFrame.setSize(300, 300);
        signFrame.setLocationRelativeTo(null);
        signFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signFrame.setContentPane(signPanel);
        signFrame.setVisible(true);
    }

    private static boolean isCorrect() {
        if (passwordField.getPassword() !=null&& userNameField.getPassword()!=null  ) {
            return true;
        }
        return false;
    }
}
