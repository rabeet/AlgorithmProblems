package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyProducerConsumer {

	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		// Object lock = new Object();
		List<Integer> list = new ArrayList();
		Thread prod = new Thread(new Producer(list, lock));
		Thread cons = new Thread(new Consumer(list, lock));

		prod.start();
		cons.start();
	}

	static class Producer implements Runnable {

		int i = 0;
		List<Integer> list;
		Object lock;

		public Producer(List<Integer> list, Object lock2) {
			this.list = list;
			this.lock = lock2;
		}

		public void run() {
			Random random = new Random();
			while (true) {
				synchronized (lock) {
					try {
//						lock.wait();
						int r = random.nextInt(10);
						list.add(r);
						System.out.println("Produced: " + r);
						lock.notify();
						Thread.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	static class Consumer implements Runnable {

		List<Integer> list;
		Object lock;

		public Consumer(List<Integer> list, Object lock2) {
			this.list = list;
			this.lock = lock2;
		}

		public void run() {
			while (true) {
				try {
					Thread.sleep(200);
					synchronized (lock) {
//						 lock.wait();
						while (list.size() > 0) {
							System.out.println("Consumed: " + list.remove(list.size() - 1) + " list size: " + list.size());
						}
						lock.notify();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
