package Layer3;

import Layer2.EthernetFrame;
import Utils.Utils;

public class CompressedIp {
	
	private int[] totalLength=new int[16];
	private int[] checkSum=new int[16];
	private String data;
	EthernetFrame ethernet;
	
	public CompressedIp(IP ip) {
		
		Utils.copyByValue(ip.getTotalLength(), this.totalLength);
		Utils.copyByValue(ip.getCheckSum(), this.checkSum);
		this.data=ip.getData();
		this.ethernet=ip.getEthernetFrame();
	}

}
