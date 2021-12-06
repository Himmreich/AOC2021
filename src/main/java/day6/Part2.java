package day6;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(6);
            List<Integer> fishList = Arrays.asList(values.get(0).split(",")).stream().map(v -> Integer.valueOf(v)).collect(Collectors.toList());

            Long[] dictionary = new Long[9];
            for (int i = 0; i < 9; i++) {
                dictionary[i] = 0l;
            }

            for (Integer val : fishList) {
                Long v = dictionary[val];
                v++;
                dictionary[val] = v;
            }

            for (int day = 0; day < 256; day++) {
                Long[] temp = {0l,0l,0l,0l,0l,0l,0l,0l,0l};
                for (int i = 8; i >= 0; i--) {
                    Long numberFish = dictionary[i]; //Nombrte de poisson a ce statut
                    if (numberFish != 0) { //S'il y a au moins 1 poisson
                        if(i == 0 && numberFish > 0) { //S'il y a des poisson a 0
                            temp[6] = temp[6] + numberFish;
                            temp[8] = temp[8] + numberFish;
                            dictionary[i] = 0l;
                        } else {
                            temp[i-1] = numberFish;
                            dictionary[i] = 0l;
                        }
                    }
                }
                for (int i = 8; i >= 0; i--) {
                    dictionary[i] = dictionary[i] + temp[i];
                }
            }

            Long total = 0l;
            for (Long i : dictionary) {
                total += i;
            }


            System.out.println("The second response is : " + total);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
