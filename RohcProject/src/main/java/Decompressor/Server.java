package Decompressor;

import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Layer3.IP;

import java.io.*;

public class Server extends Thread {
	private ServerSocket serverSocket;
	public static IP compressedIP;
	public static IP decompreessedIP;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run() {
		while (true) {
			try {
				JSONParser parser = new JSONParser();
//				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

//				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				
				/** Server Recieve**/
				DataInputStream in = new DataInputStream(server.getInputStream()); //stream in
				String response = in.readUTF();
				
				JSONObject json = (JSONObject) parser.parse(response);
				compressedIP= new IP(json);
				System.out.println("WE GOT FROM CLIENT COMPRESSED : " +compressedIP.toString());
				DecompressorAlgorithm decompressor= new DecompressorAlgorithm();
				decompreessedIP=decompressor.decompress(compressedIP);
				System.out.println("Decompressed: " + decompreessedIP);
				/**FOR RAVID : HERE WE SHOULD HAVE updateGui()**/
				
				//second
				System.out.println("Second");
				response = in.readUTF();
				json = (JSONObject) parser.parse(response);
				compressedIP= new IP(json);
				System.out.println("WE GOT FROM CLIENT COMPRESSED : " +compressedIP.toString());
				decompreessedIP=decompressor.decompress(compressedIP);
				System.out.println("Decompressed: " + decompreessedIP);
				
				/** Server Answer**/
//				DataOutputStream out = new DataOutputStream(server.getOutputStream());
//				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
			
				
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		int port = 6000;
//		try {
//			Thread t = new Server(port);
//			t.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}