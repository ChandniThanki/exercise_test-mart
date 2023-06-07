package exercise_take.home.entities;

public class Address {
	  private String address;
	  private String city;
	  private Coordinates CoordinatesObject;
	  private String postalCode;
	  private String state;

	  // Getter Methods 

	  public String getAddress() {
	    return address;
	  }

	  public String getCity() {
	    return city;
	  }

	  public Coordinates getCoordinates() {
	    return CoordinatesObject;
	  }

	  public String getPostalCode() {
	    return postalCode;
	  }

	  public String getState() {
	    return state;
	  }

	  // Setter Methods 

	  public void setAddress(String address) {
	    this.address = address;
	  }

	  public void setCity(String city) {
	    this.city = city;
	  }

	  public void setCoordinates(Coordinates coordinatesObject) {
	    this.CoordinatesObject = coordinatesObject;
	  }

	  public void setPostalCode(String postalCode) {
	    this.postalCode = postalCode;
	  }

	  public void setState(String state) {
	    this.state = state;
	  }
	}