package Decompressor;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Compressor.CompressorGui;

public class DecompressorGui extends JFrame {
	
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
	
	public DecompressorGui() {
		//check
		JPanel p1 = new JPanel(new GridLayout(14, 2));
		p1.add(new JLabel("Ver: "));
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
		;// add the data
		p1.setBorder(new TitledBorder("Before Decompressing"));

		JPanel p2 = new JPanel(new GridLayout(14, 2));
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

		JPanel p3 = new JPanel(new GridLayout(1, 4));
		p3.add(new JLabel("Number of packets: "));
		p3.add(new JLabel());
		p3.add(new JLabel("Data saved:"));
		p3.add(new JLabel());

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		DecompressorGui frame = new DecompressorGui();
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
}
