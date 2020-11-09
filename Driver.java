import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
public static Scanner input = new Scanner(System.in);

    public static User findUser(ArrayList<User> users) {
    	System.out.print("Enter your id : ");
    	int id = input.nextInt();
    	for (User u : users) {
    		if (u.getUserId() == id) {
    			return u;
    		}
    	}
    	return null;
    }
	
    // print users
    public static void printUser(ArrayList<User> users) {
    	System.out.println("----Users----");
		Collections.sort(users, new UserSorter.compareById());
		for (User user : users) {
			System.out.println(user);
		}
	}
    
	// print all doctors
	public static void printDr(ArrayList<User> users) {
		System.out.println("----Doctors----");
		for (User u : users) {
			if (u instanceof Doctor) {
		    	System.out.println(u.toString());
			} 
		}
	}

    // printing doctor's appointment
    public static void printDrAppointment(User doctor) {
       Collections.sort(doctor.getAppointments());
	   for (Appointment a : doctor.getAppointments())
		   System.out.println(a.toString());
    }
    
    // making an appointment
    public static Appointment makeAppoitment(Patient returnedUser) {
		LocalDateTime apoDateTime = null;
				
				System.out.println("When would you like to make an appointment : ");
				System.out.print("Number of year : ");
				int year = input.nextInt();
				System.out.print("Number of month : ");
				int month = input.nextInt();
				System.out.print("Day of month : ");
				int dayOfMonth = input.nextInt();
				System.out.print("Number of hour : ");
				int hour = input.nextInt();
				System.out.print("Number of minute : ");
				int minute = input.nextInt();
				
				apoDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		
		
    	return new Appointment(returnedUser, apoDateTime);	
	}
    
    public static User findDr(ArrayList<User> doctors, int doctorId) {
    	for (User d : doctors) {
    		if (d.getUserId() == doctorId) {
    			return d;
    		}
    	}
    	return null;
    }
    
    // asking a patient which dr they want to make an appointment with
    public static User chooseDoctor(ArrayList<User> users) {
		printDr(users);
		System.out.print("Enter doctor's doctor Id : ");
		int choosenDrId = input.nextInt();
		User returnDoctor = findDr(users, choosenDrId);
		
		while (returnDoctor == null) {
			System.out.println("Couldn't find the doctor.");
			System.out.print("Enter doctor's doctor Id : ");
			choosenDrId = input.nextInt();
			returnDoctor = findUser(users);

		}
		return returnDoctor;		
	}
    
    // print our patient's appointment
//    public static void printPatientAppointment(User doctor, User patient) {
// 	   for (Appointment a : doctor.getAppointments())
// 		   System.out.println(a.toString() + "With Dr. " + doctor.getFirstName() + " " + doctor.getLastName());
//    }
    
    public static void printPatientAppointment(User patient, Appointment appointment, User doctor) {
		System.out.println("Appointment : " + appointment.getAppointmentDateTime() + 
				           "\nPatient : " + patient.getFirstName() + " " + patient.getLastName() + 
				           "\nDr. " + doctor.getFirstName() + " " + doctor.getLastName());
}

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		
		Patient p1 = new Patient("Marwan", "Pace", "111-123-4567", "marwan@gmail.com", LocalDate.of(1981, 1, 2), "m");
		Patient p2 = new Patient("Farrah", "Hook", "222-123-4567", "farrah@yahoo.ca", LocalDate.of(1985, 3, 21), "f");
		Patient p3 = new Patient("Clare", "Levine", "333-123-4567", "clairelevine@gmail.com", LocalDate.of(1990, 10, 2), "f");
		
		Doctor d1 = new Doctor("Nial", "Wynn", "101-101-1010", "nial@hospital.com", "Dentist");
		Doctor d2 = new Doctor("Alec", "Macdonald", "202-222-1010", "alec@hospital.com", "Neurosurgery");
		
		users.add(p1);
		users.add(p2);
		users.add(p3);
		users.add(d1);
		users.add(d2);
		
 		Appointment a1 = new Appointment(p1, LocalDateTime.of(2020, 11, 3, 10, 00));
		Appointment a2 = new Appointment(p2, LocalDateTime.of(2020, 12, 20, 11, 30));
		Appointment a3 = new Appointment(p3, LocalDateTime.of(2020, 10, 20, 11, 30));

		
		d1.addAppointments(a1);
		d2.addAppointments(a2);
		d2.addAppointments(a3);

			

		printUser(users);
		User returnedUser = findUser(users);
		
		if (returnedUser instanceof Patient) {
			Patient p = (Patient)returnedUser;
			Appointment newAppointment = makeAppoitment(p);
			
			User choosenDoctor = chooseDoctor(users);
			choosenDoctor.addAppointments(newAppointment);
			printPatientAppointment(p, newAppointment, choosenDoctor);

		} else if (returnedUser instanceof Doctor) {
			Doctor d = (Doctor)returnedUser;
			printDrAppointment(d);
		}

	}
}
