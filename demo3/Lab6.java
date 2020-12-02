import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Lab6Support extends Thread{
	private CyclicBarrier barrier ;
	
	public Lab6Support(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		String flat =Thread.currentThread().getName();
		System.out.println("started working on " + flat);
		try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
		System.out.println("Completed Plastering for " + flat);
		try {
			barrier.await();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
		System.out.println("Completed Colouring for " + flat);
		try {
			barrier.await();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
		System.out.println("Completed Decorating  " + flat);
		
		
	}
	
}

public class Lab6 {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		Lab6Support flat1 = new Lab6Support(barrier);
		flat1.setName("Flat1");
		Lab6Support flat2 = new Lab6Support(barrier);
		flat2.setName("Flat2");
		Lab6Support flat3 = new Lab6Support(barrier);
		flat3.setName("Flat3");
		flat1.start();
		flat2.start();
		flat3.start();
	}

}
