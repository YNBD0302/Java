import javax.swing.*;

public class StartPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel[][] labels;
    private int rows;
    private int cols;

    public StartPanel(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.labels = new JLabel[rows][cols];
    this.setLayout(null);
    this.initLabels();
}

    private void initLabels() {
    }
}
