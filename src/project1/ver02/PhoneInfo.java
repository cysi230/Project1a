package project1.ver02;

import java.util.Scanner;

public class PhoneInfo {

	
	String name;
	String phoneNumber;
	String birthday;
		
	
	public void dataput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");name=sc.nextLine();
		System.out.print("전화번호: ");phoneNumber=sc.nextLine();
		System.out.print("생년월일: ");birthday=sc.nextLine();
		
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
		System.out.println("생년월일:" + birthday);
		
	}
	
	
}
