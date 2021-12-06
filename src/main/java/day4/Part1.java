package day4;

import util.InputHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    static class Board {
        Integer[][] numbers = new Integer[5][5];

        public boolean isWin(List<Integer> values) {
            for (int i = 0; i < 5; i++) {
                if ((values.contains(numbers[i][0]) && values.contains(numbers[i][1]) && values.contains(numbers[i][2]) && values.contains(numbers[i][3]) && values.contains(numbers[i][4])) ||
                        (values.contains(numbers[0][i]) && values.contains(numbers[1][i]) && values.contains(numbers[2][i]) && values.contains(numbers[3][i]) && values.contains(numbers[4][i])))
                    return true;
            }
            return false;
        }

        public Integer score(List<Integer> values) {
            List<Integer> numList = Arrays.asList(numbers).stream().flatMap(Arrays::stream).collect(Collectors.toList());
            numList.removeAll(values);
            Integer score = 0;
            for (Integer n : numList)
                score += n;
            return score;
        }
    }

    public static void main(String[] args) {
        try {
            List<String> values = InputHelper.readValues(4);
            List<Integer> drawingNumberList = Arrays.asList(values.get(0).split(",")).stream().map(n -> Integer.valueOf(n)).collect(Collectors.toList());
            List<Board> boardList = new ArrayList<>();
            Board board = null;
            int gridLine = 0;
            for (int i = 1; i < values.size(); i++) {
                String line = values.get(i);
                if (line.isEmpty()) {
                    if (board != null)
                        boardList.add(board);
                    board = new Board();
                    gridLine = 0;
                    continue;
                }
                List<Integer> gridLineNumbers = Arrays.asList(line.split(" ")).stream().filter(v -> !v.trim().isEmpty()).map(n -> Integer.valueOf(n.trim())).collect(Collectors.toList());
                for (int j = 0; j < gridLineNumbers.size(); j++) {
                    board.numbers[gridLine][j] = gridLineNumbers.get(j);
                }
                gridLine++;
            }
            boardList.add(board);

            System.out.println("...Boards populated...");
            Integer winNumber = null;
            Integer winGridNumber = null;

            for (int i = 0; i < drawingNumberList.size(); i++) {
                for (int j = 0; j < boardList.size(); j++) {
                    if (boardList.get(j).isWin(drawingNumberList.subList(0, i + 1))) {
                        winNumber = drawingNumberList.get(i);
                        winGridNumber = j;
                        break;
                    }
                }
                if (winGridNumber != null)
                    break;
            }
            System.out.println("Grid " + winGridNumber + " wins with the number " + winNumber);
            System.out.println("The first response is : " + (winNumber * boardList.get(winGridNumber).score(drawingNumberList.subList(0, drawingNumberList.indexOf(winNumber) + 1))));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
