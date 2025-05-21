import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = askInput(scanner);

		scanner.close();

		float result = calculate(input);

		System.out.println("Le résultat de l'expression " + input + " est : " + result);
	}

	public static String askInput(Scanner scanner) {
		System.out.print("Entrer un calcul : ");

		String input = scanner.nextLine();

		if (input.isEmpty()) {
			System.out.println("L'entrée ne peut pas être vide.");

			return askInput(scanner);
		}

		if (!isValidExpression(input)) {
			System.out.println("L'entrée n'est pas valide.");

			return askInput(scanner);
		}

		return input;
	}

	public static boolean isValidExpression(String expression) {
		String regex = "^[0-9]+(.[0-9]+)?(\s?[-+*/]\s?(.[0-9]+)?)*$";

		return expression.matches(regex);
	}

	public static String[] parseExpression(String expression) {
		String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");

		return tokens;
	}

	public static float calculate(String expression) {
		String[] tokens = parseExpression(expression);
		float result = Float.parseFloat(tokens[0].trim());

		for (int i = 1; i < tokens.length; i += 2) {
			String operator = tokens[i].trim();
			float operand = Float.parseFloat(tokens[i + 1].trim());

			switch (operator) {
				case "+":
					result += operand;
					break;

				case "-":
					result -= operand;
					break;

				case "*":
					result *= operand;
					break;

				case "/":
					if (operand == 0) {
						throw new ArithmeticException("Division by zero is not allowed");
					}

					result /= operand;
					break;

				default:
					throw new IllegalArgumentException("Invalid operator: " + operator);
			}
		}

		return result;
	}
}