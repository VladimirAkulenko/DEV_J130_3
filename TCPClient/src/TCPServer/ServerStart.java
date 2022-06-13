/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPServer;

/**
 *
 * @author USER
 */
public class ServerStart {
    public static void main (String[] args){
        TCPServer server = new TCPServer();
        System.out.println("Сервер запущен");
        System.out.println("Для остановки клиента и сервера введите: EXIT");
        server.start();

        System.out.println("Сервер остановлен");
    }
}
