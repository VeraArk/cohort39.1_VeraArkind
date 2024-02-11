package ShapeTask;
/*
в этом классе реализована фунция нахождения суммы объектов типа Shape_task.Shape
 */
class FindCommonArea {
    static double findArea (ShapeProcessing[] areaOfFigure){
        double sum=0;
        for (int i = 0; i < areaOfFigure.length; i++) {
            sum+= Double.parseDouble((areaOfFigure[i]).toString().trim());
        }
        return sum;
    }
}
