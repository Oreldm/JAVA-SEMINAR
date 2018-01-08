package Decompressor;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;

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
	
	JLabel numberOfPackets = new JLabel("Number Of Packets:");
	JLabel bitsSaved = new JLabel("Data saved:");
	private static int bitsSavedCounter=0;
	private static int numberOfPacketCounter=0;
	
	public DecompressorGui() {
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

		p3.add(numberOfPackets);
		p3.add(new JLabel());
		p3.add(bitsSaved);
		p3.add(new JLabel());

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		frame.pack();
		frame.setTitle("Decompressor");
		frame.setSize(600, 400);
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

	public void updateGui(UDP beforeUDP, UDP afterUDP) {
		cleanGui();
		versionP1.setText("Source Port: " + beforeUDP.getSourcePort());
		headerLengthP1.setText("Destination Port: " + beforeUDP.getDestPort());
		typeOfServiceP1.setText("Lenght: " + beforeUDP.getUdpLength());
		identificationP1.setText("CheckSum: " + beforeUDP.getUdpChecksum());
		identificationP1.setText("Data Received: " + beforeUDP.getData());

		versionP2.setText("Source Port: " + afterUDP.getSourcePort());
		headerLengthP2.setText("Destination Port: " + afterUDP.getDestPort());
		typeOfServiceP2.setText("Lenght: " + afterUDP.getUdpLength());
		identificationP2.setText("CheckSum: " + afterUDP.getUdpChecksum());
		identificationP2.setText("Data Received: " + afterUDP.getData());
		
		bitsSavedCounter+=bitsSavedCalc(beforeUDP,afterUDP);
		numberOfPacketCounter++;
		numberOfPackets.setText("Number Of Packets: "+numberOfPacketCounter);
		bitsSaved.setText("Data saved: "+bitsSavedCounter + " bits");
		
		
		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}

	public void updateGui(TCP beforeTCP, TCP afterTCP) {
		cleanGui();
		versionP1.setText("Source Port: " + beforeTCP.getSourcePort());
		headerLengthP1.setText("Destination Port: " + beforeTCP.getDestinationPort());
		typeOfServiceP1.setText("Sequence Number: " + beforeTCP.getSequenceNumber());
		identificationP1.setText("Acknowledge number: " + beforeTCP.getAckNumber());
		timeToLiveP1.setText("Data Offset: " + beforeTCP.getDataOffset());
		protocolP1.setText("Reserved: " + beforeTCP.getReserved());
		totalLengthP1.setText("Flags: " + beforeTCP.getFlags());
		flagsP1.setText("Window: " + beforeTCP.getWindow());
		checkSumP1.setText("CheckSum: " + beforeTCP.getCheckSum());
		sourceAddressP1.setText("Urgent Pointer: " + beforeTCP.getUrgentPointer());
		destinationAddressP1.setText("Options: " + beforeTCP.getOptions());
		optionP1.setText("Padding: " + beforeTCP.getPadding());
		dataP1.setText("Data Received: " + beforeTCP.getData());

		versionP2.setText("Source Port: " + afterTCP.getSourcePort());
		headerLengthP2.setText("Destination Port: " + afterTCP.getDestinationPort());
		typeOfServiceP2.setText("Sequence Number: " + afterTCP.getSequenceNumber());
		identificationP2.setText("Acknowledge number: " + afterTCP.getAckNumber());
		timeToLiveP2.setText("Data Offset: " + afterTCP.getDataOffset());
		protocolP2.setText("Reserved: " + afterTCP.getReserved());
		totalLengthP2.setText("Flags: " + afterTCP.getFlags());
		flagsP2.setText("Window: " + afterTCP.getWindow());
		checkSumP2.setText("CheckSum: " + afterTCP.getCheckSum());
		sourceAddressP2.setText("Urgent Pointer: " + afterTCP.getUrgentPointer());
		destinationAddressP2.setText("Options: " + afterTCP.getOptions());
		optionP2.setText("Padding: " + afterTCP.getPadding());
		dataP2.setText("Data Received: " + afterTCP.getData());
		
		bitsSavedCounter+=bitsSavedCalc(beforeTCP,afterTCP);
		numberOfPacketCounter++;
		numberOfPackets.setText("Number Of Packets: "+numberOfPacketCounter);
		bitsSaved.setText("Data saved: "+bitsSavedCounter + " bits");

		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}

	
	public void updateGui(IP beforeIp, IP afterIp) {
		cleanGui();
		versionP1.setText("Ver: " + beforeIp.getVer());
		headerLengthP1.setText("Header Length: " + beforeIp.getHeaderLength());
		typeOfServiceP1.setText("Type Of Service: " + beforeIp.getTypeOfService());
		identificationP1.setText("Identification: " + beforeIp.getIdentification());
		timeToLiveP1.setText("Time To Live: " + beforeIp.getTimeToLive());
		protocolP1.setText("Protocol: " + beforeIp.getProtocol());
		totalLengthP1.setText("Total Length: " + beforeIp.getTotalLength());
		flagsP1.setText("Flags: " + beforeIp.getFlags());
		offsetP1.setText("Offset: " + beforeIp.getOffset());
		checkSumP1.setText("CheckSum: " + beforeIp.getCheckSum());
		sourceAddressP1.setText("Source Address: " + beforeIp.getSourceAddress());
		destinationAddressP1.setText("Destination Address: " + beforeIp.getDestinationAddress());
		optionP1.setText("Option: " + beforeIp.getOption());
		dataP1.setText("Data Received: " + beforeIp.getData());

		versionP2.setText("Ver: " + afterIp.getVer());
		headerLengthP2.setText("Header Length: " + afterIp.getHeaderLength());
		typeOfServiceP2.setText("Type Of Service: " + afterIp.getTypeOfService());
		identificationP2.setText("Identification: " + afterIp.getIdentification());
		timeToLiveP2.setText("Time To Live: " + afterIp.getTimeToLive());
		protocolP2.setText("Protocol: " + afterIp.getProtocol());
		totalLengthP2.setText("Total Length: " + afterIp.getTotalLength());
		flagsP2.setText("Flags: " + afterIp.getFlags());
		offsetP2.setText("Offset: " + afterIp.getOffset());
		checkSumP2.setText("CheckSum: " + afterIp.getCheckSum());
		sourceAddressP2.setText("Source Address: " + afterIp.getSourceAddress());
		destinationAddressP2.setText("Destination Address: " + afterIp.getDestinationAddress());
		optionP2.setText("Option: " + afterIp.getOption());
		dataP2.setText("Data Received: " + afterIp.getData());
		
		bitsSavedCounter+=bitsSavedCalc(beforeIp,afterIp);
		numberOfPacketCounter++;
		numberOfPackets.setText("Number Of Packets: "+numberOfPacketCounter);
		bitsSaved.setText("Data saved: "+bitsSavedCounter + " bits");

		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}

	
	

	public int bitsSavedCalc(UDP beforeUDP, UDP afterUDP) {
		int before=beforeUDP.getDestPort()+beforeUDP.getSourcePort()+beforeUDP.getUdpChecksum()+
				beforeUDP.getUdpLength();
		int after=afterUDP.getDestPort()+afterUDP.getSourcePort()+afterUDP.getUdpChecksum()+
				afterUDP.getUdpLength();
		
		if(before>after) //for first time
			return before-after;
		
		return after-before;
	}
	
	public int bitsSavedCalc(IP beforeIP, IP afterIP) {
		int before= beforeIP.getCheckSum()+beforeIP.getDestinationAddress()+beforeIP.getFlags()+
				beforeIP.getHeaderLength()+beforeIP.getIdentification()+beforeIP.getOffset()+beforeIP.getOption()+
				beforeIP.getProtocol()+beforeIP.getSourceAddress()+beforeIP.getSourceAddress()+beforeIP.getTimeToLive()+
				beforeIP.getTotalLength()+beforeIP.getVer();
		
		int after= afterIP.getCheckSum()+afterIP.getDestinationAddress()+afterIP.getFlags()+
				afterIP.getHeaderLength()+afterIP.getIdentification()+afterIP.getOffset()+afterIP.getOption()+
				afterIP.getProtocol()+afterIP.getSourceAddress()+afterIP.getSourceAddress()+afterIP.getTimeToLive()+
				afterIP.getTotalLength()+beforeIP.getVer();
		
		if(before>after) //for first time
			return before-after;
		
		return after-before;
	}
	
	public int bitsSavedCalc(TCP beforeTCP, TCP afterTCP) {
		int before=beforeTCP.getAckNumber()+beforeTCP.getCheckSum()+beforeTCP.getDataOffset()+
				beforeTCP.getDestinationPort()+beforeTCP.getFlags()+beforeTCP.getOptions()+
				beforeTCP.getPadding()+beforeTCP.getReserved()+beforeTCP.getSequenceNumber()+
				beforeTCP.getSourcePort()+beforeTCP.getUrgentPointer()+beforeTCP.getWindow();
		
		int after=afterTCP.getAckNumber()+afterTCP.getCheckSum()+afterTCP.getDataOffset()+
				afterTCP.getDestinationPort()+afterTCP.getFlags()+afterTCP.getOptions()+
				afterTCP.getPadding()+afterTCP.getReserved()+afterTCP.getSequenceNumber()+
				afterTCP.getSourcePort()+afterTCP.getUrgentPointer()+afterTCP.getWindow();
		
		if(before>after) //for first time
			return before-after;
		
		return after-before;
	}
	
	
	public void cleanGui() {
		versionP1.setText("");
		headerLengthP1.setText("");
		typeOfServiceP1.setText("");
		identificationP1.setText("");
		timeToLiveP1.setText("");
		protocolP1.setText("");
		totalLengthP1.setText("");
		flagsP1.setText("");
		offsetP1.setText("");
		checkSumP1.setText("");
		sourceAddressP1.setText("");
		destinationAddressP1.setText("");
		optionP1.setText("");
		dataP1.setText("");

		versionP2.setText("");
		headerLengthP2.setText("");
		typeOfServiceP2.setText("");
		identificationP2.setText("");
		timeToLiveP2.setText("");
		protocolP2.setText("");
		totalLengthP2.setText("");
		flagsP2.setText("");
		offsetP2.setText("");
		checkSumP2.setText("");
		sourceAddressP2.setText("");
		destinationAddressP2.setText("");
		optionP2.setText("");
		dataP2.setText("");

		p1.repaint();
		p2.repaint();
		p3.repaint();
		this.repaint();
	}
}
