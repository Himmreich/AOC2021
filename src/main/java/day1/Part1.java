package day1;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(1);
            int lastMaxVal = Integer.valueOf(values.get(0));
            int increaseValuesCounter = 0;
            for (int i = 1; i < values.size(); i++) {
                if (Integer.valueOf(values.get(i)) > lastMaxVal)
                    increaseValuesCounter++;
                lastMaxVal = Integer.valueOf(values.get(i));
            }
            System.out.println("The first response is : " + increaseValuesCounter);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
