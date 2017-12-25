package Layer4;

import org.json.simple.JSONObject;

import Layer3.IP;
import Utils.Utils;
public class TCP {
	
	/*private int[] ver=new int[4];
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
	private IP ip;*/
	
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
	private IP ip;
	
	public TCP(int ver, int headerLength , int typeOfService, int identification,
			 int timeToLive, int protocol, int totalLength,  int flags, int offset,
			 int checkSum, int sourceAddress, int destinationAddress, 
			 String option, String data, IP ip) {
		setVer(ver);
		setHeaderLength(headerLength);
		setTypeOfService(typeOfService);
		setIdentification(identification);
		setTimeToLive(timeToLive);
		setProtocol(protocol);
		setTotalLength(totalLength);
		setFlags(flags);
		setOffset(offset);
		setCheckSum(checkSum);
		setSourceAddress(sourceAddress);
		setDestinationAddress(destinationAddress); 
		this.option=option;
		this.data=data;
		this.ip=ip;
	}

	public void setVer(int ver) {
		if(ver <= 15 && ver >= 0)
			this.ver = ver;
	}

	public void setHeaderLength(int headerLength) {
		if(headerLength <= 15 && headerLength >= 0)
			this.headerLength = headerLength;
	}

	public void setTypeOfService(int typeOfService) {
		if(typeOfService <= 255 && typeOfService >= 0)
			this.typeOfService = typeOfService;
	}

	public void setIdentification(int identification) {
		if(identification <= 65535 && identification >= 0)
			this.identification = identification;
	}

	public void setTimeToLive(int timeToLive) {
		if(timeToLive <= 255 && timeToLive >= 0)
			this.timeToLive = timeToLive;
	}

	public void setProtocol(int protocol) {
		if(protocol <= 255 && protocol >= 0)
			this.protocol = protocol;
	}

	public void setTotalLength(int totalLength) {
		if(totalLength <= 65535 && totalLength >= 0)
			this.totalLength = totalLength;
	}

	public void setFlags(int flags) {
		if(flags <= 7 && flags >= 0)
			this.flags = flags;
	}

	public void setOffset(int offset) {
		if(offset <= 8191 && offset >= 0)
			this.offset = offset;
	}

	public void setCheckSum(int checkSum) {
		if(checkSum <= 65535 && checkSum >= 0)
			this.checkSum = checkSum;
	}

	public void setSourceAddress(int sourceAddress) {
		//if(sourceAddress <= 4294967295 && sourceAddress >= 0)
			this.sourceAddress = sourceAddress;
	}

	public void setDestinationAddress(int destinationAddress) {
		//if(destinationAddress <= 4294967295 && destinationAddress >= 0)
			this.destinationAddress = destinationAddress;
	}
	
	@SuppressWarnings("unchecked")
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
		json.put("offset", offset);
		json.put("checkSum", checkSum);
		json.put("sourceAddress", sourceAddress);
		json.put("destinationAddress", destinationAddress);
		json.put("option", option);
		json.put("data", data);
		json.put("ip", ip);
		return json.toJSONString();
	}
	
}
