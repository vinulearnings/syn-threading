import java.util.Scanner;

class Stock{
	private int balance=0;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
class Producer extends Thread{
	private Stock stock;
	public Producer(Stock stock){
		this.stock = stock;
	}
	@Override
	public void run() {
		for (int i = 0;i < 50;i++){
			int bal = stock.getBalance();
			bal++;
			stock.setBalance(bal);
			try { 	Thread.sleep( (long)(Math.random()*100));} catch (InterruptedException e) { }
			System.out.println("In Producer = " + i + ", current stock = " + this.stock.getBalance()) ;
		}
		System.out.println("Finishing Producer  - Current Balance = " + this.stock.getBalance());
	}
}
class Consumer extends Thread{
	private Stock stock;
	public Consumer(Stock stock){
		this.stock = stock;
	}
	@Override
	public void run() {
		try{
		for (int i = 0;i < 50;i++){
			int bal = stock.getBalance();
			if (bal <= 0){
				System.out.println("Current Balance less than or equal to zero going for wait..");
				synchronized(stock){
					stock.wait();
				}
			}
			bal--;
			stock.setBalance(bal);
			Thread.sleep( (long)(Math.random()*100));
			System.out.println("In Consumer = " + i + ", current stock = " + this.stock.getBalance()) ;
		}
		System.out.println("Finishing Consumer  - Current Balance = " + this.stock.getBalance());
		} 
		catch (Exception e) {System.out.println(e); }
	}
}
public class Lab1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entter a number to continue..");
		scanner.nextInt();
		
		Stock stock = new Stock();
		Producer prod = new Producer(stock);
		Consumer con = new Consumer(stock);
		prod.start();
		con.start();

	}

}
