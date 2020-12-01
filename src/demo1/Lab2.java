import java.util.Scanner;
class Lab2Support extends Thread{
	@Override
	public void run() {
		for (int i = 0; i< 9999900;i++){
			System.out.print(".");
			if (i % 80 ==0)
					System.out.println();
		}
	}
}
public class Lab2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In main...");
		Lab2Support ls = new Lab2Support();
		ls.start();
		System.out.println("Enter a number to continue..");
		scanner.nextInt();
		System.out.println("In end of  main...");
			
	}

}
