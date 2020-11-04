package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		PhoneInfo phoneInfo  = new PhoneInfo();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("1.데이터입력");
		System.out.println("2.프로그램종료");
		System.out.print("선택: ");
		int choice = sc.nextInt();
		if(choice==1) {
			System.out.println("데이터를 입력");
				phoneInfo.dataput();
				phoneInfo.showPhonelnfo();
		}
		else {
			System.out.print("프로그램을 종료합니다");
			System.exit(0);
		}
	}
	}
}
