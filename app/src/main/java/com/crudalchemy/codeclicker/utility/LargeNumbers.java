package com.crudalchemy.codeclicker.utility;

import java.text.DecimalFormat;
import java.math.RoundingMode;


public class LargeNumbers {
    private static final String[] stringReferences = {"line", "lines", "million", "billion", "trillion", "quadrillion", "ERRRRR"};

    public static String convert(double value) {
        int multipliers = 0; // set to -2 because dictionaryNumbers will be used only with millions and higher
        if (value < 0.0001)
            return "0 " + stringReferences[1];
        if (value > 0.999 && value < 1.999)
            return "1 " + stringReferences[0];
        if (value < 999999.99) {
            String output = Integer.toString((int)value);
            if (value > 999.99)
                output = output.substring(0, output.length() - 3) + "," + output.substring(output.length() - 3);
            return output + " " + stringReferences[1];
        }
        while (value > 999.99) {
            multipliers++;
            value /= 1000;
        }
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.DOWN); // Java defaults to rounding .5 up e.g. .3456 would become .346
        return df.format(value) + " " + stringReferences[multipliers] + " " + stringReferences[1];
    }

    public static String convertWithDecimals(double value) {
        int multipliers = 0; // set to -2 because dictionaryNumbers will be used only with millions and higher
        DecimalFormat df = new DecimalFormat("#.000");
        DecimalFormat df2 = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.DOWN); // Java defaults to rounding .5 up e.g. .3456 would become .346
        df2.setRoundingMode(RoundingMode.DOWN);
        if (value < 0.0001)
            return df2.format(value) + " " + stringReferences[1];
        if (value > 0.999 && value < 1.999)
            return df2.format(value) + " " + stringReferences[0];
        if (value < 999999.99) {
            String output = df2.format(value);
            if (value > 999.99)
                output = output.substring(0, output.length() - 6) + "," + output.substring(output.length() - 6);
            return output + " " + stringReferences[1];
        }
        while (value > 999.99) {
            multipliers++;
            value /= 1000;
        }
        return df.format(value) + " " + stringReferences[multipliers] + " " + stringReferences[1];
    }
}
