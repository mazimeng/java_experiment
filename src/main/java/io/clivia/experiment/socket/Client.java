package io.clivia.experiment.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Client {
    public static void main(String[] args) throws InterruptedException, IOException {
//        final Client main = new Client();
//        main.client();

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.putInt(1);
        byteBuffer.flip();
        byteBuffer.putLong(1L);
    }

    public void client() throws IOException, InterruptedException {
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5454));
        System.out.println("a client connected");

        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        boolean running = true;
        while(running) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            byte[] bytes = input.getBytes();
            int sent = 0;
            byteBuffer.flip();
            byteBuffer.putInt(bytes.length);

            while(sent < bytes.length) {
                byteBuffer.put(bytes);
                sent += bytes.length;
            }
            client.write(byteBuffer);
        }
        client.close();
    }
}
