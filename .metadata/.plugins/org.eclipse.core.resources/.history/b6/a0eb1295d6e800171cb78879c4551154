package Layer3;

import Layer2.EthernetFrame;
import Utils.Utils;

public class IP {

	
	private int[] ver=new int[4];
	private int[] headerLength=new int[4];
	private int[] typeOfService=new int[8];
	private int[] identification=new int[16];
	private int[] timeToLive=new int[8];
	private int[] protocol=new int[8];
	private int[] totalLength=new int[16];
	private int[] flags=new int[3];
	private int[] offset=new int[13];
	private int[] checkSum=new int[16];
	private int[] sourceAddress=new int[32];
	private int[] destinationAddress=new int[32];
	private String option;
	private String data;
	EthernetFrame ethernet;
	
	public IP(int[]ver,int[]headerLength, int[] typeOfService,
			int[] identification, int[] timeToLive, int[] protocol,
			int[] totalLength, int[] flags, int[] checkSum, int[] sourceAddress,
			int[] destinationAddress,String option, String data, EthernetFrame ethernet) {
		
		Utils.copyByValue(ver, this.ver);
		Utils.copyByValue(headerLength, this.headerLength);
		Utils.copyByValue(typeOfService, this.typeOfService);
		Utils.copyByValue(identification, this.identification);
		Utils.copyByValue(timeToLive, this.timeToLive);
		Utils.copyByValue(protocol, this.protocol);
		Utils.copyByValue(totalLength, this.totalLength);
		Utils.copyByValue(flags, this.flags);
		Utils.copyByValue(offset, this.offset);
		Utils.copyByValue(checkSum, this.checkSum);
		Utils.copyByValue(sourceAddress, this.sourceAddress);
		Utils.copyByValue(destinationAddress, this.destinationAddress);
		this.option=option;
		this.data=data;
		this.ethernet=ethernet;
	}
	
	
	public int[] getTotalLength() {
		return this.totalLength;
	}
	
	public int[] getCheckSum() {
		return this.checkSum;
	}
	
	public String getData() {
		return this.data;
	}
	
	public EthernetFrame getEthernetFrame() {
		return this.ethernet;
	}
}
