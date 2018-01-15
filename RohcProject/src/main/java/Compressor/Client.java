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
			Socket client = new Socket(serverName, port);
			IP ip = new IP(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, "asdsadsadsa", null);
			CompressorAlgorithm compressor= new CompressorAlgorithm();
			IP a = compressor.compress(ip);
		
			
			/** Send Stream **/
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF(a.toString()); // Actual Place to put string
			
			
			//second
			IP x = new IP(100, 200, 300, 400, 500, 600, 700, 800, 900, 100, 110, 120, 130 , "asdsadsadsa", null);
			IP y = compressor.compress(x);
			
			System.out.println("Here is Y " + y.toString());
		
			
			/** Send Stream **/
			outToServer = client.getOutputStream();
			out = new DataOutputStream(outToServer);
			out.writeUTF(y.toString()); // Actual Place to put string
			
			

			/** Recieve from Server **/
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}