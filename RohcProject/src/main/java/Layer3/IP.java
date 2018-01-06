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
			int totalLength,int offset, int flags, int checkSum, int sourceAddress,
			int destinationAddress,String option, String data, EthernetFrame ethernet) {
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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
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
		
		
		return other;
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
