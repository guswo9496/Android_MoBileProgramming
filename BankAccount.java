package QuickCoding4;

public class BankAccount extends Thread{

	private int balance = 100;
	
	public int getBalance(){
		return balance;
	}
	public void withDraw(int amount){
			balance-=amount;
	}
	public void add(int money){
		balance+=money;
		System.out.append("����:"+balance+"\n"+money+"�Ա�\n");
	}
	public void delete(int money)
	{
		if(balance>=money){
			balance-=money;
			System.out.append("����:"+balance+"\n"+money+"���\n");
		}/*else{System.out.println("���� �����ϴ�.");}*/
	}
}
