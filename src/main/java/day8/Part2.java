package day8;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {
    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(8);

            int total = 0;
            for (String input : values) {
                String initialValues = input.substring(0, input.lastIndexOf('|')).trim();
                String num0 = "";
                String num1 = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 2).collect(Collectors.toList()).get(0);
                String num2 = "";
                String num3 = "";
                String num4 = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 4).collect(Collectors.toList()).get(0);
                String num5 = "";
                String num6 = "";
                String num7 = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 3).collect(Collectors.toList()).get(0);
                String num8 = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 7).collect(Collectors.toList()).get(0);
                String num9 = "";

                String a = difference(num7, num1);
                String c = "";
                String e = "";
                String f = "";
                String g = "";
                String cf = num1;
                String bd = difference(num4, num7);
                String aeg = difference(num8, num4);
                String eg = difference(aeg, a);
                String bf = "";

                List<String> temp = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 5).collect(Collectors.toList());
                for (String t : temp) {
                    if (compare(t, eg)) num2 = t;
                }

                for (String t : temp) {
                    if (difference(t, num2).length() == 1) num3 = t;
                    else {
                        if (t != num2) {
                            num5 = t;
                            bf = difference(t, num2);
                        }
                    }
                }
                String abdfg = num5;
                g = difference(difference(difference(abdfg, a), bf), bd);
                e = difference(eg , e);
                f = difference(difference(difference(abdfg, a), bd), g);
                c = difference(cf, f);

                temp = Arrays.asList(initialValues.split(" ")).stream().filter(n -> n.length() == 6).collect(Collectors.toList());
                for (String t : temp) {
                    if (t.contains(e)) {
                        if (t.contains(c)) num0 = t;
                        else num6 = t;
                    } else num9 = t;
                }

                String outputSignal = input.substring(input.lastIndexOf('|') + 1).trim();
                StringBuilder val = new StringBuilder("");
                for (String output : outputSignal.split(" ")) {
                    if (num0.length() == output.length() && compare(num0, output)) val.append(0);
                    else if (num1.length() == output.length() && compare(num1, output)) val.append(1);
                    else if (num2.length() == output.length() && compare(num2, output)) val.append(2);
                    else if (num3.length() == output.length() && compare(num3, output)) val.append(3);
                    else if (num4.length() == output.length() && compare(num4, output)) val.append(4);
                    else if (num5.length() == output.length() && compare(num5, output)) val.append(5);
                    else if (num6.length() == output.length() && compare(num6, output)) val.append(6);
                    else if (num7.length() == output.length() && compare(num7, output)) val.append(7);
                    else if (num8.length() == output.length() && compare(num8, output)) val.append(8);
                    else if (num9.length() == output.length() && compare(num9, output)) val.append(9);
                }
                total += Integer.valueOf(val.toString());
            }
            System.out.println("The second response is : " + total);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean compare(String str1, String str2) {
        List st1 = str1.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        List st2 = str2.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        if (st1.size() > st2.size()) return st1.containsAll(st2);
        else  return st2.containsAll(st1);
    }

    public static String difference(String str1, String str2) {
        List<Character> l1 = str1.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        List<Character> l2 = str2.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        l1.removeAll(l2);
        return l1.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
