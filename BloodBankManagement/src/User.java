

public class User extends Person {
	public String username;
	public String password;
	private String mobileNumber;
	private String bloodGroup;
	private int userType = 0;
	public String neededBlood = "";

	public User(String username, String pass, String mobile, String bloodGroup) {
		super(username, pass);
		this.username = username;
		this.password = pass;
		this.mobileNumber = mobile;
		this.bloodGroup = bloodGroup;
	}

	public User(String username, String pass) {
		super(username, pass);
		this.username = username;
		this.password = pass;
	}

	public void donate() {
		this.userType = 1;
	}

	public void getBloodSupply(String bloodType) {
		this.userType = 2;
		this.neededBlood = bloodType;
	}

	public int getUSerType() {
		return this.userType;
	}

	public String getBloodType() {
		return this.bloodGroup;
	}
	
	public String getContact() {
		return this.mobileNumber;
	}

	@Override
	public void ViewProfile() {
		// TODO Auto-generated method stub

	}
}
