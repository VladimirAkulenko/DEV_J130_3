/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDPServer;

/**
 *
 * @author USER
 */
import java.io.IOException;
import java.net.*;
import java.util.Date;

public class UDPServer {
    public static final int PORT = 15250;
    public  static final int PACKET_SIZE = 2048;
    DatagramPacket packet;
    private byte[] buffer;
    public boolean eternal = true;

    public UDPServer() {
        buffer = new byte[PACKET_SIZE];
    }

    public void start(){
        try(DatagramSocket socket = new DatagramSocket(PORT)){

            packet = new DatagramPacket(buffer, PACKET_SIZE);
            while(eternal){
                socket.receive(packet);
                String msg = new String(packet.getData(),0, packet.getLength());
                if (msg.equals("EXIT")){
                    eternal = false;
                }else{

                System.out.println("Сообщение получено: "+ new Date() + "от: " + packet.getAddress().getHostAddress());
                System.out.println(msg);

                }

            }

        }catch (SocketException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
