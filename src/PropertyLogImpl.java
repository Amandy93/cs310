
package cs310detar;
import java.util.*;

/**
 *
 * @author Amanda
 */
public class PropertyLogImpl {
    //private LinkedList<Property> propertyLinkedList = new LinkedList();
    //private Map<Integer, MapEntry> map = new HashMap<Integer, MapEntry>();
    private MapEntry[] propertyObjects;
    int MAXSIZE;
    int currSize;
    int numIdx;

    /**
     * This is my constructor that is setting everything in the array to null
     */
    public PropertyLogImpl() {
        MAXSIZE = 17;
        currSize = 0;
        numIdx = 0;
        propertyObjects = new MapEntry[MAXSIZE];
        for (int i = 0; i < propertyObjects.length; i++){
            propertyObjects[i] = null;
        }
    }
    
    /**
     * getting the property objects
     * @return
     */
    public MapEntry[] getPropertyObjects() {
        return propertyObjects;
    }
   
    /**
     * adding a property object to the array
     * @param obj
     */
    public void add(Property obj) {
        //Creates the new node
        PropertyNode newNode = new PropertyNode(obj);
        //Making hashCode equal the obj hashcode
        int hashCode = obj.getMlsNum() % MAXSIZE;
        //hashCode = hashCode % MAXSIZE;
        if (propertyObjects[hashCode] == null) {
            currSize++;
            numIdx++;
            //propertyObjects[hashCode].setKey(hashCode);
            propertyObjects[hashCode] = new MapEntry(hashCode, newNode);
            //propertyObjects[hashCode].setProperty(newNode);
        }
        else {
            // Store the property node at the top of the linkedlist
            PropertyNode topNode = propertyObjects[hashCode].getProperty();
            newNode.setNextNode(topNode);
            propertyObjects[hashCode] = new MapEntry(hashCode, newNode);
        }
    }
    
    /**
     * Finding the mls number in the array
     * @param mlsNum
     * @return
     */
    public Property find(int mlsNum){
        Property retValue = null;
        int hashCode = mlsNum % MAXSIZE;
        for (PropertyNode currNode = propertyObjects[hashCode].getProperty(); 
                currNode != null; currNode = currNode.getNextNode()){
            if (currNode.getProperty().getMlsNum() == mlsNum) {
                retValue = currNode.getProperty();
            }
        }
        return retValue;
    }
    
    /**
     * Displays the information for the property hash table
     */
    public void displayHash(){
        System.out.println("Property Hash Table:");
        for (int i = 0; i < propertyObjects.length; i++){
            if (propertyObjects[i] != null){
                System.out.print("    Index " + i + " contains Properties: ");
                for (PropertyNode currNode = propertyObjects[i].getProperty(); 
                currNode != null; currNode = currNode.getNextNode()){
                    System.out.print(currNode.getProperty().getMlsNum() + " ");                 
                }
                System.out.println();
            }
            else {
                System.out.println("    Index " + i + " is empty");
            }     
        }
    }
    
    /**
     * Verifying that the mls number is unique
     * @param mlsNum
     * @return
     */
    public boolean isMlsUnique(int mlsNum){
        boolean retValue = true;
        int hashCode = mlsNum % MAXSIZE;
        if (propertyObjects[hashCode] != null) {
            for (PropertyNode currNode = propertyObjects[hashCode].getProperty(); 
                    currNode != null; currNode = currNode.getNextNode()){
                if (currNode.getProperty().getMlsNum() == mlsNum) {
                    retValue = false;
                }
            }
        }
        return retValue;
    }
}
