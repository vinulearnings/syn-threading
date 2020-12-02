import java.awt.geom.FlatteningPathIterator;
import java.util.concurrent.CountDownLatch;

class Lab4Support extends Thread{
	private String loc;
	private CountDownLatch latch;
	public Lab4Support(String loc, CountDownLatch latch) {
		super();
		this.loc = loc;
		this.latch = latch;
	}
	@Override
	public void run() {
		for (int i = 0; i< 10 ;i++){
			try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
			System.out.println(currentThread().getName() + "  " + i);
		}
		latch.countDown();
		System.out.println("Final location is " + loc);
	
	
}
}
public class Lab4 {
	public static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Lab4Support t1 = new Lab4Support("Lonavala", latch);
		Lab4Support t2 = new Lab4Support("Khandala", latch);
		Lab4Support t3 = new Lab4Support("Khandala1", latch);
		t1.start();
		t2.start();
		t3.start();
		latch.await();
		System.out.println(" Show this code when any one thread gets over");
		System.out.println("Final Location in Main is " );
	}

}
