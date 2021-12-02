package day2;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        try {
            int forward = 0;
            int depth = 0;
            List<String> values = InputHelper.readValues(2);
            for (int i = 0; i < values.size(); i++) {
                String[] val = values.get(i).split(" ");
                if (val[0].toLowerCase().startsWith("f"))
                    forward += Integer.valueOf(val[1]);
                else if (val[0].toLowerCase().startsWith("u"))
                    depth -= Integer.valueOf(val[1]);
                else
                    depth += Integer.valueOf(val[1]);
            }
            System.out.println("The frist response is : " + forward * depth);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
