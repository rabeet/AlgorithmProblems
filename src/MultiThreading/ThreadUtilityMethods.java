package MultiThreading;

public class ThreadUtilityMethods {
	public static void main(String[] args) throws InterruptedException {
		Task1 t1 = new Task1();
		t1.start();
		Task1 t2 = new Task1();
		t2.start();
		t1.join();
		t2.join();
	}
}


class Task1 extends Thread {
	public void run() {
		for (int i = 0; i <100; i++)
			System.out.println(i);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 101; i < 200; i++)
			System.out.println(i);
	}
}