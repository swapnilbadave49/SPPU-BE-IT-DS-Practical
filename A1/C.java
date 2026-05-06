import java.rmi.Naming;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      try {
          String url="rmi://localhost/Server";
          I1 res=(I1) Naming.lookup(url);

          System.out.println("Enter n1");
          double n1=sc.nextDouble();
          System.out.println("Enter n2");
          double n2=sc.nextDouble();

          System.out.println("ans is= "+res.add(n1,n2));
      }catch (Exception e)
      {
          System.out.println("Error is= "+e.getMessage());
      }

    }
}
