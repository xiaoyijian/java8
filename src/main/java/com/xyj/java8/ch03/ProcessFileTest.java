package com.xyj.java8.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFileTest {
    public static void main(String[] args) throws IOException {
        String oneLine = processFile(br -> br.readLine());
        String twoLines = processFile(br -> br.readLine() + br.readLine());
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
