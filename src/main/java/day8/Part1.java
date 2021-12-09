package day8;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(8);

            int counter1 = 0;
            int counter7 = 0;
            int counter8 = 0;
            int counter4 = 0;

            for (String input : values) {
                String outputSignal = input.substring(input.lastIndexOf('|') + 1).trim();
                for (String output : outputSignal.split(" ")) {
                    if (output.length() == 2) counter1++;
                    else if (output.length() == 3) counter7++;
                    else if (output.length() == 7) counter8++;
                    else if (output.length() == 4) counter4++;
                }
            }
            System.out.println("The first response is : " + (counter1 + counter7 + counter8 + counter4));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
