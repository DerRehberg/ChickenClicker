import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

public class Mouse extends MouseAdapter {

    private int x,y;

    public void mousePressed(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        if(ClickChicken.rect.contains(x,y))
        {
            ClickChicken.clicked = true;
            ClickChicken.count++;
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        if(ClickChicken.clicked) {
            ClickChicken.clicked = false;
        }
    }

}
