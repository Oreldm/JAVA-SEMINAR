package Compressor;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;

public class CompressorAlgorithm {
	public static IP lastPacketIP = null;
	public static TCP lastPacketTCP = null;
	public static UDP lastPacketUDP = null;
	
	public IP compress(IP ip) {
		if(lastPacketIP == null) {
			lastPacketIP=ip;
			return ip; //IR State
		}
		 IP packetToReturn=lastPacketIP.getDifferences(ip);
		 packetToReturn.setData(ip.getData());
		 lastPacketIP=ip;
		 return packetToReturn;
	}
	
	public TCP compress(TCP tcp) {
		if(lastPacketTCP == null) {
			lastPacketTCP=tcp;
			return tcp; //IR State
		}
		 TCP packetToReturn=lastPacketTCP.getDifferences(tcp);
		 packetToReturn.setData(tcp.getData());
		 lastPacketTCP=tcp;
		 return packetToReturn;
	}
	
	public UDP compress(UDP udp) {
		if(lastPacketUDP == null) {
			lastPacketUDP=udp;
			return udp; //IR State
		}
		 UDP packetToReturn=lastPacketUDP.getDifferences(udp);
		 packetToReturn.setData(udp.getData());
		 lastPacketUDP=udp;
		 return packetToReturn;
	}
	
}
