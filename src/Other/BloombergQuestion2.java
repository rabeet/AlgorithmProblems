package Other;

public class BloombergQuestion2 {

	// Example 1

	// Job A before job B
	// Job B before job C

	// Valid job schedule: A, B, C


	// Example 2

	// Job A before job B
	// Job C before job B

	// schedule:    A C B


	// Example 3

	// Job A before job B, A-B
	// Job C before job D, C-D
	// Job D before job A, D-A

	// schedule: C D A B
	
	/*
	 * WTF is my input?
	 * 
	 */
	
	public static void main(String[] args) {
		Job a = new Job("A");
		Job b = new Job("B");
		Job c = new Job("C");
		Job d = new Job("D");
		a.nextJob = b;
		c.nextJob = d;
		d.nextJob = a;
		System.out.println(schedule(a,b,c,d));
	}
	
	public static String schedule(Job... jobs) {
		
		return null;
	}
	
	static class Job {
		String jobId;
		Job nextJob;
		public Job(String jobId) {
			this.jobId = jobId;
		}
	}

}
