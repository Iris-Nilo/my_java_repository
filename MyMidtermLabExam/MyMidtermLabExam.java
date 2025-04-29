import java.util.Arrays;
import java.util.Scanner;

public class MyMidtermLabExam {
        
    static String[] tickets = new String [5];
    static int ticketsAdded = 0;  
     
    //Add Ticket Method
    static void addTicket() {
        
        Scanner input = new Scanner(System.in);

        while (ticketsAdded < tickets.length) {
        //Issue Description
        System.out.print("Enter issue description: ");
        String issueDescription = input.nextLine();

        //Urgency Level
        System.out.print("Enter urgency level (Low / Medium / High): ");
        String urgencyLevel = input.nextLine();
        
        //Default Status of Ticket
        String status = "Pending";

        tickets[ticketsAdded] = "[" + urgencyLevel + "] " + issueDescription + " - " + "Status: " + status;
              
        System.out.print("Ticket successfully added!\n");
        ticketsAdded++;
        return;
        }
        if (ticketsAdded == tickets.length) {
            System.out.println("\nMaximum number of tickets reached.");
        }
    }
    

    
    //Update Tickets Method
    static void updateTicketStatus(){
        
        
        if (ticketsAdded == 0){
            System.out.println("No tickets yet.");
            return;
        }
        
        showTickets();
        
        //Ticket Number to Update
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ticket number to update: ");
        int ticketNumber = input.nextInt();
        input.nextLine();
        
        
        //New Status
    if (ticketNumber >= 1 && ticketNumber <= ticketsAdded) {
            int indexToUpdate = ticketNumber - 1;

            System.out.print("Enter the new status (In Progress / Resolved) " + ": ");
            String newStatus = input.nextLine();

            //Split to extract specific parts needed
            String[] parts = tickets[indexToUpdate].split(" - Status: ");
            if (parts.length > 0) {
                tickets[indexToUpdate] = parts[0] + " - Status: " + newStatus; //Assigns index[0] to the firstt ticket
                System.out.println("Ticket status updated.");
            } else {
                System.out.println("Error"); 
            }
        } else {
            System.out.println("Invalid ticket number.");
        }
    }
        
    //Show All Tickets Method
    static void showTickets() {
        System.out.println("\n--- All Tickets ---");
        if (ticketsAdded == 0) {
            System.out.println("No tickets yet.");
        } else {
            for (int i = 0; i < ticketsAdded; i++) {
                System.out.println( (i + 1) + ". " + tickets[i]);
            }
        }

    }   
   
    //Generate Report Method
    static void generateReport(){
        int totalTickets = ticketsAdded;
        int pendingTickets = 0;
        int resolvedTickets = 0;
        
        //If it contains the specified string, it will be added to its corresponding array.
        for (int i = 0; i < ticketsAdded; i++) {
            if (tickets[i].toLowerCase().contains(" - status: pending") || tickets[i].toLowerCase().contains(" - status: in progress")) {
                pendingTickets++;
            } else if (tickets[i].toLowerCase().contains(" - status: resolved")) {
                resolvedTickets++;
            }
        }
        
        System.out.println("--- Ticket Report ---");
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Pending Tickets: " + pendingTickets);
        System.out.println("Resolved Tickets: " + resolvedTickets);
        
    }
    
    //Main
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        
    //User Menu 
        do{
        System.out.println("=== IT Ticket System ===");
        System.out.println("1. Add Ticket");
        System.out.println("2. Update Ticket Status");
        System.out.println("3. Show All Tickets");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        //User Input
        Scanner inputScan = new Scanner(System.in);
        System.out.print("Enter choice: ");
        
        if (scanner.hasNextInt()){
            userChoice = scanner.nextInt();
            scanner.nextLine();
            //Options
            switch (userChoice) {
                case 1:
                    addTicket();
                    break;
                case 2:
                    updateTicketStatus();
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid input. Please choose again (1-5).");
            }   
        } else {
            System.out.println("Invalid input. Please choose again.");
            scanner.nextLine();
            userChoice = -1;
        }
        
    } while (userChoice !=5);
        scanner.close ();
        
    }
 
        
}
 
      



        
                                  
