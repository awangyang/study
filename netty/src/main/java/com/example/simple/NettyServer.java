package com.example.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wangyang
 * @date 2020/04/07
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {

        //创建 BossGroup和WorkerGroup
        //说明
        // BossGroup指处理连接请求，真正的和客户业务处理会交给WorkerGroup
        // 两个都是无限循环
        // bossGroup和workerGroup含有的子线程（NioEventLoop）的个数默认是CPU核数 * 2
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            //创建服务器端启动对象，并配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置两个线程组
            bootstrap.group(bossGroup, workerGroup)
                    //使用NioSocketChannel作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //设置保持活动的连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });


            System.out.println("服务器准备好了。。。。。。");

            //绑定端口并且同步生成一个ChannelFuture对象
            //启动服务器
            ChannelFuture channelFuture = bootstrap.bind(6668).sync();

            //对关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
