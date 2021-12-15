package beans;
//Some of this will need to be adjusted based on what fields we decide on for the database
public class Customer {
 private int id;
 private String email;
 private String firstName;
 private String lastName;
 private String password;
 
public Customer(int id, String email, String firstName, String lastName, String password) {
	this.id = id;
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
}

public Customer(String email, String firstName, String lastName, String password) {
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
}
public void setid(int id) {
	 this.id=id;
 }
 
 public int getid () {
	 return id;
 }
 
public void setEmail(String email) {
	this.email=email;
}
public String getEmail() {
	return email;
}

public void setFirstName(String firstName) {
	this.firstName=firstName;
}

public String getFirstName() {
	return firstName;
}

public void setLastName(String lastName) {
	this.lastName=lastName;
}

public String getLastName() {
	return lastName;
}

public void setPassword(String password) {
	this.password=password;
}

public String getPassword() {
	return password;
}

@Override
public String toString(){
	return "Customer{id='+id+', email='+email+', name='+firstName+' '+lastName' }";
	
}
}
