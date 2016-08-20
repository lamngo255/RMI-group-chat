package rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.server.IServer;

public class ClientImp extends UnicastRemoteObject implements IClient {

	private String name;
	private IServer chatServer;

	public ClientImp(String name, IServer chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerClient(this);

		// broadcast status message to server
		String msg = "[" + this.name + "] got connected";
		chatServer.broadcastMessage(msg);
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public void retrieveMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
}
