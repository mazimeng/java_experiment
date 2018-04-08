package io.clivia.experiment;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SocketExperiment {
    private final CountDownLatch ready = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        final SocketExperiment main = new SocketExperiment();
        Thread clientThread = new Thread(() -> {
            try {
                System.out.println("a client started");
                main.client();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("a client stopped");
            }
        }, "clientThread");

        Thread serverThread = new Thread(() -> {
            try {
                main.server();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("server stopped");
            }
        }, "serverThread");

        serverThread.start();
        clientThread.start();

        serverThread.join();
        clientThread.join();
    }

    public void client() throws IOException, InterruptedException {
        ready.await();
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5454));
        System.out.println("a client connected");
        client.close();
    }

    public void server() throws IOException, InterruptedException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(5454));
        serverSocket.configureBlocking(false);
        SelectionKey opAccept = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        boolean listening = false;

        while (true) {
            if(!listening) {
                listening = true;
                ready.countDown();
            }

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
