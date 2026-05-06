import  java.rmi.*;


public class Servimp extends UnicastRemoteObject implements Servint{
    public Servimp() throws RemoteException{}

    public double add(double num1, double num2) throws Remot{
        return num1 +  num2;
    }
}