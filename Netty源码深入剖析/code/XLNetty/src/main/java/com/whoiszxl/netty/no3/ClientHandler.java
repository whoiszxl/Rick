package com.whoiszxl.netty.no3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("netty客戶端開始讀取數據");
		
		System.out.println("netty客戶端接收到的數據是："+msg.toString());
		
		ctx.channel().attr(AttributeKey.valueOf("ChannelKey")).set(msg.toString());
		ctx.channel().close();
	}
}
