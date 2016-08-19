package rmi.client;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import rmi.server.IServer;

public class ClientImp extends UnicastRemoteObject implements IClient {
	private String name;
	private IServer chatServer;
	private ClientUI clientUI;

	public ClientImp(String name, IServer chatServer, ClientUI clientUI) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		this.clientUI = clientUI;

		// add client to server's client list
		chatServer.registerClient(this);
	}

	// display message on textArea
	@Override
	public void retrieveMessage(String message) throws RemoteException {
		clientUI.displayMessage(message);
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	// update user list of GUI
	@Override
	public void updateUsers() throws RemoteException {
		clientUI.updateUsers();
	}
}
