public class Prob8_StringToInteger {
	
	public static void main(String[] args) {
		System.out.println(myAtoi("       -108018243r52"));
	}
	
	public static int myAtoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();
		if (!str.matches("[0-9|\\+|\\-].*")) {
			return 0;
		}
		String num = "";
		char[] carr = str.toCharArray();
		for (int i = 0; i < carr.length; i++) {
			char c = carr[i];
			// First element can either be +,-, or #
			if (i == 0) {
				if ((c+"").matches("[0-9]|\\+|\\-")) {
					if (c != '0' && c != '+')
						num += c;
				} 
				else {
					break;
				}
				continue;
			}
			// Every element afterwards
			if ((c+"").matches("[0-9]")) {
				num += c;
			}
			else {
				break;
			}
		}
		
		if (num.length() < 1)
			return 0;
		
		if (num.matches("\\+|\\-") && num.length() == 1)
			return 0;
		
		if (num.length() > (""+Integer.MIN_VALUE).length() && num.charAt(0) == '-') {
				return Integer.MIN_VALUE;
		}
		if (num.length() > (""+Integer.MAX_VALUE).length() && num.charAt(0) != '-')
			return Integer.MAX_VALUE;
		
		String max = ""+Integer.MAX_VALUE, min = ""+Integer.MIN_VALUE;
		max = max.substring(0, max.length()-1);
		min = min.substring(0, min.length()-1);
		
		if (num.matches(""+max+"[8-9]"))
			return Integer.MAX_VALUE;
		if (num.matches(""+min+"[9]"))
			return Integer.MIN_VALUE;
					
		return Integer.parseInt(num);
	}

}
