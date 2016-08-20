package rmi.client;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	public String getName() throws RemoteException;
	public void retrieveMessage(String msg) throws RemoteException;
}

