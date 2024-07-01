
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HomepageUser {
	public JFrame frame;
	public String loginUserName = "";
	public String loginPassword = "";
	public User currUser;

	
	public HomepageUser(String username, String pass) {
		this.loginUserName = username;
		this.loginPassword = pass;
		Bank obank = new Bank("WoldBank");
		for (User d : obank.userList) {
			if (loginUserName.compareTo(d.username) == 0 && loginPassword.compareTo(d.password) == 0) {
				this.currUser = d;
				break;
			}
		}
		
		initialize();
	}
	   private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.BOLD, 11));
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// donate btn..
		JButton btnSeeDoner = new JButton("Donate");
		btnSeeDoner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeeDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currUser.donate();
				JOptionPane.showMessageDialog(null, "You registered for the donation of blood !", "Success !",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSeeDoner.setForeground(Color.GREEN);
		btnSeeDoner.setBounds(40, 198, 120, 35);
		frame.getContentPane().add(btnSeeDoner);

		JTextField txtField3 = new JTextField();
		txtField3.setBounds(180, 160, 120, 35);
		frame.getContentPane().add(txtField3);

		// recieve btn..
		JButton btnSeeRecievers = new JButton("Recive blood");
		btnSeeRecievers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeeRecievers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodSearch = txtField3.getText();
				if (bloodSearch == "") {
					JOptionPane.showMessageDialog(null, "PLease write a blood group on the box", "Success !",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				currUser.getBloodSupply(bloodSearch);
				JOptionPane.showMessageDialog(null,
						"You requested for " + bloodSearch + " blood. please wait for our confirmation !", "Success !\nInformation is written in the file.\nPlease open info.txt file.",
						JOptionPane.INFORMATION_MESSAGE);
				
				//Searching blood group
				for(int i=0; i<Bank.userList.size(); i++) {
					if((Bank.userList.get(i).getBloodType()).equals(bloodSearch)) {
						File infoFile = new File("info.txt");
						try {
							if(!infoFile.exists())
								infoFile.createNewFile();
							FileWriter fw = new FileWriter(infoFile,true);
							PrintWriter output = new PrintWriter(fw);
							
							output.println("Donor Name : "+Bank.userList.get(i).getName());
							output.println("Contact : "+Bank.userList.get(i).getContact());
							output.println("Blood Group : "+Bank.userList.get(i).getBloodType());
							output.println();
							output.close();
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Couldn't open the file. File missing!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No matching Blood group found!", "SORRY",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnSeeRecievers.setForeground(Color.BLACK);
		btnSeeRecievers.setBounds(180, 198, 120, 35);
		frame.getContentPane().add(btnSeeRecievers);

		// back to login btn
		JButton btnBack = new JButton("" + "Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login oLogin = new Login();
				oLogin.frame.setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(320, 198, 120, 35);
		frame.getContentPane().add(btnBack);
	}
}
