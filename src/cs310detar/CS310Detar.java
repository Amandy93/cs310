/*
 * The purpose of this program will be to track realtor and property information
 */
package cs310detar;
import java.io.*;
import java.util.Scanner;

/**
 *@author Amanda Detar 
 * Assignment 4
 */
public class CS310Detar {
   
    static final String INPUT_FILENAME = "input/assn5input.txt";
    static final String INPUT_FILENAME2 = "input/realtorRequests.txt";
    static final String OUTPUT_FILENAME = "output/assn5salesReport.txt";
    static RealtorLogImpl realtorLogImpl = new RealtorLogImpl();
    static PropertyLogImpl propertyLogImpl = new PropertyLogImpl();
    static PrintImpl2 printImpl = new PrintImpl2();
    static RealtorQueueImpl basicQueueImpl = new RealtorQueueImpl();
    static RealtorQueueImpl luxuryQueueImpl = new RealtorQueueImpl();
    static VehicleUsageImpl vehicleUsage = new VehicleUsageImpl(7);
    
    
    /**
     * This is my main method
     * @param args
     */
    public static void main(String[] args) {
        processFile();
        System.out.println();
        realtorLogImpl.displayHash();
        System.out.println();
        propertyLogImpl.displayHash();
        processFile2();
        System.out.println();
    }
    /**
     * This is my method that processes the file
     */
    private static void processFile(){
        String oneLine;
        String [] lineValues;

        File dataFile = new File(INPUT_FILENAME);
        Scanner fileScanner = null;
        try {
           fileScanner = new Scanner(dataFile);
        }
            catch (FileNotFoundException e) {
                System.err.println("File not found exception for file " + e);
                System.exit(1);
        }

        while (fileScanner.hasNext()) {
            oneLine = fileScanner.nextLine();
            lineValues = oneLine.split(",");
            
            if (lineValues[0].matches("REALTOR")) {
                if (lineValues[1].matches("ADD")){
                    processRealtorAddition(lineValues);
                }
            }
            if (lineValues[0].matches("PROPERTY")) {
                if (lineValues[1].matches("ADD")){
                    processPropertyAddition(lineValues);
                }
            }
        }
        fileScanner.close();
    }
    
    //Processes the second input file
    private static void processFile2(){
        String oneLine;
        String [] lineValues;
        File outputFile = null;
        PrintWriter result = null;
        File dataFile = new File(INPUT_FILENAME2);
        Scanner fileScanner = null;
        try {
           fileScanner = new Scanner(dataFile);
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found exception for file " + e);
            System.exit(1);
        }
        
        try {
           outputFile = new File(OUTPUT_FILENAME);
           result = new PrintWriter(outputFile);
        }
        catch(IOException e) {
            System.out.println(outputFile + "could not be created!");
        }
        
        while (fileScanner.hasNext()){
            oneLine = fileScanner.nextLine();
            lineValues = oneLine.split(" ");
            
            result = printImpl.PrintImpl(realtorLogImpl, propertyLogImpl, result, lineValues);
        }
        
        fileScanner.close();
        result.close();
    }
    
    /**
     * This method is for adding realtor information
     * @param inputLineValues
     */
    public static void processRealtorAddition (String [] inputLineValues){
        Realtor realtor1 = new Realtor(inputLineValues);
       
        if (inputLineValues[0].matches("REALTOR")) {
            if (!realtor1.checkLicenseNum()){
                System.out.println("ERROR:  Realtor with license " + 
                        realtor1.getLicenseNum() + " has invalid license number");
            }
            if (!realtor1.checkPhoneNum()){
                System.out.println("ERROR:  Realtor with license " + 
                        realtor1.getLicenseNum()+ " has invalid phone number " 
                        + realtor1.getPhoneNum());
            }
        }  
        if (realtorLogImpl.isLicenseUnique(realtor1.getLicenseNum())){
            realtorLogImpl.add(realtor1);
            System.out.println("ADDED:  Realtor with license " + 
                    realtor1.getLicenseNum());
        }
        else {
            System.out.println("ERROR:  " + realtor1.getLicenseNum() + " is NOT "
                    + "unique and will NOT be added to the log.");
        }
    }
    
