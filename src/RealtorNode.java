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
public class RealtorNode {
    private Realtor realtor;
    private RealtorNode nextNode;
    
    /**
     * constructor setting everything to null
     */
    public RealtorNode () {
        this.realtor = null;
        this.nextNode = null;
    }
    
    /**
     * constructor setting realtor to realtor
     * @param realtor
     */
    public RealtorNode (Realtor realtor){
        this.realtor = realtor;
        this.nextNode = null;
    }
    
    /**
     * getting realtor
     * @return
     */
    public Realtor getRealtor () {
        return realtor;
    }
    
    /**
     * setting realtor
     * @param realtor
     */
    public void setRealtor (Realtor realtor) {
        this.realtor = realtor;
    }
    
    /**
     * getting the next node
     * @return
     */
    public RealtorNode getNextNode() {
        return nextNode;
    }
    
    /**
     * setting the next node
     * @param nextNode
     */
    public void setNextNode (RealtorNode nextNode) {
        this.nextNode = nextNode;
    }
}
