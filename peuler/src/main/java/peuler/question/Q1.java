package peuler.question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

	private static final BigDecimal v2 = new BigDecimal(2);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Long> input = new ArrayList<Long>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextLong());
		}
		for (Long value : input) {
			long sum = findSum(value);
			System.out.println(sum);
		}

		scanner.close();

	}

	private static long findAllSum(long value) {
		return (value * (value + 1)) / 2;
	}

	private static long findSum(long value) {
		value--;
		long sum3 = 3 * findAllSum(value / 3);
		long sum5 = 5 * findAllSum(value / 5);
		long sum15 = 15 * findAllSum(value / 15);
		return sum3 + sum5 - sum15;
	}

}
