package project1.ver09;

public class DeleteSQL extends  IConnectimpl{
	
	String deletName;
	
	public DeleteSQL(String deletName) {
		super("kosmo","1234");
		this.deletName=deletName;
	}
	
	@Override
	public void execute() {
		try {
			 //1. 쿼리문 준비
			 String query = "DELETE FROM phonebook_tb WHERE name=? ";
			 //2.prepared 객체생성
			 psmt= con.prepareStatement(query);
			 //3.사용자로부터 입력받은값 인파라미터로 설정
			 psmt.setString(1, deletName);
			 //4.쿼리실행
			 System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
