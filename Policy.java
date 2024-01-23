public class Policy {
    private String policyNumber; // Users policy numbers
    private String providerName; // Provider of  the userr
    private String firstName; // Users first name
    private String lastName; // Users last name
    private int age; // Age of user
    private String smoking; // Holds whether they're a smoker or not
    private double height; // Users height
    private double weight; // Users weight

    // Creating a no-arg constructor
    public Policy() {
        // Intializes the default values for all the fields
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smoking = "";
        height = 0.0;
        weight = 0.0;
    }

    // Creating a constructor with arguments
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
            int age, String smoking, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smoking = smoking;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmoking() {
        return smoking;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Setters
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Method that will calculate the BMI of the policy holder
    public double calculateBMI() {
        double bmi = (weight * 703) / (height * height); // Calculates the BMI of the user using the formula (BMI = (Policyholder’s Weight * 703 ) / (Policyholder’s Height^2 ))
        return bmi;  // Returns the calculated BMI of the user
    }

    // Method that calculates the overall price of the insurance policy
    public double calculatePrice() {
        double baseFee = 600.0; // Constant for the base amount of the policy
        double additionalFee = 0.0; // Initializing the potential fee that can be accrued
        double bmi = calculateBMI(); // Gets the value of the bmi calculated

        if (age > 50) {
            additionalFee += 75.0; // If the Policyholder is over 50 years old, there is an additional fee of $75
        }

        if (smoking.equals("smoker")) {
            additionalFee += 100.0; // If the Policyholder is a smoker, there is an additional fee of $100
        }

        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20.0; // If the Policyholder has a BMI of over 35, there is an additional fee
        }

        return baseFee + additionalFee; // Returns the calculated price of the insurance policy
    }
}