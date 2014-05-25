package self.vpalepu.geometry.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
    Line line = new Line("A", p1, p2);
    
    //when
    double slope = line.slope();
    
    //then
    assertThat(slope, either(is(Double.POSITIVE_INFINITY))
                      .or(is(Double.NEGATIVE_INFINITY)));
  }
  
  @Test
  public void yEquals1ShouldHave0AsIntercept() {
  //given
    Point p1 = new Point(0, 1);
    Point p2 = new Point(110, 1);
    Line line = new Line("A", p1, p2);
    
    //when
    double slope = line.slope();
    
    //then
    assertThat(slope, either(is(0.0)).or(is(-0.0)));
  }
  
  @Test
  public void xEquals1ShouldHaveNaNAsIntercept() {
    //given
    Point p1 = new Point(1, 0);
    Point p2 = new Point(1, 100);
    Line line = new Line("A", p1, p2);
    
    //when
    double slope = line.intercept();
    
    //then
    assertThat(slope, either(is(Double.POSITIVE_INFINITY))
                      .or(is(Double.NEGATIVE_INFINITY)));
  }
  
  @Test
  public void yEquals1ShouldHave0AsSlope() {
  //given
    Point p1 = new Point(0, 1);
    Point p2 = new Point(110, 1);
    Line line = new Line("A", p1, p2);
    
    //when
    double slope = line.slope();
    
    //then
    assertThat(slope, either(is(0.0)).or(is(-0.0)));
  }
  
  

}
