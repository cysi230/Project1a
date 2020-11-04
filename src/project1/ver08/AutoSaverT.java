package project1.ver08;

public class AutoSaverT extends Thread {
	
	PhoneBookManager pbm;
	public AutoSaverT(PhoneBookManager pbm) {
		this.pbm = pbm;
	}
	//자동저장 5초
	@Override
	public void run() {
		
		while (true) {
			
			try {
				pbm.dataTextSave();

				sleep(5000);// 5초시간만큼 멈춰있다 다시시작
				
			} catch (InterruptedException e) {
				// interrupt호출이되면 e.printStackTrace() 로온다
				break;
			}
			System.err.println("\n5초마다 자동저장을 시작합니다");
		}
	}
}
