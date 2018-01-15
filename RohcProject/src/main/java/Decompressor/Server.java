package Decompressor;

import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;
import Utils.Utils;

import java.io.*;

public class Server extends Thread {
	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);


	}

	public void run() {
		while (true) {
			try {
				JSONParser parser = new JSONParser();
				Socket server = serverSocket.accept();
				DecompressorAlgorithm decompressor = new DecompressorAlgorithm();

				/** Server Recieve **/
				DataInputStream in = new DataInputStream(server.getInputStream()); // stream in
				String response = in.readUTF();

				JSONObject json = (JSONObject) parser.parse(response);

				if(Utils.isIp(json)) {
					IP compressedIP;
					IP decompreessedIP;
					compressedIP = new IP(json);
					decompreessedIP = decompressor.decompress(compressedIP);
					DecompressorGui.frame.updateGui(compressedIP, decompreessedIP);
				} else if (Utils.isTcp(json)) {
					TCP compressedTcp;
					TCP decompreessedTcp;
					compressedTcp = new TCP(json);
					decompreessedTcp = decompressor.decompress(compressedTcp);
					DecompressorGui.frame.updateGui(compressedTcp, decompreessedTcp);
				} else if (Utils.isUdp(json)) {
					UDP compressedUdp;
					UDP decompreessedUdp;
					compressedUdp = new UDP(json);
					decompreessedUdp = decompressor.decompress(compressedUdp);
					DecompressorGui.frame.updateGui(compressedUdp, decompreessedUdp);
				}
				/** Server Answer **/
				DecompressorGui.frame.repaint();
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
			} catch (IOException e) {
			} catch (ParseException e) {
			}
		}
	}

	public static void main(String[] args) {
		int port = 6000;
		try {
			Thread t = new Server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}