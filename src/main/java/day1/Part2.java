package day1;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(1);
            List<Integer> newValues = new ArrayList<>();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            int f = 0;
            int g = 0;
            int h = 0;
            int listCounter = 0;
            for (int i = 0; i < values.size(); i++) {
                int value = Integer.valueOf(values.get(i)).intValue();
                if (listCounter == 9)
                    listCounter = 0;
                listCounter++;
                if (listCounter == 0)
                    a += value;
                else if (listCounter == 1) {
                    a += value;
                    b += value;
                } else if (listCounter == 2) {
                    c += value;
                } else if (listCounter == 3) {
                    d += value;
                } else if (listCounter == 4) {
                    e += value;
                } else if (listCounter == 5) {
                    f += value;
                } else if (listCounter == 6) {
                    g += value;
                } else if (listCounter == 7) {
                    h += value;
                } else if (listCounter == 8) {

                } else if (listCounter == 9) {

                }
            }
            int lastMaxVal = Integer.valueOf(newValues.get(0));
            int increaseValuesCounter = 0;
            for (int i = 1; i < newValues.size(); i++) {
                int value = Integer.valueOf(values.get(i)).intValue();

            }
            System.out.println("The second response is : " + increaseValuesCounter);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
