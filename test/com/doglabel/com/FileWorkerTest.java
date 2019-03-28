// Tests

package com.doglabel.com;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileWorkerTest {

    @Test
    public void analyzeShouldReturn32KeywordsFromFile() {
        File file1 = new File("src/binSearch.java");
        String toAnalyze = FileWorker.fileToString(file1);

        assertEquals("class\n" +
                "private\n" + "static\n" + "int\n" + "public\n" + "static\n" +
                "int\n" + "return\n" + "public\n" + "static\n" + "int\n" +
                "int\n" + "int\n" + "int\n" + "int\n" + "int\n" + "int\n" +
                "while\n" + "int\n" + "if\n" + "else\n" + "if\n" + "else\n" +
                "if\n" + "break\n" + "if\n" + "return\n" + "return\n" +
                "public\n" + "static\n" + "void\n" + "int\n" + "\n" +
                "total: 32", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturn2KeywordsFromFile() {
        File file2 = new File("src/testFile.java");
        String toAnalyze = FileWorker.fileToString(file2);

        assertEquals("public\n" + "class\n" + "\n" +
                "total: 2", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturn2KeywordsAfterProcessingCorruptFile() {
        File file3 = new File("src/corruptFile.java");
        String toAnalyze = FileWorker.fileToString(file3);

        assertEquals("public\n" + "class\n" + "\n" +
                "total: 2", FileWorker.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturnNull() {
        String toAnalyze = "";

        assertEquals("" + "\n" + "total: 0", FileWorker.analyze(toAnalyze));
    }
}