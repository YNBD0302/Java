import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpError {private static final JFrame signUpErrorFrame =new JFrame("错误");
    private static final JPanel signUpErrorPanel =new JPanel();
    private static final JLabel report =new JLabel("请您重新输入");
    private static final JLabel error1 =new JLabel("用户名或密码不能为空！");
    private static final JLabel error2 =new JLabel("两次输入密码不一致！");
    private static final JButton ok =new JButton("好的");
    public SignUpError(int index){errorType(index);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpErrorFrame.dispose();
            }
        });
        ok.add(signUpErrorPanel);

        signUpErrorFrame.pack();
        signUpErrorFrame.setSize(300, 300);
        signUpErrorFrame.setLocationRelativeTo(null);
        signUpErrorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signUpErrorFrame.setContentPane(signUpErrorPanel);
        signUpErrorFrame.setVisible(true);

    }
    public static void errorType(int index){
        switch (index) {
            case (1) -> {
                error1.add(signUpErrorPanel);
            }
            case (2) -> {
                error2.add(signUpErrorPanel);
                report.add(signUpErrorPanel);
            }
        }
    }
}
