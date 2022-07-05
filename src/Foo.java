import java.io.*;
import java.util.Scanner;

class Foo {

	public static void main(String[] args) {
    	
		try {
			
			File file = new File("input.txt");
			FileWriter writer = new FileWriter(file, true);
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] a = line.split(" ");
				
				double first;
				double second;
				
				if (a[0].contains(".")) {
					first = Double.parseDouble(a[0]);
				} else {
					first = Integer.parseInt(a[0]);
				}
				
				if (a[2].contains(".")) {
					second = Double.parseDouble(a[2]);
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
				
				String temp = " = " + Double.toString(result) + ";";
				writer.write(temp);
			}
			sc.close();
			writer.close();
		} catch(NumberFormatException e) {
			System.out.println("Error! Not number");
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




