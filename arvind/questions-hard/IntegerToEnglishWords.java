/**
 * https://leetcode.com/problems/integer-to-english-words/description/ Input:
 * 123 Output: "One Hundred Twenty Three"
 **/

public class IntegerToEnglishWords {
	public static String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		return numberToWordsHelper(num).trim();
	}

	public static String numberToWordsHelper(int num) {
		String[] singles = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] hundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

		if (num < 20) {
			return singles[num];
		} else if (num < 100)
			return hundred[num / 10] + " " + numberToWordsHelper(num % 10);

		else if (num < 1000)
			return numberToWordsHelper(num / 100).trim() + " Hundred " + numberToWordsHelper(num % 100);

		else if (num < 1000000)
			return numberToWordsHelper(num / 1000).trim() + " Thousand " + numberToWordsHelper(num % 1000);

		else if (num < 1000000000)
			return numberToWordsHelper(num / 1000000).trim() + " Million " + numberToWordsHelper(num % 1000000);
		else
			return numberToWordsHelper(num / 1000000000).trim() + " Billion " + numberToWordsHelper(num % 1000000000);
	}
}