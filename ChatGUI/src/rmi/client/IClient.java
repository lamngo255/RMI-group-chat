package rmi.client;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	void retrieveMessage(String message) throws RemoteException;
	String getName() throws RemoteException;
	void updateUsers() throws RemoteException;
}
