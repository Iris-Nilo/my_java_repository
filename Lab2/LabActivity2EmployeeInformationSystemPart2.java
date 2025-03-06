import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
    public static void main(String[]args){
        //First name of employee
        Scanner inputScan = new Scanner(System.in);
        System.out.print("Enter your first name:");
        String firstName = inputScan.nextLine();
    
        //Last name of employee
        System.out.print("Enter your last name:");
        String lastName = inputScan.nextLine();
        
        //Age of employee
        System.out.print("Enter your age:");
        int age = inputScan.nextInt();
        
        //Hours worked
        System.out.print("Enter hours worked:");
        Float hoursWorked = inputScan.nextFloat();
        
        //Hourly wage
        System.out.print("Enter hourly wage:");
        Float hourlyWage = inputScan.nextFloat();
        
        //Start of Display of Employee Information
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");
        
        //Display of Employee Full Name
        firstName = firstName.toUpperCase();
        lastName = lastName.toUpperCase();
        System.out.println("Full name:" + " " + firstName + " " + lastName);
        
        //Display of Employee Age
        System.out.println("Age:" + age + " " + "years old");
        
        //Years to Retirement
        int yearsToRetirement = Math.abs(65 - age);
        System.out.println("Years to Retirement:" + " " + yearsToRetirement + " " + "years");
        
        //Daily Wage
        float dailyWage = Math.round(hoursWorked * hourlyWage);
        System.out.printf("Daily Wage: PHP %.2f\n", dailyWage);
        
        //Weekly Wage
        float weeklyWage = 5 * dailyWage;
        System.out.printf("Weekly Wage: PHP %.2f\n", weeklyWage);
        
        //Monthly Wage
        float monthlyWage = 4 * weeklyWage;
        System.out.printf("Monthly Wage: PHP %.2f\n", monthlyWage);

        //Gross Yearly Wage
        float grossYearlyWage = 12 * monthlyWage ;
        System.out.printf("Gross Yearly Wage: PHP %.2f\n", grossYearlyWage);
        
        //Net Yearly Wage
        float netYearlyWage = (float) (grossYearlyWage - (0.32 * grossYearlyWage + 1500));
        System.out.printf("Net Yearly Wage: PHP %.2f\n", netYearlyWage);

    }
    
}