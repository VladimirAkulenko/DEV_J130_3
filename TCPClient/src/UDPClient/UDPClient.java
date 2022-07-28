/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDPClient;

/**
 *
 * @author USER
 */
import java.io.*;
import java.net.*;



public class UDPClient {
    public static final int PORT = 15250;
    public  static final int PACKET_SIZE = 2048;
    DatagramPacket packet;
    public byte[] buffer;
    public boolean eternal = true;


    public UDPClient() {
        buffer = new byte[PACKET_SIZE];
    }
    public void start(String address){
        try(DatagramSocket socket =new DatagramSocket()){
            packet = new DatagramPacket(buffer,PACKET_SIZE, InetAddress.getByName(address),PORT);
            System.out.println("Для остановки клиента и сервера введите: EXIT");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(eternal){
                System.out.println("Введите сообщение: ");
                String text = reader.readLine();

                byte [] temp = text.getBytes();
                for(int i =0; i<temp.length; i+=PACKET_SIZE-1){
                    int lenght = PACKET_SIZE-1;
                    int len = (i+ lenght)<temp.length ? lenght : temp.length-i;
                    packet.setData(temp,i,len);
                    socket.send(packet);

                }
                if (text.equals("EXIT")){
                    eternal = false;
                }
            }


        }catch (SocketException | UnknownHostException se){
            System.out.println(se.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}
