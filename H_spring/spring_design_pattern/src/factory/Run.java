package factory;

public class Run {
	
	public static void main(String[] args) {
		
		//다음 메일을 보내보자
		ConnectorFactory.createSMTPConnector("daum").connect();
	}
}
