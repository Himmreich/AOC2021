package day6;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Day6_tests {

    List<Integer> values = Arrays.asList(3,4,3,1,2);

    @Test
    public void part1_test() {

        List<Integer> fishList = new ArrayList<>();
        fishList.addAll(values);
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
        Assert.assertEquals(5934, fishList.size());
    }

    @Test
    public void part2_test() {
        List<Integer> fishList = new ArrayList<>();
        fishList.addAll(values);

        Integer[] dictionary = new Integer[9];
        for (int i = 0; i < 9; i++) {
            dictionary[i] = 0;
        }

        for (Integer val : fishList) {
            Integer v = dictionary[val];
            v++;
            dictionary[val] = v;
        }

        for (int day = 0; day < 80; day++) {
            System.out.println("After " + (day + 1) + " day : " + Arrays.asList(dictionary));
            Integer[] temp = {0,0,0,0,0,0,0,0,0};
            for (int i = 8; i >= 0; i--) {
                Integer numberFish = dictionary[i]; //Nombrte de poisson a ce statut
                if (numberFish != 0) { //S'il y a au moins 1 poisson
                    if(i == 0 && numberFish > 0) { //S'il y a des poisson a 0
                        temp[6] = temp[6] + numberFish;
                        temp[8] = temp[8] + numberFish;
                        dictionary[i] = 0;
                    } else {
                        temp[i-1] = numberFish;
                        dictionary[i] = 0;
                    }
                }
            }
            for (int i = 8; i >= 0; i--) {
                dictionary[i] = dictionary[i] + temp[i];
            }
        }

        int total = 0;
        for (Integer i : dictionary) {
            total += i;
        }

        System.out.println(total);

        Assert.assertEquals(5934, total);
    }
}
