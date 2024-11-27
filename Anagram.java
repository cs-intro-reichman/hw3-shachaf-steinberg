/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {

		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// checks how many times a char appears in String and returns the count
	public static int charAmount(String str, char c) {
		int count = 0;
		if (c == 32) {
			return count;
		}
        for (int j = 0; j < str.length() ;j++) {
            if (str.charAt(j) == c) {
                count++;
            }
        }
            return count;
    }

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		boolean result = true;
		for (int i = 0; i < str1.length() ;i++) {
            if (charAmount(str1, str1.charAt(i)) != charAmount(str2, str1.charAt(i))) {
                result = false;
                break;
            }
		}
        return result;
	}

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newString = "";

		for (int i = 0; i < (str.length()) ;i++) {
            char c = str.charAt(i); 
            if ((c >= 65) && (c <= 90)) {
            	c += 32;
				newString += c;
			} else if ((c == 32) || ((c >= 97) && ( c <= 122))) {
				newString += c;
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String strHelper = str;
		String newString = str;
		String resultString = "";
		for (int i = 0; i < str.length(); i++) {
			int randomNumber = (int)((Math.random() * (newString.length()) - 1));
			resultString += newString.charAt(randomNumber);
			strHelper = newString;
			newString = "";
			newString += strHelper.substring(0, randomNumber); 
			newString += strHelper.substring(randomNumber + 1, strHelper.length());
		}
		return resultString;
	}
}
