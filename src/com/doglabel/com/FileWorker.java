package com.doglabel.com;

import javax.lang.model.SourceVersion;
import java.io.*;

public class FileWorker {

    private FileWorker() {

    }

    public static String fileToString(File file) {
        int content;
        StringBuilder sb = new StringBuilder();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while ( (content = inputStream.read()) != -1 ) {
                    sb.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String analyze(String str) {
        int count = 0;

        String[] splitStr = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String string: splitStr) {
            if (SourceVersion.isKeyword(string)) {
                sb.append(string + "\n");
                count++;
            }
        }

        return sb.toString() + "\n" + "total: " + String.valueOf(count);
    }

    public static void writeToFile(String str, String filePath) {
        File output = new File(filePath);

        try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(output))) {
            os.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
