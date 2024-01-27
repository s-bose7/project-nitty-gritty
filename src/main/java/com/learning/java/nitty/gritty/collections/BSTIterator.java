/**
 * 
 */
package com.learning.java.nitty.gritty.collections;

import java.util.List;
import java.util.ArrayList;

import com.learning.java.nitty.gritty.datastructures.Node;

/**
 * @author SUDIP BOSE
 *
 */
public class BSTIterator {
	
	private List<Integer> stack;
	private int size, iterator; 
	private Node rootNode;
	
    public BSTIterator(Node rootNode) {
    	
        this.stack = new ArrayList<Integer>();
        this.rootNode = rootNode;
        this.size = 0;
        this.iterator = -1;
        dfsRecursiveInOrder(this.rootNode);
    }
    
    private void dfsRecursiveInOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	dfsRecursiveInOrder(node.left);
    	++size;
    	stack.add(node.data);
    	dfsRecursiveInOrder(node.right);
    }
    
    public int next() {
        return stack.get(++iterator);
    }
    
    public boolean hasNext() {
        if(iterator < size-1) {
        	return false;
        }
        return true;
    }
}
