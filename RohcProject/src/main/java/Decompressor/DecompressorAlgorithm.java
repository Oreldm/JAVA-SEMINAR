package Decompressor;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;

public class DecompressorAlgorithm {
	public static IP lastPacketIP = null;
	public static TCP lastPacketTCP = null;
	public static UDP lastPacketUDP = null;

	public IP decompress(IP ip) {
		if (lastPacketIP == null) {
			lastPacketIP = ip;
			return ip;
		}
		/** First Order **/
		IP packetToReturn = lastPacketIP.getDifferences(ip);
		packetToReturn.setData(ip.getData());
		lastPacketIP = packetToReturn;
		return packetToReturn;
	}

	public TCP decompress(TCP tcp) {
		if (lastPacketTCP == null) {
			lastPacketTCP = tcp;
			return tcp;
		}
		/** First Order **/
		TCP packetToReturn = lastPacketTCP.getDifferences(tcp);
		packetToReturn.setData(tcp.getData());
		lastPacketTCP = packetToReturn;
		return packetToReturn;
	}

	public UDP decompress(UDP udp) {
		if (lastPacketUDP == null) {
			lastPacketUDP = udp;
			return udp;
		}
		/** First Order **/
		UDP packetToReturn = lastPacketUDP.getDifferences(udp);
		packetToReturn.setData(udp.getData());
		lastPacketUDP = packetToReturn;
		return packetToReturn;
	}

}
