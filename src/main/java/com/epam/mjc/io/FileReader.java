package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    private ProfileParser parser = new ProfileParser();

    public Profile getDataFromFile(File file) {
        try (BufferedReader in = new BufferedReader(new java.io.FileReader(file))) {
            parser.init();
            String line = in.readLine();
            while (line != null) {
                parser.addData(line);
                line = in.readLine();
            }
            return parser.getProfile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read profile data", e);
        }
    }
}
