import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        ServerSocket server=new ServerSocket(9000);

        String t="Swap";

        while (true)
        {
            System.out.println("Token is at 1");
            System.out.println("Entered Sc");
            System.out.println("press Enter to release");
            sc.nextLine();
            System.out.println("1 out from Sc");
            Socket s=new Socket("127.0.0.1",8000);

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            dout.writeUTF(t);

            s.close();

            System.out.println("token sent to Machine 2");

            Socket rec=server.accept();

            DataInputStream din=new DataInputStream(rec.getInputStream());

            t=din.readUTF();
            System.out.println("We got from 2"+t);
            rec.close();
        }
    }
}
