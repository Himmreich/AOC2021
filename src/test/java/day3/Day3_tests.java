package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

    private List<String> reduce(List<String> values, int index, int param, boolean revert) {
        List<String> result = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).charAt(index) == '0') {
                list0.add(values.get(i));
            } else list1.add(values.get(i));
        }
        if (list0.size() > list1.size()) {
            if (revert) result = list1;
            else result = list0;
        }
        if (list1.size() > list0.size()) {
            if (revert) result = list0;
            else result = list1;
        }
        if (list0.size() == list1.size()) {
            if (param == 0) result = list0;
            else result = list1;
        }
        return result;
    }

    @Test
    public void part2_test() {
        //In first loop over the 12 values for the first bit
        int max = values.get(0).length();
        List<String> oxygenValues = new ArrayList<>();
        oxygenValues.addAll(values);
        int param = 1;

        do {
            for (int index = 0; index < max; index++) {
                oxygenValues = reduce(oxygenValues, index, param, false);
                if (oxygenValues.size() == 1) break;
            }
        } while (oxygenValues.size() > 1);

        int oxygenRate = Integer.parseInt(oxygenValues.get(0), 2);
        Assert.assertEquals(23, oxygenRate);

        List<String> co2Values = new ArrayList<>();
        co2Values.addAll(values);
        param = 0;

        do {
            for (int index = 0; index < max; index++) {
                co2Values = reduce(co2Values, index, param, true);
                if (co2Values.size() == 1) break;
            }
        } while (co2Values.size() > 1);

        int co2Rate = Integer.parseInt(co2Values.get(0), 2);
        Assert.assertEquals(10, co2Rate);

        Assert.assertEquals(230, co2Rate * oxygenRate);
    }
}
