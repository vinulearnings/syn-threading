import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
class MyRecursiveTask extends RecursiveTask<List<Integer>>
{
	List<Integer> list;
	Predicate<Integer> filter;
	
	public MyRecursiveTask(List<Integer> list, Predicate<Integer> filter) {
		this.list = list;
		this.filter = filter;
	}

	 private List<MyRecursiveTask> forkthetasks() {
	        List<MyRecursiveTask> subtasks =     new ArrayList<MyRecursiveTask >();

	        MyRecursiveTask  subtask1 = new MyRecursiveTask (list.subList(0, 250), filter);
	        MyRecursiveTask  subtask2 = new MyRecursiveTask (list.subList( 250, 500), filter);
	        MyRecursiveTask  subtask3 = new MyRecursiveTask (list.subList(500,750), filter);
	        MyRecursiveTask  subtask4 = new MyRecursiveTask (list.subList(750, 999), filter);
	        subtasks.add(subtask1);
	        subtasks.add(subtask2);
	        subtasks.add(subtask3);
	        subtasks.add(subtask4);
	        return subtasks;
	    }
	protected List<Integer> compute() {
	
		 //if work is above threshold, break tasks up into smaller tasks
        if(this.list.size() > 100) {
            System.out.println("Splitting workLoad : " + this.list);

            List<MyRecursiveTask > subtasks =   forkthetasks();

            for(MyRecursiveTask  subtask : subtasks){
                subtask.fork();
            }
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	List<Integer> list1 = new ArrayList<Integer>(); 
          
            for(MyRecursiveTask  subtask : subtasks) {
               list1.addAll(subtask.join());
            }
            return list1;

        } else {
            System.out.println("Doing workLoad myself: " + this.list);
        	List<Integer> list1 = new ArrayList<Integer>(); 
        	
        	for (int i = 0; i< list.size();i++){
    			if (filter.test(list.get(i)))
    					list1.add(list.get(i));
    		}
    		return list1;
        }
	}
	
}


public class Lab1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entter a number to continue..");
		scanner.nextInt();
	
		
		List<Integer> l1 = new ArrayList<>();
		for (int i = 0; i<99999;i++){
			l1.add( (int)(Math.random()*1000));
		}
		System.out.println(l1);

		l1.parallelStream().filter((x)->x>500).forEach(System.out::println);
	}

}
