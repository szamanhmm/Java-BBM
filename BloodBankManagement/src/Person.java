
public abstract class Person {
	private String name;
	private String password;

	public Person(String name, String pass) {
		this.name = name;
		this.password = pass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	abstract public void ViewProfile();
}
