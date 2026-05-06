import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        ServerSocket server=new ServerSocket(8000);

        while (true)
        {
            Socket rec=server.accept();
            DataInputStream din=new DataInputStream(rec.getInputStream());
  String token=din.readUTF();
            System.out.println("We have got from machine 1="+token);

            Socket s=new Socket("127.0.0.1",9000);

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(token);
            System.out.println("Token sent back  to machine 2");
            s.close();
            rec.close();
        }
    }
}
