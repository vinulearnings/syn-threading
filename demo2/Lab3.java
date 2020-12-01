import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Lab3Helper extends Thread{
	private String str1;
	private String str2;
	 
	public Lab3Helper(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public void run() {
		synchronized (str1) {
			System.out.println(currentThread().getName() +  "   Locked Str1");
			try { 	Thread.sleep( (long)(Math.random()*10000));} catch (InterruptedException e) { }
				synchronized(str2)
				{
					System.out.println(currentThread().getName() +  "   Locked Str1 and Str2");
				    try { 	Thread.sleep( (long)(Math.random()*10000));} catch (InterruptedException e) { }
				}
		}	
	}
}
public class Lab3 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Entter a number to continue..");
	scanner.nextInt();

	String str1 ="STR1";
	String str2 = "STR2";
	Lab3Helper t1 = new Lab3Helper(str1, str2);
	t1.setName("AOne");
	Lab3Helper t2 = new Lab3Helper(str2, str1);
	t2.setName("ATwo");
	
	
	t1.start();
	t2.start();

	
}
}
