package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Long> input = new ArrayList<Long>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextLong());
		}
		for (Long value : input) {
			findLargestPalindrome(value);
		}
		scanner.close();

	}

	private static void findLargestPalindrome(long value) {
		value--;
		for (long i = value; i >= 101101; i--) {
			if (isPalindrome(i) && hasQuatrants(i)) {
				System.out.println(i);
				return;
			}
		}
	}

	private static boolean hasQuatrants(long value) {
		for (int i = 999; i > 100; i--) {
			if (value % i == 0 && (value / i) <= 999)
				return true;
		}
		return false;
	}

	private static boolean isPalindrome(long palind) {
		String s = Long.valueOf(palind).toString();
		return s.equals(reverseString(s));
	}

	private static String reverseString(String a) {
		String r = "";
		char[] chars = a.toCharArray();
		for (int i = 5; i >= 0; i--) {
			r += chars[i];
		}
		return r;
	}

}
