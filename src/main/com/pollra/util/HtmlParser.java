package main.com.pollra.util;

import java.io.*;

public class HtmlParser {
    private final String defualtPath = "src/main/resources/";
    private String parsingData = null;
    public String HtmlParser(String fileName){
        File file = new File(defualtPath + fileName + ".html");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String fileContent;
            while((fileContent = br.readLine()).isEmpty()){
                parsingData += fileContent + "\r\n";
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println(fileName + ".html 파일을 찾을 수 없습니다.");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("파일의 끝을 검사하는 과정에서 오류가 발생했습니다.");
        }
        return parsingData;
    }

}
