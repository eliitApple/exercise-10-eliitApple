package com.serenitydojo.exceptions;

public class WordCounter {

    public int numberOfWordsIn(String someString) {
        if (someString == null) {
            return 0;
        }
        int numberOfWords = someString.split("\\W").length;
        return numberOfWords;
    }
}
