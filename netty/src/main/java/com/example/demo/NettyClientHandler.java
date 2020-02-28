package com.example.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;

public class NettyClientHandler extends ChannelHandlerAdapter {
    private ByteBuf firstMessage;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        byte[] data = "你好，服务器".getBytes();
//        firstMessage = Unpooled.buffer();
//        firstMessage.writeBytes(data);
//        ctx.writeAndFlush(firstMessage);
//        System.err.println("客户端发送消息:你好，服务器");
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        String rev = getMessage(buf);
//        System.err.println("客户端收到服务器消息:" + rev);
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }

//    private String getMessage(ByteBuf buf) {
//        byte[] con = new byte[buf.readableBytes()];
//        buf.readBytes(con);
//        try {
//            return new String(con, "UTF8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
