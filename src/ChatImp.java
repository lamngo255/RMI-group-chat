
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImp extends UnicastRemoteObject implements IChat {
	public String name;
	public List<IChat> clients;

	public ChatImp(String name) throws RemoteException {
		this.name = name;
		this.clients = new ArrayList<>();
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public void send(String msg) throws RemoteException {
		System.out.println(msg);
	}

	@Override
	public void registerClient(IChat client) {
		this.clients.add(client);
	}

	@Override
	public List<IChat> getClients() throws RemoteException {
		return this.clients;
	}
}

