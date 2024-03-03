import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculationServer extends UnicastRemoteObject implements CalculationInterface {
    protected CalculationServer() throws RemoteException {
        super();
    }

    @Override
    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divide(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Division by zero is not allowed.");
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            CalculationServer server = new CalculationServer();
            // Lancer le serveur RMI
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
