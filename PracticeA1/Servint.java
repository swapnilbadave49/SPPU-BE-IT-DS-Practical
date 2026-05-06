import java.rmi.*;

public interface Servint extends Remote{

    public double add(double num1, double num2)throws RemoveException;
}