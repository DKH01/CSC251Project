public class Policy
{ 
 
   int policyNumber;
   String providerName;
   String firstName;
   String lastName;
   int holderAge;
   String smokingStatus;
   double holderHeight;
   double holderWeight;
   
      public Policy()
      {
         policyNumber = 0000;
         providerName = "Nation Wide";
         firstName = "Bob";
         lastName = "Dole";
         holderAge = 35;
         smokingStatus = "False";
         holderHeight = 72.0;
         holderWeight = 160.0;
      }
      
      public Policy(int policyNumber, String providerName, String firstName, String lastName,
                          int holderAge, String smokingStatus, double holderHeight, double holderWeight)
      {
         this.policyNumber = policyNumber;
         this.providerName = providerName;
         this.firstName = firstName;
         this.lastName = lastName;
         this.holderAge = holderAge;
         this.smokingStatus = smokingStatus;
         this.holderHeight = holderHeight;
         this.holderWeight = holderWeight;

      }

   public static void main(String[] args)
   {
      Policy a = new Policy();
   }
}  