package com.whoiszxl.netty.no3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("netty�͑����_ʼ�xȡ����");
		
		System.out.println("netty�͑��˽��յ��Ĕ����ǣ�"+msg.toString());
		
		ctx.channel().attr(AttributeKey.valueOf("ChannelKey")).set(msg.toString());
		ctx.channel().close();
	}
}
