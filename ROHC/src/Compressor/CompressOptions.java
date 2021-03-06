package Compressor;

import Layer3.CompressedIp;
import Layer3.IP;

public class CompressOptions {
	private static IP lastIp;

	public static String IP_Only(IP ip) {
		if (lastIp == null || lastIp != ip) {
			return ip.toString();
		}
		lastIp = ip;

		CompressedIp compressed = new CompressedIp(ip);

		return compressed.toString();
	}
	
	public static String IP_TCP(IP ip) {
		return null;
	}
	
	public static String IP_UDP(IP ip) {
		return null;
	}

}
