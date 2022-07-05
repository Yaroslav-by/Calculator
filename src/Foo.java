import java.util.Scanner;

class Foo {

	public static void main(String[] args) {
    	
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] a = line.split(" ");
		
		try {
			double first;
			double second;
			
			if (a[0].contains(".")) {
				first = stringToDouble(a[0]);
			} else {
				first = Integer.parseInt(a[0]);
			}
			
			if (a[2].contains(".")) {
				second = stringToDouble(a[2]);
			} else {
				second = Integer.parseInt(a[2]);
			}

			char operation;
			
			if (a[1].length() > 1) {
				throw new OperationException();
			} else if (a[1].equals("+") || a[1].equals("-") || a[1].equals("*") || a[1].equals("/")) {
				operation = a[1].charAt(0);
				if (operation == '/' && second == 0) {
					throw new ArithmeticException();
				}
			} else {
				throw new OperationException();
			}
			
			switch (operation) {
				case '+': System.out.println(first + second); 
			break;
				case '-': System.out.println(first - second); 
			break;
				case '*': System.out.println(first * second); 
			break;
				case '/': System.out.println((double) first / second); 
			break;
			}

		} catch(NumberFormatException e) {
			System.out.println("Error! Not number");
		} catch (OperationException e) {
			System.out.println("Operation Error!");
		} catch (ArithmeticException e) {
			System.out.println("Error! Division by zero");
		}		
    }
	
	public static double stringToDouble(String s) {
		String[] temp = s.split("\\.");
		double first = Integer.parseInt(temp[0]);
		return first = first + (Integer.parseInt(temp[1]) / Math.pow(10, temp[1].length()));
	}
    
}

class OperationException extends Exception {
	
}




