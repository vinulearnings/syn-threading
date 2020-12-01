import java.util.ArrayList;
import java.util.List;

class Lab2Helper extends Thread{
	private List<String> list ;
	 public Lab2Helper(List<String> list) {
		 this.list = list;
	}
	@Override
	public void run() {
		for (int i = 0;i < 50;i++){
					list.add(this.currentThread().getName() +"" +i);
		}
		System.out.println("Current Size " + list.size() + " for thread " + this.currentThread().getName());
	}
}
public class Lab2 {
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	Lab2Helper t1 = new Lab2Helper(list);
	Lab2Helper t2 = new Lab2Helper(list);
	Lab2Helper t3 = new Lab2Helper(list);
	t1.start();
	t2.start();
	t3.start();
}
}
