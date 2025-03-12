import java.util.Scanner;


public class LabActivity3ConditionalStatement {

    public static void main(String args[]) {
        //First name of employee
        Scanner inputScan = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = inputScan.nextLine();

        //Last name of employee
        System.out.print("Enter your last name: ");
        String lastName = inputScan.nextLine();

        //Age of employee
        System.out.print("Enter your age: ");
        int age = inputScan.nextInt();
        if (age<18){
            System.out.print("Minors are not allowed");
            System.exit(0);
        }
        else if (age>=65){
            System.out.print("Senior Citizens are not allowed");
            System.exit(0);
        }
        
        //Hours worked
        System.out.print("Enter hours worked: ");
        Float hoursWorked = inputScan.nextFloat();
        if (hoursWorked > 24) {
            System.out.print("Number of hours worked cannot exceed 24 hours");
            System.exit(0);
        }
        else if (hoursWorked<=0){
            System.out.print("Wrong input on daily work hours");
            System.exit(0);
        }

        //Hourly wage
        System.out.print("Enter hourly wage: ");
        Float hourlyWage = inputScan.nextFloat();
        
        //Role Code
        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCode = inputScan.nextInt();
        
        //Start of Display of Employee Information
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");

        //Display of Employee Full Name
        firstName = firstName.toUpperCase();
        lastName = lastName.toUpperCase();
        System.out.println("Full name:" + "            " + firstName + " " + lastName);

        //Display of Employee Age
        System.out.println("Age:" + "                  " + age + " " + "years old");

        //Position
        String position;
        switch (roleCode) {
            case 1:
                position = "Manager";
                break;
            case 2:
                position = "Supervisor";
                break;
            case 3:
                position = "Staff";
                break;
            case 4:
                position = "Intern";
                break;
            default:
                position = "Undefined";
                break;
        }
        System.out.println("Position:" + "             " + position);
        
        //Years to Retirement
        int yearsToRetirement = Math.abs(65 - age);
        System.out.println("Years to Retirement:" + "  " + yearsToRetirement + " " + "years");

        //Daily Wage
        float dailyWage = Math.round(hoursWorked * hourlyWage);
        System.out.printf("Daily Wage:           PHP %.2f\n", dailyWage);

        //Weekly Wage
        float weeklyWage = 5 * dailyWage;
        System.out.printf("Weekly Wage:          PHP %.2f\n", weeklyWage);

        //Monthly Wage
        float monthlyWage = 4 * weeklyWage;
        System.out.printf("Monthly Wage:         PHP %.2f\n", monthlyWage);

        //Gross Yearly Wage
        float grossYearlyWage = 12 * monthlyWage;
        System.out.printf("Gross Yearly Wage:    PHP %.2f\n", grossYearlyWage);

        //Net Yearly Wage
        if (grossYearlyWage >= 250000){
            float netYearlyWage = (float) (grossYearlyWage - (0.32 * grossYearlyWage + 1500));
            System.out.printf("Net Yearly Wage:      PHP %.2f\n", netYearlyWage);
        }
        else if (grossYearlyWage <= 250000){
            float netYearlyWage = (float) (grossYearlyWage - 1500);
            System.out.printf("Net Yearly Wage:      PHP %.2f\n", netYearlyWage);
        }
        
    }
}
