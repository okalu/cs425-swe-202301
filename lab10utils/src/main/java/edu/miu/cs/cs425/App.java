package edu.miu.cs.cs425;

import edu.miu.cs.cs425.utils.DataTypeCheckerConverter;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        var s1 = "Anna";
        var s2 = "3.50";
        var s3 = "3.50bob";
        var s4 = "1";
        DataTypeCheckerConverter.convertStringToDouble(s1)
            .ifPresentOrElse(
                d -> { System.out.printf("String, %s is a valid double, %.2f\n", s1, d); }, 
                () -> { System.out.printf("String, %s is NOT a valid double\n", s1); }
            );
        DataTypeCheckerConverter.convertStringToDouble(s2)
            .ifPresentOrElse(
                d -> { System.out.printf("String, %s is a valid double, %.2f\n", s2, d); }, 
                () -> { System.out.printf("String, %s is NOT a valid double\n", s2); }
        );
        DataTypeCheckerConverter.convertStringToDouble(s3)
            .ifPresentOrElse(
                d -> { System.out.printf("String, %s is a valid double, %.2f\n", s3, d); }, 
                () -> { System.out.printf("String, %s is NOT a valid double\n", s3); }
        );
        DataTypeCheckerConverter.convertStringToDouble(s4)
            .ifPresentOrElse(
                d -> { System.out.printf("String, %s is a valid double, %.2f\n", s4, d); }, 
                () -> { System.out.printf("String, %s is NOT a valid double\n", s4); }
        );
    }
}
