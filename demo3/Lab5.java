import java.awt.geom.FlatteningPathIterator;
import java.util.concurrent.CountDownLatch;
class TransportSelection extends Thread{
	private String mode;
	private CountDownLatch latch;
	public TransportSelection(String mode, CountDownLatch latch) {
		this.mode = mode;
		this.latch = latch;
	}
	@Override
	public void run() {
		for (int i = 0; i< 10 ;i++){
			try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
			System.out.println(currentThread().getName() + "  " + i + "  " + mode);
		}
		if (Lab5.mode =="")
			Lab5.mode = this.mode;
		latch.countDown();
		
		System.out.println("We will travel via  " + mode);
}
}
class LocationSelection extends Thread{
	private String loc;
	private CountDownLatch latch;
	public LocationSelection(String loc, CountDownLatch latch) {
		super();
		this.loc = loc;
		this.latch = latch;
	}
	@Override
	public void run() {
		for (int i = 0; i< 10 ;i++){
			try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
			System.out.println(currentThread().getName() + "  " + i + "  " + loc);
		}
		if (Lab5.loc =="")
			Lab5.loc = this.loc;
		latch.countDown();
	
		System.out.println("Final location is " + loc);
}
}
public class Lab5 {
	public static boolean flag = false;
	static String loc="";
	static String mode="";
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(1);
		CountDownLatch latch1 = new CountDownLatch(1);
		LocationSelection t1 = new LocationSelection("Lonavala", latch);
		LocationSelection t2 = new LocationSelection("Khandala", latch);
		LocationSelection t3 = new LocationSelection("Khandala1", latch);
		TransportSelection t4 = new TransportSelection("Car" , latch1);
		TransportSelection t5 = new TransportSelection("Bus" , latch1);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		latch.await();
		latch1.await();
		System.out.println(" Show this code when any one thread gets over");
		System.out.println("Final Location in Main is " + loc + " travel mode selected is  " + mode);
	}

}
