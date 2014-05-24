package self.vpalepu.geometry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class LineComponent extends JComponent {

    /**
   * 
   */
  private static final long serialVersionUID = 1L;
    ArrayList<Line2D.Double> lines;

    LineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        lines = new ArrayList<Line2D.Double>();
    }

    public void addLine(Line l) {
        Line2D.Double line = new Line2D.Double(l.pointA().x(),
            l.pointA().y(),
            l.pointB().x(),
            l.pointB().y());
        lines.add(line);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                (int)line.getX1() + 100,
                (int)line.getY1() + 100,
                (int)line.getX2() + 100,
                (int)line.getY2() + 100
                );
            
        }
    }
}
