
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import static javax.swing.JOptionPane.showMessageDialog;

public class Register {
	public static int id = 0;

	public JFrame registerFrame;
	private JTextField textFieldusername;
	private JTextField textFieldpassword;
	private JTextField textFieldmobileNumber;
	private JTextField textFieldBloodGroup;

	
	public Register() {
		initialize();
	}

	
	private void initialize() {
		registerFrame = new JFrame();
		registerFrame.setBounds(200, 100, 848, 468);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.getContentPane().setLayout(null);

		JLabel lblregister = new JLabel("Register form");
		lblregister.setForeground(Color.RED);
		lblregister.setHorizontalAlignment(SwingConstants.CENTER);
		lblregister.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		lblregister.setBounds(286, 11, 252, 55);
		registerFrame.getContentPane().add(lblregister);

		JLabel lblFirst_name = new JLabel("User name");
		lblFirst_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirst_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst_name.setBounds(52, 67, 78, 40);
		registerFrame.getContentPane().add(lblFirst_name);

		JLabel lblLast_name = new JLabel("Password");
		lblLast_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLast_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblLast_name.setBounds(52, 125, 78, 40);
		registerFrame.getContentPane().add(lblLast_name);

		JLabel lblUsername = new JLabel("MobileNo");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(52, 176, 78, 40);
		registerFrame.getContentPane().add(lblUsername);

		JLabel lblEmail_address = new JLabel("BloodGroup");
		lblEmail_address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_address.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail_address.setBounds(52, 229, 122, 36);
		registerFrame.getContentPane().add(lblEmail_address);

		textFieldusername = new JTextField();
		textFieldusername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldusername.setBounds(171, 77, 136, 20);
		registerFrame.getContentPane().add(textFieldusername);
		textFieldusername.setColumns(10);

		textFieldpassword = new JTextField();
		textFieldpassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldpassword.setBounds(171, 135, 136, 20);
		registerFrame.getContentPane().add(textFieldpassword);
		textFieldpassword.setColumns(10);

		textFieldmobileNumber = new JTextField();
		textFieldmobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldmobileNumber.setBounds(171, 186, 136, 20);
		registerFrame.getContentPane().add(textFieldmobileNumber);
		textFieldmobileNumber.setColumns(10);

		textFieldBloodGroup = new JTextField();
		textFieldBloodGroup.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBloodGroup.setBounds(171, 239, 136, 20);
		registerFrame.getContentPane().add(textFieldBloodGroup);
		textFieldBloodGroup.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(313, 310, 225, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textFieldusername.getText();
				String pass = textFieldpassword.getText();
				String mobile = textFieldmobileNumber.getText();
				String bloodGroup = textFieldBloodGroup.getText();
				User oUser = new User(username, pass, mobile, bloodGroup);
				Bank.userList.add(oUser);
				JOptionPane.showMessageDialog(null, "Successfully saved !", "Success !",
						JOptionPane.INFORMATION_MESSAGE);
				registerFrame.dispose();
				Login oLogin = new Login();
				oLogin.frame.setVisible(true);
			}
		});

		registerFrame.getContentPane().add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 56, 800, 2);
		registerFrame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 278, 800, 2);
		registerFrame.getContentPane().add(separator_1);

	}

}
