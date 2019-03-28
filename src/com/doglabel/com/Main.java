package com.doglabel.com;

import java.io.File;

public class Main {

    public static void main(String[] args) {
//        Entry point
        File file1 = new File("src/corruptFile.java");
        String toAnalyze = FileWorker.fileToString(file1);
        String analyzed = FileWorker.analyze(toAnalyze);
        FileWorker.writeToFile(analyzed, "src/test1.txt");

    }
}
