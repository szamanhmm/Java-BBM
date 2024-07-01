
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.List;
import java.util.ArrayList;

public class HomepageAdmin {
	public JFrame frame;
	ArrayList<User> donerList = new ArrayList<User>();
	ArrayList<User> reciverList = new ArrayList<User>();


	public HomepageAdmin() {
		this.getDonersRecievers();
		initialize();
	}

	public void getDonersRecievers() {
		this.donerList = new ArrayList<User>();
		this.reciverList = new ArrayList<User>();
		Bank obank = new Bank("Shonali");
		for (User d : obank.userList) {
			if (d.getUSerType() == 1) {
				this.donerList.add(d);
			} else if (d.getUSerType() == 2) {
				this.reciverList.add(d);
			}

			// something here
		}
		System.out.println(this.donerList);
		System.out.println(this.reciverList);

	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSeeDoner = new JButton("Doners");
		btnSeeDoner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeeDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int additionalWidth = 20;
				int initialYpoint = 70;
				JLabel label3 = new JLabel("Doners");
				initialYpoint += additionalWidth;
				label3.setBounds(40, 70, 300, 50);
				frame.getContentPane().add(label3);
				for (User d : donerList) {
					JLabel label = new JLabel("username:" + d.username + ", bloodType:" + d.getBloodType()
							+ " Contact No.:" + d.getContact());
					initialYpoint += additionalWidth;
					label.setBounds(40, initialYpoint, 600, 35);
					frame.getContentPane().add(label);
				}
			}
		});
		btnSeeDoner.setForeground(Color.RED);
		btnSeeDoner.setBounds(40, 198, 120, 35);
		frame.getContentPane().add(btnSeeDoner);

		JButton btnSeeRecievers = new JButton("Recivers");
		btnSeeRecievers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeeRecievers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int additionalWidth = 20;
				int initialYpoint = 70;
				JLabel label3 = new JLabel("Recievers");
				initialYpoint += additionalWidth;
				label3.setBounds(700, 70, 300, 50);
				frame.getContentPane().add(label3);
				for (User d : reciverList) {
					JLabel label = new JLabel("username:" + d.username + ", needed Blood Type:" + d.getBloodType()
							+ ", Contact No.:" + d.getContact());
					initialYpoint += additionalWidth;
					label.setBounds(700, initialYpoint, 800, 35);
					frame.getContentPane().add(label);
				}
			}
		});
		btnSeeRecievers.setForeground(Color.BLACK);
		btnSeeRecievers.setBounds(180, 198, 120, 35);
		frame.getContentPane().add(btnSeeRecievers);

		JButton btnBack = new JButton("Back");
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
