import java.util.Scanner;

public class LineCalculator {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        int pointCount = 2;  
        int option = 0;        

        while(true){
        
        double[] xPoints = getXPoints(pointCount);
        double[] yPoints = getYPoints(pointCount);
        
        showOptions();
        option = scanner.nextInt();

        switch(option){

            case 1:
            double slope = findSlope(xPoints, yPoints);
            System.out.println("Slope is " + slope);
            break;

            case 2:
            double yInt = findYInt(xPoints, yPoints);
            System.out.println("Y-Intercept is " + yInt);
            break;

            case 3:
            String slopeEquation = findEquation(xPoints, yPoints);
            System.out.println(slopeEquation);
        }
    }
    }


    public static double[] getXPoints(int pointCount){
        Scanner scanner = new Scanner(System.in);

        double[] Points = new double[pointCount];

        for(int i = 0; i < pointCount; i++){
            System.out.print("Enter point X" + (i+1) + " :");
            Points[i] = scanner.nextDouble();
        }
        return Points;
    }
    
    public static double[] getYPoints(int pointCount){
        Scanner scanner = new Scanner(System.in);

        double[] Points = new double[pointCount];

        for(int i = 0; i < pointCount; i++){
            System.out.print("Enter point Y" + (i+1) + " :");
            Points[i] = scanner.nextDouble();
        }
        return Points;
    }

    public static void showOptions(){
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Find the slope.");
        System.out.println("2. Find the y-intercept. ");
        System.out.println("3. Find the equation in slope form. ");

    }

    public static double findSlope(double[] xPoints, double[] yPoints){

      double yDiff = yPoints[1] - yPoints[0];
        double xDiff = xPoints[1] - xPoints[0];

        if (xDiff == 0) {
            return Double.NaN;
        }

        double slope = yDiff / xDiff;
        return Math.round(slope * 10) / 10.0;
    }

    public static double findYInt(double[] xPoints, double[] yPoints){

        double slope = findSlope(xPoints, yPoints);
        double yInt = yPoints[0] - slope * xPoints[0];
        return yInt;
    }

    public static String findEquation(double[] xPoints, double[] yPoints){

        double slope = findSlope(xPoints, yPoints);
        double yInt = findYInt(xPoints, yPoints);

        if (Double.isNaN(slope)) {
            return "Cannot determine equation: Division by zero";
        } else if (slope == 0) {
            return "f(x) = " + yInt;
        } else if (yInt == 0) {
            return "f(x) = " + slope + "x";
        } else if (yInt < 0 ){

            return "f(x) = " + slope + " - " + Math.abs(yInt);
        }
         else{
            return "f(x) = " + slope + "x + " + yInt;
        }
    }
}
