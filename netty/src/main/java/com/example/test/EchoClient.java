package com.example.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.remoteAddress(host, port);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new EchoClientHandler());
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            if(f.isSuccess()){
                System.err.println("连接服务器成功");
            }
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws Exception {
        new EchoClient("localhost", 10086).start();
    }
}
