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
	JPanel p1 = new JPanel(new GridLayout(14, 1));
	JPanel p2 = new JPanel(new GridLayout(14, 1));
	JPanel p3 = new JPanel(new GridLayout(1, 4));
		
	JLabel versionP1 = new JLabel("Ver: ");
	JLabel headerLengthP1 = new JLabel("Header Length: ");
	JLabel typeOfServiceP1 = new JLabel("Type Of Service: ");
	JLabel identificationP1 = new JLabel("Identification: ");
	JLabel timeToLiveP1 = new JLabel("Time To Live: ");
	JLabel protocolP1 = new JLabel("Protocol: ");
	JLabel totalLengthP1 = new JLabel("Total Length: ");
	JLabel flagsP1 = new JLabel("Flags: ");
	JLabel offsetP1 = new JLabel("Offset: ");
	JLabel checkSumP1 = new JLabel("CheckSum:");
	JLabel sourceAddressP1 = new JLabel("Source Address: ");
	JLabel destinationAddressP1 = new JLabel("Destination Address: ");
	JLabel optionP1 = new JLabel("Option: ");
	JLabel dataP1 = new JLabel("Data received:");
	
	JLabel versionP2 = new JLabel("Ver: ");
	JLabel headerLengthP2 = new JLabel("Header Length: ");
	JLabel typeOfServiceP2 = new JLabel("Type Of Service: ");
	JLabel identificationP2 = new JLabel("Identification: ");
	JLabel timeToLiveP2 = new JLabel("Time To Live: ");
	JLabel protocolP2 = new JLabel("Protocol: ");
	JLabel totalLengthP2 = new JLabel("Total Length: ");
	JLabel flagsP2 = new JLabel("Flags: ");
	JLabel offsetP2 = new JLabel("Offset: ");
	JLabel checkSumP2 = new JLabel("CheckSum:");
	JLabel sourceAddressP2 = new JLabel("Source Address: ");
	JLabel destinationAddressP2 = new JLabel("Destination Address: ");
	JLabel optionP2 = new JLabel("Option: ");
	JLabel dataP2 = new JLabel("Data received:");

	
	
	public DecompressorGui() {
		//check
		p1.add(versionP1);
		p1.add(headerLengthP1);
		p1.add(typeOfServiceP1);
		p1.add(identificationP1);
		p1.add(timeToLiveP1);
		p1.add(protocolP1);
		p1.add(totalLengthP1);
		p1.add(flagsP1);
		p1.add(offsetP1);
		p1.add(checkSumP1);
		p1.add(sourceAddressP1);
		p1.add(destinationAddressP1);
		p1.add(optionP1);
		p1.add(dataP1);
		p1.setBorder(new TitledBorder("Before Decompressing"));

		p2.add(versionP2);
		p2.add(headerLengthP2);
		p2.add(typeOfServiceP2);
		p2.add(identificationP2);
		p2.add(timeToLiveP2);
		p2.add(protocolP2);
		p2.add(totalLengthP2);
		p2.add(flagsP2);
		p2.add(offsetP2);
		p2.add(checkSumP2);
		p2.add(sourceAddressP2);
		p2.add(destinationAddressP2);
		p2.add(optionP2);
		p2.add(dataP2);
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
		versionP1			.setText("Ver: "+beforeIp.getVer());
		headerLengthP1		.setText("Header Length: " + beforeIp.getHeaderLength());
		typeOfServiceP1		.setText("Type Of Service: " + beforeIp.getTypeOfService());
		identificationP1	.setText("Identification: " + beforeIp.getIdentification());
		timeToLiveP1		.setText("Time To Live: " + beforeIp.getTimeToLive());
		protocolP1			.setText("Protocol: " + beforeIp.getProtocol());
		totalLengthP1		.setText("Total Length: " + beforeIp.getTotalLength());
		flagsP1				.setText("Flags: " + beforeIp.getFlags());
		offsetP1			.setText("Offset: " + beforeIp.getOffset());
		checkSumP1			.setText("CheckSum: " + beforeIp.getCheckSum());
		sourceAddressP1		.setText("Source Address: " + beforeIp.getSourceAddress());
		destinationAddressP1.setText("Destination Address: " + beforeIp.getDestinationAddress());
		optionP1			.setText("Option: " + beforeIp.getOption());
		dataP1				.setText("Data Received: " + beforeIp.getData());
		
		
		versionP2			.setText("Ver: "+afterIp.getVer());
		headerLengthP2		.setText("Header Length: " + afterIp.getHeaderLength());
		typeOfServiceP2		.setText("Type Of Service: " + afterIp.getTypeOfService());
		identificationP2	.setText("Identification: " + afterIp.getIdentification());
		timeToLiveP2		.setText("Time To Live: " + afterIp.getTimeToLive());
		protocolP2			.setText("Protocol: " + afterIp.getProtocol());
		totalLengthP2		.setText("Total Length: " + afterIp.getTotalLength());
		flagsP2				.setText("Flags: " + afterIp.getFlags());
		offsetP2			.setText("Offset: " + afterIp.getOffset());
		checkSumP2			.setText("CheckSum: " + afterIp.getCheckSum());
		sourceAddressP2		.setText("Source Address: " + afterIp.getSourceAddress());
		destinationAddressP2.setText("Destination Address: " + afterIp.getDestinationAddress());
		optionP2			.setText("Option: " + afterIp.getOption());
		dataP2				.setText("Data Received: " + afterIp.getData());
		
		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}
}
