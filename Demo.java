import java.util.Scanner; // Importing scanner to take in user variables
import java.util.InputMismatchException; // Importing a package for error handling incase the user inputs the wrong data type, prevents crashing and bugs

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Setting up scanner

        // Initializing variables
        String policyNumber, providerName, firstName, lastName, smoking; // Policy Number is a string because we will not be using or changing it for calculations
        int age = 0;
        double height, weight;

        System.out.print("Please enter the Policy Number: ");
        policyNumber = scan.nextLine(); // Takes in the string that the user inputs

        System.out.print("Please enter the Provider Name: ");
        providerName = scan.nextLine(); // nextLine allows for multiple words to be entered when spaces are included in the provider name (Such as "State Farm")

        System.out.print("Please enter the Policyholder's First Name: ");
        firstName = scan.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        lastName = scan.nextLine();
        
        while(true) { // Error handling to make sure the program doesn't crash if the user inputs the wrong data type
            try {
                System.out.print("Please enter the Policyholder's Age: ");
                age = scan.nextInt();
                break; // Breaks out of the loop to the next lines of code once the error handling is finished
            } catch (InputMismatchException e) {
                scan.nextLine(); // Makes sure nothing is left in the scanner to prevent feedback loop
            }
        }
        
        scan.nextLine(); // Clears the input line for the next lines of code

        while (true) { // Ensures that the user inputs the appropriate response as to not mess up the final calculations of the insurance policy
            System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
            smoking = scan.nextLine();
            smoking = smoking.toLowerCase(); // Allows the user to use any variation of typecase, defaults it to lowercase to prevent bugs
            if (smoking.equals("smoker") || smoking.equals("non-smoker")) { // Checks to make sure the response is correct
                break; 
            }
        }

        while(true) {  // Error handling to make sure the program doesn't crash if the user inputs the wrong data type
            try {
                System.out.print("Please enter the Policyholder's Height (in inches): ");
                height = scan.nextDouble();
                break;
            } catch(InputMismatchException e) {
                scan.nextLine();
            }
        } 

        while(true) { // Error handling to make sure the program doesn't crash if the user inputs the wrong data type
            try {
                System.out.print("Please enter the Policyholder's Weight (in pounds): ");
                weight = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                age, smoking, height, weight); // Creates a new instance object using the data that the user inputted previously

        // Outputs the information created from the instantiated object created for the user to read in a clean manner
        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmoking());
        System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
        System.out.println("Policyholder's BMI: " + (Math.round(policy.calculateBMI() * 100.0) / 100.0)); // Rounds the output of the calculateBMI method to the second decimal place
        System.out.println("Policy Price: $" + (Math.round(policy.calculatePrice() * 100.0) / 100.0)); // Rounds the output of the calculatePrice method to the second decimal place

        scan.close(); // Scanner is closed to prevent a memory leak
    }
}