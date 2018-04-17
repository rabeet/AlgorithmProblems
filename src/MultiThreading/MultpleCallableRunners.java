package MultiThreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultpleCallableRunners {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService ex = Executors.newFixedThreadPool(1);
//		Stream.of(new CallableTask("Rabeet"), new CallableTask("Omair"), new CallableTask("Fatmi")).forEach(e -> ex.submit(e));
		List<Future<String>> results = ex.invokeAll(Arrays.asList(new CallableTask("Rabeet"), new CallableTask("Omair")));
		results.stream().forEach(e -> {
			try {
				System.out.println(e.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		ex.shutdown();
	}
}