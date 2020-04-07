package com.example.test.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Wang Yang
 * @date 2020/3/114:45
 */
public class ClientDemo {
    private String host;
    private int port;

    public ClientDemo(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(host, port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect().sync();
            if (channelFuture.isSuccess()) {
                System.out.println("连接成功");
            }
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ClientDemo("localhost", 10086).start();
    }
}
