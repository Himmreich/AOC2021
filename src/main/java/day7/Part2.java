package day7;

import util.InputHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) {
        try {
            List<String> values = Arrays.asList(InputHelper.readValues(6).get(0).split(","));
            List<Integer> valuesSorted = values.stream().map(v -> Integer.valueOf(v)).sorted().collect(Collectors.toList());

            int minTotalFuel = -1;
            for (int pos = valuesSorted.get(0); pos <= valuesSorted.get(values.size() -1 ); pos++) {
                int currentTotalFuel = 0;
                for (Integer val : valuesSorted) {
                    if (pos > val) {
                        int counter = 0;
                        for (int i = pos; i > val; i--) {
                            counter++;
                            currentTotalFuel+=counter;
                        }
                    } else if (pos < val) {
                        int counter = 0;
                        for (int i = val; i > pos; i--) {
                            counter++;
                            currentTotalFuel+=counter;
                        }
                    }
                }
                if (minTotalFuel == -1 || currentTotalFuel < minTotalFuel) {
                    minTotalFuel = currentTotalFuel;
                }
            }

            System.out.println("The second response is : " + minTotalFuel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
