package project1.ver06;

public class PhoneCompanyInfo extends PhoneInfo {
	String company;//회사명
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {	
		super(name, phoneNumber);
		this.company=company;
	}
	@Override
	public void showPhonelnfo(){
		super.showPhonelnfo();
		System.out.println("회사명: "+company);
	}	
}

