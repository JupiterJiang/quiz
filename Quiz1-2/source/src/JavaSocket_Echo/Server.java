package JavaSocket_Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author zhenshan
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12346);
        System.out.println("服务器启动，绑定12346端口");

        while (true) {
            final Socket socket = server.accept();

            new Thread() {
                public void run() {
                    try {
                        //输入流
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
                        
                        //输出流
                        PrintStream ps = new PrintStream(
                                socket.getOutputStream());
                        
                        
                        String line = br.readLine();
                        ps.println(line);
                        socket.close();
                    } catch (IOException ex) {
                    }
                }
            }.start();
        }
    }
}
