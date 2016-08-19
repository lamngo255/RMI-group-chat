package rmi.server;


import rmi.client.IClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImp extends UnicastRemoteObject implements IServer {
	private ArrayList<IClient> chatClients;
	private String name;
	private ServerUI serverUI;

	public ServerImp(String name, ServerUI serverUI) throws RemoteException {
		chatClients = new ArrayList<>();
		this.name = name;
		this.serverUI = serverUI;
	}

	// add new client to client list, and update user list for GUI
	@Override
	public synchronized void registerClient(IClient chatClient) throws RemoteException {
		this.chatClients.add(chatClient);
		System.out.println(chatClients.size());
		serverUI.updateUsers();
	}

	// broadcast to all client, include itself
	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		for (IClient chatClient : chatClients) {
			chatClient.retrieveMessage(message);
		}
		serverUI.displayMessage(message);
	}

	@Override
	public ArrayList<IClient> getClients() throws RemoteException {
		return this.chatClients;
	}

	public String getName() throws RemoteException {
		return this.name;
	}

	public ServerUI getServerUI() throws RemoteException {
		return this.serverUI;
	}
}
