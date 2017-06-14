package whirlpool.newsletter.entidades;

import whirlpool.newsletter.WritterHelper;

public class NewsLetters {

	private String emailAddress;
	private String customerId;
	private String firstName;
	private String lastName;
	private String registro;
	private String tienda;
	private String birthDate;
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	@Override
	public String toString() {
		return "NewsLetter [emailAddress=" + emailAddress + ", customerId=" + customerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", registro=" + registro + ", tienda=" + tienda + ", birthDate="
				+ birthDate + "]";
	}
	
	private String insertNotNull(String value){
		return value==null?"":value;
	}
	
	public String reemplazarKeysPorValue(String line){
		try{
		line=line.replaceAll("emailAddress", insertNotNull(emailAddress));
		line=line.replaceAll("customerId", insertNotNull(customerId));
		line=line.replaceAll("firstName", insertNotNull(firstName));
		line=line.replaceAll("lastName", insertNotNull(lastName));
		line=line.replaceAll("registro", insertNotNull(registro));
		line=line.replaceAll("tienda", insertNotNull(tienda));
		line=line.replaceAll("birthDate", insertNotNull(birthDate));
		}
		catch (Exception e) {
			WritterHelper.getInstance().escribirError("mapearKeyValue.log", "Error al querer mapear las keys de mapeo.csv con sus values");
		}
		return line;
		
	}

	

//	EMAIL_ADDRESS_;CUSTOMER_ID_;FIRST_NAME;LAST_NAME;REGISTRO;TIENDA;BIRTH_DATE

}
