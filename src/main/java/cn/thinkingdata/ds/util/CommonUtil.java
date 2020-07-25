package cn.thinkingdata.ds.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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


    public static String getContentFromResFile(String filePath) throws IOException {
        InputStream resourceAsStream = CommonUtil.class.getResourceAsStream(filePath);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
