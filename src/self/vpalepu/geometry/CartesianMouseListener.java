package self.vpalepu.geometry;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartesianMouseListener implements MouseListener  {

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println(new Point(e.getX(), e.getY()));
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println(new Point(e.getX(), e.getY()));
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println(new Point(e.getX(), e.getY()));
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println(new Point(e.getX(), e.getY()));
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println(new Point(e.getX(), e.getY()));
  }

}
