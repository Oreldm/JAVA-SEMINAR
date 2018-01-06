package Decompressor;

import Layer3.IP;

public class DecompressorAlgorithm {
	public static IP lastPacket = null;
	
	public IP decompress(IP ip) {
		if(lastPacket==null) {
			lastPacket=ip;
			return ip;
		}
		
		/**First Order**/
		IP packetToReturn=lastPacket.getDifferences(ip);
		packetToReturn.setData(ip.getData());
		lastPacket=ip;
		return packetToReturn;
	}

}
