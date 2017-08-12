/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310detar;

/**
 *
 * @author Amanda
 */
public class MapEntry {
    private int key;
    private PropertyNode property;
    //Property [] propertyObjects = null;

    /**
     * Constructor
     * @param key
     * @param property
     */
    public MapEntry(int key, PropertyNode property) {
        this.property = property;
        this.key = key;
    }
    
    /**
     * Setting the key
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * setting the property
     * @param property
     */
    public void setProperty(PropertyNode property) {
        this.property = property;
    }

    /**
     * getting the key
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * getting the property
     * @return
     */
    public PropertyNode getProperty() {
        return property;
    }
}
