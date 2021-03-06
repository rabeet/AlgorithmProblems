package Utilities;
import java.io.File;
import java.io.FileWriter;

public class Readme {

	/*
	 * Readme generator to make it look goood!
	 */
	public static void main(String[] args) throws Exception{
		File file = new File("src/LeetCode");
		if (!file.isDirectory()) {
			System.out.println("Can't find 'LeetCode' directory in /src directory.");
			System.exit(1);
		}
		File[] list = file.listFiles();
		File readme = new File("Readme.md");
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Rabeet's LeetCode solutions</h2>"
				+ "<h3>Total solved: " + (list.length-2) + "</h3>"
				+ "<center><table id =\"leet\"><tr><th>No.</th>  <th>Title</th>  <th>Solution</th></tr>");

		for (File fl : list) {
			String text = fl.getName();
			String num = "";
			try {
			num = text.substring(text.indexOf('b')+1, text.indexOf('_'));
			} catch (Exception e) {
				num = "";
			}
			String title = text.substring(text.indexOf('_') + 1, text.indexOf('.'));
			title = format(title);
			String solution = text.contains("java") ? "Java" : text.contains("cpp")? "CPP":"";

			sb.append("<tr>");
			sb.append("<th><a href=\"src/LeetCode/" +text+ "\">" + num + "</a></th>");
			sb.append("<th><a href=\"http://www.google.com/search?q=" +title+ " leetcode&btnI"+ "\">" + title + "</a></th>");
			sb.append("<th>" + solution + "</th>");
			sb.append("</tr>");

		}

		sb.append("</table></center>");
		
		FileWriter writer = new FileWriter(readme, false);
		writer.write(sb.toString());
	    writer.close();
		System.out.println("Done!");
	}

	private static String format(String text) {
		String ans = "";
		for (int i = 0; i < text.length(); i++) {
			Character c = text.charAt(i);

			if (Character.isUpperCase(c))
				ans += " " + c;
			else
				ans += "" + c;
		}
		return ans;
	}

}
