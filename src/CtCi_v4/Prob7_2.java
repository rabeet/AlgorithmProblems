package CtCi_v4;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Prob7_2 {
	/*
	 * Design a call center with three levels of employees
	 * which routes calls to fresher, TL or PM whoever is available starting
	 * from fresher.
	 */
	
	class User {
		private String name;
		private int dob;
		private boolean free;
		public User(String name, int dob) {
			super();
			this.name = name;
			this.dob = dob;
			free = true;
		}
		public void becomeFree() {free = true;}
		public void becomeBusy() {free = false;}
		public boolean getStatus() {return free;}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDob() {
			return dob;
		}
		public void setDob(int dob) {
			this.dob = dob;
		}
	}
	
	class Fresher extends User {
		public Fresher(String name, int dob) {
			super(name, dob);
		}
		
		public void escalate(Call call) {
			
		}
	}
	
	class TL extends User {
		public TL(String name, int dob) {
			super(name, dob);
		}
		
		public void escalate(Call call) {
			
		}
	}
	
	class PM extends User {
		public PM(String name, int dob) {
			super(name, dob);
		}
	}
	
	class Call {
		private String phoneNumber;
		public String phoneNum() {
			return phoneNumber;
		}
		public Call(String s) {
			phoneNumber = s;
		}
	}
	
	static class CallForwarder {
		private Queue<Call> queue;
		private List<User> users;
		private static CallForwarder forwarder = new CallForwarder();
		private CallForwarder() { queue = new ArrayDeque<>(); }
		public CallForwarder getForwarder() {return forwarder;}
		public void receiveCall(Call call) throws Exception {
			if (!queue.offer(call))
				throw new Exception("Call not completed");
			User user = getCallHandler();
			// dispatch call to this user
		}
		private User getCallHandler() {
			
			return null;
		}
	}
}
