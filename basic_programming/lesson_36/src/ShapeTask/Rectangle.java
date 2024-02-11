package ShapeTask;
/*
в этом классе реалізован метод вычисления площади прямоугольника
 */
class Rectangle implements Shape  {
    @Override
    public double area(double[] sites) {
        return sites[0] * sites[1];
    }
}
