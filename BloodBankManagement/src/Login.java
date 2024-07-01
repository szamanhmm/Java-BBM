
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public Register register;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(75, 74, 70, 35);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(75, 124, 70, 35);
		frame.getContentPane().add(lblPassword);

		JLabel lbllogin = new JLabel("User login");
		lbllogin.setToolTipText("");
		lbllogin.setLabelFor(frame);
		lbllogin.setBackground(Color.BLACK);
		lbllogin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lbllogin.setForeground(Color.RED);
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setBounds(160, 0, 153, 46);
		frame.getContentPane().add(lbllogin);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(209, 74, 139, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(209, 124, 139, 35);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] pswd = passwordField.getPassword();
				String password = new String(pswd);
				String username = textField.getText();
				Bank oBank = new Bank("Shonali");

				if (username.contains("admin") && password.contains("admin")) {
					textField.setText(null);
					passwordField.setText(null);
					frame.dispose();
					HomepageAdmin oHome = new HomepageAdmin();
					oHome.frame.setVisible(true);
				} else {

					for (User d : oBank.userList) {
						if (username.compareTo(d.username) == 0 && password.compareTo(d.password) == 0) {
							textField.setText(null);
							passwordField.setText(null);
							frame.dispose();
							HomepageUser oHome = new HomepageUser(d.username, d.password);
							oHome.frame.setVisible(true);
							break;
						}
					}

				}
			}
		});
		btnLogin.setForeground(Color.RED);
		btnLogin.setBounds(40, 198, 90, 35);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);

			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setBounds(169, 198, 105, 35);
		frame.getContentPane().add(btnReset);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setForeground(Color.RED);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register oRegister = new Register();
				oRegister.registerFrame.setVisible(true);
			}
		});
		btnRegister.setBounds(316, 198, 139, 35);
		frame.getContentPane().add(btnRegister);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 464, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 179, 464, 2);
		frame.getContentPane().add(separator_1);
	}
}
