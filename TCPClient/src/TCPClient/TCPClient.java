/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPClient;

/**
 *
 * @author USER
 */
import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static final int PORT = 15260;
    public boolean eternal = true;
    public void start(String address){

        try(Socket socket = new Socket(address, PORT)) {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            System.out.println("Для остановки клиента и сервера введите: EXIT");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(eternal){
                System.out.println("Введите сообщение: ");
                String text = reader.readLine();
                os.write(text.getBytes());
                if (text.equals("EXIT")){
                    eternal = false;
                }
                socket.shutdownOutput();
                StringBuilder sb = new StringBuilder();
                byte[] buffer = new byte[256];
                int var =0;
                while((var = is.read(buffer))>-1){
                    sb.append(new String(buffer, 0, var));
                }
                System.out.println("Сообщение отправлено в: "+ sb);
            }
            os.flush();
            os.close();
            is.close();
        }catch (IOException e){
                System.out.println(e.getMessage());
            }
    }
}