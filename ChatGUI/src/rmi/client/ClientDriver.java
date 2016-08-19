package rmi.client;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.server.IServer;

public class ClientDriver {

	public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
		// create a GUI
		ClientUI clientUI = new ClientUI();
		clientUI.setVisible(true);

		String chatServerURL = "rmi://localhost/RMIChatServer";
		IServer chatServer = (IServer) Naming.lookup(chatServerURL);

		// Note that chatServer is IServer
		clientUI.setServerBase(chatServer);
		ClientImp chatClient = new ClientImp(clientUI.getUserName(), chatServer, clientUI);
	}
}