    /**
     * This method if for adding property information
     * @param inputLineValues
     */
    public static void processPropertyAddition (String [] inputLineValues) {
        Property property1 = new Property(inputLineValues);
        
        if (inputLineValues[0].matches("PROPERTY")){
            if (!property1.checkMLSNum()) {
                System.out.println("ERROR:  Property with MLS number " + 
                        property1.getMlsNum() + " has an invalid MLS number.");
            }
            if (!property1.checkState()) {
                System.out.println("ERROR:  Property with MLS number " + 
                        property1.getMlsNum() + " has invalid state "
                                + "abbreviation " + property1.getState());
            }
            if (!property1.checkZipCode()) {
                System.out.println("ERROR:  Property with MLS number " + 
                        property1.getMlsNum() + " has invalid zip code " + 
                        property1.getZipCode());
            }
        }
        if (!realtorLogImpl.isLicenseUnique(property1.getLicenseNum()) && 
                propertyLogImpl.isMlsUnique(property1.getMlsNum())) {
            propertyLogImpl.add(property1);
            System.out.println("ADDED:  Property with MLS number " + 
                    property1.getMlsNum() + " listed by realtor " + 
                    property1.getLicenseNum());
        }
        else {
            System.out.println("ADD ERROR: Property with MLS number " + 
                    property1.getMlsNum() + " has Realtor with license " + 
                    property1.getLicenseNum() + ",\nbut there is no such Realtor"
                            + " license in the realtor log.\nSo property will NOT"
                            + " be added to property log.");
        }
    }
    
//    /**
//     * This method is for deleting realtor information
//     * @param inputLineValues
//     */
//    public static void processRealtorDeletion (String [] inputLineValues){
//        if (!realtorLogImpl.isLicenseUnique(inputLineValues[2])){
//            propertyLogImpl.removeByLicense(inputLineValues[2]);
//            realtorLogImpl.remove(inputLineValues[2]);
//            
//            System.out.println("DELETED:  Realtor with license " + 
//                    inputLineValues[2] + " has been removed from the "
//                            + "realtor log.\nAll realtor's properties will "
//                            + "also be removed from the property log");
//        }
//        else {
//            System.out.println("ERROR:  Realtor with license " + 
//                    inputLineValues[2] + " has invalid license number.");
//        }
//    }
//    
//    /**
//     * This method is for deleting property information.
//     * @param inputLineValues
//     */
//    public static void processPropertyDeletion (String [] inputLineValues){
//        if (!propertyLogImpl.isMlsUnique(Integer.parseInt(inputLineValues[2]))) {
//            propertyLogImpl.remove(Integer.parseInt(inputLineValues[2]));
//            System.out.println("DELETED:  " + inputLineValues[2] + 
//                    " has been deleted.");
//        }
//        else {
//            System.out.println("ERROR:  Property with MLS number " + 
//                    inputLineValues[2] + " has an invalid MLS number.");
//        }
//    }
    
//    /**
//     * This method calls another method to create a report
//     * @param fileName
//     */
//    public static void createReport(String fileName) {
//        printImpl.PrintImpl(realtorLogImpl, propertyLogImpl, fileName);
//        
//    }
    
//    /**
//     *
//     * @param fileName
//     */
//    public static void createUsageReport(String fileName) {
//        printImpl.PrintImpl2(basicCarStack, luxuryCarStack, realtorLogImpl, 
//                propertyLogImpl, vehicleUsage, basicQueueImpl, luxuryQueueImpl, 
//                fileName, BASIC_CARS);
//    }
    
