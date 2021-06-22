package com.nordea.assignment;

import com.nordea.assignment.domain.Sentence;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TextUtility {
    private static final String SENTENCE_SPLITTER_REGEX = "(?<=[.!;?])(?<!Mr\\.|Mrs\\.|Dr\\.|Ms\\.)";
    private static final String CHARACTERS_TO_REMOVE_FROM_WORDS = "[\"().,!?:-]";


    /**
     * Parses any text into a Map containing {@link Sentence} and a list of words.
     *
     * @param fileText text to be parsed
     * @return Map with a {@link Sentence} key and a list of words as value
     */
    public Map<Sentence, List<String>> parseText(String fileText) {
        List<String> splitSentences = Arrays.asList(fileText.split(SENTENCE_SPLITTER_REGEX));

        LinkedHashMap<Sentence, List<String>> parsedSentences = new LinkedHashMap<>();

        splitSentences.forEach(splitSentence -> {
            Sentence sentence = new Sentence(splitSentence.trim());
            List<String> words = Arrays.asList(sentence.getText().replaceAll(CHARACTERS_TO_REMOVE_FROM_WORDS, " ").split("\\s+"));
            words.sort(String.CASE_INSENSITIVE_ORDER);

            parsedSentences.put(sentence, words);
        });

        return parsedSentences;
    }
}
