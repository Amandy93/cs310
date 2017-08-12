
package cs310detar;

/**
 *
 * @author Amanda
 */
public class CarStackImpl {
    int [] carStack;
    int top;
    int size;
    
    /**
     * 
     * @param size
     */
    public CarStackImpl(int size) {
        carStack = new int[size];
        top = -1;
    }
    
    /**
     * My push method
     * @param carNum
     */
    public void push(int carNum) {
        if (top < carStack.length) {
            top++;
            carStack[top] = carNum;
        }
        else {
            System.out.println("The car lot is full.");
        }
    }
    
    /**
     * Is the stack empty method
     * @return
     */
    public boolean isEmpty() {
        boolean retValue = false;
        if (top < 0) {
            retValue = true;
        }
        return retValue;
    }
    
    /**
     * taking off of stack
     * @return
     */
    public int pop() {
        int carNum = -1;
        
        if (!isEmpty()) {
            carNum = carStack[top];
            top--;
        }
        else {
            System.out.println("The car lot is empty");
        }
        return carNum;
    }
}
