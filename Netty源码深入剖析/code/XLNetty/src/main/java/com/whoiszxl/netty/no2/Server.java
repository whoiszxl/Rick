package com.whoiszxl.netty.no2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��ͳsocket�����
 * @author whoiszxl
 *
 */
public class Server {
	
	private ServerSocket serverSocket;
	
	public Server(int port) {
		try {
			this.serverSocket = new ServerSocket(port);
			System.out.println("����������ɹ����˿�:" + port);
		} catch (IOException e) {
			System.out.println("���������ʧ��");
		}
	}
	
	public void start() {
		new Thread(new Runnable() {
			
			public void run() {
				doStart();
			}
		}).start();
	}
	
	private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("������쳣");
            }
        }
    }
}
