/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310detar;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Amanda
 */
public class PrintImpl2 {
    int countPropertyObjects;
    
    /**
     * my method that is outputting the information inputted
     * @param realtor
     * @param property
     * @param result
     * @param lineValues
     * @return 
     */
    public PrintWriter PrintImpl (RealtorLogImpl realtor, PropertyLogImpl property, 
            PrintWriter result, String[] lineValues) {
        
        Realtor realtorObj = null;
        
        // Check through each realtor to find a matching license number
        for (int i = 0; i < realtor.getRealtorObjects().length; i++){
            if (realtor.getRealtorObjects()[i] != null){
                if (realtor.getRealtorObjects()[i].getLicenseNum()
                        .compareTo(lineValues[0]) == 0) {
                    // Save the realtor object for later
                    realtorObj = realtor.getRealtorObjects()[i];
                }
            }
        }
        
        // Check if realtor object has data
        if (realtorObj != null) {
            // Print out realtor information line
            result.println("Realtor " + 
                realtorObj.getLicenseNum() + ", " + 
                realtorObj.getFirstName() + " " + 
                realtorObj.getLastName());
            
            // Get each property MLS number from array
            for (int o = 1; o < lineValues.length; o++) {
                // Find the property using the MLS number
                Property prop = property.find(Integer.parseInt(lineValues[o]));
                
                // Check if the property has data
                if (prop != null) {
                    if (prop.getSold()) {
                        result.println("    Property " + 
                            property.getPropertyObjects()[o].
                                    getProperty().getProperty()
                                    .getMlsNum() + " is SOLD");
                    } else {
                        result.println("    Property " + 
                            property.getPropertyObjects()[o].getProperty()
                                    .getProperty().getMlsNum() + " is "
                                    + "available for $" + 
                            property.getPropertyObjects()[o].getProperty()
                                    .getProperty().getAskingPrice());
                    }
                }
            }
        }
        else {
            result.println("Realtor " + 
                    lineValues[0] + " does not exist");
        }
        return result;
    }
    
//    /**
//     * New print method for new output file.
//     * @param basicCarStack
//     * @param luxuryCarStack
//     * @param realtor1
//     * @param property
//     * @param vehicleUsage
//     * @param basicQueueImpl
//     * @param luxuryQueueImpl
//     * @param fileName
//     * @param numOfBasic
//     */
//    public void PrintImpl2(CarStackImpl basicCarStack, CarStackImpl luxuryCarStack,
//            RealtorLogImpl realtor1, PropertyLogImpl property, 
//            VehicleUsageImpl vehicleUsage, RealtorQueueImpl basicQueueImpl, 
//            RealtorQueueImpl luxuryQueueImpl, String fileName, int numOfBasic) {
//        
//        
//        Realtor realtor = new Realtor();
//        Realtor [] vehicleList = vehicleUsage.getArray();
//        File outputFile = null;
//        PrintWriter result = null;
//        
//        try {
//           outputFile = new File(fileName);
//           result = new PrintWriter(outputFile);
//        }
//        catch(IOException e) {
//            System.out.println(outputFile + "could not be created!");
//        }
//        result.println("CAR USAGE REPORT");
//        for (int i = 1; i <= vehicleList.length; i++) {
//            if (vehicleList[i-1] != null) {
//                result.println(vehicleList[i-1].getFirstName() + " " + vehicleList[i-1].getLastName() +
//                        " is using car number " + i);
//            }
//        }
//        result.println("");
//        result.println("AVAILABLE CARS");
//        result.println("    BASIC CARS");
//        if (!basicCarStack.isEmpty()) {
//            for (int i = 1; i <= numOfBasic; i++) {
//                if (vehicleList[i-1] == null) {
//                    result.println("        Standard car number " + i + " is available");
//                }
//            }
//        }
//        else {
//            result.println("        No standard cars are available");
//        }
//        result.println("");
//        result.println("    LUXURY CARS");
//        if (!luxuryCarStack.isEmpty()) {
//            for (int i = numOfBasic + 1; i <= vehicleList.length; i++) {
//                if (vehicleList[i-1] == null) {
//                    result.println("        Luxury car number " + i + " is available");
//                }
//            }
//        }
//        else {
//            result.println("        No luxury cars are available");
//        }
//        result.println("");
//        result.println("TOP SELLER QUEUE");
//        RealtorNode curr = new RealtorNode();  
//        if (!luxuryQueueImpl.isEmpty()) {
//            curr = luxuryQueueImpl.frontNode;
//            while (curr != null) {
//                result.println(curr.getRealtor().getFirstName() + " " +
//                        curr.getRealtor().getLastName() + " is waiting");
//                curr = curr.getNextNode();
//            }
//        } else {
//            result.println("There are no top selling realtors waiting");
//        }
//        
//        result.println("");
//        result.println("STANDARD REALTOR QUEUE");
//        if (!basicQueueImpl.isEmpty()) {
//            curr = basicQueueImpl.frontNode;
//            while (curr != null) {
//                result.println(curr.getRealtor().getFirstName() + " " +
//                        curr.getRealtor().getLastName() + " is waiting");
//                curr = curr.getNextNode();
//            }
//        } else {
//            result.println("There are no top selling realtors waiting");
//        }
//        result.close();
//    }
}


