package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import rmi.server.IServer;


public class ClientDriver {
	public static void main(String[] args) {
		try {
			// enter username
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your name: ");
			String name = in.nextLine().trim();

			// get chatServer (stub) from RMI registry
			IServer chatServer = (IServer)Naming.lookup("rmi://localhost/ABC");
			ClientImp chatClient= new ClientImp(name, chatServer);

			while (true) {
				String msg = in.nextLine().trim();
				msg = "[" + chatClient.getName() + "] " + msg;
				chatServer.broadcastMessage(msg);
			}
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			System.out.println("[System] Server failed: " + e);
		}
	}
}
