//package project1.ver09;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBConnect extends IConnectimpl {
//	
//	
//public DBConnect() {
//	try {
//		/*
//		 JDBC 프로그램밍 절차
//		 
//		 1] 오라클용 JDBC 드라이버를 메모리에 로드
//		 : new를 사용하지않고 클래스명으로 직접 찾아서 객체성상후
//		 메모리에 로드하는 forName()을 사용한다. 메모리에 로드된
//		 드라이버가 Drivermanager라는 클래스에 등록된다
//		 */
//		Class.forName("oracle.jdbc.OracleDriver");
//		
//		/*
//		 2]오라클 연결을 위한 커넥션 URL, 계정아이디, 패스워드를 준비하낟
//		 커넥션 URL => 
//		 	jdbc:orcle:thin:@IP주소:포트번호:SID
//		 ※서버환경에 따라 ip주소, 포트번호, sid는 변경될수있다
//		 */
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String userid = "kosmo";
//		String userpw = "1234";
//		
//		/*
//		 2-1]DriverManager 클래스의 메소드를 통해 오라클에 연결을
//		 시도한다. 연결에 성공할 경우 연결된 주소를 반환한다.
//		 */
//		Connection con = DriverManager.getConnection(url, userid, userpw);
//		if(con!=null) {
//			System.out.println("Oracle DB연결성공");
//			
//		}
//		else {
//			System.out.println("연결실패 ㅜ");
//		}
//	}
//	catch (SQLException e) {
//		System.out.println("SQLException 예외발생");
//		e.printStackTrace();
//	}
//	catch (ClassNotFoundException e) {
//		System.out.println("ClassNotFoundException 예외발생");
//		e.printStackTrace();
//	}
//	catch(Exception e) {
//		System.out.println("DB연결시 예외발생");
//		e.printStackTrace();
//	}
//}
//
//	public void execute() {
//		// TODO Auto-generated method stub
//		
//	}
//}