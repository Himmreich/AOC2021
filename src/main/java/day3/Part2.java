package day3;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(3);
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

            System.out.println("The second response is : " + co2Rate * oxygenRate);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> reduce(List<String> values, int index, int param, boolean revert) {
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
}
