package util;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputHelper {

    public static List<String> readValues(int number) throws IOException, URISyntaxException {
        Path path = Paths.get(InputHelper.class.getClassLoader()
                .getResource("input" + number).toURI());
        List<String> lines = new ArrayList<>();
        lines = Files.readAllLines(path);
        return lines;
    }
}
