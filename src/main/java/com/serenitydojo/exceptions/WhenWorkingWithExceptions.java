package com.serenitydojo.exceptions;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WhenWorkingWithExceptions {
    @Test
    public void shouldCountWordsInAString() {
        WordCounter wordCounter = new WordCounter();

        int numberOfWords = wordCounter.numberOfWordsIn("some string");

        assertThat(numberOfWords).isEqualTo(2);

    }
    @Test
    public void shouldReturnZeroForANullString() {
        WordCounter wordCounter = new WordCounter();

        int numberOfWords = wordCounter.numberOfWordsIn(null);

        assertThat(numberOfWords).isEqualTo(0);
    }
}
