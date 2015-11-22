package peuler.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcase = scanner.nextInt();
		List<Integer> digits = new ArrayList<>();
		List<String> inputs = new ArrayList<>();
		for (int i = 0; i < tcase; i++) {
			scanner.nextLine();
			digits.add(Integer.parseInt(scanner.nextLine().split(" ")[1]));
			inputs.add(scanner.next());
		}
		for (int i = 0; i < tcase; i++) {
			findLargestConsecDigitProduct(digits.get(i), inputs.get(i));
		}
		scanner.close();
	}

	private static void findLargestConsecDigitProduct(int consc, String num) {
		int max = 0;
		for (int i = 0; i <= num.length() - consc; i++) {
			int product = 1;
			for (int j = i; j < i + consc; j++) {
				product *= Integer.parseInt(num.substring(j, j + 1));
				if (product == 0)
					break;
			}
			if (product > max)
				max = product;
		}
		System.out.println(max);
	}

}
