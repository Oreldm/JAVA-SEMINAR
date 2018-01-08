package Layer4;

import org.json.simple.JSONObject;

import Layer3.IP;
import Utils.Network;
import Utils.Utils;

public class TCP extends Network {

	/*
	 * private int[] ver=new int[4]; private int[] headerLength=new int[4]; private
	 * int[] typeOfService=new int[8]; private int[] identification=new int[16];
	 * private int[] timeToLive=new int[8]; private int[] protocol=new int[8];
	 * private int[] totalLength=new int[16]; private int[] flags=new int[3];
	 * private int[] offset=new int[13]; private int[] checkSum=new int[16]; private
	 * int[] sourceAddress=new int[32]; private int[] destinationAddress=new
	 * int[32]; private String option; private String data; private IP ip;
	 */

	private int sourcePort;
	private int destinationPort;
	private int sequenceNumber;
	private int ackNumber;
	private int dataOffset;
	private int reserved;
	private int flags;
	private int window;
	private int checkSum;
	private int urgentPointer;
	private int options;
	private int padding;
	private String data;
	private IP ip;

	public TCP(int sourcePort, int destinationPort, int sequenceNumber, int ackNumber, int dataOffset, int reserved,
			int flags, int window, int checkSum, int urgentPointer, int options, int padding, String data, IP ip) {

		setSourcePort(sourcePort);
		setDestinationPort(destinationPort);
		setSequenceNumber(sequenceNumber);
		setAckNumber(ackNumber);
		setDataOffset(dataOffset);
		setReserved(reserved);
		setFlags(flags);
		setWindow(window);
		setCheckSum(checkSum);
		setUrgentPointer(urgentPointer);
		setOptions(options);
		setPadding(padding);
		setData(data);
		setIp(ip);
		this.data = data;
	}
	
	public TCP(JSONObject json) {
		setSourcePort(((Long) json.get("sourcePort")).intValue());
		setDestinationPort(((Long) json.get("destinationPort")).intValue());
		setSequenceNumber(((Long) json.get("sequenceNumber")).intValue());
		setAckNumber(((Long) json.get("ackNumber")).intValue());
		setDataOffset(((Long) json.get("dataOffset")).intValue());
		setReserved(((Long) json.get("reserved")).intValue());
		setUrgentPointer(((Long) json.get("urgentPointer")).intValue());
		setOptions(((Long) json.get("options")).intValue());
		setPadding(((Long) json.get("padding")).intValue());
		setFlags(((Long) json.get("flags")).intValue());
		setWindow(((Long) json.get("window")).intValue());
		setCheckSum(((Long) json.get("checkSum")).intValue());
		this.setData((String) json.get("data"));
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}

	public int getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getAckNumber() {
		return ackNumber;
	}

	public void setAckNumber(int ackNumber) {
		this.ackNumber = ackNumber;
	}

	public int getDataOffset() {
		return dataOffset;
	}

	public void setDataOffset(int dataOffset) {
		this.dataOffset = dataOffset;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getFlags() {
		return flags;
	}

	public void setFlags(int flags) {
		this.flags = flags;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public int getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}

	public int getUrgentPointer() {
		return urgentPointer;
	}

	public void setUrgentPointer(int urgentPointer) {
		this.urgentPointer = urgentPointer;
	}

	public int getOptions() {
		return options;
	}

	public void setOptions(int options) {
		this.options = options;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public String getData() {
		return data;
	}

	public IP getIp() {
		return ip;
	}

	public void setIp(IP ip) {
		this.ip = ip;
	}
	
	public void setData(String data) {
		this.data=data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		JSONObject json = new JSONObject();
		json.put("sourcePort", sourcePort);
		json.put("destinationPort", destinationPort);
		json.put("sequenceNumber", sequenceNumber);
		json.put("ackNumber", ackNumber);
		json.put("dataOffset", dataOffset);
		json.put("reserved", reserved);
		json.put("flags", flags);
		json.put("window", window);
		json.put("checkSum", checkSum);
		json.put("urgentPointer", urgentPointer);
		json.put("options", options);
		json.put("padding", padding);
		json.put("data", data);
		json.put("ip", ip);
		return json.toJSONString();
	}

	public TCP getDifferences(TCP other) {
		if(other==null)
			return null;
		TCP tcpToReturn=Utils.getTcpObject();

		tcpToReturn.setSourcePort(this.getSourcePort() ^ other.getSourcePort());
		tcpToReturn.setDestinationPort(this.getDestinationPort() ^ other.getDestinationPort());
		tcpToReturn.setSequenceNumber(this.getSequenceNumber() ^ other.getSequenceNumber());
		tcpToReturn.setAckNumber(this.getAckNumber() ^ other.getAckNumber());
		tcpToReturn.setDataOffset(this.getDataOffset() ^ other.getDataOffset());
		tcpToReturn.setReserved(this.getReserved() ^ other.getReserved());
		tcpToReturn.setFlags(this.getFlags() ^ other.getFlags());
		tcpToReturn.setWindow(this.getWindow() ^ other.getWindow());
		tcpToReturn.setCheckSum(this.getCheckSum() ^ other.getCheckSum());
		tcpToReturn.setUrgentPointer(this.getUrgentPointer() ^ other.getUrgentPointer());
		tcpToReturn.setOptions(this.getOptions() ^ other.getOptions());
		tcpToReturn.setPadding(this.getPadding() ^ other.getPadding());
		tcpToReturn.setData(other.data);
		
		return tcpToReturn;
		
	}


	
}
