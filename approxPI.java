package edu.gcccd.java;
import java.util.*;
class approxPI
{
    public static void main (String[] args)
    {

        System.out.println ("My approximation of PI is " + Square( 1000000));
    }
    public static boolean inCircle(double x, double y)
    {
        double r = 1.0;
        return ((x * x) + (y * y) <= (r * r));
    }
    public static double Square (final long drops)
    {
        Random random = new Random (System.currentTimeMillis());
        int c = 0;
        int s = 0;
        double PI = 0;
        for (int i = 1; i <= drops; i++){
            double x = (random.nextDouble());
            double y = (random.nextDouble());
            s++;
            if (inCircle(x, y)){
                c++;
            }
        }
        PI = ((4.0 *c)/s);
        return PI;
    }

}