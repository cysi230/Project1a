package project1.ver07;

public class PhoneInfo {

	
	String name;
	String phoneNumber;

	
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;

	}
	
	
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
	
	public void showPhonelnfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
//		System.out.println("생년월일: " + birthday);
		
	///////////////////Hash Set///////////////////////
		/*
	 객체에게 부여된 주소값(참조값)을 숫자형태로 반환해주는 메소드
	 */
	}
	@Override
	public int hashCode() {
		
		int hc1 = name.hashCode();
//		System.out.println(hc1);
		/*
		  해당 객체가 보요한 멤버변수를 이용해서 해시값을 구하고
		  연산하여 결과를 반환하면 된다.
		 */
		return hc1;
	}

	/*
	 객체의 내용을 비교하여 동일한지 여부를 판단하는 메소드
	 */
	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneinfo = (PhoneInfo)obj;
		if(this.name.equals(phoneinfo.name)){
			return true;
		}
		else {
			return false;
		}
	}	
}