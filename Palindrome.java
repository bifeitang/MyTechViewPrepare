/**
 * Palindrome:
 * A palindrome string is a string when all the nonalphanumeric are removed it reads the same from front to back ignoring the case
 * A palindrome decimal number is reading the same from front and back (negative number isn't, have to discuss the proper return value with interviewer)
 * */
public class Palindrome {
	public static boolean isPalindormicNum (int num) {
		if (num < 0)	return false;
		//Remember the usage of final, and how to get a number's digit number
		final int numDigits = (int)(Math.floor(Math.log10(num))) + 1;
		int mask = (int)(Math.pow(10, numDigits - 1));		//Pay attention to the usage of math.pow, math.floor, math.log
		while (mask != 0) {
			if (num/mask != num%10) 	return false;
			num = num % mask;
			num = num / 10;
			mask = mask / 100;
		}
		return true;
	}
	
	/**
	 * Be aware of what is alphanumeric: consisted by number and alphabet
	 * How to determine: Use character check
	 * */
	
	public static boolean isPalindromicString (String test) {
		//Corner case: if the string is null
		if (test == null || test.length() == 0)		return true;
		int start = 0, end = test.length() - 1;
		while (start <= end) {
			if (!isValid(test.charAt(start))) {
				start++;
				continue;
			}
			if (!isValid(test.charAt(end))) {
				end--;
				continue;
			}
			
			//Have to change it to lower case as well
			if (Character.toLowerCase(test.charAt(start)) != Character.toLowerCase(test.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	private static boolean isValid (Character a) {
		return Character.isLetterOrDigit(a);
	}
	
	public static void main (String[] args) {
		System.out.println(isPalindormicNum(2929));
		String test = "ab.c3****43cb,a";
		System.out.println(isPalindromicString(test));
	}
}
