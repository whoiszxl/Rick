package com.whoiszxl.netty.no2;

/**
 * socket服务启动程序
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
