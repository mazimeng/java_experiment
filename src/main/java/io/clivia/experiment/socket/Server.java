package io.clivia.experiment.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {
        final Server main = new Server();

        main.server();
    }

    public void server() throws IOException, InterruptedException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(5454));
        serverSocket.configureBlocking(false);
        SelectionKey opAccept = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("server started");

        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectedKeys.iterator();
            while (it.hasNext()) {
                System.out.println("received a selection");

                SelectionKey key = it.next();

                if (key.isAcceptable()) {
//                    register(selector, serverSocket);
                    SocketChannel client = serverSocket.accept();
                    System.out.println(String.format("%s, %s", client.getLocalAddress(), client.getRemoteAddress()));
                }

                if (key.isReadable()) {
//                    answerWithEcho(buffer, key);
                }
//                it.remove();
            }
        }
    }
}
