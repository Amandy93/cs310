
package cs310detar;

import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class Realtor {
    String licenseNum;
    String firstName;
    String lastName;
    String phoneNum;
    double commissionRate;

    /**
     *This is my empty constructor
     */
    public Realtor() {
        
    }

    /**
     * This is my constructor with all the parameters defined above
     * @param licenseNum
     * @param firstName
     * @param lastName
     * @param phoneNum
     * @param commissionRate
     */
    public Realtor(String licenseNum, String firstName, String lastName, 
            String phoneNum, double commissionRate) {
        this.licenseNum = licenseNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.commissionRate = commissionRate;
    }
    
    /**
     * This is my method I replaced setRealtorAttributes with
     * @param realtorAttributes
     */
    public Realtor (String [] realtorAttributes){
        this.licenseNum = realtorAttributes[2];
        this.firstName = realtorAttributes[3];
        this.lastName = realtorAttributes[4];
        this.phoneNum = realtorAttributes[5];
        this.commissionRate = Double.parseDouble(realtorAttributes[6]);
    }

    /**
     * LicenseNum Setter
     * @param licenseNum
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     * FirstName Setter
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * LastName Setter
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * PhoneNum Setter
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * CommissionRate Setter
     * @param commissionRate
     */
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * LicenseNum Getter
     * @return
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * FirstName Getter
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * LastName Getter
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * PhoneNum Getter
     * @return
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * CommissionRate Getter
     * @return
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        char[] array = licenseNum.toCharArray();
        for(char z : array){
            hash += (int)z;
        }
        return hash;
    }

    /**
     * This method is the equals to method
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Realtor other = (Realtor) obj;
        if (Double.doubleToLongBits(this.commissionRate) != 
                Double.doubleToLongBits(other.commissionRate)) {
            return false;
        }
        if (!Objects.equals(this.licenseNum, other.licenseNum)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNum, other.phoneNum)) {
            return false;
        }
        return true;
    }

    /**
     * This method is for objects representing strings
     * @return
     */
    @Override
    public String toString() {
        return "Realtor{" + "licenseNum=" + licenseNum + ", firstName=" + 
                firstName + ", lastName=" + lastName + ", phoneNum=" + 
                phoneNum + ", commissionRate=" + commissionRate + '}';
    }
    
    /**
     * This method is checking the LicenseNum pattern that is required
     * @return
     */
    public Boolean checkLicenseNum(){
        boolean retValue = false;
        String pattern = "^[a-zA-Z]{2}\\d{7}";
        if (this.licenseNum.matches(pattern)) {
            retValue = true;
        } 
            return retValue;
    }
    
    /**
     * This method is checking the PhoneNum pattern that is required
     * @return
     */
    public Boolean checkPhoneNum(){
        boolean retValue = false;
        String pattern = "^\\d{3}-\\d{3}-\\d{4}";
        if (this.phoneNum.matches(pattern)) {
            retValue = true;
        }
        return retValue;
    }
}