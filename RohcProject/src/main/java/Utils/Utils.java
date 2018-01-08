package Utils;

import org.json.simple.JSONObject;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;

public class Utils {
	public static IP getIpObject() {
		IP ip= new IP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, 3, "ip test packet", null);
		return ip;
	}
	
	public static TCP getTcpObject() {
		TCP tcp= new TCP(1,2,3,4,5,6,7,8, 9, 10, 11, 12, getIpObject().getData(), getIpObject());
		return tcp;
	}
	
	public static UDP getUdpObject() {
		UDP udp= new UDP(1, 2, 3, 4, "udp test packet");
		return udp;
	}
	
	public static boolean isIp(JSONObject json) {
		if(json.get("destinationAddress")==null)
			return false;
		return true;
	}
	
	public static boolean isTcp(JSONObject json) {
		if(json.get("window")==null)
			return false;
		return true;
	}
	
	public static boolean isUdp(JSONObject json) {
		if(json.get("udpChecksum")==null)
			return false;
		return true;
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
