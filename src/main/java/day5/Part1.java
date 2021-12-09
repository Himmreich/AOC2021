package day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    @AllArgsConstructor
    @Getter
    @Setter
    static class Coord {
        int x;
        int y;
    }

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(5);
            List<Coord> listCoords = new ArrayList<>();
            String[][] grid = new String[1000][1000];
            for(int row = 0; row < grid.length; row++){
                for(int col = 0; col < grid[row].length; col++){
                    grid[row][col] = ".";
                }
            }

            for (String val : values) {
                Coord coordFirst = new Coord(Integer.valueOf(val.split(" -> ")[0].split(",")[0]),
                        Integer.valueOf(val.split(" -> ")[0].split(",")[1]));
                Coord coordLast = new Coord(Integer.valueOf(val.split(" -> ")[1].split(",")[0]),
                        Integer.valueOf(val.split(" -> ")[1].split(",")[1]));

                if (coordFirst.getX() == coordLast.getX()) {
                    if (coordFirst.getY() < coordLast.getX()) {
                        for (int i = coordFirst.getY(); i <= coordLast.getY(); i++) {
                            listCoords.add(new Coord(coordFirst.getX(), i));
                        }
                    } else if (coordFirst.getY() > coordLast.getY()) {
                        //for (int i = coo)
                    }
                }

                if (coordFirst.getY() == coordLast.getY()) {

                }
            }


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
