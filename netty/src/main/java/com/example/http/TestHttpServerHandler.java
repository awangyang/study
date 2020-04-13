package com.example.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author wangyang
 * @date 2020/04/09
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

//        HttpRequest httpRequest = (HttpRequest) msg;
        System.out.println("--------------");

        if (msg instanceof HttpRequest) {
            ByteBuf buf = Unpooled.copiedBuffer("nihao,我是服务器！！！", CharsetUtil.UTF_8);

            //构造一个http的相应，即 httpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());

            //将构建好 response返回
            ctx.writeAndFlush(response);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
