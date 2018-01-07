package Decompressor;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Layer3.IP;

public class DecompressorGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DecompressorGui frame = new DecompressorGui();
	JPanel p1 = new JPanel(new GridLayout(14, 2));
	JPanel p2 = new JPanel(new GridLayout(14, 2));
	JPanel p3 = new JPanel(new GridLayout(1, 4));
	
	private String beforeVer;
	private String beforeHeaderLength;
	private String beforeTypeOfService;
	private String beforeIdentification;
	private String beforeTimeToLive;
	private String beforeProtocol;
	private String beforeTotalLength;
	private String beforeFlags;
	private String beforeOffset;
	private String beforeCheckSum;
	private String beforeSourceAddress;
	private String beforeDestinationAddress;
	private String beforeOption;
	private String beforeData;
	
	private String afterVer;
	private String afterHeaderLength;
	private String afterTypeOfService;
	private String afterIdentification;
	private String afterTimeToLive;
	private String afterProtocol;
	private String afterTotalLength;
	private String afterFlags;
	private String afterOffset;
	private String afterCheckSum;
	private String afterSourceAddress;
	private String afterDestinationAddress;
	private String afterOption;
	private String afterData;
	
	JLabel versionP1 = new JLabel("Ver: ");
	
	
	public DecompressorGui() {
		//check
		p1.add(versionP1);
		p1.add(new JLabel(beforeVer));
		p1.add(new JLabel("Header Length: "));
		p1.add(new JLabel(beforeHeaderLength));
		p1.add(new JLabel("Type Of Service: "));
		p1.add(new JLabel(beforeTypeOfService));
		p1.add(new JLabel("Identification: "));
		p1.add(new JLabel(beforeIdentification));
		p1.add(new JLabel("Time To Live: "));
		p1.add(new JLabel(beforeTimeToLive));
		p1.add(new JLabel("Protocol: "));
		p1.add(new JLabel(beforeProtocol));
		p1.add(new JLabel("Total Length: "));
		p1.add(new JLabel(beforeTotalLength));
		p1.add(new JLabel("Flags: "));
		p1.add(new JLabel(beforeFlags));
		p1.add(new JLabel("Offset: "));
		p1.add(new JLabel(beforeOffset));
		p1.add(new JLabel("CheckSum:"));
		p1.add(new JLabel(beforeCheckSum));
		p1.add(new JLabel("Source Address: "));
		p1.add(new JLabel(beforeSourceAddress));
		p1.add(new JLabel("Destination Address:"));
		p1.add(new JLabel(beforeDestinationAddress));
		p1.add(new JLabel("Option: "));
		p1.add(new JLabel(beforeOption));
		p1.add(new JLabel("Data received:"));
		p1.add(new JLabel(beforeData));
		p1.setBorder(new TitledBorder("Before Decompressing"));

		p2.add(new JLabel("Ver: "));
		p2.add(new JLabel(afterVer));
		p2.add(new JLabel("Header Length: "));
		p2.add(new JLabel(afterHeaderLength));
		p2.add(new JLabel("Type Of Service: "));
		p2.add(new JLabel(afterTypeOfService));
		p2.add(new JLabel("Identification: "));
		p2.add(new JLabel(afterIdentification));
		p2.add(new JLabel("Time To Live: "));
		p2.add(new JLabel(afterTimeToLive));
		p2.add(new JLabel("Protocol: "));
		p2.add(new JLabel(afterProtocol));
		p2.add(new JLabel("Total Length: "));
		p2.add(new JLabel(afterTotalLength));
		p2.add(new JLabel("Flags: "));
		p2.add(new JLabel(afterFlags));
		p2.add(new JLabel("Offset: "));
		p2.add(new JLabel(afterOffset));
		p2.add(new JLabel("CheckSum:"));
		p2.add(new JLabel(afterCheckSum));
		p2.add(new JLabel("Source Address: "));
		p2.add(new JLabel(afterSourceAddress));
		p2.add(new JLabel("Destination Address:"));
		p2.add(new JLabel(afterDestinationAddress));
		p2.add(new JLabel("Option: "));
		p2.add(new JLabel(afterOption));
		p2.add(new JLabel("Data received:"));
		p2.add(new JLabel(afterData));
		p2.setBorder(new TitledBorder("After Decompressing"));

		p3.add(new JLabel("Number of packets: "));
		p3.add(new JLabel());
		p3.add(new JLabel("Data saved:"));
		p3.add(new JLabel());

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		frame.pack();
		frame.setTitle("Decompressor");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		
		int port = 6000;
		try {
			Thread t = new Server(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void updateGui(IP beforeIp, IP afterIp){
		versionP1.setText("Ver: "+beforeIp.getVer());
		beforeVer = String.valueOf(beforeIp.getVer());
		beforeHeaderLength = String.valueOf(beforeIp.getHeaderLength());
		beforeTypeOfService = String.valueOf(beforeIp.getTypeOfService());
		beforeIdentification = String.valueOf(beforeIp.getIdentification());
		beforeTimeToLive = String.valueOf(beforeIp.getTimeToLive());
		beforeProtocol = String.valueOf(beforeIp.getProtocol());
		beforeTotalLength = String.valueOf(beforeIp.getTotalLength());
		beforeFlags = String.valueOf(beforeIp.getFlags());
		beforeOffset = String.valueOf(beforeIp.getOffset());
		beforeCheckSum = String.valueOf(beforeIp.getCheckSum());
		beforeSourceAddress = String.valueOf(beforeIp.getSourceAddress());
		beforeDestinationAddress = String.valueOf(beforeIp.getDestinationAddress());
		beforeOption = String.valueOf(beforeIp.getOption());
		beforeData = String.valueOf(beforeIp.getData());
		
		afterVer = String.valueOf(afterIp.getVer());
		afterHeaderLength = String.valueOf(afterIp.getHeaderLength());
		afterTypeOfService = String.valueOf(afterIp.getTypeOfService());
		afterIdentification = String.valueOf(afterIp.getIdentification());
		afterTimeToLive = String.valueOf(afterIp.getTimeToLive());
		afterProtocol = String.valueOf(afterIp.getProtocol());
		afterTotalLength = String.valueOf(afterIp.getTotalLength());
		afterFlags = String.valueOf(afterIp.getFlags());
		afterOffset = String.valueOf(afterIp.getOffset());
		afterCheckSum = String.valueOf(afterIp.getCheckSum());
		afterSourceAddress = String.valueOf(afterIp.getSourceAddress());
		afterDestinationAddress = String.valueOf(afterIp.getDestinationAddress());
		afterOption = String.valueOf(afterIp.getOption());
		afterData = String.valueOf(afterIp.getData());
		
		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}
}
