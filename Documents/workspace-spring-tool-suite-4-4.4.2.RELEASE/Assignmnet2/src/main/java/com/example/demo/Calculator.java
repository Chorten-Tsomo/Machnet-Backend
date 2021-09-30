package com.example.demo;

import java.util.Scanner;

public class Calculator {
	
		private double x;
		private double y;
		private double result;
		private char op;
		
		
		public void calculate() {
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter first number:");

	        
	        x = scanner.nextDouble();
	        System.out.print("Enter second number:");
	        y = scanner.nextDouble();

	        System.out.print("Enter an operator (+, -, *, /): ");
	        op = scanner.next().charAt(0);

	        scanner.close();
	        

	        switch(op)
	        {
	            case '+':
	            	result = x + y;
	                break;

	            case '-':
	            	result = x - y;
	                break;

	            case '*':
	            	result = x * y;
	                break;

	            case '/':
	            	result = x / y;
	                break;

	            
	            default:
	                System.out.printf("You have entered wrong operator");
	                return;
	        }

	        System.out.println(x+" "+op+" "+y+": "+result);
			
	}
		
		

}
	


