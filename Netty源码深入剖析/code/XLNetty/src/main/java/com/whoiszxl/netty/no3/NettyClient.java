package com.whoiszxl.netty.no3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

/**
 * netty客戶端
 * @author whoiszxl
 *
 */
public class NettyClient {
	public static EventLoopGroup group = null;
	public static Bootstrap bootstrap = null;
	static {
		group = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		bootstrap.group(group);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
				.handler(new ChannelInitializer<NioSocketChannel>() {

					@Override
					protected void initChannel(NioSocketChannel ch) throws Exception {
						System.out.println("initChannel 執行了嗎？");
						ch.pipeline().addLast(
								new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new ClientHandler());
						ch.pipeline().addLast(new StringEncoder());
					}
				});
	}
	
	public static void main(String[] args) {
		
		
		
		try {
			
			ChannelFuture future = bootstrap.connect("localhost", 8888).sync();
			String girl = "ayanami\r\n";
			future.channel().writeAndFlush(girl);
			future.channel().closeFuture().sync();
			
			Object result = future.channel().attr(AttributeKey.valueOf("ChannelKey")).get();
			System.out.println("在客戶端獲取通過AttributeKey設置的數據:"+ result.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			group.shutdownGracefully();
		}
	}
}
