package org.example;


import java.util.stream.IntStream;

public class Calculator {
    public static void main( String[] args )
    {
        Operation sum = (x,y) -> x+y;

        Operation substract = (x,y) -> x-y;

        System.out.println("Addition: " +sum.operation(4,5));
        System.out.println("Substract: " +substract.operation(4,5));

        Operation multiplication = (x,y) ->{
            int z = 0;
            if(x>0 && y>0){
                for (int i = x; i>0; i--){
                    z=sum.operation(z,y);
                }
            }
            return z;
        };



        System.out.println("Multiplication:" +multiplication.operation(5,3));
        System.out.println("Multiplication:" +multiplication.operation(-3,3));

    }

}

