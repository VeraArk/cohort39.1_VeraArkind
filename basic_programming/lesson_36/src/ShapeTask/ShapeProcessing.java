package ShapeTask;
/*
в этом классе инициализируются объекты и вызываюься методы.
 */

class ShapeProcessing{
    double areaOfFigure = 0;
    public ShapeProcessing(double areaOfFigure) {
        this.areaOfFigure = areaOfFigure;
    }


    public static void main(String[] args) {

         double[] rectangleSites = {3, 6};
         double[] circleSites = {3.6};
         double rectangleArea = Rectangle.area(rectangleSites);
         double circleArea = Circle.area(circleSites);

         ShapeProcessing rectangle = new ShapeProcessing(rectangleArea);
         ShapeProcessing circle = new ShapeProcessing(circleArea);
         ShapeProcessing[] commonArea = {rectangle, circle};
         double findCommonArea = FindCommonArea.findArea(commonArea);

        System.out.println(findCommonArea);
    }
}

