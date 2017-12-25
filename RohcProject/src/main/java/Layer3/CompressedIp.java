package Layer3;

import org.json.simple.JSONObject;

import Layer2.EthernetFrame;
import Utils.Utils;

public class CompressedIp {
	
	private int totalLength;
	private int checkSum;
	private String data;
	EthernetFrame ethernet;
	
	public CompressedIp(IP ip) {
		this.totalLength=ip.getTotalLength();
		this.checkSum=ip.getCheckSum();
		this.data=ip.getData();
		this.ethernet=ip.getEthernetFrame();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		
		JSONObject json = new JSONObject();
		json.put("totalLength",totalLength);
		json.put("checkSum", checkSum);
		json.put("data", data);
		return json.toJSONString();
	}

}
