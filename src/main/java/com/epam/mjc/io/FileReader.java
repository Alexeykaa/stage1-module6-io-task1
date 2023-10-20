package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);
    private ProfileParser parser = new ProfileParser();

    @java.lang.SuppressWarnings("java:S2139")
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
            logger.error("Cannot read profile data", e);
            throw new ProfileDataException("Cannot read profile data", e);
        }
    }
}
