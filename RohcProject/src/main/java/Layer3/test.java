package Layer3;

public class test {
	public static void main(String[] args) {

		IP ip= new IP(1, 2, 3, 4, 5, 6, 7, 4, 4, 7, 8, 2, 3, "asdsadsadsa", null);
		System.out.println(ip.toString());
		CompressedIp a= new CompressedIp(ip);
		System.out.println(a);
		
	}
}
