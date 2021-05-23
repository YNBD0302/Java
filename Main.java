import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Main extends JFrame implements MouseListener{
    private int screenwide;//screenWide
    private int screenhigh;//screenHigh
    private int colNum;//columnNom
    private int rowNum;//rowNum
    private int mineNum;
    private int restNum;//restMineNum
    private int restPressNum=100;//restPressNum好像只在双人对战模式中有用!!需要命名初始值
    private boolean judge9Full=true;//判断九宫格内是否有全满 全满则为false
    private int score=0;//记录分数
    private int min = 0;//minute
    private int sec = 0;//second
    private JLabel label1;//显示时间用
    private JLabel label2;//显示剩余雷数
    private JLabel label3;//显示剩余次数
    private JButton button;//buttonRestart笑脸按钮，用于重新开始
    private String gameState = "run";//游戏运行状态
    private boolean isfirst = true;//判断是否是第一次按下
    private boolean cheatOrNot=false;//判断是否使用过作弊模式，true指使用过
    //难度选择菜单
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem low;//LOW
    private JMenuItem mid;//MID
    private JMenuItem high;//HIGH
    private JMenuItem allOpen;//作弊模式
    //核心模块
    private ArrayList<Bub>list = new ArrayList<Bub>(0);
    public boolean isFirst() {
        return isfirst;
    }
    public boolean judge(int index) {
        if(index>=0&&index<list.size()) {
            if(list.get(index).getreal()==1)return true;
        }
        return false;
    }
    public void initMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("难度设置");
        low = new JMenuItem("初级(10)");
        mid = new JMenuItem("中级(40)");
        high = new JMenuItem("高级(99)");
        allOpen = new JMenuItem("作弊模式");
        low.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Main(10);
            }
        });
        mid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main(40);
            }
        });
        high.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main(99);
            }
        });
        allOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cheatOrNot) {
                    Random r = new Random();
                    int len = list.size();
                    for (int i = 1; i <= mineNum; ++i) {
                        while (true) {
                            int des = r.nextInt(len);
                            int cnt = 0;
                            int index = des;
                            if (judge(index - colNum)) {
                                ++cnt;
                            }
                            if (judge(index + colNum)) {
                                ++cnt;
                            }
                            if (judge(index - 1)) {
                                ++cnt;
                            }
                            if (judge(index + 1)) {
                                ++cnt;
                            }
                            if (judge(index - colNum + 1)) {
                                ++cnt;
                            }
                            if (judge(index + colNum + 1)) {
                                ++cnt;
                            }
                            if (judge(index - colNum - 1)) {
                                ++cnt;
                            }
                            if (judge(index + colNum - 1)) {
                                ++cnt;
                            }
                            if (list.get(des).getreal() != 1 && cnt != 8) {
                                list.get(des).setreal(1);
                                list.get(des).showImg(13);
                                break;
                            } else if (list.get(des).getreal() != 1 && cnt == 8) {
                                list.get(des).setreal(0);
                                list.get(des).showImg(13);
                                break;
                            }
                        }
                    }
                    for (Bub bub : list) {
                        if (bub.getreal() == 1) bub.showImg(9);
                    }
                    cheatOrNot = true;
                }
                else {
                    for (Bub bub : list) {
                        if (bub.getreal() == 1) bub.showImg(9);
                    }
                }
            }
        });
        menu.add(low);
        menu.add(mid);
        menu.add(high);
        menu.add(allOpen);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    class stopwatch extends Thread{
        public void run() {
            while(gameState.equals("run")) {
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
                sec++;
                if(sec==60) {
                    sec=0;
                    min++;
                }
                if(min==0&&sec<10)label1.setText("00:0"+new Integer(sec).toString());
                if(min==0&&sec>=10)label1.setText("00:"+new Integer(sec).toString());
                if(min>0&&sec<10)label1.setText(new Integer(min).toString()+":0"+new Integer(sec).toString());
                if(min>0&&sec>=10)label1.setText(new Integer(min).toString()+":"+new Integer(sec).toString());
            }
        }
    }
    public Main(int num) {
        super("扫雷");
        mineNum = num;
        restNum = mineNum;
        if(mineNum == 10) {
            screenwide = 200;
            screenhigh = 290;
            colNum = 9;
            rowNum = 9;
        }
        if(mineNum == 40) {
            screenwide = 340;
            screenhigh = 430;
            colNum = 16;
            rowNum = 16;
        }

        if(mineNum == 99) {
            screenwide = 620;
            screenhigh = 430;
            colNum = 30;
            rowNum = 16;
        }
        initMenu();
        setSize(screenwide,screenhigh);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton(new ImageIcon("D:\\学习文档\\smile1.jpg"));
        button.setBounds(screenwide/2-20, 5, 20, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main(mineNum);
            }
        });
        add(button);
        label1 = new JLabel("剩余时间");
        label1.setBounds(10,5,60,20);
        add(label1);

        label2 = new JLabel("次数:"+restPressNum);
        label2.setBounds(screenwide-70,5,60,20);
        add(label2);

        label3 = new JLabel("分数:"+score);
        label3.setBounds(screenwide-70,20,60,20);
        add(label3);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(rowNum,colNum,0,0));
        for(int i = 0;i<rowNum*colNum;++i) {
            Bub bub = new Bub();
            bub.showImg(13);
            bub.addMouseListener(this);
            list.add(bub);
            p.add(bub);
        }
        p.setBounds(0,40,colNum*20,rowNum*20);
        add(p);
        this.setVisible(true);
    }

    public static void main(String[]args) {
        new Main(10);
    }
    class Result extends JFrame {
        /**
         *
         */
        private static final long serialVersionUID = 7899366376251467187L;

        public Result(String con) {
            super("游戏结果");
            setSize(250,150);
            setLocationRelativeTo(null);
            JButton button = new JButton("确定");
            setLayout(null);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Main(mineNum);
                }
            });
            JLabel label3 = new JLabel();
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            label3.setFont(new Font("微软雅黑",Font.BOLD,15));
            if(con.equals("win")) label3.setText("用时"+min+"分"+sec+"秒");
            if(con.equals("lose"))label3.setText("继续努力!");
            label3.setBounds(70, 5, 100, 40);
            add(label3);
            button.setBounds(80, 50, 70, 40);
            add(button);
            setVisible(true);
        }
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO 自动生成的方法存根

    }

    public boolean judgeLimit(int index) {
        if(index>=0&&index<list.size()) return true;
        return false;
    }

    public void show(int index) {
        Bub tmp1 = list.get(index);//当前点击位置的在链表中的索引
        int cnt = 0;                //四周雷数的记录值
        boolean edgeU = (index%colNum!= 0);     //判断是否在右边界
        boolean edgeD = ((index+1)%colNum!= 0);   //判断是否在左边界
        if(judge(index-colNum)){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index+colNum)){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index-1)&&edgeU){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index+1)&&edgeD){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index-colNum+1)&&edgeD){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index+colNum+1)&&edgeD){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index-colNum-1)&&edgeU){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(judge(index+colNum-1)&&edgeU){
            ++cnt;
            tmp1.setface(cnt);
        }
        if(cnt==0) {
            tmp1.setface(0);
            tmp1.showImg(0);
            if(!judge(index-colNum)
                    &&judgeLimit(index-colNum)
                    &&!list.get(index-colNum).getOpen())show(index-colNum);//为了避免这里的递归陷入了死循环，要对相邻的按钮进行判断，如果已经处于翻开状态，就不用在进一步操作
            if(!judge(index+colNum)
                    &&judgeLimit(index+colNum)
                    &&!list.get(index+colNum).getOpen())show(index+colNum);
            if(!judge(index-1)&&edgeU
                    &&judgeLimit(index-1)
                    &&!list.get(index-1).getOpen())show(index-1);
            if(!judge(index+1)&&edgeD
                    &&judgeLimit(index+1)
                    &&!list.get(index+1).getOpen())show(index+1);
            if(!judge(index-colNum+1)&&edgeD
                    &&judgeLimit(index-colNum+1)
                    &&!list.get(index-colNum+1).getOpen())show(index-colNum+1);
            if(!judge(index+colNum+1)&&edgeD
                    &&judgeLimit(index+colNum+1)
                    &&!list.get(index+colNum+1).getOpen())show(index+colNum+1);
            if(!judge(index-colNum-1)&&edgeU
                    &&judgeLimit(index-colNum-1)
                    &&!list.get(index-colNum-1).getOpen())show(index-colNum-1);
            if(!judge(index+colNum-1)&&edgeU
                    &&judgeLimit(index+colNum-1)
                    &&!list.get(index+colNum-1).getOpen())show(index+colNum-1);
        }
        else tmp1.showImg(cnt);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        Bub tmp = (Bub)e.getSource();
        int index = list.indexOf(tmp);//put in the location of tmp
        if(!this.gameState.equals("over"))
      {
            if(e.getButton()==MouseEvent.BUTTON1) {
                if(tmp.getface()!=11&&tmp.getface()!=12&&!tmp.getOpen()) {
                    if(isfirst&&!cheatOrNot) {
                        tmp.setreal(1);
                        Random r = new Random();
                        int len = list.size();
                        for(int i = 1;i<=mineNum;++i) {
                            while(true) {
                                int des = r.nextInt(len);
                                int cnt=0;
                                if(judge(index-colNum)){++cnt;}
                                if(judge(index+colNum)){++cnt;}
                                if(judge(index-1)){++cnt;}
                                if(judge(index+1)){++cnt;}
                                if(judge(index-colNum+1)){++cnt;}
                                if(judge(index+colNum+1)){++cnt;}
                                if(judge(index-colNum-1)){++cnt;}
                                if(judge(index+colNum-1)){++cnt;}
                                if(list.get(des).getreal()!=1&&cnt!=8) {
                                    list.get(des).setreal(1);
                                    list.get(des).showImg(13);
                                    break;
                                }
                                else if(list.get(des).getreal()!=1&&cnt==8){
                                    list.get(des).setreal(0);
                                    list.get(des).showImg(13);
                                    break;
                                }
                            }
                        }
                        tmp.setreal(0);
                        isfirst = false;
                        show(index);
                        new stopwatch().start();
                        restPressNum--;
                        cheatOrNot=true;
                    }
                    else if(tmp.getreal()!=1){
                        show(index);
                        restPressNum--;
                    }
                    else if(tmp.getreal()==1) {
                        tmp.setface(9);tmp.showImg(9);
                        score--;
                        restPressNum--;
                        restNum--;
                    }
                }
                if(restPressNum==0){
                    gameState = "over";
                }
            }
            if(e.getButton()==MouseEvent.BUTTON3) {//右键
                if(tmp.getface()==13) {
                    if(tmp.getreal()==1) {

                        tmp.setface(11);
                        tmp.showImg(11);
                        restNum--;
                        restPressNum--;
                        score++;
                    }
                    else if(tmp.getreal()==0){
                            tmp.setface(12);
                            tmp.showImg(12);
                            restNum--;
                            restPressNum--;
                            score--;
                    }
                }
                if(restPressNum==0){
                    gameState = "over";
                }
            }
        }
        if(restNum==0) {
                button.setIcon(new ImageIcon("D:\\学习文档\\smile2.jpg"));
                new Result("win");
        }
        label2.setText("次数:"+restPressNum);
        label3.setText("分数:"+score);
    }
}