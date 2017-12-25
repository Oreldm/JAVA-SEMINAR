package Layer3;

import Layer2.EthernetFrame;
import Utils.Utils;
import org.json.simple.JSONObject;
public class IP {

	
//	private int[] ver=new int[4];
//	private int[] headerLength=new int[4];
//	private int[] typeOfService=new int[8];
//	private int[] identification=new int[16];
//	private int[] timeToLive=new int[8];
//	private int[] protocol=new int[8];
//	private int[] totalLength=new int[16];
//	private int[] flags=new int[3];
//	private int[] offset=new int[13];
//	private int[] checkSum=new int[16];
//	private int[] sourceAddress=new int[32];
//	private int[] destinationAddress=new int[32];
	private int ver;
	private int headerLength;
	private int typeOfService;
	private int identification;
	private int timeToLive;
	private int protocol;
	private int totalLength;
	private int flags;
	private int offset;
	private int checkSum;
	private int sourceAddress;
	private int destinationAddress;
	private String option;
	private String data;
	EthernetFrame ethernet;

	public IP(int ver,int headerLength, int typeOfService,
			int identification, int timeToLive, int protocol,
			int totalLength, int flags, int checkSum, int sourceAddress,
			int destinationAddress,String option, String data, EthernetFrame ethernet) {
		this.ver=ver;
		this.headerLength=headerLength;
		this.typeOfService=typeOfService;
		this.identification=identification;
		this.timeToLive=timeToLive;
		this.protocol=protocol;
		this.totalLength=totalLength;
		this.flags=flags;
		this.checkSum=checkSum;
		this.sourceAddress=sourceAddress;
		this.destinationAddress=destinationAddress;
		this.option=option;
		this.data=data;
		this.ethernet=ethernet;
	}
	
	
	public int getTotalLength() {
		return this.totalLength;
	}
	
	public int getCheckSum() {
		return this.checkSum;
	}
	
	public String getData() {
		return this.data;
	}
	
	public EthernetFrame getEthernetFrame() {
		return this.ethernet;
	}
	
	@Override
	public String toString() {

		
		JSONObject json = new JSONObject();
		json.put("ver",ver);
		json.put("headerLength", headerLength);
		json.put("typeOfService", typeOfService);
		json.put("identification", identification);
		json.put("timeToLive", timeToLive);
		json.put("protocol", protocol);
		json.put("totalLength", totalLength);
		json.put("flags", flags);
		json.put("checkSum", checkSum);
		json.put("sourceAddress", sourceAddress);
		json.put("destinationAddress", destinationAddress);
		json.put("option", option);
		json.put("data", data);
		return json.toJSONString();
	}
}
