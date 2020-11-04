package project1.ver09;

import java.sql.SQLException;

public class SelectQuery extends IConnectimpl {
	String searchName;
	
	public SelectQuery(String searchName) {
		super(ORACLE_DRIVER, "kosmo","1234");
		this.searchName = searchName;
	}
	
/*
 ResultSet 클래스
 : select 문실행시 쿼리의 실행결과가 resultSet 객체에 저장된다
 결과로 반환된레코드의 처음부터 마지막까지 next()메소드를 통해
 확인후 반복하면서 추출하게 된다
 - get XXX()계열의 메소드
 오라클의 자료형이
 	number타입 : getInt()
 	char/varchar2타입: getString()
 		=> 오라클 자료형에 상관없이 모든타입 추출할수있다.
 	date 타입: getDate()
 	메소드로 각 컬럼의 데이터를 추출하낟
 	- 인자는 select절의 컬럼 순서대로 인덱스(1부터시작)를 사용하거나
 	컬럼명을 사용할수있다.
 */
	@Override
	public void execute() {
		try {
			 stmt = con.createStatement();
			
//			String query = " SELECT name, phoneNumber, birthday, "
//					+ " FROM phonebook_tb ";
			String query = " select name, phoneNumber, birthday from  phonebook_tb where name like '%"+searchName+"%'"; 
//			select * from pr_employees where hiredate like '%12/%'
				
			
				rs= stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("birthday");


				
				System.out.printf("%s %s %s \n", name, phoneNumber, birthday);
			}
		}
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB자원반납
		}
	}

}