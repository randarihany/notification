package subjects;

import gateways.EmailGateway;
import gateways.GateWay;
import gateways.SMSGateway;
import messages.TaskAddedEmailMessage;
import Users.Professor;
import Users.Student;
import Users.TA;

import java.util.ArrayList;

public class Course implements Subject {
	
	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;
	
	ArrayList<Professor> professorsForEmailNotification;
	ArrayList<Professor> professorsForSMSNotification;
	
	ArrayList<TA> tasForEmailNotification;
	ArrayList<TA> tAsForSMSNotification;
	
	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;
	
	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;

		announcements = new ArrayList<String>();
		exams = new ArrayList<String>();
		grades = new ArrayList<String>();

		professorsForEmailNotification = new ArrayList<Professor>();
		professorsForSMSNotification = new ArrayList<Professor>();
		
		tasForEmailNotification = new ArrayList<TA>();
		tAsForSMSNotification = new ArrayList<TA>();
		
		studentsForEmailNotification = new ArrayList<Student>();
		studentsForSMSNotification = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void subscribeProfessorForEmailNotification(Professor professor) {
		professorsForEmailNotification.add(professor);
	}
	
	public void subscribeProfessorForSMSNotification(Professor professor) {
		professorsForSMSNotification.add(professor);
	}

	public void subscribeTAForEmailNotification(TA ta) {
		tasForEmailNotification.add(ta);
	}
	
	public void subscribeTAForSMSNotification(TA ta) {
		tAsForSMSNotification.add(ta);
	}
	
	public void subscribeStudentForEmailNotification(Student student) {
		studentsForEmailNotification.add(student);
	}
	
	public void subscribeStudentForSMSNotification(Student student) {
		studentsForSMSNotification.add(student);
	}

	@Override
	public void notifyAllUsers(String[] placeholders) {

			// notify users by email
			TaskAddedEmailMessage msg = new TaskAddedEmailMessage();
			String notification = msg.prepareMessage(placeholders);

			// open connection for Email gateway and do some configurations to the object
		   GateWay emailGateway = new EmailGateway();

		// open connection for Email gateway and do some configurations to the object
		GateWay smsGateway = new SMSGateway();

			for (Professor professor : professorsForEmailNotification) {
				professor.update(notification);
				emailGateway.sendMessage(notification, professor.getEmail());
			}

			for (TA ta : tasForEmailNotification) {
				ta.update(notification);
				emailGateway.sendMessage(notification, ta.getEmail());
			}

			for (Student student : studentsForEmailNotification) {
				student.update(notification);
				emailGateway.sendMessage(notification, student.getEmail ());
			}


			// notify users by SMS
		for (Professor professor : professorsForSMSNotification) {
			professor.update(notification);
			smsGateway.sendMessage(notification, professor.getEmail());
		}

		for (TA ta : tAsForSMSNotification) {
			ta.update(notification);
			smsGateway.sendMessage(notification, ta.getEmail());
		}

		for (Student student : studentsForSMSNotification) {
			student.update(notification);
			smsGateway.sendMessage(notification, student.getEmail ());
		}

	}


	public void AddAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here 
		
		notifyAllUsers(placeholders);
	}
	public void AddExam(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void PostGrades(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}
	public void PostAnnouncement(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}
	
	// AddExam, PostGrades, PostAnnouncement  will be the same 



}
