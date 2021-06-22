package com.nordea.assignment;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilityTest {
    private final FileUtility fileUtility = new FileUtility();

    @Test
    public void shouldReadTextFile() {
        String textFromFile = fileUtility.readFile("readableTestingFile");
        String expectedText = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam," +
                "eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.";

        Assert.assertNotNull("The resulting text from the file should not be null.", textFromFile);
        Assert.assertEquals("The resulting text from the file not as expected.", expectedText, textFromFile);
    }
}
