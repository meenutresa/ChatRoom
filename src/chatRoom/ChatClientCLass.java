/**
 * 
 */
package chatRoom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Meenu Vincent
 *
 */
public class ChatClientCLass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String server_name = args[0];
				String server_name = "localhost";
				//int server_portnum = Integer.parseInt(args[1]);
				int server_portnum = 4444;
				String chat_from_server, chat_to_server;
				BufferedReader message = new BufferedReader(new 
						InputStreamReader(System.in)); 
				
				try {
			         Socket chat_socket = new Socket(server_name, server_portnum);
			         PrintWriter out = new PrintWriter(chat_socket.getOutputStream(), true);
			         BufferedReader in = new BufferedReader(new
			            InputStreamReader(chat_socket.getInputStream()));
			         
			         while ((chat_from_server = in.readLine()) != null) {
			        	 System.out.println("Server: " + chat_from_server + '\n');
			        	 if (chat_from_server.equals("Bye")) {
			        	        break;
			        	 }
			        	 chat_to_server = message.readLine();
			        	 if (chat_to_server != null) {
			        		 System.out.println("Client: " + chat_to_server + '\n');
			        		 out.println(chat_to_server);
			        	 }
			        	 
			        	 
			         }
			         
			         in.close();
			         chat_socket.close();
			      }
			      catch(Exception e) {
			         System.out.print("Whoops! It didn't work!\n");
			      }

	}

}
