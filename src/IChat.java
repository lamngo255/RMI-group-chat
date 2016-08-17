
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {
	public String getName() throws RemoteException;
	public void send(String msg) throws RemoteException;
	public void registerClient(IChat client) throws RemoteException;
	public List<IChat> getClients() throws RemoteException;
}

