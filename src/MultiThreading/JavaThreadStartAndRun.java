package MultiThreading;

import java.util.stream.IntStream;

public class JavaThreadStartAndRun {
	public static void main(String[] args) throws InterruptedException {
//		System.out.println(Math.ceil(-82.4));
//		System.out.println(Math.pow(-6, 2));
//		new Thread1().run(); // DON'T do this - this does not start the thread parellely
		Thread1 t = new Thread1();
		Thread2 t2 = new Thread2();
		t.start();
		t2.start();
		t.join(); // wait for t and t2 to end
		t2.join();
		
		Thread4 t4 = new Thread4();
		Thread t4thread = new Thread(t4);
		t4thread.start();
		t4thread.join(0);
	}
}

class Thread1 extends Thread {
	public void run() {
		IntStream.range(1, 101).forEach(n -> System.out.println("T1: " +n));
	}
}

class Thread2 extends Thread {
	public void run() {
		IntStream.range(101, 201).forEach(n -> System.out.println("T2: " + n));
	}
}

class Thread3 extends Thread {
	public void run() {
		IntStream.range(201, 301).forEach(n -> System.out.println("T3: " + n));
	}
}

class Thread4 implements Runnable {

	@Override
	public void run() {
		IntStream.range(301, 401).forEach(n -> System.out.println("T4: " + n));
	}
	
}