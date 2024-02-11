package ShapeTask;
/*
в этом классе реализован метод вычисления площади круга
 */

class Circle implements Shape{
    @Override
    public double area(double[] sites) {
        return Math.PI*Math.pow(sites[0],2);
    }
}
