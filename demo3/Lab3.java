import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class Lab3Helper extends Thread{
	private ReentrantLock lock;
	private List<String> list ;
	 public Lab3Helper(List<String> list, ReentrantLock lock) {
		 this.list = list;
		 this.lock = lock;
	}
	@Override
	public void run() {
		
		for (int i = 0;i < 50;i++){
				lock.lock();
				list.add(this.currentThread().getName() +"" +i);
				lock.unlock();
		}
		System.out.println("Current Size " + list.size() + " for thread " + this.currentThread().getName());
	}
}
public class Lab3 {
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	final ReentrantLock lock = new ReentrantLock();
	Lab3Helper t1 = new Lab3Helper(list, lock);
	Lab3Helper t2 = new Lab3Helper(list, lock);
	Lab3Helper t3 = new Lab3Helper(list, lock);
	t1.start();
	t2.start();
	t3.start();
}
}
