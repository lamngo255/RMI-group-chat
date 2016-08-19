package rmi.server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerDriver {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		ServerUI serverUI = new ServerUI();
		serverUI.setVisible(true);

		LocateRegistry.createRegistry(1099);

		// Note that server is ServerImp
		ServerImp server = new ServerImp(serverUI.getUserName(), serverUI);
		serverUI.setServerBase(server);
		String url = "RMIChatServer";
		Naming.rebind(url, server);

		System.out.println("[System] Server is ready...");
	}
}
