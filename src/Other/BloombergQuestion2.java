package Other;

import java.util.ArrayList;
import java.util.List;

public class BloombergQuestion2 {

	// Example 1

	// Job A before job B
	// Job B before job C

	// Valid job schedule: A, B, C

	// Example 2

	// Job A before job B
	// Job C before job B

	// schedule: A C B

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
		Job schedule = schedule(a, b, c, d);
		System.out.println(schedule);
	}

	public static Job schedule(Job... jobs) {
		List<Job> jobList = new ArrayList();
		for (Job j : jobs) {
			int ind = jobList.indexOf(j.nextJob);
			if (ind != -1)
				jobList.add(ind, j);
			else
				jobList.add(0, j);
		}
		return jobList.get(0);
	}

	static class Job {
		String jobId;
		Job nextJob;

		public Job(String jobId) {
			this.jobId = jobId;
		}

		@Override
		public String toString() {
			String ret = jobId + "";
			if (this.nextJob != null) {
				ret += " -> " + this.nextJob.toString();
			}
			return ret;
		}
	}

}
