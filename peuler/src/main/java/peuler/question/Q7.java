package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7 {

	private static List<Long> primes = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < tcase; i++) {
			input.add(scanner.nextInt());
		}
		for (Integer value : input) {
			findPrime(value);
		}
		scanner.close();

	}

	private static void findPrime(int i) {
		if (primes.size() >= i) {
			System.out.println(primes.get(i - 1));
			return;
		}

		for (long j = 2; j < Long.MAX_VALUE; j++) {
			boolean isPrime = true;
			for (Long prime : primes) {
				if (j % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(j);
			}
			if (primes.size() >= i) {
				System.out.println(primes.get(i - 1));
				return;
			}
		}

	}

}
