import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel {
    private static final int minValue = 0;
    private static final int maxValue = 100;

    private static int currentValue = minValue;
    public ProgressPanel() {run();}

    public void run() {
        JFrame progressPanel = new JFrame("扫雷");
        progressPanel.setSize(250, 250);
        progressPanel.setLocationRelativeTo(null);
        progressPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个进度条
        final JProgressBar progress = new JProgressBar();

        // 设置进度的 最小值 和 最大值
        progress.setMinimum(minValue);
        progress.setMaximum(maxValue);

        // 设置当前进度值
        progress.setValue(currentValue);

        // 绘制百分比文本（进度条中间显示的百分数）
        progress.setStringPainted(true);

        // 添加进度改变通知
        progress.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前进度值: " + progress.getValue() + "; " +
                        "进度百分比: " + progress.getPercentComplete());
            }
        });

        // 添加到内容面板
        panel.add(progress);

        progressPanel.setContentPane(panel);
        progressPanel.setVisible(true);

        // 模拟延时操作进度, 每隔 0.5 秒更新进度
        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentValue++;
                if (currentValue > maxValue) {
                    currentValue = minValue;
                }
                progress.setValue(currentValue);
                if (currentValue == maxValue) {
                    progressPanel.dispose();
                    StartPanel startPanel=new StartPanel();
                }
            }
        }).start();
    }
}
