import java.awt.*;

public class ClickChicken {

    static Rectangle rect;
    static int scale;
    static long count = 0;
    static boolean clicked = false;

    static void init()
    {
        scale = Main.frame.getHeight()/2;
        rect = new Rectangle(Main.frame.getWidth()/2-scale/2,Main.frame.getHeight()/2-scale/2,scale,scale);
    }


    static void render()
    {
        if(!clicked) {
            Main.g.drawImage(Main.Textures.get(0), rect.x, rect.y, scale, scale, null);
        }else
        {
            Main.g.drawImage(Main.Textures.get(1), rect.x, rect.y, scale, scale, null);
        }
        Main.g.setColor(Color.BLACK);
        Main.g.drawString(String.valueOf(count),Main.frame.getWidth()/2,Main.frame.getHeight()/5);
    }

}
