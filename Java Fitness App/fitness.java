import java.util.*;
import java.io.*;
public class fitnessProgram {
	
	public static void main(String[] args){
		banner();
		
		Scanner s = new Scanner(System.in);
		int user_choice = 2;
		

	    do {
	        //display menu to user
	        //ask user for his choice and validate it (make sure it is between 1 and 6)
	    	System.out.println();
	        System.out.println("Enter choice [1 - 6]: ");
	        System.out.println("1) Calculate Resting Metabolic Rate");
	        System.out.println("2) Determine your activity factor");
	        System.out.println("3) Determine your Total Daily Energy Expenditure");
	        System.out.println("4) Find out your max heart rate");
	        System.out.println("5) Calculate targeted heart rate for fitness goals");
	        System.out.println("6) Quit");
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        user_choice = s.nextInt();
	        switch (user_choice) {
	            case 1: double[] input = getValuesRMR();
	    				rmr(input);
	    				break;
	         case 2: activityFactor();
	         		break;
	         case 3: tdee();
	         		break;
	         case 4: heartRate();
	         		break;
	         case 5: heartRatePercentage();
	        }
	}
	while (user_choice != 6);
	    System.out.println("Thank you for using this program.\n Created by Matt Schmidt, 2016.");
	}
	
	public static void heartRatePercentage(){
		System.out.println();
		System.out.printf("What is your goal?\nBurn Fat [Enter 1]\nIncrease stamina/cardio [Enter 2]");
		System.out.println();
		System.out.println();
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		int maxhr = 0;
		double goal = 0.0;
		int age = 0;
		if(choice == 1){
			Scanner hr = new Scanner(System.in);
			System.out.println("Enter your age: ");
			age = hr.nextInt();
			maxhr = 220 - age;
			goal = maxhr * .70;
			System.out.println("Your targeted heart rate to burn fat is " + goal + "bpm.");
		} else {
			Scanner hr2 = new Scanner(System.in);
			System.out.println("Enter your age: ");
			age = hr2.nextInt();
			maxhr = 220 - age;
			goal = maxhr * .85;
			System.out.println("Your targeted heart rate to burn fat is " + goal + "bpm.");
		}
		
	}
	
	
	
	public static int heartRate(){
		int age = 0;
		int heartRate = 0;
		System.out.println("Enter your age: ");
		Scanner hr = new Scanner(System.in);
		age = hr.nextInt();
		heartRate = 220 - age; 
		System.out.println("Your Max Heart Rate is " + heartRate);
		return heartRate; 
	} //end heartRate()
		
	
	public static double[] getValuesRMR(){
		System.out.println("To calculate your RMR:");
		double[] input;
		input = new double[3];
		Scanner rmr = new Scanner(System.in);
		System.out.println("Enter the following values in order.");
		System.out.println("Weight(lb), Height(in), age");
		for(int i = 0; i < input.length; i++){
			input[i] = rmr.nextDouble();
		}
		return input; 
	} //end getValuesRMR()
	
	public static double activityFactor(){
		System.out.println("Your Activity Factor is a measure of how active you are during the week.\n\n\t"
				+ "1. Little to no activity.\n\t2. Slightly active (Light Exercise 1-3 days of the week).\n\t3. Moderately active (Moderate Exercise 3-5 days of the week).\n\t4. Very active (Strenuous Exercise 6-7 days of the week)."
				+ "\n\nSelect (1 - 4) based on how active you are during the week");
		System.out.println();
		int afSelect;
		double activityFactor = 0; 
		Scanner af = new Scanner(System.in);
		afSelect = af.nextInt();
		if(afSelect == 1){
			System.out.println();
			System.out.println("Little to no activity.");
			activityFactor =+ 1.2;
		} else if(afSelect == 2){
			System.out.println();
			System.out.println("Slightly active");
			activityFactor =+ 1.375;
		} else if(afSelect == 3){
			System.out.println();
			System.out.println("Moderately Active.");
			activityFactor =+ 1.55;
		} else if(afSelect == 4){
			System.out.println();
			System.out.println("Very Active.");
			activityFactor =+ 1.725;
		} else {
			System.out.println("Please choose a number (1 - 4)");
		}
		System.out.println("You have an Activity Factor of " + activityFactor);
		return afSelect;
		
	} //end activityFactor()
	
	public static void tdee(){
		System.out.println("In order to calculate the estimated amount of calories you should consume a day, make sure you have your Resting Metabolic Rate number and Activity Factor.");	
		Scanner userInput = new Scanner(System.in);
	
		System.out.println("Enter your RMR you calculated: ");
		double rmr = userInput.nextDouble();
		System.out.println();
		System.out.println("Enter your Activity Factor: ");
		double af = userInput.nextDouble();
		System.out.println();
		double tdee = rmr * af;
		System.out.println("It is recommended you consume " + tdee + " calories a day.");
	} //end tdee()
	
	
	
	public static double rmr(double[] input){
		
		double weight = input[0];
		double height = input[1];
		double age = input[2];
		weight = weight * (0.45359237);
		height = height * (2.54);
		double rmrValue = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
		System.out.printf("Your resting metabolic rate is %.1f", rmrValue);
		System.out.println();
		return rmrValue;
	} //end rmr
	
	public static void banner(){
		System.out.println("This program will help you calculate various numbers to help you with your fitness goals.\n\n\t -Resting Metabolic Rate (RMR) is the amount of calories at a minimum you should consume daily.\n \t"
				+ "This program will calculate your RMR for you by taking your height, weight, and age.\n\n\t - Activity Factor. This means we will determine how much you move around during the day."
				+ "\n\n\t - Total Daily Energy Expenditure: Using your RMR and Activity Factor, this will calculate how \n\tmany calories based on your lifestyle is recommended to be consumed daily."
				+ "\n\n\t- Max Heart Rate. Your max heart rate is good to know so you can help determine how to meet your fitness goals."
				+ "\n\n\t- And lastly we can calculate where your heart rate should be based on if you want to lose fat or increase cardiovascular stamina."
				+ "\n\nPlease review the choices below, I suggest going in order. When finished, simply press \"6\" on your keyboard");
		System.out.println();
		System.out.println();
	} //end banner()
}
