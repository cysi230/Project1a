package project1;

import java.util.Scanner;

import project1.ver05.PhoneBookManager;
import project1.ver05.MenuItem;
import project1.ver05.SubMenuItem;

public class PhoneBookVer05 implements MenuItem,SubMenuItem {

	public static void main(String[] args) {

		PhoneBookManager phonebookmanager = new PhoneBookManager(100);
	
		while(true) {
			phonebookmanager.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			switch(menu) {
			case DATAINPUT:
				//1.데이터입력시 메뉴
				phonebookmanager.printMenu2();
				//printMenu2()
				while(true) {
				
					Scanner scan1 = new Scanner(System.in);
					int choice = scan1.nextInt();// printMenu2() 로가는 choice Scanner
						
					switch(choice) {
					case NOMALDATAPUT:
						//1. 일반
						phonebookmanager.dataput(choice);
						break;
							
					case SCHOOLDATAPUT:
						//2. 동창
						phonebookmanager.dataput(choice);
						break;
							
					case COMPANYDATAPUT:
						//3. 회사
						phonebookmanager.dataput(choice);
						}
					break;
					}//end of while	
				break;
			case DATASEARCH:
				//2. 데이터 검색
				phonebookmanager.dataSearch();
				break;
			case DATADELETE:
				//3. 데이터 삭제
				phonebookmanager.dataDelete();
				break;
				
			case DATAALLSHOW:
				//4. 주소록 출력
				phonebookmanager.dataAllShow();
				break;
				
			case EXTI:
				//5. 프로그램 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				return;
			}
		}//end of while	
	}
}
