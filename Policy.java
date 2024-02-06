public class Policy {    
    private String policyNumber; // Users policy numbers
    private String providerName; // Provider of  the user
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

    /**
    * Creates a constructor with arguments, Policy object with specified values for each field
    * 
    * @param policyNumber the user's insurance policy number
    * @param providerName the insurance provider's name
    * @param firstName the user's first name
    * @param lastName the user's last name
    * @param age the user's age
    * @param smoking indicates whether the user smokes or not
    * @param height the user's height
    * @param weight the user's weight
    */
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

    /**
     * Calculates the BMI of the policy holder
     *
     * @param bmi The BMI of the user
     * @return The user's calculated BMI using weight, and h^2
     */
    public double calculateBMI() {
        double bmi = (weight * 703) / (height * height); // Calculates the BMI of the user using the formula (BMI = (Policyholder’s Weight * 703 ) / (Policyholder’s Height^2 ))
        return bmi;  // Returns the calculated BMI of the user
    }

    /**
     * Calculates the total price of the insurance policy overall
     *
     * @param baseFee The insurance policy's base fee
     * @param additionalFee The additional fee based on the user's BMI
     * @return The overall price of the insurance policy
     */
    public double calculatePrice() {
        double baseFee = 600.0; // Constant for the base amount of the policy
        double additionalFee = 0.0; // Initializing the potential fee that can be accrued
        double bmi = calculateBMI(); // Gets the value of the BMI calculated

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



