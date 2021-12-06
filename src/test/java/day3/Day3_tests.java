package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Day3_tests {

    List<String> values = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");

    @Test
    public void part1_test() {
        int counter0 = 0;
        int counter1 = 0;

        String gamma = "";
        String epsilon = "";

        for (int i = 0; i < values.get(0).length(); i++) {
            counter0 = 0;
            counter1 = 0;
            for (int j = 0; j < values.size(); j++) {
                if (values.get(j).charAt(i) == '0')
                    counter0++;
                else counter1++;
            }
            if (counter0 > counter1) {
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            } else {
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            }
        }
        Assert.assertEquals(gamma, "10110");
        Assert.assertEquals(epsilon, "01001");

        Assert.assertEquals(198, Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }
}
