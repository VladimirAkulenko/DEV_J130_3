/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDPClient;

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class ClientStart {

    public static void main (String[] args){
        UDPClient client = new UDPClient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес сервера: ");
        String address = scanner.nextLine();
        System.out.println("Клиент запущен");
        client.start(address);
        System.out.println("Клиент остановлен");

    }
}
