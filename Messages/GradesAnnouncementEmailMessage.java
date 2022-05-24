package messages;

public class GradesAnnouncementEmailMessage implements Messages{


	@Override
	public String prepareMessage(String [] placeHolders) {
		// code to replace place holders of this type
		return "";
	}
	
	public boolean verifyGrades() {
		// code to verify Grades before announcement
		
		return true;
	}
}
