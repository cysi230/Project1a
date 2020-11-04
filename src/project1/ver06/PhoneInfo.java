package project1.ver06;

import java.util.Scanner;

public class PhoneInfo {

	
	String name;
	String phoneNumber;
//	String birthday;
	
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
//		this.birthday = birthday;
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
		
	}
}