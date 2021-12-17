import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream data = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                String st = sc.nextLine();
                data.writeUTF(st);

                String sms = dis.readUTF();
                System.out.println(sms);
                if(sms.equals("bye")){
                    break;
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
