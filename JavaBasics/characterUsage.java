package JavaBasics;

public class characterUsage {
	public static void checkCharacter () {
		String test = "aA,1*";
		for (int i = 0; i < test.length(); i++) {
			if (Character.isAlphabetic(test.charAt(i))) {
				System.out.println("isAlphabetic: " + test.charAt(i));
			}
			if (Character.isDigit(test.charAt(i))) {
				System.out.println("isDigit: " + test.charAt(i));
			}
			//Recommend: isLetter, although no much difference with isAlpahbetic
			if (Character.isLetter(test.charAt(i))) {
				System.out.println("isLetter: " + test.charAt(i));
			}
			if (Character.isLetterOrDigit(test.charAt(i))) {
				System.out.println("isLetterOrDigit: " + test.charAt(i));
			}
			if (Character.isLowerCase(test.charAt(i))) {
				System.out.println("isLowerCase: " + test.charAt(i));
			}
			if (Character.isTitleCase(test.charAt(i))) {
				System.out.println("isTitleCase: " + test.charAt(i));
			}
			if (Character.isUpperCase(test.charAt(i))) {
				System.out.println("isUpperCase: " + test.charAt(i));
				//Use function to change UpperCase to lower case, but this function won't change the original value, which means test.charAt(i) is still UpperCase
				System.out.println("toLowerCase result: " + Character.toLowerCase(test.charAt(i)));
			}
		}
	}
	
	public static void main (String[] args) {
		checkCharacter();
	}
}
