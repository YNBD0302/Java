import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bub extends JButton{

    private int face=13;       //表面上的图形显示
    private int real=0;    //有无雷，有雷为1，无雷为0
    private boolean isOpen = false;//表明当前按钮的状态，true表示已经翻开，false表示还未翻开
    private ImageIcon[]img = new ImageIcon[14];
    public Bub() {
        super();
        img[0] = new ImageIcon("C:\\Users\\HP\\Desktop\\空.jpg.png");
        img[1] = new ImageIcon("C:\\Users\\HP\\Desktop\\1蓝色.png");
        img[2] = new ImageIcon("C:\\Users\\HP\\Desktop\\2蓝色.png");
        img[3] = new ImageIcon("C:\\Users\\HP\\Desktop\\3蓝色.png");
        img[4] = new ImageIcon("C:\\Users\\HP\\Desktop\\4蓝色.png");
        img[5] = new ImageIcon("C:\\Users\\HP\\Desktop\\5mine.jpg");
        img[6] = new ImageIcon("C:\\Users\\HP\\Desktop\\6mine.jpg");
        img[7] = new ImageIcon("C:\\Users\\HP\\Desktop\\7mine.jpg");
        img[8] = new ImageIcon("C:\\Users\\HP\\Desktop\\8mine.jpg");
        img[9] = new ImageIcon("C:\\Users\\HP\\Desktop\\mine.png");
        img[10] = new ImageIcon("C:\\Users\\HP\\Desktop\\mineerr.jpg");
        img[11] = new ImageIcon("C:\\Users\\HP\\Desktop\\flag正确.png");
        img[12] = new ImageIcon("C:\\Users\\HP\\Desktop\\flag错误.png");
        img[13] = new ImageIcon("C:\\Users\\HP\\Desktop\\bg.jpg");
    }
    public int getface() {
        return face;
    }
    public int getreal() {
        return real;
    }
    public void setface(int c) {
        face = c;
    }
    public void setreal(int c) {
        real = c;
    }
    public void setOpen(boolean swit) {
        isOpen = swit;
    }
    public boolean getOpen() {
        return isOpen;
    }
    public void showImg(int c) {
        this.setIcon(img[c]);
        if(c!=13)isOpen = true;
    }

}