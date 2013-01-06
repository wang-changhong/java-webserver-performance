package com.corindwyer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloWorldServer {
    public void run() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup()).channel(NioServerSocketChannel.class).localAddress(8080).childHandler(new ServerInitializer());
            bootstrap.bind().sync().channel().closeFuture().sync();
        } finally {
            bootstrap.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        new HelloWorldServer().run();
    }
}
