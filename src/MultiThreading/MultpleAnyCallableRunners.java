package MultiThreading;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultpleAnyCallableRunners {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		String result = ex.invokeAny(Arrays.asList(new CallableTask("Rabeet"), new CallableTask("Omair")));
		System.out.println(result);
	}
}
