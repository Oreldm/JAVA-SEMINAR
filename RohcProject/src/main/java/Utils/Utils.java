package Utils;

import Layer3.IP;

public class Utils {
	public static IP getIpObject() {
		IP ip= new IP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, 3, "asdsadsadsa", null);
		return ip;
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
