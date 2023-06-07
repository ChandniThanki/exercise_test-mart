package exercise_take.home.entities;

public class Bank {
	  private String cardExpire;
	  private String cardNumber;
	  private String cardType;
	  private String currency;
	  private String iban;

	  // Getter Methods 

	  public String getCardExpire() {
	    return cardExpire;
	  }

	  public String getCardNumber() {
	    return cardNumber;
	  }

	  public String getCardType() {
	    return cardType;
	  }

	  public String getCurrency() {
	    return currency;
	  }

	  public String getIban() {
	    return iban;
	  }

	  // Setter Methods 

	  public void setCardExpire(String cardExpire) {
	    this.cardExpire = cardExpire;
	  }

	  public void setCardNumber(String cardNumber) {
	    this.cardNumber = cardNumber;
	  }

	  public void setCardType(String cardType) {
	    this.cardType = cardType;
	  }

	  public void setCurrency(String currency) {
	    this.currency = currency;
	  }

	  public void setIban(String iban) {
	    this.iban = iban;
	  }
	}
