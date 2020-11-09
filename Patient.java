import java.time.LocalDate;
import java.util.regex.Pattern;


public class Patient extends User{

	private LocalDate dateOfBirth;
	private String gender;
	
	private final String DEFAULT_UNKNOWN = "Unknown";
	
	public Patient(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String gender) {
		
		super(firstName, lastName, email, phoneNumber);
		setDateOfBirth(dateOfBirth);
		setGender(gender);
		
		}
	
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		if (!gender.isEmpty() && !gender.equalsIgnoreCase(null)) {
			
			if (gender.equalsIgnoreCase("m")) {
				this.gender = "Male";
			} else if (gender.equalsIgnoreCase("f")) {
				this.gender = "Female";
			} 
			
		} else {
		    this.gender = DEFAULT_UNKNOWN;
		}
	}
	
	public String toString() {
		return super.toString() + 
				"Date of Birth : " + dateOfBirth + 
				"\nGender : " + gender + "\n";
	}
	
}
