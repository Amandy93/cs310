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
public class PropertyNode {
    private Property property;
    private PropertyNode nextNode;
    
    /**
     * Constructor making property and nextnode null
     */
    public PropertyNode() {
        this.property = null;
        this.nextNode = null;
    }
    
    /**
     * Constructor making property point to property
     * @param property
     */
    public PropertyNode(Property property){
        this.property = property;
        this.nextNode = null;
    }
    
    /**
     * getting the property node
     * @return
     */
    public Property getProperty() {
        return property;
    }
    
    /**
     * setting the property node
     * @param property
     */
    public void setProperty (Property property) {
        this.property = property;
    }
    
    /**
     * getting next node
     * @return
     */
    public PropertyNode getNextNode() {
        return nextNode;
    }
    
    /**
     * setting the next node
     * @param nextNode
     */
    public void setNextNode (PropertyNode nextNode) {
        this.nextNode = nextNode;
    }
}
