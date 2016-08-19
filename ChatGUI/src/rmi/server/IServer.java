package rmi.server;


import rmi.client.IClient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServer extends Remote {
	void registerClient(IClient chatClient) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;
	public ArrayList<IClient> getClients() throws RemoteException;
	public String getName() throws RemoteException;
}
