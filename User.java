import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	private ArrayList<Appointment> appointments;

	
	private final String DEFAULT_UNKNOWN = "Unknown";
	
	public User(String firstName, String lastName, String phoneNumber, String email) {
		setUserId();
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		
		this.appointments = new ArrayList<Appointment>();
	}
	
	public void addAppointments(Appointment a) {
		this.appointments.add(a); 
	}
	
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId() {
		int randomNum = (int)(Math.random() * 1000 - 100 + 1) + 100;
		this.userId = randomNum;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && !firstName.equalsIgnoreCase(null)) {
			this.firstName = firstName;
		} else {
			this.firstName = DEFAULT_UNKNOWN;
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && !lastName.equalsIgnoreCase(null)) {
			this.lastName = lastName;
		} else {
			this.lastName = DEFAULT_UNKNOWN;
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		  String pattern = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";
		    Pattern p = Pattern.compile(pattern);
		    
		    if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
		    	
		    	if (p.matcher(email).find()) {
		    		this.email = email;
		    	} else {
		    		this.email = "Invalid email";
		    	}
		    	
		    } else {
		    	this.email = DEFAULT_UNKNOWN;
		    }
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		String pattern = "^\\d{3}-\\d{3}-\\d{4}$";
		Pattern p = Pattern.compile(pattern);
		
		if (!phoneNumber.isEmpty() && !phoneNumber.equalsIgnoreCase(null)) {
			
			if (p.matcher(phoneNumber).find()) {
				this.phoneNumber = phoneNumber;
			} else {
				this.phoneNumber = "Invalid phone number";
			}
			
		} else {
			this.phoneNumber = DEFAULT_UNKNOWN;
		}
	}
	
	public String toString() {
		return "User Id : " + userId + "\nName : " + firstName + " " + lastName +
				"\nEmail : " + email + "\nPhone Number : " + phoneNumber + "\n";
	}



	
	

}
