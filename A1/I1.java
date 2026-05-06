import java.rmi.Remote;
import java.rmi.RemoteException;

public interface I1 extends Remote {

    public double add(double n1,double n2)throws RemoteException;
}
