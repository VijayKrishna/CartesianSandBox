package self.vpalepu.geometry.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import self.vpalepu.geometry.Line;
import self.vpalepu.geometry.Point;

public class LineUnitTest {

  @Test
  public void xAxisShouldHave0Slope() {
    //given
    Line line = Line.getInstance("A 0 0 1 0");
    
    //when
    double slope = line.slope();
    
    //then
    assertEquals(0.0, slope, 0.0);
  }
  
  @Test
  public void yAxisShouldHaveInfinityAsSlope() {
    //given
    Line line = Line.getInstance("A 0 1 0 0");
    
    //when
    double slope = line.slope();
    
    //then
    assertEquals(Double.POSITIVE_INFINITY, slope, 0.0);
  }
  
  @Test
  public void xEquals1ShouldHaveInfinityAsSlope() {
    //given
    Point p1 = new Point(1, 0);
    Point p2 = new Point(1, 100);
    Line line = Line.getInstance("A 0 1 0 0");
    
    //when
    double slope = line.slope();
    
    //then
    assertEquals(Double.POSITIVE_INFINITY, slope, 0.0);
  }

}
