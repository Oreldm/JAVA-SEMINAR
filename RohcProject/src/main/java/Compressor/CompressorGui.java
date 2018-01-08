package Compressor;

import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Layer2.EthernetFrame;
import Layer3.IP;
import Layer4.TCP;
import Layer4.UDP;
import Utils.Utils;

public class CompressorGui extends JFrame {

	private JTextField data = new JTextField();
	private Font font = new Font("Californian FB", Font.BOLD, 15);

	private String ipString;
	private String dataString;

	private String serverName = "localhost";
	private int port = 6000;
	private CompressorAlgorithm compressor = new CompressorAlgorithm();

	JPanel p1 = new JPanel(new GridLayout(2, 2));
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	public CompressorGui() {
		startMenu();
	}

	public void startMenu() {
		GridLayout grid = new GridLayout(1, 3);
		grid.setHgap(23);
		grid.setVgap(100);
		p1 = new JPanel(grid);
		p1.setBorder(new TitledBorder("Chose Your Option"));

		JButton IP = new JButton("IP");
		JButton TCP = new JButton("TCP");
		JButton UDP = new JButton("UDP");
		p1.add(IP);
		p1.add(TCP);
		p1.add(UDP);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.NORTH);
		add(p4, BorderLayout.WEST);
		add(p5, BorderLayout.EAST);
		IP.addActionListener(new IPButtonListener());
		TCP.addActionListener(new TCPButtonListener());
		UDP.addActionListener(new UDPButtonListener());
	}

	public void updateToIp() {
		setPreferredSize(new Dimension(1000, 280));
		pack();
		p1.removeAll();
		p2.removeAll();
		p1.setLayout(new GridLayout(7, 2));
		p1.setBorder(new TitledBorder("Enter ip and data to send"));

		final JTextField option = new JTextField();
		final JTextField ver = new JTextField();
		final JTextField headerLength = new JTextField();
		final JTextField typeOfService = new JTextField();
		final JTextField identification = new JTextField();
		final JTextField timeToLive = new JTextField();
		final JTextField protocol = new JTextField();
		final JTextField totalLength = new JTextField();
		final JTextField flags = new JTextField();
		final JTextField offset = new JTextField();
		final JTextField checkSum = new JTextField();
		final JTextField sourceAddress = new JTextField();
		final JTextField destinationAddress = new JTextField();
		JButton tcpButton = new JButton("TCP");
		JButton udpButton = new JButton("UDP");
		JButton sendButton = new JButton("Send");

		option.setFont(font);
		ver.setFont(font);
		headerLength.setFont(font);
		typeOfService.setFont(font);
		identification.setFont(font);
		timeToLive.setFont(font);
		protocol.setFont(font);
		totalLength.setFont(font);
		flags.setFont(font);
		offset.setFont(font);
		checkSum.setFont(font);
		sourceAddress.setFont(font);
		destinationAddress.setFont(font);
		data.setFont(font);

		p1.add(new JLabel("Source address"));
		p1.add(sourceAddress);
		p1.add(new JLabel("Destination address"));
		p1.add(destinationAddress);
		p1.add(new JLabel("option"));
		p1.add(option);
		p1.add(new JLabel("ver"));
		p1.add(ver);
		p1.add(new JLabel("headerLength"));
		p1.add(headerLength);
		p1.add(new JLabel("typeOfService"));
		p1.add(typeOfService);
		p1.add(new JLabel("identification"));
		p1.add(identification);
		p1.add(new JLabel("timeToLive"));
		p1.add(timeToLive);
		p1.add(new JLabel("protocol"));
		p1.add(protocol);
		p1.add(new JLabel("totalLength"));
		p1.add(totalLength);
		p1.add(new JLabel("flags"));
		p1.add(flags);
		p1.add(new JLabel("offset"));
		p1.add(offset);
		p1.add(new JLabel("checkSum"));
		p1.add(checkSum);
		p1.add(new JLabel("Data"));
		p1.add(data);
		p2.add(sendButton);
		p2.add(tcpButton);
		p2.add(udpButton);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket client = new Socket(serverName, port);
					IP ip = new IP(Integer.parseInt(ver.getText()), Integer.parseInt(headerLength.getText()),
							Integer.parseInt(typeOfService.getText()), Integer.parseInt(identification.getText()),
							Integer.parseInt(timeToLive.getText()), Integer.parseInt(protocol.getText()),
							Integer.parseInt(totalLength.getText()), Integer.parseInt(offset.getText()),
							Integer.parseInt(flags.getText()), Integer.parseInt(checkSum.getText()),
							Integer.parseInt(sourceAddress.getText()), Integer.parseInt(destinationAddress.getText()),
							Integer.parseInt(option.getText()), data.getText(), null);
					IP compressedIP = compressor.compress(ip);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					out.writeUTF(compressedIP.toString()); // Actual Place to put string

					client.close();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		tcpButton.addActionListener(new TCPButtonListener());
		udpButton.addActionListener(new UDPButtonListener());
		p1.repaint();
		p2.repaint();
		// For Update
		SwingUtilities.updateComponentTreeUI(p1);
		SwingUtilities.updateComponentTreeUI(p2);
	}

	public void updateToTcp() {

		setPreferredSize(new Dimension(1000, 280));
		pack();
		p1.removeAll();
		p2.removeAll();
		p1.setLayout(new GridLayout(7, 2));
		p1.setBorder(new TitledBorder("TCP MENU"));

		final JTextField sourcePort = new JTextField();
		final JTextField destinationPort = new JTextField();
		final JTextField sequenceNumber = new JTextField();
		final JTextField ackNumber = new JTextField();
		final JTextField dataOffset = new JTextField();
		final JTextField reserved = new JTextField();
		final JTextField flags = new JTextField();
		final JTextField window = new JTextField();
		final JTextField checkSum = new JTextField();
		final JTextField urgentPointer = new JTextField();
		final JTextField options = new JTextField();
		final JTextField padding = new JTextField();
		JButton ipButton = new JButton("IP");
		JButton udpButton = new JButton("UDP");
		JButton sendButton = new JButton("Send");

		sourcePort.setFont(font);
		destinationPort.setFont(font);
		sequenceNumber.setFont(font);
		ackNumber.setFont(font);
		dataOffset.setFont(font);
		reserved.setFont(font);
		flags.setFont(font);
		window.setFont(font);
		checkSum.setFont(font);
		urgentPointer.setFont(font);
		options.setFont(font);
		padding.setFont(font);
		data.setFont(font);

		p1.add(new JLabel("Source Port"));
		p1.add(sourcePort);
		p1.add(new JLabel("Destination Port"));
		p1.add(destinationPort);
		p1.add(new JLabel("Sequence Number"));
		p1.add(sequenceNumber);
		p1.add(new JLabel("ackNumber"));
		p1.add(ackNumber);
		p1.add(new JLabel("dataOffset"));
		p1.add(dataOffset);
		p1.add(new JLabel("reserved"));
		p1.add(reserved);
		p1.add(new JLabel("flags"));
		p1.add(flags);
		p1.add(new JLabel("checkSum"));
		p1.add(checkSum);
		p1.add(new JLabel("urgentPointer"));
		p1.add(urgentPointer);
		p1.add(new JLabel("window"));
		p1.add(window);
		p1.add(new JLabel("options"));
		p1.add(options);
		p1.add(new JLabel("padding"));
		p1.add(padding);
		p1.add(new JLabel("Data"));
		p1.add(data);
		p2.add(sendButton);
		p2.add(ipButton);
		p2.add(udpButton);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket client = new Socket(serverName, port);

					TCP tcp = new TCP(Integer.parseInt(sourcePort.getText()),
							Integer.parseInt(destinationPort.getText()), Integer.parseInt(sequenceNumber.getText()),
							Integer.parseInt(ackNumber.getText()), Integer.parseInt(dataOffset.getText()),
							Integer.parseInt(reserved.getText()), Integer.parseInt(flags.getText()),
							Integer.parseInt(window.getText()), Integer.parseInt(checkSum.getText()),
							Integer.parseInt(urgentPointer.getText()), Integer.parseInt(options.getText()),
							Integer.parseInt(padding.getText()), data.getText(), null);
					TCP tcpToSend = compressor.compress(tcp);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					System.out.println(tcpToSend.toString());
					out.writeUTF(tcpToSend.toString());

					client.close();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		ipButton.addActionListener(new IPButtonListener());
		udpButton.addActionListener(new UDPButtonListener());
		p1.repaint();
		p2.repaint();
		// For Update
		SwingUtilities.updateComponentTreeUI(p1);
		SwingUtilities.updateComponentTreeUI(p2);
	}

	public void updateToUdp() {
		setPreferredSize(new Dimension(1000, 280));
		pack();
		p1.removeAll();
		p2.removeAll();
		p1.setLayout(new GridLayout(7, 2));
		p1.setBorder(new TitledBorder("UDP MENU"));

		/**
		 * private int sourcePort; private int destPort; private int udpLength; private
		 * int udpChecksum; private String data;
		 */

		final JTextField sourcePort = new JTextField();
		final JTextField destPort = new JTextField();
		final JTextField udpLength = new JTextField();
		final JTextField udpChecksum = new JTextField();
		final JTextField data = new JTextField();
		JButton ipButton = new JButton("IP");
		JButton tcpButton = new JButton("TCP");
		JButton sendButton = new JButton("Send");

		sourcePort.setFont(font);
		destPort.setFont(font);
		udpLength.setFont(font);
		udpChecksum.setFont(font);
		data.setFont(font);

		p1.add(new JLabel("Source address"));
		p1.add(sourcePort);
		p1.add(new JLabel("Destination address"));
		p1.add(destPort);
		p1.add(new JLabel("udpLength"));
		p1.add(udpLength);
		p1.add(new JLabel("udpChecksum"));
		p1.add(udpChecksum);
		p1.add(new JLabel("Data"));
		p1.add(data);
		p2.add(sendButton);
		p2.add(ipButton);
		p2.add(tcpButton);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket client = new Socket(serverName, port);

					UDP udp = new UDP(Integer.parseInt(sourcePort.getText()), Integer.parseInt(destPort.getText()),
							Integer.parseInt(udpLength.getText()), Integer.parseInt(udpChecksum.getText()),
							data.getText());
					UDP udpToReturn = compressor.compress(udp);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					out.writeUTF(udpToReturn.toString()); // Actual Place to put string
					
					client.close();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		ipButton.addActionListener(new IPButtonListener());
		tcpButton.addActionListener(new TCPButtonListener());
		p1.repaint();
		p2.repaint();
		// For Update
		SwingUtilities.updateComponentTreeUI(p1);
		SwingUtilities.updateComponentTreeUI(p2);
	}

	private class TCPButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("in");
			updateToTcp();
		}
	}

	private class UDPButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			updateToUdp();
		}
	}

	private class IPButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("in");
			updateToIp();
		}
	}

	static int counter = 0;

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String ipString = ipAdress.getText();
			String dataString = data.getText();
			try {
				Socket client = new Socket(serverName, port);
				// System.out.println("Just connected to " + client.getRemoteSocketAddress());
				// OutputStream outToServer = client.getOutputStream();

				if (counter < 2) {
					IP ip = new IP(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, "asdsadsadsa", null);
					IP a = compressor.compress(ip);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					out.writeUTF(a.toString()); // Actual Place to put string
					counter++;
				} else if (counter < 4) {
					TCP tcp = Utils.getTcpObject();
					TCP a = compressor.compress(tcp);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					out.writeUTF(a.toString()); // Actual Place to put string

					counter++;
				} else {
					UDP udp = Utils.getUdpObject();
					UDP a = compressor.compress(udp);

					/** Send Stream **/
					OutputStream outToServer = client.getOutputStream();
					DataOutputStream out = new DataOutputStream(outToServer);
					out.writeUTF(a.toString()); // Actual Place to put string
				}

				/** Recieve from Server **/
				// InputStream inFromServer = client.getInputStream();
				// DataInputStream in = new DataInputStream(inFromServer);
				// System.out.println("Server says " + in.readUTF());

				client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		CompressorGui frame = new CompressorGui();
		frame.pack();
		frame.setTitle("Compressor");
		frame.setSize(400, 120);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
}
