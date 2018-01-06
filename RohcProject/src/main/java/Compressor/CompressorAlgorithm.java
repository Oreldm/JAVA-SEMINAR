package Compressor;

import Layer3.IP;

public class CompressorAlgorithm {
	// str.getBytes();
	public static IP lastPacket = null;
	
	
	public IP compress(IP ip) {
		if(ip.equals(lastPacket) == false) {
			lastPacket=ip;
			return ip; //IR State
		}
		//IF RTP/SomethingDynamic Do Second Order (means to add sequence number!)
		/**TODO: ADD SecondOrder**/
		
		
		//else:
		/**First Order**/
		 IP packetToReturn=lastPacket.getDifferences(ip);
		 packetToReturn.setData(ip.getData());
		 lastPacket=ip;
		 return packetToReturn;
	}
	
}
