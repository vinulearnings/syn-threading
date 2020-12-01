import java.util.Scanner;
class Lab3Support implements Runnable{
	public void run() {
		for (int i = 0; i< 9900;i++){
			System.out.print(".");
			if (i % 80 ==0)
					System.out.println();
		}
	}
}
public class Lab3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In main...");
		Thread t1 =new Thread(new Lab3Support());
		t1.start();
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In end of  main...");
			
	}

}
