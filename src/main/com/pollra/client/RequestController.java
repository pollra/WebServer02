package main.com.pollra.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class RequestController implements Runnable{
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
            while(!((temp = br.readLine()).isEmpty())){
                responseLine += temp + "\r\n";
            }

            /**
             * HttpHeandler 가 어떤 페이지를 보낼지 파악한 뒤 body를 리턴.
             * 그 뒤,
             */


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
