package peuler.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3 {

	private static List<Long> factors = new ArrayList<Long>();
	private static Set<Long> primes = new HashSet<Long>();

	public static void main(String[] args) {
		// long start = System.currentTimeMillis();
		// Scanner scanner = new Scanner(System.in);
		// int tcase = scanner.nextInt();
		// List<Long> input = new ArrayList<Long>();
		// for (int i = 0; i < tcase; i++) {
		// input.add(scanner.nextLong());
		// }
		// for (Long value : input) {
		// factors.clear();
		// Set<Long> primes = new HashSet<Long>();
		// boolean prime = isPrime(value);
		// // boolean prime = isPrime(value, factors, primes);
		// Collections.sort(factors);
		// if (prime)
		// System.out.println(value);
		// else if ((factors.get(factors.size() - 1)) == value)
		// System.out.println(factors.get(factors.size() - 2));
		// else
		// System.out.println(factors.get(factors.size() - 1));
		// }
		//
		// scanner.close();
		// System.out.println("Time:" + (System.currentTimeMillis() - start));
		long value = 600851475143l;
		long start = System.currentTimeMillis();
		printLargestFactor(value);
		System.out.println("Elapsed:" + (System.currentTimeMillis() - start));
	}

	private static void printLargestFactor(long value) {
		Double vd = new Double(value);
		Double sqrt = Math.sqrt(vd);
		long max = sqrt.longValue() + 1;
		for (long i = 2; i < max; i++) {
			if (value % i == 0) {
				printLargestFactor(value / i);
				return;
			}
		}
		System.out.println(value);
	}

	// public static boolean isPrime(Long n, List<Long> factors, Set<Long> primes) {
	// Double d = new Double(n);
	// Double sqrt = Math.sqrt(d);
	// long max = sqrt.intValue() + 1;
	// boolean retval = true;
	// for (long i = 2; i < max; i++) {
	// if (primes.size() == 0) {
	// addWithDivRes(n, new ArrayList<Long>(), primes, i);
	// } else {
	// for (Long prime : primes) {
	// if (i % prime == 0)
	// continue;
	// }
	// addWithDivRes(n, new ArrayList<Long>(), primes, i);
	// }
	// }
	// if (factors.size() > 0) {
	// for (Long prime : primes) {
	// if (n % prime == 0) {
	// factors.add(prime);
	// retval = false;
	// }
	// }
	// }
	// return retval;
	//
	// }
	//
	// private static void addWithDivRes(Long n, List<Long> factors, Set<Long> primes, long i) {
	// primes.add(i);
	// long div = n / i;
	// if (isPrime(div, factors, primes)) {
	// primes.add(div);
	// }
	// }

	public static boolean isPrime(Long n) {
		Double d = new Double(n);
		Double sqrt = Math.sqrt(d);
		int max = sqrt.intValue() + 1;
		for (int i = 2; i < max; i++) {
			Long li = (long) i;
			if (primes.contains(li)) {
				if (divisible(n, li)) {
					factors.add(li);
					isPrime(n / li);
					return false;
				}
			} else {
				if (primes.size() == 0) {
					primes.add(li);
					if (divisible(n, li)) {
						factors.add(li);
						isPrime(n / li);
						return false;
					}
				} else {
					for (Long prime : primes) {
						if (divisible(li, prime)) {
							continue;
						}
					}
					primes.add(li);
					if (divisible(n, li)) {
						factors.add(li);
						isPrime(n / li);
						return false;
					}
				}
			}
		}
		primes.add(n);
		factors.add(n);
		return true;
	}

	private static boolean divisible(Long n, Long li) {
		return n % li == 0;
	}

}
