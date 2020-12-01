import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Lab2Helper extends Thread{
	private List<String> list ;
	 public Lab2Helper(List<String> list) {
		 this.list = list;
	}
	@Override
	public void run() {
		
		for (int i = 0;i < 50;i++){
		//	synchronized (list) {
				list.add(this.currentThread().getName() +"" +i);
		//	}
					
		}
		System.out.println("Current Size " + list.size() + " for thread " + this.currentThread().getName());
	}
}
public class Lab2 {
public static void main(String[] args) {
// Option 1 - Normal List + Synchronized Block
//	List<String> list = new ArrayList<>();
// Option 2 - Synchronized Collections	
	List<String> list =Collections.synchronizedList(new ArrayList<>());
	Lab2Helper t1 = new Lab2Helper(list);
	Lab2Helper t2 = new Lab2Helper(list);
	Lab2Helper t3 = new Lab2Helper(list);
	t1.start();
	t2.start();
	t3.start();
}
}
