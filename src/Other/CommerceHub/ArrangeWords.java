package Other.CommerceHub;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeWords {
	
	public static void main(String[] args) {
		System.out.println(arrange("I love to code."));
		System.out.println(arrange("The lines are printed in reverse order."));
		System.out.println(arrange("bye tye she    jye."));
		System.out.println(arrange("    Yo.    "));
		System.out.println(arrange("Hye   dshd   ."));
		System.out.println(arrange("Cats and hats."));
		System.out.println(arrange("M f s a g a q sd da f."));
		System.out.println(arrange("  My name  is  rabeet h."));
		System.out.println(arrange("Oh."));
		System.out.println(arrange("Oh o o o o o o o o o o o o oof fo lol."));
	}
	
	static String arrange(String sentence) {
        String[] sArr = sentence.toLowerCase().replace(".", "").split(" ");
        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            	if (s1.length() < s2.length())
            		return -1;
            	else if (s1.length() == s2.length())
            		return 0;
            	else return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : sArr) {
        	sb.append( s+ " ");
        }
        String output = sb.toString().trim();
        return output.substring(0, 1).toUpperCase() + output.substring(1)+".";
    }

}
