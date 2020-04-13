package com.example.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author wangyang
 * @date 2020/04/09
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 表示channel 处于活动状态, 提示 xx上线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.err.println("【客户端】 " + channel.remoteAddress() + " 上线了");
    }

    /**
     * 表示channel 处于不活动状态, 提示 xx离线了
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.err.println("【客户端】 " + channel.remoteAddress() + " 离线了");
    }


    /**
     * handlerAdded 表示连接建立，一旦连接，第一个被执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("【客户端】 " + channel.remoteAddress() + " 加入聊天\n");
        channels.add(channel);
    }

    /**
     * 断开连接, 将xx客户离开信息推送给当前在线的客户
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("【客户端】 " + channel.remoteAddress() + " 离开聊天\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channels.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush("【客户】 " + channel.remoteAddress() + " 发送了消息：" + msg + "\n");
            } else {
                ch.writeAndFlush("【自己】 发送了消息：" + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent stateEvent = (IdleStateEvent) evt;
            String state = "";
            switch (stateEvent.state()) {
                case READER_IDLE:
                    state = "读空闲";
                    break;
                case WRITER_IDLE:
                    state = "写空闲";
                    break;
                case ALL_IDLE:
                    state = "读写空闲";
                    break;
                default:
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "---" + state);
            ctx.channel().close();
        }
    }
}
