package cn.thinkingdata.ds.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * class_name: LoggerUtil
 * package: cn.thinkingdata.ds.util
 * describe: TODO
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/7/25
 * creat_time: 8:37 下午
 **/
public class LoggerUtil {
    private static final Log logger = LogFactory.getLog(LoggerUtil.class);

    private static final String RED_COLOR = "\033[01;40;31m";

    private static final String RESET = "\033[0m";

    public static void info(String content){
        logger.info(content);
        System.out.println(content);
    }
    public static void info(String serverIp,String content){
        logger.info("[" + serverIp + "] " + content);
        System.out.println("[" + serverIp + "] " + content);
    }

    public static void error(String content){
        logger.error(content);
        System.err.println(RED_COLOR + content + RESET);
    }
    
    public static void error(String serverIp,String content){
        logger.error("[" + serverIp + "] " + content);
        System.err.println(RED_COLOR + "[" + serverIp + "] " +content + RESET);
    }

    public static void formatPrintMatrix(List<List<String>> dataMatrixList){
        int[] maxLengthForEachCol = getMaxLengthForEachCol(dataMatrixList);
        for (List<String> colList : dataMatrixList) {
            StringBuilder lineBuilder = new StringBuilder();
            for (int i = 0; i < colList.size() - 1; i++) {
                lineBuilder.append(String.format("%-" + (maxLengthForEachCol[i] + 4) + "s",colList.get(i)));
            }
            lineBuilder.append(colList.get(colList.size() - 1));
            info(lineBuilder.toString());
        }
    }


    private static int[] getMaxLengthForEachCol(List<List<String>> dataMatrixList){
        int[] colMaxLengths = new int[dataMatrixList.get(0).size()];
        for(int i = 0; i < dataMatrixList.get(0).size(); i++){
            colMaxLengths[i] = 0;
        }
        for (List<String> colList : dataMatrixList) {
            for (int i = 0; i < colList.size(); i++) {
                int length = colList.get(i).length();
                if(length > colMaxLengths[i]){
                    colMaxLengths[i] = length;
                }
            }
        }
        return colMaxLengths;
    }

}
