package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;

public class PhoneBookVer04 {

	public static void main(String[] args) {

		PhoneBookManager phonebookmanager = new PhoneBookManager(100);
	
		while(true) {
			phonebookmanager.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				//1.데이터입력시 메뉴
				phonebookmanager.printMenu2();
				//printMenu2()
				while(true) {
				
					Scanner scan1 = new Scanner(System.in);
					int choice = scan1.nextInt();// printMenu2() 로가는 choice Scanner
						
					switch(choice) {
					case 1:
						//1. 일반
						phonebookmanager.dataput(choice);
						break;
							
					case 2:
						//2. 동창
						phonebookmanager.dataput(choice);
						break;
							
					case 3:
						//3. 회사
						phonebookmanager.dataput(choice);
						}
					break;
					}//end of while	
				break;
			case 2:
				//2. 데이터 검색
				phonebookmanager.dataSearch();
				break;
			case 3:
				//3. 데이터 삭제
				phonebookmanager.dataDelete();
				break;
				
			case 4:
				//4. 주소록 출력
				phonebookmanager.dataAllShow();
				break;
				
			case 5:
				//5. 프로그램 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				return;
			}
		}//end of while	
	}
}
