import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HeapLabTest {

    @Test    
    public void testMakeTree() {
        String inputString = "1 3 2 4 5 8 7 6 9 52 10 12 99 13 14";
        Scanner input = new Scanner(inputString);
        //creating a tree using ArrayList methods
        ArrayList<Integer> expectedTree = new ArrayList<>();
        while (input.hasNextInt()) {
            expectedTree.add(input.nextInt());
        }

        //creating a tree using our makeTree method
        Scanner inputForMakeTree = new Scanner(inputString);
        ArrayList<Integer> actualTree = HeapLab.makeTree(inputForMakeTree);
        
        input.close();
        inputForMakeTree.close();

        assertEquals(expectedTree, actualTree);
    }
    @Test
    public void testHeapSort() {
        String inputString = "1 3 2 4 5 8 7 6 9 52 10 12 99 13 14";
        ArrayList<Integer> inputTree = new ArrayList<>();
        Scanner inputScanner = new Scanner(inputString);
        //make the tree using a sample input
        while (inputScanner.hasNextInt()) {
            inputTree.add(inputScanner.nextInt());
        }
        
        ArrayList<Integer> expectedSortedTree = new ArrayList<>();
        Scanner sortedInputScanner = new Scanner(inputString);
        while (sortedInputScanner.hasNextInt()) {
            expectedSortedTree.add(sortedInputScanner.nextInt());
        }
        // this sorts it form lowest to highest using the sort method
        expectedSortedTree.sort(null);
        
        //this sorts it from lowest to highest using the heapSort we made
        ArrayList<Integer> actualSortedTree = HeapLab.heapSort(inputTree);

        inputScanner.close();
        sortedInputScanner.close();

        assertEquals(expectedSortedTree, actualSortedTree);
    }
}
