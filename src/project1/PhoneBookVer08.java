package project1;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.SubMenuItem;

public class PhoneBookVer08 implements MenuItem,SubMenuItem {

	public static void main(String[] args) throws MenuSelectException, IOException {

		/////////////////////////////데이터/////////////////////////////////
		PhoneBookManager phonebookmanager = new PhoneBookManager(100);
//		AutoSaverT deamon = new AutoSaverT();
		////////////////////////데몬쓰레드 5초 오토 자동저장 클래스 생성자 //////////////
		AutoSaverT deamon = new AutoSaverT(phonebookmanager);
		deamon.setDaemon(true);
		
		while(true) {
			//메뉴출력
			phonebookmanager.printMenu();
			
		try {	//InputMismatchException, NullPointerException//
			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();
			
			try {//MenuSelectException//
				if(menu>6|| menu<1) {
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
				
			case SAVE:
				/*
				 스레드의 상태가 종료되어있는 상태인가 확인하는 함수
				 종료되어있으면 deamon= new AutoSaverT(phonebookmanager);
				 객체 생성을 해라
				 */
				if(deamon.getState()==Thread.State.TERMINATED) {
					deamon= new AutoSaverT(phonebookmanager);
				}
				phonebookmanager.menuSave(deamon);
				
				break;
			case EXIT:
				//6. 프로그램 종료 및 저장
				System.err.println("obj파일로 저장합니다");
				System.out.println("프로그램을 종료합니다");
				phonebookmanager.dataSave();
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