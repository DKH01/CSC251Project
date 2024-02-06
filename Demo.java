import java.util.Scanner; // Importing scanner to take in user variables
import java.io.FileWriter; // Writing to Files
import java.io.File; // File manipulation
import java.io.FileNotFoundException; // File Error Handling
import java.io.FileOutputStream; // File creation
import java.io.IOException; // Error handling
import java.util.InputMismatchException; // Importing a package for error handling incase the user inputs the wrong data type, prevents crashing and bugs
import java.util.ArrayList; // Making lists

public class Demo {
    public static void main(String[] args) {

        ArrayList<Policy> policyList = new ArrayList<>(); // Makes a list to keep track of multiple policy objects to iterate through

        // Initializing variables
        String policyNumber, providerName, firstName, lastName, smoking, age, height, weight; // Policy Number is a string because we will not be using or changing it for calculations
        int convertedAge; // Converting age from a string to an int
        int smokingCounter = 0; // Counts smokers with insurance policies
        int nonSmokingCounter = 0; // Counts non-smokers with insurance policies
        double convertedHeight, convertedWeight; // Converting height and weight from a string to double

        String txtFile = "PolicyInformation.txt"; // Path to the text file required to be read from
        String fileContent = ("PolicyNumber:\nProvider Name:\nPolicy Holder's Last Name:\nPolicyholder's Age:\nPolicy Holder's Smoking Status (smoker/non-smoker:\nPolicyholder's Height (in inches):\nPolicyholder's Weight (in pounds):\nPolicyholder's BMI:\nPolicy Price:");
        // Content that will populate a newly created text file as a basic template if it doesn't already exist in the current directory

        try {
            File file = new File(txtFile); // Creates a new file object
            
            if (!file.exists()) { // Checks to see if the PolicyInformation.txt file exists in the current directory
                try {
                    String cd = System.getProperty("user.dir"); // Sets cd to the current user directory the program is located
                    cd = cd + "\\" + txtFile; // Creates a specified name and location for the file creation
                    FileWriter fw = new FileWriter(cd); // Creates the file using the cd file just modified
                    fw.write(fileContent); // Writes the file content into the file for the user to fill out
                    fw.close(); // Closes fw to prevent memory leaks
                } catch (IOException e) { // Error catching
                    e.printStackTrace(); // Prints out error code
                }

                System.out.printf("New text file created: %s\n\nPlease fill out the basic information inside the document or paste a completed file in the folder\n", txtFile); 
                System.out.print("Please add the insurance holder information in the file before restarting the program.\n");
                System.exit(0); // Exits the program for the user to restart once it's filled out
            }

            Scanner scan = new Scanner(file); // Scanner used to scan the files contents
            policyNumber = scan.nextLine(); // Checks the first line of the program

            // Two options provided: One that follows and formats the output that uses my template, and one that utilizes just the plain text without my self-created guidelines
            if (policyNumber.contains("Policy")) { // Checks if it mentions "Policy" in the first line of the program (Because my template uses "Policy Number: ") for the user to fill out easily
                while (scan.hasNextLine()) { // Iterates through the text file until no more lines remain
                    policyNumber = policyNumber.substring(policyNumber.indexOf(": ") + 2); // Removes everything before ": " in the text file to only leave the data to be used for the Policy class info

                    providerName = scan.nextLine(); // scans the next line down
                    providerName = providerName.substring(providerName.indexOf(": ") + 2);

                    firstName = scan.nextLine();
                    firstName = firstName.substring(firstName.indexOf(": ") + 2);

                    lastName = scan.nextLine();
                    lastName = lastName.substring(lastName.indexOf(": ") + 2);

                    age = scan.nextLine();
                    age = age.substring(age.indexOf(": ") + 2);
                    convertedAge = Integer.parseInt(age); // Converts the age string taken from the document and turns it into an integer

                    smoking = scan.nextLine();
                    smoking = smoking.substring(smoking.indexOf(": ") + 2);
                    if (smoking.contains("non-smoker")) { // Checks to see if they're a non-smoker or not then adds to either respective variable
                        nonSmokingCounter += 1;
                    } else {
                        smokingCounter += 1;
                    }

                    height = scan.nextLine();
                    height = height.substring(height.indexOf(": ") + 2);
                    convertedHeight = Double.parseDouble(height); // Converts the height string taken from the document and turns it into a double

                    weight = scan.nextLine();
                    weight = weight.substring(weight.indexOf(": ") + 2);
                    convertedWeight = Double.parseDouble(weight); // Converts the weight string taken from the document and turns it into a double

                    Policy policy = new Policy(policyNumber, providerName, firstName, lastName, convertedAge, smoking, convertedHeight, convertedWeight); // Instantiates the Policy object
                    policyList.add(policy); // adds the newly instantiated Policy object into the array list to iterate through later

                    if (scan.hasNextLine()) {
                        policyNumber = scan.nextLine(); // Policy Number will take in the next line if there is no white space present between policy holders in the text file
                        while (policyNumber.isEmpty() && scan.hasNextLine()) { // Registers whether Policy Number is blank and there is a new line in the program for if there is a white space between policies
                            policyNumber = scan.nextLine(); // Gets the next line until it gets a value
                        }
                    }
                }
            } else {
                while (scan.hasNextLine()) {
                    providerName = scan.nextLine();
                    firstName = scan.nextLine();
                    lastName = scan.nextLine();
                    age = scan.nextLine();
                    convertedAge = Integer.parseInt(age);

                    smoking = scan.nextLine();
                   
                    if (smoking.contains("non-smoker")) {
                        nonSmokingCounter += 1;
                    } else {
                        smokingCounter += 1;
                    }
                    
                    height = scan.nextLine();
                    convertedHeight = Double.parseDouble(height);

                    weight = scan.nextLine();
                    convertedWeight = Double.parseDouble(weight);

                    Policy policy = new Policy(policyNumber, providerName, firstName, lastName, convertedAge, smoking, convertedHeight, convertedWeight); // Instantiates the Policy object
                    policyList.add(policy); // adds the newly instantiated Policy object into the array list to iterate through later

                    if (scan.hasNextLine()) {
                        policyNumber = scan.nextLine();
                        while (policyNumber.isEmpty() && scan.hasNextLine()) {
                            policyNumber = scan.nextLine();
                        }
                    }
                }
            }
            
        } catch (FileNotFoundException e) { // File error handling
            e.printStackTrace();
        }
        
        for (Policy policy : policyList){ // for loop to iterate through each policy pertaining to the array list
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmoking());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.println("Policyholder's BMI: " + (Math.round(policy.calculateBMI() * 100.0) / 100.0)); // Rounds the output of the calculateBMI method to the second decimal place
            System.out.println("Policy Price: $" + (Math.round(policy.calculatePrice() * 100.0) / 100.0)); // Rounds the output of the calculatePrice method to the second decimal place
            System.out.println();
       }
       System.out.printf("The number of policies with a smoker is: %d\n", smokingCounter); // Count for each smoker
       System.out.printf("The number of policies with a non-smoker is: %d",  nonSmokingCounter); // Count for each non-smoker
    }
}