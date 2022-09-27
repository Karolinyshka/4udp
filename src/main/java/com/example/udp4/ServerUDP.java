package com.example.udp4;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {


    public final static int SERVICE_PORT=50001;

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("input");
        String receivedData = "";
        while (true) {

            try {

                DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);

                byte[] receivingDataBuffer = new byte[1024];
                byte[] sendingDataBuffer = new byte[1024];

                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
                System.out.println("Waiting for a client to connect...");

                serverSocket.receive(inputPacket);
                receivedData = new String(inputPacket.getData(), inputPacket.getOffset(), inputPacket.getLength());
                System.out.println("Sent from the client: " + receivedData);

                if (receivedData.length() > 1) {
                    file = new FileWriter("input");
                    file.append("Входные данные: " + receivedData);
                }

                String[] abc = receivedData.split(",");
                int[] chisla = new int[3];
                chisla[0] = Integer.parseInt(abc[0]);
                chisla[1] = Integer.parseInt(abc[1]);
                chisla[2] = Integer.parseInt(abc[2]);
                SumForOne one = new SumForOne(chisla[0], chisla[1]);
                SumForTwo two = new SumForTwo(chisla[1], chisla[2]);
                Thread sum = one;
                Thread sum1 = two;

                sum.run();
                sum1.run();

                Float res = one.res - two.res;
                String output = res.toString();
                sendingDataBuffer = output.getBytes();
                InetAddress senderAddress = inputPacket.getAddress();
                int senderPort = inputPacket.getPort();

                DatagramPacket outputPacket = new DatagramPacket(
                        sendingDataBuffer, sendingDataBuffer.length,
                        senderAddress, senderPort
                );


                serverSocket.send(outputPacket);
                file.append("\n");
                file.append("Результат: " + output);
                file.close();
                serverSocket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }
}
