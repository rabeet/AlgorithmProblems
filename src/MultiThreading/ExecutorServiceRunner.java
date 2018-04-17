package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	public static void main(String[] args) throws InterruptedException {
//		ExecutorService executor = Executors.newSingleThreadExecutor(); // single thread at a time
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Thread1());
		executor.execute(new Thread2());
		executor.execute(new Thread3());
		executor.shutdown();
	}

}
