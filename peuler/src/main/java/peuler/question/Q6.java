package peuler.question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q6 {

	private static Map<Integer, Long> valueResult = new HashMap<>();

	private static void initiateCache() {
		for (int i = 1; i <= 10000; i++) {
			double sum = ((double) ((i * (i + 1)) / 2));
			long squareSum = i * (i + 1) * ((2 * i) + 1);
			long sumSquare = (long) Math.pow(sum, 2d);
			valueResult.put(i, sumSquare - squareSum);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		// if (tcase > 100)
		// initiateCache();
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextInt());
		}
		for (Integer value : input) {
			findSumDifference(value);
		}
		scanner.close();

	}

	private static void findSumDifference(int value) {
		BigDecimal bdValue = new BigDecimal(value);
		BigDecimal bdValue1 = new BigDecimal(value + 1);
		BigDecimal two = new BigDecimal(2);
		BigDecimal six = new BigDecimal(6);
		BigDecimal sum = bdValue.multiply(bdValue1).divide(two);
		BigDecimal squareSum = bdValue.multiply(bdValue1).multiply(two.multiply(bdValue).add(new BigDecimal(1))).divide(six);
		BigDecimal sumSquare = sum.multiply(sum);
		System.out.println(sumSquare.subtract(squareSum).toPlainString());
	}

}
