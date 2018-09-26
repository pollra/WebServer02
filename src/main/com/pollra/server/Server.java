package main.com.pollra.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port = 12345;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    private Server(){
        try {
            serverSocket = new ServerSocket(port);
            executorService = Executors.newFixedThreadPool(10);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Server getInstance() { return SingletonHolder.instance; }
    private static class SingletonHolder{
        private static final Server instance = new Server();
    }

    public void start(){
        while(true){

        }
    }

}
