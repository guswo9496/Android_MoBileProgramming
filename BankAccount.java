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
		System.out.append("총합:"+balance+"\n"+money+"입금\n");
	}
	public void delete(int money)
	{
		if(balance>=money){
			balance-=money;
			System.out.append("총합:"+balance+"\n"+money+"출금\n");
		}/*else{System.out.println("돈이 없습니다.");}*/
	}
}
