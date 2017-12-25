package Compressor;

import java.net.*;

import Layer3.CompressedIp;
import Layer3.IP;

import java.io.*;

public class Client {

	public static void main(String[] args) {
		String serverName = "localhost";
		int port = 6000;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
//			OutputStream outToServer = client.getOutputStream();
			
			IP ip= new IP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, "a", "asdsadsadsa", null);
			CompressedIp a= new CompressedIp(ip);
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF(a.toString());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/////sadfdsaf
	} 
}