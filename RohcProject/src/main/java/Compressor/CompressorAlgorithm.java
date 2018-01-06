package Compressor;

import Layer3.IP;

public class CompressorAlgorithm {
	// str.getBytes();
	public static IP lastPacket = null;
	
	
	public String compress(IP ip) {
		if(ip.equals(lastPacket) == false) {
			return ip.toString(); //IR State
		}
		//IF RTP/SomethingDynamic Do Second Order (means to add sequence number!)
		/**TODO: ADD SecondOrder**/
		
		//else:
		/**First Order**/
		
		
		
		return null;
	}
	
}
