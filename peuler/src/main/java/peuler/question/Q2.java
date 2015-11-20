package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Long> input = new ArrayList<Long>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextLong());
		}
		for (Long value : input) {
			long evenFibSum = findEvenFibSum(value);
			System.out.println(evenFibSum);
		}
		scanner.close();

	}

	private static long findEvenFibSum(long value) {
		long prev1 = 1;
		long prev2 = 2;
		long sum = 0;
		while (prev2 <= value) {
			if (prev2 % 2 == 0)
				sum += prev2;
			long tmp = prev1;
			prev1 = prev2;
			prev2 = tmp + prev2;
		}
		return sum;
	}

}
