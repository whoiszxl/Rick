package com.whoiszxl.netty.no2;

/**
 * socket������������
 * @author whoiszxl
 *
 */
public class ServerApp {

	private static final int PORT = 8000;
	
	public static void main(String[] args) {
		Server server = new Server(PORT);
        server.start();
	}
}
