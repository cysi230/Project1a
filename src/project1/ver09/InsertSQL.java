package project1.ver09;

import java.util.Scanner;

public class InsertSQL extends IConnectimpl {
		String name;
		String phoneNumber;
		String birthday;
		
	public InsertSQL(String name, String phoneNumber, String birthday) {
		super(ORACLE_DRIVER, "kosmo","1234");
		
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;
	}
		@Override
		public void execute() {
			try {
				//1.쿼리문준비: 값의 셋팅이 필요한부분을 ?(인파라미터)로 대체한다
				String query = "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextVal,?,?,?) ";
				
				//2. prepared 객체생성: 생성시 준비한 쿼리문을 인자로 전달한다.
				psmt = con.prepareStatement(query);
				
				//4.인파라미터 설정: ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작
				/*
				 인파라미터 설정시 사용하는 메소드
				 자료형이 
				 	숫자면 setInt()
				 	문자면 setString()
				 	날짜면 setDate()를 사용한다
				 해당 setXXX()메소드를 사용하면 '(싱글쿼테이션)은 자동으로 삽입된다
				 */
				psmt.setNString(1, name);
				psmt.setNString(2, phoneNumber);
				psmt.setNString(3, birthday);
				
				//5.쿼리실행을 위해 prepared객체를 생성한다.
				int affected = psmt.executeUpdate();
				System.out.println(affected+"행이 입력되었습니다");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				close();
			}
		}
	}

