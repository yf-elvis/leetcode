package com.hyf.leetcode.net;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author huyufei on 2020/11/15
 * @Desc: TODO
 */
public class NetTEst {

    private Selector selector;
    private SocketChannel socketChannel;


    public static void main(String[] args) throws UnknownHostException {
        NetTEst netTEst = new NetTEst();
        netTEst.connect();
        netTEst.sendMsg();

    }

    public void sendMsg() {
        try{
            ByteBuffer byteBuffer = ByteBuffer.allocate(12);
            byteBuffer.putLong(123456789);
            byteBuffer.put("huyu".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            try {
                while (true) {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    selector.select();

                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if (selectionKey.isReadable()) {
                            readMsgFromChannel();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void readMsgFromChannel() {

    }

    public void connect() {
        try {
            socketChannel = SocketChannel.open();
            selector = Selector.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 20880));
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
            }
            System.out.printf("socket channel 初始化完成\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
