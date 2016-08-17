
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;


public class ChatClient {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your name: ");
			String name = in.nextLine().trim();

			IChat client = new ChatImp(name);
			IChat server = (IChat)Naming.lookup("rmi://localhost/ABC");
			String msg = "[" + client.getName() + "] got connected";

			server.send(msg);
			server.registerClient(client);
			
			while (true) {
				msg = in.nextLine().trim();
				msg = "[" + client.getName() + "] " + msg;
				server.send(msg);

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
