package day6;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(6);
            List<Integer> fishList = Arrays.asList(values.get(0).split(",")).stream().map(v -> Integer.valueOf(v)).collect(Collectors.toList());

            for (int day = 0; day < 80; day++) {
                int size = fishList.size();
                for (int i = 0; i < size; i++) {
                    Integer fish = fishList.get(i);
                    fish--;
                    if (fish < 0) {
                        fishList.set(i, 6);
                        fishList.add(8);
                    } else {
                        fishList.set(i, fish);
                    }
                }
            }
            System.out.println("The first response is : " + fishList.size());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
