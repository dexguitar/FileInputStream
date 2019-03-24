package com.doglabel.com;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ReaderTest {

    @Test
    public void analyzeShouldReturn32KeywordsFromFile() {
        Reader reader = new Reader();
        File file1 = new File("src/binSearch.java");
        String toAnalyze = reader.fileToString(file1);

        assertEquals("class\n" +
                "private\n" + "static\n" + "int\n" + "public\n" + "static\n" +
                "int\n" + "return\n" + "public\n" + "static\n" + "int\n" +
                "int\n" + "int\n" + "int\n" + "int\n" + "int\n" + "int\n" +
                "while\n" + "int\n" + "if\n" + "else\n" + "if\n" + "else\n" +
                "if\n" + "break\n" + "if\n" + "return\n" + "return\n" +
                "public\n" + "static\n" + "void\n" + "int\n" + "\n" +
                "total: 32", reader.analyze(toAnalyze));
    }

    @Test
    public void analyzeShouldReturn2KeywordsFromFile() {
        Reader reader = new Reader();
        File file2 = new File("src/testFile.java");
        String toAnalyze = reader.fileToString(file2);

        assertEquals("public\n" + "class\n" + "\n" +
                "total: 2", reader.analyze(toAnalyze));
    }
}