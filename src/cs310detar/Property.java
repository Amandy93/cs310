

package cs310detar;

import java.util.Objects;

/**
 *
 * @author Amanda
 */
public class Property {
    int mlsNum;
    String licenseNum;
    String streetAddress;
    String city;
    String state;
    int zipCode;
    int numBedrms;
    double numBaths;
    boolean sold;
    double askingPrice;

    /**
     *This is my empty constructor
     */
    public Property() {
    }

    /**
     *This is my constructor with all the parameters from above
     * @param mlsNum
     * @param licenseNum
     * @param streetAddress
     * @param city
     * @param state
     * @param zipCode
     * @param numBedrms
     * @param numBaths
     * @param sold
     * @param askingPrice
     */
    public Property(int mlsNum, String licenseNum, String streetAddress, 
            String city, String state, int zipCode, int numBedrms, 
            double numBaths, boolean sold, double askingPrice) {
        this.mlsNum = mlsNum;
        this.licenseNum = licenseNum;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.numBedrms = numBedrms;
        this.numBaths = numBaths;
        this.sold = sold;
        this.askingPrice = askingPrice;
    }
    
    /**
     * This is the method I replaced setPropertyAttributes with
     * @param propertyAttributes
     */
    public Property(String [] propertyAttributes){
        this.mlsNum = Integer.parseInt(propertyAttributes[2]);
        this.licenseNum = propertyAttributes[3];
        this.streetAddress = propertyAttributes[4];
        this.city = propertyAttributes[5];
        this.state = propertyAttributes[6];
        this.zipCode = Integer.parseInt(propertyAttributes[7]);
        this.numBedrms = Integer.parseInt(propertyAttributes[8]);
        this.numBaths = Double.parseDouble(propertyAttributes[9]);
        this.sold = Boolean.parseBoolean(propertyAttributes[10]);
        this.askingPrice = Double.parseDouble(propertyAttributes[11]);
    }

    /**
     * MLSNum Setter
     * @param mlsNum
     */
    public void setMlsNum(int mlsNum) {
        this.mlsNum = mlsNum;
    }

    /**
     *LicenseNum Setter
     * @param licenseNum
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     *StreetAddress Setter
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     *City Setter
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *State Setter
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *ZipCode Setter
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    /**
     *NumBedrms Setter
     * @param numBedrms
     */
    public void setNumBedrms(int numBedrms) {
        this.numBedrms = numBedrms;
    }

    /**
     *NumBaths Setter
     * @param numBaths
     */
    public void setNumBaths(double numBaths) {
        this.numBaths = numBaths;
    }

    /**
     *Sold Setter
     * @param sold
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     *AskingPrice Setter
     * @param askingPrice
     */
    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    /**
     *MLS Getter
     * @return
     */
    public int getMlsNum() {
        return mlsNum;
    }

    /**
     *LicenseNum Getter
     * @return
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     *StreetAddress Getter
     * @return
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     *City Getter
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *State Getter
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *ZipCode Getter
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *NumBedrms Getter
     * @return
     */
    public int getNumBedrms() {
        return numBedrms;
    }

    /**
     *NumBaths Getter
     * @return
     */
    public double getNumBaths() {
        return numBaths;
    }

    /**
     *Sold Getter
     * @return
     */
    public boolean getSold() {
        return sold;
    }


    /**
     * AskingPrice Getter
     * @return
     */
    public double getAskingPrice() {
        return askingPrice;
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
        final Property other = (Property) obj;
        if (this.mlsNum != other.mlsNum) {
            return false;
        }
        if (this.licenseNum != other.licenseNum) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (this.numBedrms != other.numBedrms) {
            return false;
        }
        if (Double.doubleToLongBits(this.numBaths) != 
                Double.doubleToLongBits(other.numBaths)) {
            return false;
        }
        if (this.sold != other.sold) {
            return false;
        }
        if (Double.doubleToLongBits(this.askingPrice) != 
                Double.doubleToLongBits(other.askingPrice)) {
            return false;
        }
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    /**
     *This method is for objects representing strings
     * @return
     */
    @Override
    public String toString() {
        return "Property{" + "mlsNum=" + mlsNum + ", licenseNum=" + 
                licenseNum + ", streetAddress=" + streetAddress + ", city=" + 
                city + ", state=" + state + ", zipCode=" + zipCode + 
                ", numBedrms=" + numBedrms + ", numBaths=" + numBaths + 
                ", sold=" + sold + ", askingPrice=" + askingPrice + '}';
    }

    /**
     *This method checks the MLSNum Pattern that is required
     * @return
     */
    public Boolean checkMLSNum() {
        return this.mlsNum >= 1000000 && this.mlsNum < 10000000;   
    }       

    /**
     *This method checks the State that is required 
     * @return
     */
    public Boolean checkState() {
        return this.state.equals("CO") || this.state.equals("WY");
    }

    /**
     *This method checks the zip code that is required
     * @return
     */
    public Boolean checkZipCode() {
        return this.zipCode >= 80000 && this.zipCode < 84000;
    }
}
