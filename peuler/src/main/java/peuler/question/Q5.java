package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

	private static List<Integer> primes = new ArrayList<>();

	static {
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		primes.add(17);
		primes.add(19);
		primes.add(23);
		primes.add(29);
		primes.add(37);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextInt());
		}
		for (Integer value : input) {
			findOkek(value);
		}
		scanner.close();

	}

	private static void findOkek(int value) {
		int[] nums = new int[value - 1];
		int quadrant = 2;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = quadrant;
			quadrant++;
		}
		List<Integer> factors = new ArrayList<>();
		for (int prime : primes) {
			boolean allOne = true;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 1) {
					allOne = false;
					break;
				}
			}
			if (allOne)
				break;
			while (true) {
				boolean primeAdded = false;
				boolean divisible = false;
				for (int j = 0; j < nums.length; j++) {
					int num = nums[j];
					if (num % prime == 0) {
						if (!primeAdded) {
							factors.add(prime);
							primeAdded = true;
						}
						divisible = true;
						nums[j] = nums[j] / prime;
					}
				}
				if (!divisible)
					break;
			}
		}
		long sum = 1;
		for (Integer factor : factors) {
			sum *= factor;
		}
		System.out.println(sum);
	}

}
