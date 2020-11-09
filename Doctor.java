import java.util.ArrayList;
import java.util.regex.Pattern;

public class Doctor extends User{
	
	private String specialty;
	
	private ArrayList<Appointment> appointments;
	
	private final String DEFAULT_UNKNOWN = "Unknown";
	
	
	public Doctor(String firstName, String lastName, String email, String phoneNumber, String specialty) {
		
		super(firstName, lastName, email, phoneNumber);
		setSpecialty(specialty);
		this.appointments = new ArrayList<Appointment>();
		}
	
	public void addAppointments(Appointment a) {
		this.appointments.add(a); 
	}
	
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		if (!specialty.isEmpty() && !specialty.equalsIgnoreCase(null)) {
			this.specialty = specialty;
		} else {
			this.specialty = DEFAULT_UNKNOWN;
		}
	}
	
	public String toString() {
		return super.toString() + "Specialty : " + specialty + "\n";
	}
	
	
}
