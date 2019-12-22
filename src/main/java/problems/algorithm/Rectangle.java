package problems.algorithm;

import org.junit.Test;

/**
 * 给定4个点代表的矩形，再给定一个点(x,y)，判断(x,y)是否在矩形中
 * @author prd-fuy
 * @version $Id: Rectangle.java, v 0.1 2019年9月25日 上午9:13:41 prd-fuy Exp $
 */
public class Rectangle {
    
    private double[] x1 = { 1, 1 };
    private double[] x2 = { 2, 0 };
    private double[] x3 = { 2, 2 };
    private double[] x4 = { 3, 1 };
    
    public void rectangle(double[] point) {
        double x = point[0];
        double y = point[1];
        double centerX = (x4[0] + x1[0]) / 2;
        double centerY = (x3[1] + x2[1]) / 2;
        double point2center = Math.hypot(centerX - x, centerY - y);
        double diagonal = Math.hypot(centerX - x1[0], centerY - x1[1]);
        double sideLen = Math.hypot(x2[0] - x1[0], x2[1] - x1[1]);
        if (point2center > diagonal)
            System.out.println(" The point is outside");
        else if (point2center < sideLen / 2)
            System.out.println(" The point is inside");
        else {
            double point2x1 = Math.hypot(x1[0] - x, x1[1] - y);
            double point2x2 = Math.hypot(x2[0] - x, x2[1] - y);
            double point2x3 = Math.hypot(x3[0] - x, x3[1] - y);
            double point2x4 = Math.hypot(x4[0] - x, x4[1] - y);
            double nearestPoint[] = x1;
            double distance = point2x1;
            if (point2x2 < distance) {
                nearestPoint = x2;
                distance = point2x2;
            }
            if (point2x3 < distance) {
                nearestPoint = x3;
                distance = point2x3;
            }
            if (point2x4 < distance) {
                nearestPoint = x4;
                distance = point2x4;
            }
            double degree = (Math.acos((Math.pow(point2center, 2) + Math.pow(diagonal, 2) - Math.pow(distance, 2)) / 2 * point2center * diagonal)) / Math.PI * 180;
            System.out.println(" degree = " + degree);
            if (degree > 45)
                System.out.println(" The point is outside");
            else
                System.out.println(" The point is inside");
            System.out.println(" nearest point = " + nearestPoint[0] + "," + nearestPoint[1]);
        }
        System.out.println(" half of sideLen = " + sideLen / 2);
        System.out.println(" half of diagonal = " + diagonal);
        System.out.println(" point2center = " + point2center);
    }
    
    @Test
    public void test1() {
        rectangle(new double[] { 1.1, 1 });
    }
}
