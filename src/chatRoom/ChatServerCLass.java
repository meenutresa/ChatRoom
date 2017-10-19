/**
 * 
 */
package chatRoom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Meenu Vincent
 *
 */
public class ChatServerCLass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message_from_server, message_from_client;
	      try {
	    	 //int port = Integer.parseInt(args[0]);
	    	  int port = 4444;
			 ServerSocket server_socket = new ServerSocket(port);
			 Socket client_socket = server_socket.accept();
	         //System.out.print("Welcome to chat room\n");
	         PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
	         BufferedReader in = new BufferedReader(
	        	        new InputStreamReader(client_socket.getInputStream()));
	         message_from_server = "Hello Client";
	         out.println(message_from_server);
	         
	         while (true) {
	        	 message_from_client = in.readLine();
	        	 out.println(message_from_client);
	        	 System.out.print("Message from client : \n" + message_from_client );
	        	 if(message_from_client.equals("Bye")) {
	        		 break;
	        	 }
	        	 
	         }
	                 
	         out.close();
	         client_socket.close();
	         server_socket.close();
	      }
	      catch(Exception e) {
	         System.out.print("Sorry!! Something went wrong\n");
	      }

	}

}
