import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Lab2 {

	public static void main(String[] args) {
		System.out.println("in main");
		Runnable run1 = ()->{
			System.out.println(new Date());
		};
	
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
	//	ses.schedule(run1,5, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(run1,5, 2,TimeUnit.SECONDS);
	}
	

}
