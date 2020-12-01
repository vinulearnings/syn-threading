import java.awt.geom.FlatteningPathIterator;

class Lab4Support extends Thread{
	private String loc;

	public Lab4Support(String loc) {
		super();
		this.loc = loc;
	}
	@Override
	public void run() {
		for (int i = 0; i< 10 && Lab4.flag== false;i++){
			try { 	Thread.sleep( (long)(Math.random()*1000));} catch (InterruptedException e) { }
			System.out.println(currentThread().getName() + "  " + i);
			
		}
		if (Lab4.flag==false){
			Lab4.flag = true;		
			System.out.println("Final location is " + loc);
	}
	
}
}
public class Lab4 {
	public static boolean flag = false;
	public static void main(String[] args) {
		Lab4Support t1 = new Lab4Support("Lonavala");
		Lab4Support t2 = new Lab4Support("Khandala");
		Lab4Support t3 = new Lab4Support("Khandala1");
		t1.start();
		t2.start();
		t3.start();
		/*try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Final Location in Main is " );*/
	}

}
