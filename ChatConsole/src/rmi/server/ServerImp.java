package rmi.server;

import rmi.client.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImp extends UnicastRemoteObject implements IServer {

	public String name;
	public List<IClient> clients;

	public ServerImp(String name) throws RemoteException {
		this.name = name;
		this.clients = new ArrayList<>();
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public void broadcastMessage(String msg) throws RemoteException {
		for (IClient client : clients) {
			client.retrieveMessage(msg);
		}
		System.out.println(msg);
	}

	@Override
	public void registerClient(IClient client) throws RemoteException {
		this.clients.add(client);
	}

	@Override
	public List<IClient> getClients() throws RemoteException {
		return this.clients;
	}
}
