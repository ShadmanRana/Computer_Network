import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server Started");
        Socket socket = ss.accept();
        System.out.println("Client Accepter");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = dis.readUTF();
            System.out.println(s);
            if(s.equals("bye")){
                break;
            }

            String st = sc.nextLine();
            dos.writeUTF(st);

        }
    }
}
