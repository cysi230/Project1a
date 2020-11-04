package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectimpl implements IConnect {
	public Statement stmt;
	public PreparedStatement psmt;//동적쿼리처리를 위한 객체
	public Connection con;
	public ResultSet rs;
	
	//기본생성자
	public IConnectimpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	//인자생성자(매개변수2개)
	public IConnectimpl(String user, String pass) {
		System.out.println("IConnectImpl 인자새성자 호출");
		try {
			//드라이버로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		}
	}
	//인자생성자(매개변수3개) - 오버로딩으로 생성자 선언
	public IConnectimpl(String driver, String user, String pass) {
		System.out.println("IConnectImpl 인자새성자 호출");
		try {
			//드라이버로드
			Class.forName(driver);
			//DB연결
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		}
	}
	
	//오라클 DB에 연결
	@Override
	public void connect(String user , String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL,user,pass);
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결오류");
			e.printStackTrace();
		}
	}
	
	/*
	 오버라이딩의 목적으로 정의한 메소드 ,쿼리실행은 각각의 클래스에
	 진행하게 될것임.
	 */
	@Override
	public void execute() {
		//하는일없음
	}
	
	@Override
	public void close() {
		try {
			if(psmt!=null) psmt.close();
			if(con!=null)con.close();
			if(rs!=null)rs.close();
			if(stmt!=null) stmt.close();
			System.out.println("DB자원 반납완료");
		}
		catch (Exception e) {
			System.out.println("자원반납시 오류가 발생하였습니다");
			e.printStackTrace();
		}
	}

	//자원해제
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.println(title + "을 (를) 입력(exit -> 종료)");
		String inputStr = scan.nextLine();
		/*
		 equalsIgnoreCase()
		 : equal() 메소드와 동일하게 문자열이 같은지 비교하는 메소드로
		 다른점은 대소문자를 구분하지 않는다.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다");
			close();//자원해제
			//프로그램자체종료
			System.exit(0);//프로그램 자체가 즉시종료
		}
		return inputStr;//입력받은 문자열을 반환
	}
}
