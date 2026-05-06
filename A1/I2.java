import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class I2 extends UnicastRemoteObject implements I1 {

    public I2()throws RemoteException{};

    @Override
    public double add(double n1, double n2) throws RemoteException {
        return Math.pow(n1,n2);
    }
}
