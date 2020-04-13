package com.example.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author wangyang
 * @date 2020/04/08
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());

        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());

        System.out.println("ok ~~~~~");
    }
}
