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
	private int option;
	private String data;
	EthernetFrame ethernet;

	public IP(int ver,int headerLength, int typeOfService,
			int identification, int timeToLive, int protocol,
			int totalLength,int offset, int flags, int checkSum, int sourceAddress,
			int destinationAddress,int option, String data, EthernetFrame ethernet) {
		this.ver=ver;
		this.headerLength=headerLength;
		this.typeOfService=typeOfService;
		this.identification=identification;
		this.timeToLive=timeToLive;
		this.protocol=protocol;
		this.offset=offset;
		this.totalLength=totalLength;
		this.flags=flags;
		this.checkSum=checkSum;
		this.sourceAddress=sourceAddress;
		this.destinationAddress=destinationAddress;
		this.option=option;
		this.data=data;
		this.ethernet=ethernet;
	}
	
	
	public IP(JSONObject json) {
		this.setVer(((Long) json.get("ver")).intValue());
		this.setHeaderLength(((Long) json.get("headerLength")).intValue());
		this.setTypeOfService(((Long) json.get("typeOfService")).intValue());
		this.setIdentification(((Long) json.get("identification")).intValue());
		this.setOffset(((Long) json.get("offset")).intValue());
		this.setTimeToLive(((Long) json.get("timeToLive")).intValue());
		this.setProtocol(((Long) json.get("protocol")).intValue());
		this.setTotalLength(((Long) json.get("totalLength")).intValue());
		this.setFlags(((Long) json.get("flags")).intValue());
		this.setCheckSum(((Long) json.get("checkSum")).intValue());
		this.setSourceAddress(((Long) json.get("sourceAddress")).intValue());
		this.setDestinationAddress(((Long) json.get("destinationAddress")).intValue());
		this.setOption(((Long) json.get("option")).intValue());
		this.setData((String) json.get("data"));
	}
	
	
	public int getVer() {
		return ver;
	}


	public void setVer(int ver) {
		this.ver = ver;
	}


	public int getHeaderLength() {
		return headerLength;
	}


	public void setHeaderLength(int headerLength) {
		this.headerLength = headerLength;
	}


	public int getTypeOfService() {
		return typeOfService;
	}


	public void setTypeOfService(int typeOfService) {
		this.typeOfService = typeOfService;
	}


	public int getIdentification() {
		return identification;
	}


	public void setIdentification(int identification) {
		this.identification = identification;
	}


	public int getTimeToLive() {
		return timeToLive;
	}


	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}


	public int getProtocol() {
		return protocol;
	}


	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getFlags() {
		return flags;
	}


	public void setFlags(int flags) {
		this.flags = flags;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(int sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public int getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(int destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public EthernetFrame getEthernet() {
		return ethernet;
	}

	public void setEthernet(EthernetFrame ethernet) {
		this.ethernet = ethernet;
	}


	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}


	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}

	public void setData(String data) {
		this.data = data;
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
	
	@Override
    public boolean equals(Object o) {
		if(o==null)
			return false;
		IP ip = (IP)o;
		
//		private int ver;
//		private int headerLength;
//		private int typeOfService;
//		private int identification;
//		private int timeToLive;
//		private int protocol;
//		private int totalLength;
//		private int flags;
//		private int offset;
//		private int checkSum;
//		private int sourceAddress;
//		private int destinationAddress;
//		private String option;
//		private String data;
//		EthernetFrame ethernet;
		/**TODO: Make it more accurate and return the exact thing that is missing**/
		return (this.ver==ip.getVer() && this.getDestinationAddress()==ip.getDestinationAddress() && this.getSourceAddress() == ip.getSourceAddress() &&
				this.getProtocol()== ip.getProtocol());
	}
	
	public IP getDifferences(IP other) {
//		private int ver;
//		private int headerLength;
//		private int typeOfService;
//		private int identification;
//		private int timeToLive;
//		private int protocol;
//		private int totalLength;
//		private int flags;
//		private int offset;
//		private int checkSum;
//		private int sourceAddress;
//		private int destinationAddress;
//		private String option;
//		private String data;
//		EthernetFrame ethernet;
		if(other==null)
			return null;
		
		
		IP ipToReturn = Utils.getIpObject();
		//XOR the difference
		ipToReturn.setVer(this.ver^other.ver);
		ipToReturn.setTypeOfService(this.typeOfService^other.typeOfService);
		ipToReturn.setIdentification(this.identification^other.identification);
		ipToReturn.setTimeToLive(this.timeToLive^other.timeToLive);
		ipToReturn.setProtocol(this.protocol^other.protocol);
		ipToReturn.setFlags(this.flags^other.flags);
		ipToReturn.setSourceAddress(this.sourceAddress^other.sourceAddress);
		ipToReturn.setDestinationAddress(this.destinationAddress^other.destinationAddress);
		ipToReturn.setOption(this.option^other.option);
		ipToReturn.setCheckSum(this.checkSum^other.checkSum);
		ipToReturn.setOffset(0);
		ipToReturn.totalLength=0;
		ipToReturn.headerLength=0;
		
		return ipToReturn;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		
		JSONObject json = new JSONObject();
		json.put("ver",ver);
		json.put("headerLength", headerLength);
		json.put("typeOfService", typeOfService);
		json.put("identification", identification);
		json.put("offset", offset);
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
