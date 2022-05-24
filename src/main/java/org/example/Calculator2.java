package org.example;


import java.util.stream.IntStream;

public class Calculator {
    public static void main( String[] args )
    {
        Operation sum = (x,y) -> x+y;

        Operation substract = (x,y) -> x-y;

        Operation multiplication = (x,y) ->{
            int z = 0;
            if(x>0 && y>0){
                for (int i = x; i>0; i--){
                    z=sum.operation(z,y);
                }
                return z;
            } else if (x<0 && y<0) {
                for (int i = -x; i>0; i--){
                    z=sum.operation(z,-y);
                }
                return z;
            } else if (x<0 && y>0) {
                for (int i = -x; i>0; i--){
                    z=sum.operation(z,y);
                }
                return -z;
            }else if (x>0 && y<0) {
                for (int i = x; i>0; i--){
                    z=sum.operation(z,-y);
                }
                return -z;
            }
            return z;
        };

        Operation division = (x,y)->{
            int z=0;
            if(x>0 && y>0){
                while (x>=y){
                    x=substract.operation(x,y);
                    z++;
                }
                return z;
            } else if (x<0 && y<0) {
                x=-x;
                y=-y;
                while (x>=y){
                    x=substract.operation(x,y);
                    z++;
                }
                return z;
            } else if (x<0 && y>0) {
                x=-x;
                while (x>=y){
                    x=substract.operation(x,y);
                    z++;
                }
                return -z;
            }else if (x>0 && y<0) {
                y=-y;
                while (x>=y){
                    x=substract.operation(x,y);
                    z++;
                }
                return -z;
            } else if (y==0) {
                throw new ArithmeticException("You cannot divide by 0");
            }

            return z;
        };


        System.out.println("Addition: " +sum.operation(4,5));
        System.out.println("Substract: " +substract.operation(4,5));
        System.out.println("Multiplication:" +multiplication.operation(5,3));
        System.out.println("Multiplication:" +multiplication.operation(-5,-3));
        System.out.println("Multiplication:" +multiplication.operation(5,-3));
        System.out.println("Multiplication:" +multiplication.operation(-5,3));
        System.out.println("Multiplication:" +multiplication.operation(-5,0));
        System.out.println("Multiplication:" +multiplication.operation(0,5));
        System.out.println("Division: " +division.operation(20,5));
        System.out.println("Division: " +division.operation(-20,-5));
        System.out.println("Division: " +division.operation(-20,5));
        System.out.println("Division: " +division.operation(20,-5));
        System.out.println("Division: " +division.operation(0,5));
        System.out.println("Division: " +division.operation(20,0));

    }

}

