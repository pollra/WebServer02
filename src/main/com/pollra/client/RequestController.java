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
            String temp;
            while(!((temp = br.readLine()).isEmpty())){
                System.out.println(temp);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
