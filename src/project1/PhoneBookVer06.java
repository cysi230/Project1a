package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneBookManager;
import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.SubMenuItem;

public class PhoneBookVer06 implements MenuItem,SubMenuItem {

	public static void main(String[] args) throws MenuSelectException {

		PhoneBookManager phonebookmanager = new PhoneBookManager(100);
	
	
		while(true) {
			phonebookmanager.printMenu();
			
		try {	//InputMismatchException, NullPointerException//
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			try {//MenuSelectException//
				
				if(menu>5|| menu<1) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}				
				
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
				
			case 5:
				//5. 프로그램 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				return;
			}
			
		}catch (MenuSelectException e) {
			System.err.println(e.getMessage());
		}
		}catch (InputMismatchException e) {
			System.err.println("정수만 입력해주세요");
		}catch (NullPointerException e) {
			System.out.println("이클립스에 검색결과가없습니다");
		}
		
		}
	}
}