package rmi.server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class ServerDriver {

	public static void main(String[] args) {
		try {
			// enter username
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your name: ");
			String name = in.nextLine().trim();

			// register a name to RMI registry, for binding chatServer
			LocateRegistry.createRegistry(1099);

			ServerImp chatServer = new ServerImp(name);
			String url = "rmi://localhost/ABC";
			Naming.rebind(url, chatServer);
			System.out.println("[System] Server is ready...");
			
			while (true) {
				String msg = in.nextLine().trim();
				msg = "[" + chatServer.getName() + "] " + msg;
				chatServer.broadcastMessage(msg);
			}
		} catch (RemoteException | MalformedURLException e) {
			System.out.println("[System] Server failed: " + e);
		}

	}
}
