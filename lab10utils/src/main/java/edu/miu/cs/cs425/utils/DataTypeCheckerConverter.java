package edu.miu.cs.cs425.utils;

import java.util.Optional;
import java.util.regex.Pattern;

public class DataTypeCheckerConverter {
    
    /**
     * Checks if the given String value, s, is a valid Double
     * using Regular expression.
     * Based on regex specified in JavaSE API documentation 
     * at file:///C:/javaplatform/se/17/docs/api/java.base/java/lang/Double.html#valueOf(java.lang.String)
     * @param s
     * @return true is s is valid double, otherwise false
     */
    public static boolean checkIfDouble(String s) {
        final String Digits     = "(\\p{Digit}+)";
        final String HexDigits  = "(\\p{XDigit}+)";
        // an exponent is 'e' or 'E' followed by an optionally
        // signed decimal integer.
        final String Exp        = "[eE][+-]?"+Digits;
        final String fpRegex    =
                ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
                "[+-]?(" + // Optional sign character
                "NaN|" +           // "NaN" string
                "Infinity|" +      // "Infinity" string

                // A decimal floating-point string representing a finite positive
                // number without a leading sign has at most five basic pieces:
                // Digits . Digits ExponentPart FloatTypeSuffix
                //
                // Since this method allows integer-only strings as input
                // in addition to strings of floating-point literals, the
                // two sub-patterns below are simplifications of the grammar
                // productions from section 3.10.2 of
                // The Java Language Specification.

                // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
                "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

                // . Digits ExponentPart_opt FloatTypeSuffix_opt
                "(\\.("+Digits+")("+Exp+")?)|"+

                // Hexadecimal strings
                "((" +
                    // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
                    "(0[xX]" + HexDigits + "(\\.)?)|" +

                    // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
                    "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

                    ")[pP][+-]?" + Digits + "))" +
                "[fFdD]?))" +
                "[\\x00-\\x20]*");// Optional trailing "whitespace"

        return Pattern.matches(fpRegex, s);
    }

    public static Optional<Double> convertStringToDouble(String s) {
        if(checkIfDouble(s)) {
            return Optional.of(Double.valueOf(s));
        } else {
            return Optional.empty();
        }
    }

}
