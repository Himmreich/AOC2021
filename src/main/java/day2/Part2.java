package day2;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        try {
            int forward = 0;
            int aim = 0;
            int depth = 0;
            List<String> values = InputHelper.readValues(2);
            for (int i = 0; i < values.size(); i++) {
                String[] val = values.get(i).split(" ");
                if (val[0].toLowerCase().startsWith("f")) {
                    forward += Integer.valueOf(val[1]);
                    depth += (Integer.valueOf(val[1]) * aim);
                } else if (val[0].toLowerCase().startsWith("u"))
                    aim -= Integer.valueOf(val[1]);
                else
                    aim += Integer.valueOf(val[1]);
            }
            System.out.println("The second response is : " + forward * depth);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
