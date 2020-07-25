package cn.thinkingdata.ds.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonUtil {

    public static String getContentFromFile(String filePath) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
