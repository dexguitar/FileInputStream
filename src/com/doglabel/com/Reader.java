package com.doglabel.com;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public String fileToString(File file) {
        int content;
        StringBuilder sb = new StringBuilder();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while ( (content = inputStream.read()) != -1 ) {
                if (Character.isLetter( (char) content )) {
                    sb.append((char) content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String analyze(String str) {
        int count = 0;
        String keywords = "abstract|assert|boolean|break|byte|case|catch|char|class|continue|default" +
                "|do|double|else|enum|extends|final|finally|float|for|if|implements|import|instanceof" +
                "|int|interface|long|native|new|null|package|private|protected|public|return|short" +
                "|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while";

        Pattern p = Pattern.compile(keywords);
        Matcher m = p.matcher(str);

        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            sb.append(m.group() + "\n");
            count++;
        }

        return sb.toString() + "\n" + "total: " + String.valueOf(count);
    }

    public void writeToFile(String str) {
        File output = new File("src/test1.txt");

        try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(output))) {
            os.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
