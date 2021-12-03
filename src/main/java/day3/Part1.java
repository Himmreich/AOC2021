package day3;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(3);
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

            System.out.println("The first response is : " + (Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)));

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
