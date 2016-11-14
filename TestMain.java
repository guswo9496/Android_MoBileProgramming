package QuickCoding4;

public class TestMain {
	public static BankAccount bankAccount = new BankAccount();
	public static void main(String []argc){
		
		Thread depositMain =new Thread(){
			//¹º°¡
			public void run(){
				for(int i=0;i<10;i++){
					bankAccount.withDraw(10);
					bankAccount.add(100);
				}
				
			}
			
		};
	
		Thread withdrawMan =new Thread(){
			//¹º°¡
			public void run(){
				for(int i=0;i<10;i++){
					bankAccount.withDraw(10);
					bankAccount.delete(100);
				}
				
			}
		};
		depositMain.start();
		withdrawMan.start();
	}
}
