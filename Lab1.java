package dyn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
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

	        MyRecursiveTask  subtask1 = new MyRecursiveTask (list.subList(0, list.size()/2), filter);
	        MyRecursiveTask  subtask2 = new MyRecursiveTask (list.subList( list.size()/2,  list.size()), filter);
	        subtasks.add(subtask1);
	        subtasks.add(subtask2);
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


public class Lab2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entter a number to continue..");
		scanner.nextInt();
	
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i< 500;i++){
				list.add((int)(Math.random() *1000));
		}
		Predicate<Integer> pred = (num)->num>200;
		
		MyRecursiveTask task = new MyRecursiveTask(list, pred);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		List<Integer> sortedlist = forkJoinPool.invoke(task);
			System.out.println(sortedlist);
	}

}
