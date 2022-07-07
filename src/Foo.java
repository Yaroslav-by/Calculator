import java.io.*;
import java.util.Scanner;

class Foo {

	public static void main(String[] args) {
    	
		File file = new File("input.txt");
		try (FileWriter writer = new FileWriter("output.txt", false);
			 Scanner sc = new Scanner(file);)
		{
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] a = line.split(" ");
				
				double first;
				double second;
				try {
					first = Double.parseDouble(a[0]);
					second = Double.parseDouble(a[2]);
				} catch (Exception e) {
					writer.write(line + " = Error! Not number;\n");
					continue;
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
				
				double result = 0;
				switch (operation) {
					case '+': result = first + second; 
				break;
					case '-': result = first - second; 
				break;
					case '*': result = first * second; 
				break;
					case '/': result = first / second; 
				break;
				}
				
				String temp = line + " = " + Double.toString(result) + ";";
				writer.write(temp + "\n");
			}
		} catch (OperationException e) {
			System.out.println("Operation Error!");
		} catch (ArithmeticException e) {
			System.out.println("Error! Division by zero");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
}

class OperationException extends Exception {
	
}




