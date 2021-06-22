package com.nordea.assignment;

import com.nordea.assignment.domain.Sentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


public class FileUtility {
    private static final Logger log = LoggerFactory.getLogger(FileUtility.class);

    /**
     * Reads any text file inside project resources.
     *
     * @param fileName name of the file
     * @return Text of the read file
     */
    public String readFile(String fileName) {
        StringBuilder text = new StringBuilder();

        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName)) {
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null; ) {
                text.append(line);
            }
        } catch (IOException | NullPointerException e) {
            log.error("Failed to read the file with name {}. Exception is: {}.", fileName, e);
        }

        return text.toString();
    }

    /**
     * Writes a map of Sentences to the CSV file. The CSV file will be in the format of: "Sentence number, Word 1, Word 2, Word 3, Word 4"
     *
     * @param inputMap map to be written into the file
     * @param fileName name (including a path) used for writing the file
     */
    public void writeSentencesToCSVFile(Map<Sentence, List<String>> inputMap, String fileName) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8)) {
            int sentenceNumber = 1;

            for (Map.Entry<Sentence, List<String>> entry : inputMap.entrySet()) {
                writer.append("Sentence ")
                        .append(String.valueOf(sentenceNumber));

                for (String word : entry.getValue()) {
                    writer.append(", ")
                            .append(word);
                }

                writer.append('\n');

                sentenceNumber++;
            }

        } catch (IOException e) {
            log.error("Failed to write the file with name {}. Exception is: {}", fileName, e);
        }
    }
}
