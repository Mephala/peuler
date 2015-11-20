package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
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
		long sum = 0;
		for (int i = 1; i < value; i++) {
			for (int j = i + 1; j <= value; j++) {
				sum += 2 * i * j;
			}
		}
		System.out.println(sum);
	}

}
