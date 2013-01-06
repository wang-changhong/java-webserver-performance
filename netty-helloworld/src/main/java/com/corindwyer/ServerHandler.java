package com.corindwyer;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundMessageHandlerAdapter<HttpRequest> {

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest) throws Exception {
        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        response.setHeader(HttpHeaders.Names.CONTENT_TYPE, "text/html;charset=utf-8");
        StringBuffer buf = new StringBuffer();
        buf.append("Hello World!");
        response.setContent(Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8));
        channelHandlerContext.write(response).addListener(ChannelFutureListener.CLOSE);
    }
}
