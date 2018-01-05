package Compressor;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class CompressorGui extends JFrame { 
	
  private JTextField ipAdress = new JTextField();
  private JTextField data = new JTextField();
  private Font font = new Font("Californian FB", Font.BOLD, 15);
  private JButton sendButton = new JButton("Send");
  
  public CompressorGui() {
	ipAdress.setFont(font);
	data.setFont(font);
	JPanel p1 = new JPanel(new GridLayout(5, 2));
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
     }
  }
  public static void main(String[] args) {
	CompressorGui frame = new CompressorGui();
    frame.pack();
    frame.setTitle("Compressor");
    frame.setSize(500,300);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);             }
}
