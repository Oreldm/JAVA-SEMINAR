package Decompressor;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Compressor.CompressorGui;

<<<<<<< HEAD
import Layer3.IP;
public class DecompressorGui extends JFrame { 
	  
  public DecompressorGui() {
	  
	IP ip = DecompressorAlgorithm.lastPacket;
	
	JPanel p1 = new JPanel(new GridLayout(14, 2));
	 p1.add(new JLabel("Ver: "));
	    p1.add(new JLabel(String.valueOf(ip.getVer())));
	    p1.add(new JLabel("Header Length: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Type Of Service: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Identification: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Time To Live: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Protocol: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Total Length: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Flags: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Offset: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("CheckSum:"));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Source Address: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Destination Address:"));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Option: "));
	    p1.add(new JLabel());
	    p1.add(new JLabel("Data received:"));
	    p1.add(new JLabel());
    p1.setBorder(new TitledBorder("Before Decompressing"));
    
    
    JPanel p2 = new JPanel(new GridLayout(14, 2));
    p2.add(new JLabel("Ver: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Header Length: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Type Of Service: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Identification: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Time To Live: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Protocol: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Total Length: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Flags: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Offset: "));
    p2.add(new JLabel());
    p2.add(new JLabel("CheckSum:"));
    p2.add(new JLabel());
    p2.add(new JLabel("Source Address: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Destination Address:"));
    p2.add(new JLabel());
    p2.add(new JLabel("Option: "));
    p2.add(new JLabel());
    p2.add(new JLabel("Data received:"));
    p2.add(new JLabel());
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
=======
public class DecompressorGui extends JFrame {

	public DecompressorGui() {
		JPanel p1 = new JPanel(new GridLayout(14, 2));
		p1.add(new JLabel("identification: "));
		p1.add(new JLabel(""));// enter identification!
		p1.add(new JLabel("Data received:"));
		p1.add(new JLabel());
		;// add the data
		p1.setBorder(new TitledBorder("Before Decompressing"));

		JPanel p2 = new JPanel(new GridLayout(14, 2));
		p2.add(new JLabel("Ver: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Header Length: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Type Of Service: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Identification: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Time To Live: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Protocol: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Total Length: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Flags: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Offset: "));
		p2.add(new JLabel());
		p2.add(new JLabel("CheckSum:"));
		p2.add(new JLabel());
		p2.add(new JLabel("Source Address: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Destination Address:"));
		p2.add(new JLabel());
		p2.add(new JLabel("Option: "));
		p2.add(new JLabel());
		p2.add(new JLabel("Data received:"));
		p2.add(new JLabel());
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
>>>>>>> 6ef6d20c27b6d5909c3c6e32553a0d937d014603
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
