package JavaSocket_Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author zhenshan
 */
public class Client {

    public static void main(String[] args) throws IOException {

        while (true) {
            Scanner sc = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 12346);
            //输入流
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            //输出流
            PrintStream ps = new PrintStream(
                    socket.getOutputStream());

            String message = sc.nextLine();
            ps.println(message);

            if (message.equals("exit")) {
                break;
            } else {
                System.out.println(br.readLine());
                socket.close();
            }
        }
    }
}
