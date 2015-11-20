package peuler.question;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Long> input = new ArrayList<Long>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextLong());
		}
		for (Long value : input) {

		}

		scanner.close();
		long value = 10;
		long sum = findSum(value);
		System.out.println(sum);
	}

	private static long findSum(long value) {
		long max = 0;
		for (int i = 0; i < value; i++) {
			if (i % 3 == 0)
				max += i;
			else if (i % 5 == 0)
				max += i;
		}
		return max;
	}

}
