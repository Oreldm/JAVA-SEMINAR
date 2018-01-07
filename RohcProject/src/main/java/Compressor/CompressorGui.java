package Compressor;

import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Layer3.IP;

public class CompressorGui extends JFrame {

	private JTextField ipAdress = new JTextField();
	private JTextField data = new JTextField();
	private Font font = new Font("Californian FB", Font.BOLD, 15);
	private JButton sendButton = new JButton("Send");
	private String ipString;
	private String dataString;

	public CompressorGui() {
		ipAdress.setFont(font);
		data.setFont(font);
		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(new JLabel("Enter ip adress:"));
		p1.add(ipAdress);
		p1.add(new JLabel("Enter data:"));
		p1.add(data);
		p1.setBorder(new TitledBorder("Enter ip and data to send"));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(sendButton);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		sendButton.addActionListener(new ButtonListener());
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ipString = ipAdress.getText();
			String dataString = data.getText();
			String serverName = "localhost";
			int port = 6000;
			try {
				// System.out.println("Connecting to " + serverName + " on port " + port);
				Socket client = new Socket(serverName, port);

				// System.out.println("Just connected to " + client.getRemoteSocketAddress());
				// OutputStream outToServer = client.getOutputStream();

				IP ip = new IP(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, "asdsadsadsa", null);
				CompressorAlgorithm compressor= new CompressorAlgorithm();
				IP a = compressor.compress(ip);
			
				
				/** Send Stream **/
				OutputStream outToServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				out.writeUTF(a.toString()); // Actual Place to put string
				
				
				//second
				IP x = new IP(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, "asdsadsadsa", null);
				IP y = compressor.compress(x);
				
				System.out.println("Here is Y " + y.toString());
			
				
				/** Send Stream **/
				outToServer = client.getOutputStream();
				out = new DataOutputStream(outToServer);
				out.writeUTF(y.toString()); // Actual Place to put string
				
				

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
		frame.setSize(400, 180);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
}
