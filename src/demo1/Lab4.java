import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			for (int i = 0; i< 9900;i++){
				System.out.print("x");
				if (i % 80 ==0)
						System.out.println();
			}
		};
	
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In main...");
		Thread t1 =new Thread(runnable);
		t1.start();
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In end of  main...");
			
	}

}
