package Utils;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;

public class Utils {
	public static IP getIpObject() {
		IP ip= new IP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, 3, "ip test packet", null);
		return ip;
	}
	
	public static TCP getTcpObject() {
		TCP tcp= new TCP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, null, "tcp test packet", null);
		return tcp;
	}
	
	public static UDP getUdpObject() {
		UDP udp= new UDP(1, 2, 3, 4, "udp test packet");
		return udp;
	}
	
	public static void copyByValue(char[]src,char[]dst) {
		for(int i=0; i<src.length;i++) {
			dst[i]=src[i];
		}
	}
	
	public static void copyByValue(int[]src,int[]dst) {
		for(int i=0; i<src.length;i++) {
			dst[i]=src[i];
		}
	}
}
