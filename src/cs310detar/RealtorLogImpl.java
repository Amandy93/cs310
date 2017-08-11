
package cs310detar;

import java.util.*;

/**
 *
 * @author Amanda
 */
public class RealtorLogImpl {
    private int MAXSIZE;
    private int currSize;
    private Realtor [] realtorObjects;
    //Set<Realtor> set = new HashSet<Realtor>();
    
    
    /**
     * empty constructor
     */
    public RealtorLogImpl (){
        MAXSIZE = 23;
        currSize = 0;
        realtorObjects = new Realtor[MAXSIZE];
        for (int i = 0; i < realtorObjects.length; i++) {
            realtorObjects[i] = null;
        }
    }
    
    /**
     * Getting the realtor objects
     * @return
     */
    public Realtor[] getRealtorObjects() {
        return realtorObjects;
    }
    
    /**
     * This method will add a realtor object to the set
     * @param realtor
     * @return 
     */
    public boolean add(Realtor realtor) {
        boolean retValue = false;
        //This is using hash code to create a unique spot for the object
        int hashCode = realtor.hashCode();
        hashCode = hashCode % MAXSIZE;
        
        //If the retValue does not equal false 
        while (!retValue) {
            //This is checking that the realtorObjects location is null
            if (realtorObjects[hashCode] == null) {
                //Assigning the realtorObjects location to equal the realtor
                realtorObjects[hashCode] = realtor;
                //Increments the currSize
                currSize++;
                retValue = true;
                System.out.println("Realtor " + realtor.getLastName() + 
                        " added.");
            }
            else {
                //Increments the hashCode, which is assigned a value above
                hashCode++;
                //If true, starts back at the beginning
                if (hashCode > realtorObjects.length){
                    hashCode = 0;
                }
            }
        }
        return retValue;
    }
    
    /**
     * Finding the license number in the list
     * @param licenseNum
     * @return
     */
    public Realtor find(String licenseNum){
        Realtor retValue = null;
        int hashCode = 0;
        char[] array = licenseNum.toCharArray();
        for(char z : array){
            hashCode += (int)z;
        }
        
        // Get the hash code
        hashCode = hashCode % MAXSIZE;
        
        // Check if there is something there
        if (realtorObjects[hashCode] != null){
            // return a something
            retValue = realtorObjects[hashCode];
        }
        return retValue;
    }
          
    /**
     * Displaying the information for the realtor hash table
     */
    public void displayHash(){
        System.out.println("Realtor Hash Table:");
        for (int i = 0; i < realtorObjects.length; i++){
            if (realtorObjects[i] != null){
                String lastName = realtorObjects[i].getLastName();
                String firstName = realtorObjects[i].getFirstName();
                System.out.println("    Index " + i + " contains Realtor " + 
                        realtorObjects[i].getLicenseNum() + ", " + 
                        firstName + " " + lastName);
            }
            else {
                System.out.println("    Index " + i + " is empty");
            }
        }
    }
    
    /**
     * verifying that the license is unique
     * @param licenseNum
     * @return
     */
    public boolean isLicenseUnique(String licenseNum){
        boolean retValue = true;
        int hashCode = 0;
        char[] array = licenseNum.toCharArray();
        for(char z : array){
            hashCode += (int)z;
        }
        
        // Get the hash code
        hashCode = hashCode % MAXSIZE;
        
        // Check if there is something there
        if (realtorObjects[hashCode] != null){
            // return a something
            retValue = false;
        }
        return retValue;      
    }
}
