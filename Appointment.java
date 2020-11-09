import java.time.LocalDateTime;


public class Appointment implements Comparable<Appointment>{

	private Patient patients;
	private LocalDateTime appointmentDateTime;
	
	public Appointment(Patient returnedUser, LocalDateTime appointmentDateTime) {
		setPatients(returnedUser);
		setAppointmentDateTime(appointmentDateTime);
	}
	
	
	public User getPatients() {
		return patients;
	}
	
	public void setPatients(Patient patients) {
		this.patients = patients;
	}
	
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	
	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	
	public String toString() {
		return "Appointment : " + appointmentDateTime + "\n" +
				"Patient : " + patients.getFirstName() + " " + patients.getLastName() + "\n";
	}


	@Override
	public int compareTo(Appointment o) {
		return this.getAppointmentDateTime().compareTo(o.getAppointmentDateTime());
	}
}

