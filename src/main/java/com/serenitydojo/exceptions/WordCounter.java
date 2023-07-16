package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class WordCounter {

    public int numberOfWordsIn(String someString) {
        if (someString == null) {
            return 0;
        }
        int numberOfWords = someString.split("\\W").length;
        return numberOfWords;
    }

    public int numberOfWordsInFile(String filename) throws IOException, FileHasNoWordsException {
        try {
            String fileContents = Files.readString(Paths.get(filename));
            int wordCount = numberOfWordsIn(fileContents);
            if(wordCount == 0) {
                throw new FileHasNoWordsException("No words in the file " + filename);
            }
            return wordCount;
        } catch (NoSuchFileException noSuchFile) {
            throw new FileHasNoWordsException("No words in the non existent file " + filename);
        }
    }
}
