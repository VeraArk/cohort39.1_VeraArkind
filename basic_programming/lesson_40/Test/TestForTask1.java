import Task1.Circle;
import Task1.Main;
import Task1.Polygon;
import Task1.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForTask1 {
    @Test
    public void testPerimetrOfCircle() {
        double radius = 2.5;
        double expectedPerimeter = 2 * radius * Math.PI;
        Assertions.assertEquals(expectedPerimeter, new Circle(radius).getPerimeter());
    }

    @Test
    public void testPerimetrOfRectangle() {
        double siteOne = 2.5;
        double siteTwo = 3;
        double expectedPerimeter = 2 * (siteOne + siteTwo);
        Assertions.assertEquals(expectedPerimeter, new Rectangle(siteOne, siteTwo).getPerimeter());
    }

    @Test
    public void testPerimeterOfPolygon() {
        double site = 2.5;
        int amountOgSites = 6;
        double expectedPerimeter = site * amountOgSites;
        Assertions.assertEquals(expectedPerimeter, new Polygon(site, amountOgSites).getPerimeter());
    }

    @Test
    public void testcalculatePrise() {
        double perimeter = 60;
        double prisePerMetr = 2;
        double expectedPrise = perimeter * prisePerMetr;
        Assertions.assertEquals(expectedPrise, Main.calculatePrise(perimeter, prisePerMetr));
    }
}
