package day1;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(1);
            int lastMaxSum = Integer.valueOf(values.get(0)) + Integer.valueOf(values.get(1)) + Integer.valueOf(values.get(2));
            int increaseValuesCounter = 0;
            for (int i = 0; i < values.size(); i++) {
                int currentVal = Integer.valueOf(values.get(i));
                if ((i +1) < values.size())
                    currentVal += Integer.valueOf(values.get(i + 1));
                if ((i +2) < values.size())
                    currentVal += Integer.valueOf(values.get(i + 2));

                if (currentVal > lastMaxSum)
                    increaseValuesCounter++;
                lastMaxSum = currentVal;
            }
            System.out.println("The second response is : " + increaseValuesCounter);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
