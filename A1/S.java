import java.rmi.Naming;

public class S {
    public static void main(String[] args) {
        try {
            I2 simp=new I2();
            Naming.rebind("Server",simp);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
