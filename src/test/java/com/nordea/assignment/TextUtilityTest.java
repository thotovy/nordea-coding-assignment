package com.nordea.assignment;

import com.nordea.assignment.domain.Sentence;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TextUtilityTest {
    private final TextUtility textUtility = new TextUtility();

    @Test
    public void shouldCorrectlyParseText() {
        String textToTest = "Dr. Lorem (ipsum) dolor sit amet, consectetur \"adipiscing\" elit, sed'do eiusmod tempor! Incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim, veniam - quis, nostrud. Exěřčítätíón 汉字 ullamco laboris nisi ut aliquip ex ea commodo consequat? Duis aute irure dolor in ";


        Map<Sentence, List<String>> parsedText = textUtility.parseText(textToTest);

        assertNotNull("Parsed text should not be null.", parsedText);
        assertFalse("Parsed text should not be empty.", parsedText.isEmpty());

        //1st sentence
        testParsedSentence(parsedText, "first",
                new Sentence("Dr. Lorem (ipsum) dolor sit amet, consectetur \"adipiscing\" elit, sed'do eiusmod tempor!"),
                Arrays.asList("adipiscing", "amet", "consectetur", "dolor", "Dr", "eiusmod", "elit", "ipsum", "Lorem", "sed'do", "sit", "tempor"));

        //2nd sentence
        testParsedSentence(parsedText, "second",
                new Sentence("Incididunt ut labore et dolore magna aliqua."),
                Arrays.asList("aliqua", "dolore", "et", "Incididunt", "labore", "magna", "ut"));

        //3rd sentence
        testParsedSentence(parsedText, "third",
                new Sentence("Ut enim ad minim, veniam - quis, nostrud."),
                Arrays.asList("ad", "enim", "minim", "nostrud", "quis", "Ut", "veniam"));

        //4th sentence
        testParsedSentence(parsedText, "fourth",
                new Sentence("Exěřčítätíón 汉字 ullamco laboris nisi ut aliquip ex ea commodo consequat?"),
                Arrays.asList("aliquip", "commodo", "consequat", "ea", "ex", "Exěřčítätíón", "laboris", "nisi", "ullamco", "ut", "汉字"));

        //5th sentence
        testParsedSentence(parsedText, "fifth",
                new Sentence("Duis aute irure dolor in"),
                Arrays.asList("aute", "dolor", "Duis", "in", "irure"));
    }

    private void testParsedSentence(Map<Sentence, List<String>> textToTest, String sentenceNumber, Sentence expectedSentence, List<String> expectedWords) {
        assertTrue("The " + sentenceNumber + " sentence was not as expected.", textToTest.containsKey(expectedSentence));
        assertEquals("Number of words in the " + sentenceNumber + " sentence was not as expected.", expectedWords.size(), textToTest.get(expectedSentence).size());
        assertEquals("List of words in the " + sentenceNumber + " sentence was not as expected.", expectedWords, textToTest.get(expectedSentence));
    }
}
