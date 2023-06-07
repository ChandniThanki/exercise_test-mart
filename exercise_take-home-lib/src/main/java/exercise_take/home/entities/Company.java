package exercise_take.home.entities;

public class Company {
	  private Address AddressObject;
	  private String department;
	  private String name;
	  private String title;

	  // Getter Methods 

	  public Address getAddress() {
	    return AddressObject;
	  }

	  public String getDepartment() {
	    return department;
	  }

	  public String getName() {
	    return name;
	  }

	  public String getTitle() {
	    return title;
	  }

	  // Setter Methods 

	  public void setAddress(Address addressObject) {
	    this.AddressObject = addressObject;
	  }

	  public void setDepartment(String department) {
	    this.department = department;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public void setTitle(String title) {
	    this.title = title;
	  }
	}
