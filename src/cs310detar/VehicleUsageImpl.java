/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310detar;
import java.util.ArrayList;
/**
 *
 * @author Amanda
 */
public class VehicleUsageImpl {
    private Realtor[] usageList = null;
    
    /**
     * setting everything to null
     * @param size
     */
    public VehicleUsageImpl(int size) {
         usageList = new Realtor[size];
         for (int i = 0; i < usageList.length; i++) {
             usageList[i] = null;
         }
    }
    
    /**
     * getting the array
     * @return
     */
    public Realtor[] getArray(){
        return usageList;
    }
    
    /**
     * adding realtor to usage log
     * @param obj
     */
    public void add(Realtor obj) {
        //usageList.add(obj);
    }
    
    /**
     * adding vehicle with assigned realtor to usuage log
     * @param vehicle
     * @param obj
     */
    public void add(int vehicle, Realtor obj) {
        vehicle--;
        usageList[vehicle] = obj;
    }
    
    /**
     * removing from the usage log
     * @param license
     * @return
     */
    public int remove(String license) {
        int index = -1;
        for (int i = 0; i < usageList.length; i++){
            if (usageList[i] != null) {
                if (usageList[i].getLicenseNum().compareTo(license) == 0){
                    usageList[i] = null;
                    index = i + 1;
                }
            }
        }
        return index;
    }
    
    /**
     * test display
     */
    public void display() {
        for (int i = 0; i < usageList.length; i++){
            System.out.println(i + ": " + usageList[i].getLicenseNum());
        }
    }
}
