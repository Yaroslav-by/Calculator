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
				if (line.equals("")) {
					continue;
				}
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
					writer.write(line + " = Operation Error!\n");
					continue;
				} else if (a[1].equals("+") || a[1].equals("-") || a[1].equals("*") || a[1].equals("/")) {
					operation = a[1].charAt(0);
					if (operation == '/' && second == 0) {
						writer.write(line + " = Error! Division by zero\n");
						continue;
					}
				} else {
					writer.write(line + " = Operation Error!\n");
					continue;
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
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
}