    // This method will process the carInfo file

//    /**
//     * processes the information given through new input file
//     */
//    public static void processCarInfo() {
//        String oneLine;
//        String [] lineValues;
//        Realtor realtor = new Realtor();
//        
//        // Get the file
//        File dataFile = new File(INPUT_FILENAME2);
//        Scanner fileScanner = null;
//        
//        // Try to open the file
//        try {
//           fileScanner = new Scanner(dataFile);
//        }
//            catch (FileNotFoundException e) {
//                System.err.println("File not found exception for file " + e);
//                System.exit(1);
//        }
//        
//        // No errors, go through the file line by line
//        while (fileScanner.hasNext()) {
//            // Get the next line (first line)
//            oneLine = fileScanner.nextLine();
//            
//            // Parse the line with " " spaces
//            lineValues = oneLine.split(" ");
//            
//            // Normal lines look like this:
//            // REQUEST AA0123456
//            // LineValues[0] = "REQUEST"
//            // LineValues[1] = "AA0123456"
//            
//            // Check if the first word is request
//            if (lineValues[0].matches("REQUEST")) {
//                // Check if the license number is in the list
//                if (!realtorLogImpl.isLicenseUnique(lineValues[1])){
//                    // Find the realtor object that matches the license num
//                    realtor = realtorLogImpl.getRealtorByLicense(lineValues[1]);
//                    // Process car request
//                    processCarRequest(realtor);
//                }
//                else {
//                    System.out.println("Unknown realtor " + 
//                            realtor.getLicenseNum() + " not allowed access to cars. "
//                                    + "Request ignored.");
//                }
//            }
//            if (lineValues[0].matches("RETURN")) {
//                realtor = realtorLogImpl.getRealtorByLicense(lineValues[1]);
//                processCarReturn(realtor);
//            }
//        }
//        fileScanner.close();
//    }
//    
//    /**
//     * processing the realtor request for a car
//     * @param obj
//     * @return
//     */
//    public static int processCarRequest(Realtor obj){
//        int popped = 0;
//        String typeOfCar = null;
//        String typeOfRealtor = null;
//        if (propertyLogImpl.totalPropertyValue(obj.getLicenseNum()) > 1000000) {
//            typeOfRealtor = "Top seller";
//            // Yes, the realtor needs a luxury car
//            if (!luxuryCarStack.isEmpty()) {
//                popped = luxuryCarStack.pop();
//                // Take the next car off the stack          
//                // Assign the car to the realtor
//                vehicleUsage.add(popped, obj);
//                typeOfCar = "luxury";
//            }
//            else if (luxuryCarStack.isEmpty() && !basicCarStack.isEmpty()){
//                popped = basicCarStack.pop();
//                // Assign the basic car to the realtor
//                vehicleUsage.add(popped, obj);
//                typeOfCar = "basic";
//            }
//            else {
//                luxuryQueueImpl.addToQueue(obj);
//                System.out.println(obj.getFirstName() + " " + obj.getLastName() 
//                        + " waiting in luxury car queue");
//            }
//        }
//        else {
//            typeOfRealtor = "Standard";
//            // No, the realtor needs a prius
//            if (!basicCarStack.isEmpty()) {
//                popped = basicCarStack.pop();
//                // Assign the car to the realtor
//                vehicleUsage.add(popped, obj);
//                typeOfCar = "basic";
//            }
//            else {
//                //Adds realtor to queue
//                basicQueueImpl.addToQueue(obj);
//                System.out.println(obj.getFirstName() + " " + obj.getLastName() 
//                        + " waiting in standard car queue");
//            }
//        }
//        if (popped > 0) {
//            System.out.println(typeOfRealtor + " " + obj.getFirstName() + " " + 
//                obj.getLastName() + " has been assigned " + typeOfCar + 
//                " number " + popped);
//        }
//        return popped;
//    }
//    
//    /**
//     * processing the return of a car from the realtor
//     * @param obj
//     * @return
//     */
//    public static int processCarReturn(Realtor obj) {
//        int pushed = 0;
//        
//        if (propertyLogImpl.totalPropertyValue(obj.getLicenseNum()) > 1000000) {
//            // Yes, the realtor was driving a luxury car
//            
//            // Unassign the car from the realtor
//            pushed = vehicleUsage.remove(obj.getLicenseNum());
//
//            // Add the car id back to the stack
//            if (pushed > -1) {
//                luxuryCarStack.push(pushed);
//                
//            }
//            if (pushed > 0) {
//                System.out.println(obj.getFirstName() + " " + obj.getLastName() +
//                        " has returned car number " + pushed);
//            }
//            //removing from queue
//            if (!luxuryQueueImpl.isEmpty() && !luxuryCarStack.isEmpty()) {
//            
//                // Assign the car to the realtor
//                processCarRequest(luxuryQueueImpl.removeFromQueue());
//                
//            }
//            else if (!luxuryQueueImpl.isEmpty() && !basicCarStack.isEmpty()) {
//                processCarRequest(luxuryQueueImpl.removeFromQueue());
//            }
//        }
//        else {
//            // No, the realtor returned a prius       
//            
//            //Unsasign the car from the realtor
//            pushed = vehicleUsage.remove(obj.getLicenseNum());
//            
//            //Add the car id back to the stack
//            basicCarStack.push(pushed);
//            if (pushed > 0) {
//                System.out.println(obj.getFirstName() + " " + obj.getLastName() +
//                        " has returned car number " + pushed);
//            }
//            if (!basicQueueImpl.isEmpty() && !basicCarStack.isEmpty()) {
//                // Assign the car to the realtor
//                processCarRequest(basicQueueImpl.removeFromQueue());
//            }
//        }
//
//        return pushed;
//    }
}

