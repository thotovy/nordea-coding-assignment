package com.nordea.assignment;


import com.nordea.assignment.domain.Sentence;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * @param args First parameter is the Text to parse. Second parameter is the name of the csv file to be output (including suffix).
     *             If no arguments are provided, the program will read a default test file from resources and save it with a default naming.
     */
    public static void main(String[] args) {
        FileUtility fileUtility = new FileUtility();
        String defaultInputFileName = "inputFile.in";
        String outputFileName = "defaultOutput.csv";
        String inputText;

        if (args.length == 0) {
            inputText = fileUtility.readFile(defaultInputFileName);
        } else {
            inputText = args[0];
        }
        if (args.length > 1) {
            outputFileName = args[1];
            if (!outputFileName.contains(".csv")) {
                outputFileName = outputFileName + ".csv";
            }
        }

        Map<Sentence, List<String>> sentenceMap = new TextUtility().parseText(inputText);

        fileUtility.writeSentencesToCSVFile(sentenceMap, outputFileName);
    }
}
