package day14;

import com.google.common.collect.ImmutableMap;
import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(14);

            String input = values.get(0);

            Map<String, Character> pairs = new HashMap<>();

            for (int i = 2; i < values.size(); i++) {
                pairs.put(values.get(i).split("->")[0].trim(), values.get(i).split("->")[1].trim().charAt(0));
            }

            Map<String, Long> polymer = new LinkedHashMap<>();
            int i = 0;
            while (i < input.toCharArray().length - 1) {
                String pair = input.substring(i, i + 2);
                if (polymer.containsKey(pair)) polymer.replace(pair, polymer.get(pair) + 1);
                else polymer.put(pair, 1l);
                i++;
            }

            for (int day = 0; day < 40; day++) {
                Map<String, Long> polymerEntries = ImmutableMap.copyOf(polymer);
                for (Map.Entry<String, Long> entry : polymerEntries.entrySet()) {
                    Character letter = pairs.get(entry.getKey());
                    String newPair1 = "" + entry.getKey().charAt(0) + letter;
                    String newPair2 = "" + letter + entry.getKey().charAt(1);

                    if (polymer.containsKey(newPair1)) polymer.replace(newPair1, polymer.get(newPair1) + entry.getValue());
                    if (polymer.containsKey(newPair2)) polymer.replace(newPair2, polymer.get(newPair2) + entry.getValue());

                    polymer.putIfAbsent(newPair1, entry.getValue());
                    polymer.putIfAbsent(newPair2, entry.getValue());

                    polymer.replace(entry.getKey(), polymer.get(entry.getKey()) - entry.getValue());
                }
            }

            Map<Character, Long> polymerQuantity = new LinkedHashMap<>();

            for (Map.Entry<String, Long> entry : polymer.entrySet()) {
               Character c2 = entry.getKey().charAt(1);
               Long quantity = entry.getValue();

               if (polymerQuantity.containsKey(c2)) polymerQuantity.replace(c2, polymerQuantity.get(c2) + quantity);

               polymerQuantity.putIfAbsent(c2, quantity);
            }

            Long max = 0l;

            for (Map.Entry<Character, Long> entry : polymerQuantity.entrySet()) {
                if (entry.getValue() > max) max = entry.getValue();
            }

            Long min = max;

            for (Map.Entry<Character, Long> entry : polymerQuantity.entrySet()) {
                if (entry.getValue() < min) min = entry.getValue();
            }

            System.out.println("The second response is : " + (max - min));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
