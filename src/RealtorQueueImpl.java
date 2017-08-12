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
public class RealtorQueueImpl {
    RealtorNode frontNode;
    RealtorNode rearNode;
    
    /**
     * Making front and rear nodes null
     */
    public RealtorQueueImpl(){
        frontNode = null;
        rearNode = null;
    }
    
    /**
     * adding a realtor to the queue
     * @param realtor
     */
    public void addToQueue (Realtor realtor) {
        RealtorNode newNode = new RealtorNode(realtor);
        if (rearNode != null) {
            rearNode.setNextNode(newNode);
        }
        else {
            frontNode = newNode;
        }
        rearNode = newNode;
    }

    /**
     * removing a realtor from the queue
     * @return
     */
    public Realtor removeFromQueue() {
        Realtor realtor = null;
        if (frontNode != null) {
            realtor = frontNode.getRealtor();
            frontNode = frontNode.getNextNode();
        }
        else {
            System.out.println("Queue was empty - cannot return person");
        }
        return realtor;
    }

    /**
     * the queue is full
     * @return
     */
    public boolean isFull() {
        boolean retValue = false;
        if (rearNode != null) {
            retValue = true;
        }
        return retValue;
    }

    /**
     * the queue is empty
     * @return
     */
    public boolean isEmpty() {
        boolean retValue = true;
        if (frontNode != null) {
            retValue = false;
        }
        return retValue; 
    }

    /**
     * the amount of nodes in the queue (realtors)
     * @return
     */
    public int calculateNumberOfNodes() {
        int count = 0;
        RealtorNode currNode = frontNode;
        while (currNode != null) {
            count++;
            currNode = currNode.getNextNode();
        }
        return count;
    }
    
}
