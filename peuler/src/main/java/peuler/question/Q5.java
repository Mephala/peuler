package peuler.question;

import java.util.ArrayList;
import java.util.List;

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
		// Scanner scanner = new Scanner(System.in);
		// int tcase = scanner.nextInt();
		// List<Long> input = new ArrayList<Long>();
		// for (int i = 0; i < tcase; i++) {
		// input.add(scanner.nextLong());
		// }
		// for (Long value : input) {
		// }
		// scanner.close();

		int value = 3;
		findOkek(value);
		findOkek(10);

	}

	private static void findOkek(int value) {
		int[] nums = new int[value - 2];
		int quadrant = 2;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = quadrant;
			quadrant++;
		}
		List<Integer> factors = new ArrayList<>();
		for (int prime : primes) {
			if (prime > nums[nums.length - 1])
				break;
			boolean primeAdded = false;
			while (true) {
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
