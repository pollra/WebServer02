package main.com;

import main.com.pollra.server.Server;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        try {
            server.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
