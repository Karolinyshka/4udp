package com.example.udp4;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;

public class HelloApplication extends Application {
    public int a;
    public int b;
    public int c;
    public String argc = null;
    public HelloController controller;
    public final static int SERVICE_PORT = 50001;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("лаб4");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();

        controller = fxmlLoader.getController();
        controller.main = this;


    }
    public void clientStart() {
        try{

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

            String sentence = a + "," + b + "," + c;
            sendingDataBuffer = sentence.getBytes();

            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, SERVICE_PORT);
            clientSocket.send(sendingPacket);


            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);
            String receivedData = new String(receivingPacket.getData(), receivingPacket.getOffset(), receivingPacket.getLength());
            argc = receivedData;
            controller.text.setText("Разность сумм равна: "+ argc);
            System.out.println("Sent from the server: "+receivedData);


            clientSocket.close();
        }
        catch(SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}