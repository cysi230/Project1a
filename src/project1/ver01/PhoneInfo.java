package project1.ver01;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String birthday;
	
	public void showPhonelnfo(String name, String phoneNumber, String birthday ) {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("생년월일: "+birthday);
	}
	
	public void showPhonelnfo(String name, String phoneNumber) {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("생년월일:" + "입력되지않음");
	}
}
