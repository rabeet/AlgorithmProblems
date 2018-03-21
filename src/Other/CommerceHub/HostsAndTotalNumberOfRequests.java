package Other.CommerceHub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HostsAndTotalNumberOfRequests {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// read the string filename
		String filename;
		filename = scan.nextLine();

		// get buffered reader
		BufferedReader reader = getReader(filename);
		// create file and get its writer
		FileWriter writer = getWriter("records_" + filename);
		// Create hashmap to store the K,V pair
		Map<String, Integer> map = new HashMap<>();
		
		String line;
		try {
			// Get the hosts and its requests
			while ((line = reader.readLine()) != null) {
				String host = line.substring(0, line.indexOf(' '));
				map.put(host, map.getOrDefault(host, 0)+1);
			}
			// Write the output to file
			Set<String> set = map.keySet();
			boolean start = true;
			for (String host : set) {
				writer.write(start?host + " " + map.get(host):"\n"+host + " " + map.get(host));
				start = false;
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static FileWriter getWriter(String filename) {
		File file = new File(filename);
		FileWriter fw = null;
		try {
			file.createNewFile();
			fw = new FileWriter(file);
		} catch (IOException e) {
			System.err.println(filename + " already exists!");
			System.exit(0);
		}
		return fw;
	}

	private static BufferedReader getReader(String filename) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.err.println(filename + " does not exist!");
			System.exit(1);
		}
		return br;
	}

}
