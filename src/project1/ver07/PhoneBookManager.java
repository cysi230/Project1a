package project1.ver07;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import project1.ver07.PhoneInfo;

public class PhoneBookManager {
	
	///////////////////Hash Set///////////////////////
	HashSet<PhoneInfo> phoneinfo = new HashSet<PhoneInfo>();
	
	private PhoneInfo[] myFriends;
	private int numOfFriends;//추가시 저장된 주소록사람의 갯수를 카운트

	public PhoneBookManager(int num) {
		myFriends = new PhoneInfo[num];
		numOfFriends=0;//정보추가시 +1증가(저장된 친구의 갯수를 카운트)
	}
		
//////////////////////////////////메 뉴 출 력///////////////////////////
		public void printMenu() {
			System.out.println("선택하세요");
			System.out.println("1.데이터입력");
			System.out.println("2.데이터검색");
			System.out.println("3.데이터삭제");
			System.out.println("4.주소록출력");
			System.out.println("5.프로그램종료");
			System.out.print("선택: ");
			
		}
		
////////////////////////////1.데이터입력시 메뉴/////////////////////
		public void printMenu2() {
			System.out.println("데이터입력을 시작합니다");
			System.out.print("1.일반 ");
			System.out.print("2.동창 ");
			System.out.print("3.회사\n");
			System.out.print("선택: ");
		}
		
////////////////////////////////입 력////////////////////////////
		public void dataput(int choice) {
			
			///////////////////Hash Set///////////////////////	
			Scanner sc = new Scanner(System.in);
			
			String name, phoneNumber, major ,company;
			int grade;
			System.out.print("이름: ");name=sc.nextLine();
			System.out.print("전화번호: ");phoneNumber=sc.nextLine();
			
			//////1 일반, 2.동창, 3.회사
			
			///////////////////Hash Set///////////////////////

			if(choice==1) {//일반
				PhoneInfo phInfo = new PhoneInfo(name, phoneNumber);
				
				boolean normal = phoneinfo.add(phInfo);
             //////////////////////일반Hash Set//////////////////////////////////
				if(!(normal)) {
		            System.out.print("중복발견됨, 덮어쓸까요?(y/n)");
		            Scanner scan = new Scanner(System.in);
		            String str = scan.nextLine();

		            if(str.equalsIgnoreCase("y")) {
		                  if(!(normal)) {
		                	  phoneinfo.remove(phInfo);
		                	  phoneinfo.add(phInfo);
		                	  System.out.println("덮어쓰기 완료되었습니다.");
		                  }
		            }
		            if(str.equalsIgnoreCase("n")) {
		               System.out.println("덮어쓰기 실패하였습니다.");
		            }
		         }
/////////////////////////////////////hashset 저장한친구값에저장///////////////////////////
			}
			else if(choice==2) {//동창
				System.out.print("전공: ");major = sc.nextLine();
				System.out.print("학년: ");grade = sc.nextInt();
				PhoneSchoolInfo phoneschoolinfo= new PhoneSchoolInfo(name, phoneNumber, major, grade);
				
				boolean school = phoneinfo.add(phoneschoolinfo);
                /////////////////////////동 창 Hash Set//////////////////////////////////
				if(!(school)) {
		            System.out.print("중복발견됨, 덮어쓸까요?(y/n)");
		            Scanner scan = new Scanner(System.in);
		            String str = scan.nextLine();

		            if(str.equalsIgnoreCase("y")) {
		                  if(!(school)) {
		                	  phoneinfo.remove(phoneschoolinfo);
		                	  phoneinfo.add(phoneschoolinfo);
		                	  System.out.println("덮어쓰기 완료되었습니다.");		           
		                  }
		            }
		            if(str.equalsIgnoreCase("n")) {
		               System.out.println("덮어쓰기 실패하였습니다.");
		            }
		         }
/////////////////////////////////////hashset 저장한친구값에저장///////////////////////////
			}
			else if(choice==3) {//회사
				System.out.print("회사: ");company = sc.nextLine();
				PhoneCompanyInfo phonecompanyinfo= new PhoneCompanyInfo(name, phoneNumber,company);
				
				boolean company1 = phoneinfo.add(phonecompanyinfo);
              ///////////////////회 사 Hash Set////////////////////////////
				if(!(company1)) {
		            System.out.print("중복발견됨, 덮어쓸까요?(y/n)");
		            Scanner scan = new Scanner(System.in);
		            String str = scan.nextLine();

		            if(str.equalsIgnoreCase("y")) {
		                  if(!(company1)) {
		                	  phoneinfo.remove(phonecompanyinfo);
		                	  phoneinfo.add(phonecompanyinfo);
		                	  System.out.println("덮어쓰기 완료되었습니다.");
		                  }
		            }
		            if(str.equalsIgnoreCase("n")) {
		               System.out.println("덮어쓰기 실패하였습니다.");
		            }
		         }
/////////////////////////////////////hashset 저장한친구값에저장///////////////////////////
			}
		}
		
////////////////////////////////검 색////////////////////////////////
		public void dataSearch() {
		
			Iterator<PhoneInfo> itr = phoneinfo.iterator();
			
			boolean isFind = false; // 검색 확인하기 위한함수
			Scanner sc = new Scanner(System.in);
			System.out.println("데이터 검색을 시작합니다");
			System.out.print("선택: ");
			String searchName = sc.nextLine();
			
			//배열에 저장된 친구정보의 갯수만큼 반복
				while(itr.hasNext()) {
				PhoneInfo pi = itr.next();
				if(searchName.equals(pi.name)) {
					pi.showPhonelnfo();
				System.out.println("데이터 검색이 완료되었습니다");
				isFind=true;//찾는정보가 있다면 true
			}
		}
			if(isFind ==false)System.out.println("찾는정보가없습니다");
		}
/////////////////////////////////////삭 제////////////////////////////
		public void dataDelete() {
			Iterator<PhoneInfo> itr = phoneinfo.iterator();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("선택: ");
			String deletName = sc.nextLine();

			boolean removed = false;
			
			while(itr.hasNext()) {
				PhoneInfo pi = itr.next();
				if(deletName.equals(pi.name)) {
//					removed = phoneinfo.remove(pi);
					 itr.remove();
					removed = true;
				}
			}
			if(removed==false) {
				System.out.println("데이터가없습니다");//초기값이 -1 데이터가없을시
			}
			else {
				System.out.println("데이터 삭제가 완료되었습니다");
				}
		}
		
////////////////////////////////추 소 록  전 체 출 력/////////////////////////
		public void  dataAllShow() {
//		for(int i=0 ; i<numOfFriends ; i++) {
//			myFriends[i].showPhonelnfo();
			
			for(PhoneInfo pi : phoneinfo)
			{
				pi.showPhonelnfo();
//				System.out.println(pi.toString());			
			}
//		}
		}
}