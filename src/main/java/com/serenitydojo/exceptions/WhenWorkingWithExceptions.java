package com.serenitydojo.exceptions;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WhenWorkingWithExceptions {

    WordCounter wordCounter = new WordCounter();
    @Test
    public void shouldCountWordsInAString() {


        int numberOfWords = wordCounter.numberOfWordsIn("some string");

        assertThat(numberOfWords).isEqualTo(2);
    }
    @Test
    public void shouldReturnZeroForANullString() {


        int numberOfWords = wordCounter.numberOfWordsIn(null);

        assertThat(numberOfWords).isEqualTo(0);
    }

    @Test
    public void shouldCountWordsInAFile() throws IOException, FileHasNoWordsException {


        int numberOfWords = wordCounter.numberOfWordsInFile("src/main/resources/hello.txt");
    }

    @Test//(expected = FileHasNoWordsException.class)
    public void shouldReportAnErrorIfTheFileDoesNotExist() throws  IOException {
        int numberOfWords = wordCounter.numberOfWordsInFile("file-that-doesn't-not-exist.txt");
        assertThat(numberOfWords).isEqualTo(0);
    }

    @Test(expected = FileHasNoWordsException.class)
    public void shouldThrowMeaningfulExceptionIfThereAreNoWordsInTheFile() throws Exception {
        wordCounter.numberOfWordsInFile("src/main/resources/no_words.txt");
    }

}
