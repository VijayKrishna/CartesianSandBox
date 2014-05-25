package self.vpalepu.geometry;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartesianMouseListener implements MouseListener  {

  Point previousPoint;
  LineComponent l;
  
  public CartesianMouseListener(LineComponent l) {
    this.l = l;
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
    
  }
  
  @Override
  public void mousePressed(MouseEvent e) {

  }
  
  @Override
  public void mouseExited(MouseEvent e) {

  }
  
  @Override
  public void mouseEntered(MouseEvent e) {

  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    Point point = new Point(e.getX(), e.getY());
    if(previousPoint != null) {
      Line line = new Line("a", previousPoint, point);
      l.addLine(line);
      l.repaint();
    }
    previousPoint = new Point(e.getX(), e.getY());
    System.out.println(new Point(e.getX(), e.getY()));
  }

}
