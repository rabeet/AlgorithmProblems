package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(1);
		Future<String> task = ex.submit(new CallableTask("Rabeet"));
		System.out.println(task.get());
		ex.shutdown();
	}

}
// Callable -> send data to thread and get result back
// Runnable -> just run thread
class CallableTask implements Callable<String> {
	
	private String name;
	
	public CallableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello " + name;
	}
	
}