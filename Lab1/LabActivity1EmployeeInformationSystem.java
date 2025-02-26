import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
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
        
        //Computation of Daily Salary
        float dailySalary = hoursWorked * hourlyWage;
        
        //Display Employee Information
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");
        System.out.println("Full name:" + " " + firstName + " " + lastName);
        System.out.println("Age:" + age + " " + "years old");
        System.out.printf("Daily Salary: PHP %.2f\n", dailySalary);
    }
    
}