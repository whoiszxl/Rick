package com.whoiszxl.netty.no2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 客户端处理
 * @author whoiszxl
 *
 */
public class ClientHandler {

	public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;
    
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    public void start() {
        System.out.println("新客户端接入");
        new Thread(new Runnable() {
            
            public void run() {
                doStart();
            }
        }).start();
    }
    
    /**
     * 读取客户端发送过来的数据再写回去
     */
    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息: " + message);
                    socket.getOutputStream().write(data);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
