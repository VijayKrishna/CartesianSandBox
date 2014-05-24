package self.vpalepu.geometry;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Line {
  private Point a;
  private Point b;
  private String label;
  
  public static Line getInstance(String str) {
    String[] strArr = str.split("\\s");
    String label = strArr[0];
    double x1 = Double.parseDouble(strArr[1]);
    double y1 = Double.parseDouble(strArr[2]);
    double x2 = Double.parseDouble(strArr[3]);
    double y2 = Double.parseDouble(strArr[4]);
    
    return new Line(label, new Point(x1, y1), new Point(x2, y2));
    
  }
  
  public Line(String label, Point a, Point b) {
    this.a = a;
    this.b = b;
    this.label = label;
  }
  
  public Point pointA() {
    return a;
  }
  
  public Point pointB() {
    return b;
  }
  
  private String label() {
    return label;
  }
  
  public double slope() {
    double slope;
    slope = (a.y() - b.y()) / (a.x() - b.x());
    return slope;
  }
  
  public double intercept() {
    return a.y() - (a.x() * slope());
  }
  
  /**
   * ref: http://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Intersection_of_two_lines_in_the_plane
   * @param l
   * @return
   */
  public Point intersectWith(Line l) {
    double x, y;
    x = (l.intercept() - this.intercept())/(this.slope() - l.slope());
    y = (this.slope() * x) + this.intercept();
    return new Point(x, y);
  }
  
  public boolean isParallelTo(Line l) {
    return this.slope() == l.slope();
  }
  
  public boolean isPerpendicularTo(Line l) {
    return l.slope()*this.slope() == -1 ? true : false;
  }
  
  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(label).append(a.toString()).append(" -> ").append(b.toString());
    return buffer.toString();
  }
  
  public static class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
    
    public double x() {
      return x;
    }
    
    public double y() {
      return y;
    }
    
    public double distanceFrom(Point a) {
      double distance = 0.0;
      double xDiff = Math.pow(this.x - a.x, 2);
      double yDiff = Math.pow(this.y - a.y, 2);
      distance = Math.sqrt(xDiff + yDiff);
      return distance;
    }
    
    public boolean isOnLine(Line l) {
      return this.y() == (this.x() * l.slope() + l.intercept());
    }
    
    public boolean isOnLineSegment(Point start, Point end) {
      Line l = new Line("temp", start, end);
      if(!this.isOnLine(l)) {
        return false;
      }
      
      double min, max;
      if(start.x() > end.x()) {
        min = end.x();
        max = start.x();
      } else {
        min = start.x();
        max = end.x();
      }
      
      if(this.x() > max || this.x() < min)
        return false;
      
      if(start.y() > end.y()) {
        min = end.y();
        max = start.y();
      } else {
        min = start.y();
        max = end.y();
      }
      
      if(this.y() > max || this.y() < min)
        return false;
      
      return true;
    }
    
    @Override
    public String toString() {
      StringBuffer buffer = new StringBuffer();
      buffer.append("(").append(x).append(",").append(y).append(")");
      return buffer.toString();
    }
  }
  
  public static void main(String[] args) {
    
    
    String[] inputs = {
        "A -2.5 .5 3.5 .5",
        "B -2.23 99.99 -2.10 -56.23",
        "C -1.23 99.99 -1.10 -56.23",
        "D 100.1 1000.34 2000.23 2100.23",
        "E 1.5 -1 1.5 1.0",
        "F 2.0 2.0 3.0 2.0",
        "G 2.5 .5 2.5 2.0"  
    };
    
    ArrayList<Line> lines = new ArrayList<>();
    for(String in : inputs) {
      Line line = Line.getInstance(in);
      System.out.println("reading in " + line.toString());
      lines.add(line);
    }
    
    draw(lines);
    
    for(int i = 0; i < lines.size(); i += 1) {
      for(int j = i + 1; j < lines.size(); j += 1) {
        if(j == i) continue;
        doTheyIntersect(lines.get(i), lines.get(j));
      }
    }
  }
  
  private static void draw(final ArrayList<Line> lines) {
    Runnable r = new Runnable() {
      public void run() {
        LineComponent lineComponent = new LineComponent(100,100);
        for (Line line : lines) {
          lineComponent.addLine(line);
        }
        JOptionPane.showMessageDialog(null, lineComponent);
      }
    };
    SwingUtilities.invokeLater(r);
  }

    private static void doTheyIntersect(Line l1, Line l2) {
      if(l1.isParallelTo(l2)) {
        System.out.println(l1.label() + " & " + l2.label() + " don't intersect");
        return;
      }        

      Point p1234 = l1.intersectWith(l2);
      
      if(p1234.isOnLineSegment(l1.pointA(), l1.pointB()) 
          && p1234.isOnLineSegment(l2.pointA(), l2.pointB())) {
        System.out.print(p1234 + " ");
        System.out.println(l1.label() + " & " + l2.label() + " intersect");
      } else {
        System.out.print(p1234 + " ");
        System.out.println(l1.label() + " & " + l2.label() + " don't intersect");
      }
    }
}
