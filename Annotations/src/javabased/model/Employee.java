package javabased.model;

public class Employee {
	private String name;
	private String surname;
	
	
	public Employee() {
		super();
	}

	public Employee(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + "]";
	}
	
	
	

}
