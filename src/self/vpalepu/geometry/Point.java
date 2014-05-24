package self.vpalepu.geometry;

public class Point {
  private final double x;
  private final double y;
  
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