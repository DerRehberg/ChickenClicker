import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<BufferedImage> Textures = new ArrayList<>();
    static JFrame frame;static BufferStrategy bs;static Graphics2D g;

    public static void main(String[] args) {
        frame = new JFrame("ChickenClicker");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addMouseListener(new Mouse());
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                init();
            }
        });
        loadTextures(16);
        init();
        while(true)
        {
            try{Thread.sleep(5);}catch(Exception e){}
            render();
        }

    }

    static void init()
    {
        ClickChicken.init();
    }
    static void loadTextures(int bit)
    {
        File dir = new File("Textures/"+bit);
        File[] files = dir.listFiles();
        if(files != null) {
            Arrays.sort(files);

            for (File file : files) {
                try {
                    BufferedImage one = ImageIO.read(file);
                    for (int i = 0; i < one.getWidth() / bit; i++) {
                        Textures.add(ImageIO.read(file).getSubimage(i*bit, 0, bit, one.getHeight()));
                    }
                } catch (IOException e) {
                    System.out.print(e);
                }
            }
        }
    }

    static void render()
    {
        if (bs == null) {
            frame.createBufferStrategy(3);
            bs = frame.getBufferStrategy();
            frame.requestFocus();
            return;
        }
        g = (Graphics2D) bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,frame.getWidth(),frame.getHeight());
        ClickChicken.render();


        g.dispose();
        bs.show();
    }
}