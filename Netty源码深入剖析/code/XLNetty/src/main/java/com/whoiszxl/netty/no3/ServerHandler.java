package com.whoiszxl.netty.no3;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter{


    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        
        System.out.println("�������_ʼ�xȡ������.....");
        System.out.println();
        
        
        
        if(msg instanceof ByteBuf) {
        	ByteBuf req = (ByteBuf) msg;
        	String content = req.toString(Charset.defaultCharset());
        	System.out.println("���������յ�����Ϣ��"+content);
        	
        	ctx.channel().writeAndFlush(loadFromDB());
        }
        
//        new Thread(new Runnable() {
//            public void run() {
//                // ��ʱ�Ĳ���
//                String result = loadFromDB();
//
//                ctx.channel().writeAndFlush(result);
//                ctx.executor().schedule(new Runnable() {
//                    public void run() {
//                        // ...
//                    }
//                }, 1, TimeUnit.SECONDS);
//
//            }
//        }).start();
    }

    private String loadFromDB() {
        return "hello world!\r\n";
    }
}
