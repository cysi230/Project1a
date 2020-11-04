package project1.ver08;

public class PhoneSchoolInfo extends PhoneInfo{
		
	public String major;//전공
	public int grade;//학년
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);	
		this.major=major;
		this.grade=grade;
		}
	
	@Override
	public void showPhonelnfo(){
		super.showPhonelnfo();
		System.out.println("전공: "+major);
		System.out.println("학년: "+grade);
	}	
}

