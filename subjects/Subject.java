package subjects;

import Users.Professor;
import Users.Student;
import Users.TA;


public interface Subject {
     void subscribeProfessorForEmailNotification(Professor professor) ;
     void subscribeProfessorForSMSNotification(Professor professor) ;
     void subscribeTAForEmailNotification(TA ta) ;
     void subscribeTAForSMSNotification(TA ta) ;
     void subscribeStudentForEmailNotification(Student student) ;
     void subscribeStudentForSMSNotification(Student student) ;
     void notifyAllUsers(String[] placeholders);
}
