package Layer4;

import org.json.simple.JSONObject;

public class UDP {
	//SHOULD CHANGE
	/*private char[] sourcePort=new char[16];
	private char[] destPort=new char[16];
	private char[] UdpLength=new char[16];
	private char[] UdpChecksum=new char[16];
	private String data;*/
	
	private int sourcePort;
	private int destPort;
	private int udpLength;
	private int udpChecksum;
	private String data;
	
	public UDP(int sourcePort, int destPort, int udpLength,
			int udpChecksum, String data) {
		
		setSourcePort(sourcePort);
		setDestPort(destPort);
		setUdpLength(udpLength);
		setUdpChecksum(udpChecksum);
		this.data = data;
	}

	public void setSourcePort(int sourcePort) {
		if(sourcePort <= 65535 && sourcePort >= 0)
			this.sourcePort = sourcePort;
	}

	public void setDestPort(int destPort) {
		if(destPort <= 65535 && destPort >= 0)
			this.destPort = destPort;
	}

	public void setUdpLength(int udpLength) {
		if(udpLength <= 65535 && udpLength >= 0)
			this.udpLength = udpLength;
	}

	public void setUdpChecksum(int udpChecksum) {
		if(udpChecksum <= 65535 && udpChecksum >= 0)
			this.udpChecksum = udpChecksum;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		JSONObject json = new JSONObject();
		json.put("sourcePort",sourcePort);
		json.put("destPort", destPort);
		json.put("udpLength", udpLength);
		json.put("udpChecksum", udpChecksum);
		json.put("data", data);
		
		return json.toJSONString();
	}
	
}
