import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class HeapLab {
	// this creates the tree using the makeTree method scanning in a file

    public static ArrayList<Integer> makeTree(Scanner input) {
        ArrayList<Integer> tree = new ArrayList<>();
        while (input.hasNextInt()) {
            tree.add(input.nextInt());
        }
        return tree;
    }

	    public static void makeHeap(ArrayList<Integer> tree, int N, int i) {
	        int largest = i;
	        int leftChild = 2 * i + 1;
	        int rightChild = 2 * i + 2;
	        //looks at the 3 nodes, and put the largest on top
	        
	        //we need leftChild< N to check if the child exist, since sometimes we can 
	        //calculate that if a child WERE to exist, it would be index 2*i + 1, but 
	        //we might not have it in our tree for that specific parent node.
	        if (leftChild < N && tree.get(leftChild) > tree.get(largest)) {
	            largest = leftChild;
	        }
	
	        if (rightChild < N && tree.get(rightChild) > tree.get(largest)) {
	            largest = rightChild;
	        }
	        //this is to swap the node when the parent isn't the largest
	        //after the swap happens, the tree get heapified again
	        if (largest != i) {
	            int temp = tree.get(i); 
	            tree.set(i, tree.get(largest)); 
	            
	            tree.set(largest, temp); 
	            //we make his recursive call because when we swap i and largest
	            // (largest) is the parent node that was swapped, index largest is now holding
	            //the new value of the (parent) that we swapped.
	            //we look at that node and its children to see if the new value mess up the 
	            //max heap.
	            makeHeap(tree, N, largest);
	        }
	    }

    public static ArrayList<Integer> heapSort(ArrayList<Integer> tree) {
        int N = tree.size();
        //the int i = N/2 -1 gives us the the non leaf nodes( meaning they have left and right children)
        for (int i = N / 2 - 1; i >= 0; i--) {
        	//makeheap now sort this, looking at i and its children, then the node before that,
        	//until it reaches the root. this creates the MAX HEAP
            makeHeap(tree, N, i);
       
        }
        
        for (int i = N - 1; i > 0; i--) {
            int temp = tree.get(0);
            tree.set(0, tree.get(i));
            tree.set(i, temp);
            //we "removed" the largest node, by swapping with the last, then 
            //calling makeHeap on the array excluding the last node.
            makeHeap(tree, i, 0);
        }

        return tree;
    }


    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File fileInput = fileChooser.getSelectedFile();

            try {
                Scanner scan = new Scanner(fileInput);
                ArrayList<Integer> tree = makeTree(scan);

                System.out.println("\nTree Elements are:");
                
                for (Integer element : tree) {
                    System.out.print(element + " ");
                }

                heapSort(tree);

                System.out.println("\nSorted Elements (min to max):");
                
                for (Integer element : tree) {
                    System.out.print(element + " ");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
