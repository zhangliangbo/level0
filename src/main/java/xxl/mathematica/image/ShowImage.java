package xxl.mathematica.image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;

/**
 * 电脑显示图片
 */
public class ShowImage extends JFrame {
    /**
     * 显示图片
     *
     * @param filePath
     */
    public static void showImage(String filePath) {
        CountDownLatch latch = new CountDownLatch(1);
        ShowImage window = new ShowImage();
        JLabel imageLabel = new JLabel();
        Container panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(imageLabel);
        //读取图像
        File f = new File(filePath);
        Path file = f.toPath();
        try {
            ImageIcon imageIcon = new ImageIcon(file.toUri().toURL());
            window.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
            imageLabel.setIcon(imageIcon);
        } catch (MalformedURLException e) {
            return;
        }
        //打开窗口
        window.setTitle(f.getAbsolutePath());
        window.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                latch.countDown();
            }
        });
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(panel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}
