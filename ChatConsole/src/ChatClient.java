
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;


public class ChatClient {
	public static void main(String[] args) {
		try {
			// enter username
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your name: ");
			String name = in.nextLine().trim();

			// get server (stub) from RMI registry
			// suggestion: add server to ChatImp constructor, separate IClient and IServer
			IChat client = new ChatImp(name);
			IChat server = (IChat)Naming.lookup("rmi://localhost/ABC");
			String msg = "[" + client.getName() + "] got connected";

			// send message to server's console
			// add client to userlist
			server.send(msg);
			server.registerClient(client);
			
			while (true) {
				msg = in.nextLine().trim();
				msg = "[" + client.getName() + "] " + msg;
				server.send(msg);

				// broadcasting message to another client
				List<IChat> clients = server.getClients();
				for (IChat iClient : clients) {
					if (!iClient.getName().equals(client.getName())) {
						iClient.send(msg);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("[System] Server failed: " + e);
		}
	}
}
