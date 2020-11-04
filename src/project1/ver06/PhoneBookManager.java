package project1.ver06;
import java.util.Scanner;
import project1.ver06.PhoneInfo;

public class PhoneBookManager {
	
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
			Scanner sc = new Scanner(System.in);
			
			String name, phoneNumber, major ,company;
			int grade;
			System.out.print("이름: ");name=sc.nextLine();
			System.out.print("전화번호: ");phoneNumber=sc.nextLine();
			
			//////1 일반, 2.동창, 3.회사
			if(choice==1) {//일반
				// 입력후 추가
				PhoneInfo phInfo = new PhoneInfo(name, phoneNumber);
				myFriends[numOfFriends++] = phInfo;
			}
			else if(choice==2) {//동창
				//동창
				System.out.print("전공: ");major = sc.nextLine();
				System.out.print("학년: ");grade = sc.nextInt();
				PhoneSchoolInfo phoneschoolinfo= new PhoneSchoolInfo(name, phoneNumber, major, grade);
				myFriends[numOfFriends++] = phoneschoolinfo;
			}
			else if(choice==3) {//회사
				System.out.print("회사: ");company = sc.nextLine();
				myFriends[numOfFriends++] = new PhoneCompanyInfo(name, phoneNumber, company);
			}
		}
		
////////////////////////////////검 색////////////////////////////////
		public void dataSearch() {
			boolean isFind = false; // 검색 확인하기 위한함수
			Scanner sc = new Scanner(System.in);
			System.out.println("데이터 검색을 시작합니다");
			System.out.print("선택: ");
			String searchName = sc.nextLine();
			
			//배열에 저장된 친구정보의 갯수만큼 반복
			for(int i=0 ; i<numOfFriends ;i++) {
//				System.out.println("이름: "+myFriends[i].name);
//				myFriends[i].showPhonelnfo();
				if(searchName.compareTo(myFriends[i].name)==0) {
					myFriends[i].showPhonelnfo();
					System.out.println("데이터 검색이 완료되었습니다");
					isFind=true;//찾는정보가 있다면 true
				}
			}
				if(isFind ==false)System.out.println("찾는정보가없습니다");
			}
		
/////////////////////////////////////삭 제////////////////////////////
		public void dataDelete() {
			Scanner sc = new Scanner(System.in);
			System.out.print("선택: ");
			String deletName = sc.nextLine();
			
			int deleteIndex=-1;
			
			for(int i=0 ; i<numOfFriends ;i++) {
				if(deletName.compareTo(myFriends[i].name)==0) {
					myFriends[i]=null;//요소삭제위한값 null
					deleteIndex=i;//삭제된요소를 deleteIndex값에 저장
					numOfFriends--;//1차감
				}
			}
			if(deleteIndex==-1) {
				System.out.println("데이터가없습니다");//초기값이 -1 데이터가없을시
			}
			else {
				for(int i=deleteIndex; i<numOfFriends;i++) {
					myFriends[i]=myFriends[i+1];//삭제할경우 해당 요소의 뒤에 저장된 요소들을 한칸씩 앞으로 이동
				}
				System.out.println("데이터 삭제가 완료되었습니다");
			}
		}
		
////////////////////////////////추 소 록  전 체 출 력/////////////////////////
		public void  dataAllShow() {
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showPhonelnfo();
		}
		}
}
