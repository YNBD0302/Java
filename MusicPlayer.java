import javax.sound.sampled.*;
import java.io.*;

public class MusicPlayer extends Thread {

    private static double volume = 2;

    private static AudioInputStream bgm;

    //TODO 换电脑后记得修改文件地址

    private static int time = 0; // 音乐播放时间

    private static boolean play = false;

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        MusicPlayer.play = play;
    }

    public int getT() {
        return time;
    }

    public void setTime(int time) {
        MusicPlayer.time = time;
    }

    public MusicPlayer(String filePath) {
        try {
            bgm = AudioSystem.getAudioInputStream(new File(filePath));
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }  // 获得音频输入流
        AudioInputStream ais;
        AudioFormat baseFormat;
        DataLine.Info info;
        ais = bgm;
        baseFormat = ais.getFormat(); // 指定声音流中特定数据安排
        info = new DataLine.Info(SourceDataLine.class, baseFormat);
        SourceDataLine line = null;  //该数据线处理字节的缓冲并将其传递到混频器
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(baseFormat);
            // 打开具有指定格式的行，这样可使行获得所有所需的系统资源并变得可操作。
            line.start();// 允许数据行执行数据 I/O

            int BUFFER_SIZE = 4000 * 4;
            int intBytes = 0;
            byte[] audioData = new byte[BUFFER_SIZE]; // 音频数据数组
            while (intBytes != -1 && (!play)) {
                intBytes = ais.read(audioData, 0, BUFFER_SIZE);
                // 从音频流读取指定的最大数量的数据字节，并将其放入给定的字节数组中。
                if (intBytes >= 0) {
                    line.write(audioData, 0, intBytes);// 通过此源数据行将音频数据写入混频器。
                    time += 1;
                }
                System.out.println(time);
            }
        } catch (LineUnavailableException | IOException e1) {
            e1.printStackTrace();
        }
    }



}
