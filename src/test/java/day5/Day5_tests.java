package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5_tests {

    List<String> values = Arrays.asList("0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2");

    @Test
    public void part1_test() {
        List<Part1.Coord> listCoords = new ArrayList<>();
        String[][] grid = new String[1000][1000];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                grid[row][col] = ".";
            }
        }

        for (String val : values) {
            Part1.Coord coordFirst = new Part1.Coord(Integer.valueOf(val.split(" -> ")[0].split(",")[0]),
                    Integer.valueOf(val.split(" -> ")[0].split(",")[1]));
            Part1.Coord coordLast = new Part1.Coord(Integer.valueOf(val.split(" -> ")[1].split(",")[0]),
                    Integer.valueOf(val.split(" -> ")[1].split(",")[1]));

            if (coordFirst.getX() == coordLast.getX()) {
                if (coordFirst.getY() < coordLast.getX()) {
                    for (int i = coordFirst.getY(); i <= coordLast.getY(); i++) {
                        listCoords.add(new Part1.Coord(coordFirst.getX(), i));
                    }
                } else if (coordFirst.getY() > coordLast.getY()) {
                    for (int i = coordFirst.getY(); i >= coordLast.getY(); i--) {
                        listCoords.add(new Part1.Coord(coordLast.getX(), i));
                    }
                }
            }

            if (coordFirst.getY() == coordLast.getY()) {
                if (coordFirst.getX() < coordLast.getX()) {
                    for (int i = coordFirst.getX(); i <= coordLast.getX(); i++) {
                        listCoords.add(new Part1.Coord(i, coordFirst.getY()));
                    }
                } else if (coordFirst.getX() > coordLast.getX()) {
                    for (int i = coordFirst.getX(); i >= coordLast.getX(); i--) {
                        listCoords.add(new Part1.Coord(i, coordLast.getY()));
                    }
                }
            }
        }

        for (Part1.Coord coord : listCoords) {
            if (grid[coord.getX()][coord.getY()].compareTo(".") == 0) {
                grid[coord.getX()][coord.getY()] = "1";
            } else {
                int val = Integer.valueOf(grid[coord.getX()][coord.getY()]).intValue();
                val++;
                grid[coord.getX()][coord.getY()] = String.valueOf(val);
            }
        }

        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j].compareTo(".") != 0 && Integer.parseInt(grid[i][j]) >= 2)
                    counter++;
            }
        }

        Assert.assertEquals(5, counter);
    }
}
