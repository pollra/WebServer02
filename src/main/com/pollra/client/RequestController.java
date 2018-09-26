package main.com.pollra.client;

import main.com.pollra.client.http.HttpRequestMethod;
import main.com.pollra.client.http.HttpResponse;
import main.com.pollra.client.http.HttpStatus;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestController implements Runnable{
    private final String defualtPath = "src/main/resources/";
    private Socket socket;
    public RequestController(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream()){

            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String requestLine = br.readLine();
            if(requestLine == null){
                return;
            }
            System.out.println(requestLine);
            String temp, responseLine = "";
            List<String> httpHeader = new LinkedList<>();
            while(!((temp = br.readLine()).isEmpty())){
                responseLine += temp + "\r\n";
                httpHeader.add(responseLine);
            }

            // 반복문 돌면서 key와 value 를 분리. HttpRequest에 저장.
            HttpResponse httpResponse;
            String content[] = requestLine.split(" ");
            byte[] body = Files.readAllBytes(new File(defualtPath + "index.html").toPath());
            HttpResponse.ResponseBuilder builder = new HttpResponse.ResponseBuilder(HttpStatus.OK);
            httpResponse = builder
                    .addHeader("Content-Type:","text/html; charset=utf-8")
                    .addHeader("Content-Length:", body.length+"")
                    .build();

            DataOutputStream dos = new DataOutputStream(os);

            dos.writeBytes(httpResponse.getProtocol()+""+httpResponse.getStatus().getStatusMessage() + "\r\n");
            for(Map.Entry<String, String> entry : httpResponse.getResponseHeader().entrySet()){
                dos.writeBytes(entry.getKey() + ": "+entry.getValue()+"\r\n");
            }

            dos.writeBytes("\r\n");
            dos.write(body, 0, body.length);
            dos.writeBytes("\r\n");
            dos.flush();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
