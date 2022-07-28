/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPServer;

/**
 *
 * @author USER
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServer {
    static final int PORT = 15260;
    public boolean eternal = true;
    public void start(){
        try(ServerSocket server = new ServerSocket(PORT)){
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte [256];
            int var =0;
            while((var = is.read(buf))>-1){
                sb.append(new String(buf, 0, var));
            }
            if (String.valueOf(sb).equals("EXIT")){
                eternal = false;
            } else{
                System.out.println("Сообщение получено: "+ new Date() + "от: " + socket.getInetAddress().getHostAddress() + sb);
                os.write(new Date().toString().getBytes());
            }
            os.flush();
            is.close();
            os.close();
            socket.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
