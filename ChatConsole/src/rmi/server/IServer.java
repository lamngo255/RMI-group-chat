package rmi.server;


import rmi.client.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
	public String getName() throws RemoteException;
	public void broadcastMessage(String msg) throws RemoteException;
	public void registerClient(IClient client) throws RemoteException; 
	public List<IClient> getClients() throws RemoteException;
}

