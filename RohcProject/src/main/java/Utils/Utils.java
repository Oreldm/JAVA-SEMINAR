package Utils;

public class Utils {
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
