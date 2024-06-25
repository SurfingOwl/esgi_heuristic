package com.esgi.csvcalculator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvIO {

    private static final String COMMA_DELIMITER = ",";

    public List<LinkedList<String>> openCsv(String path) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.map(line -> new LinkedList<>(Arrays.asList(line.split(COMMA_DELIMITER))))
                    .collect(Collectors.toList());
        }
    }

    public void writeCsv(List<List<String>> csv, String path) throws IOException {
        Stream<String> lines = csv.stream().flatMap(line ->
                line.stream().map(e ->
                        Stream.of(e).collect(Collectors.joining(","))));

        Files.write(Path.of(path), lines.collect(Collectors.toList()), Charset.defaultCharset());
    }
}
