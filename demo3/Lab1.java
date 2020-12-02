import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lab1 {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			for (int i = 0; i< 9;i++){
				System.out.println(Thread.currentThread().getName() + "===> " + i);
					}
				System.out.println();
			
		};
		System.out.println("In main...");
	//	ExecutorService ex = Executors.newSingleThreadExecutor();
	//	ExecutorService ex = Executors.newCachedThreadPool();
		ExecutorService ex = Executors.newFixedThreadPool(3);
		ex.submit(runnable);
    	ex.submit(runnable);
    	ex.submit(runnable);
    	ex.submit(runnable);
    	ex.submit(runnable);
	}
}
