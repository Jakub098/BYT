package p1;

import java.util.Scanner;

public class Driver {
	public static int result = 0;
	static Request req = null;

	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the first number, operation and the second number: ");
			String input = sc.nextLine();
			String[] splitted = input.split(" ");
			String operation = splitted[1];
			int first = Integer.parseInt(splitted[0]);
			int second = Integer.parseInt(splitted[2]);

			req = new Request(first, second, operation);
			
			Chain chainAdd = new Add();
			Chain chainSub = new Subtract();
			Chain chainMul = new Multiply();
			Chain chainDiv = new Divide();

			chainAdd.setNextChain(chainSub);
			chainSub.setNextChain(chainMul);
			chainMul.setNextChain(chainDiv);

			chainAdd.calculate(req);
			System.out.println(result);

		} catch (NumberFormatException e) {
			System.err.println(
					"can't parse to a number.\nit has to be a number, operation and another number\n(Only one space between each value)");
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.err.println(
					"wrong input.\nit has to be a number, operation and another number\n(Only one space between each value)");
		} catch (NullPointerException e3) {
			System.err.println(
					"this program can't handle operation: " + req.getOperation());
		}

		
		
	}

}
