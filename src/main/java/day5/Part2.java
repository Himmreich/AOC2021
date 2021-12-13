package day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
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

                if (coordFirst.getX() == coordLast.getX()) { //Horizontal
                    if (coordFirst.getY() < coordLast.getY()) {
                        for (int i = coordFirst.getY(); i <= coordLast.getY(); i++) {
                            listCoords.add(new Coord(coordFirst.getX(), i));
                        }
                    } else if (coordFirst.getY() > coordLast.getY()) {
                        for (int i = coordFirst.getY(); i >= coordLast.getY(); i--) {
                            listCoords.add(new Coord(coordLast.getX(), i));
                        }
                    }
                } else if (coordFirst.getY() == coordLast.getY()) { //Vertical
                    if (coordFirst.getX() < coordLast.getX()) {
                        for (int i = coordFirst.getX(); i <= coordLast.getX(); i++) {
                            listCoords.add(new Coord(i, coordFirst.getY()));
                        }
                    } else if (coordFirst.getX() > coordLast.getX()) {
                        for (int i = coordFirst.getX(); i >= coordLast.getX(); i--) {
                            listCoords.add(new Coord(i, coordLast.getY()));
                        }
                    }
                } else {
                    if (coordFirst.getX() > coordLast.getX()) { //x-1
                        if (coordFirst.getY() > coordLast.getY()) { //y-1
                           int x = coordFirst.getX();
                           int y = coordFirst.getY();
                           while (x >= coordLast.getX() && y >= coordLast.getY()) {
                               listCoords.add(new Coord(x, y));
                               x--;
                               y--;
                           }
                        } else if (coordFirst.getY() < coordLast.getY()) { //y+1
                            int x = coordFirst.getX();
                            int y = coordFirst.getY();
                            while (x >= coordLast.getX() && y <= coordLast.getY()) {
                                listCoords.add(new Coord(x, y));
                                x--;
                                y++;
                            }
                        }
                    } else if (coordFirst.getX() < coordLast.getX()) { //x+1
                        if (coordFirst.getY() > coordLast.getY()) { //y-1
                            int x = coordFirst.getX();
                            int y = coordFirst.getY();
                            while (x <= coordLast.getX() && y >= coordLast.getY()) {
                                listCoords.add(new Coord(x, y));
                                x++;
                                y--;
                            }
                        } else if (coordFirst.getY() < coordLast.getY()) { //y+1
                            int x = coordFirst.getX();
                            int y = coordFirst.getY();
                            while (x <= coordLast.getX() && y <= coordLast.getY()) {
                                listCoords.add(new Coord(x, y));
                                x++;
                                y++;
                            }
                        }
                    }
                }
            }

            for (Coord coord : listCoords) {
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

            System.out.println("The second response is : " + counter);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
