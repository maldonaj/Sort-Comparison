import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;
import java.io.*;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 *  
 *  
 *  Algorithm performance comparison
 *  
 *  Average running time from three times.
 *  |					|Insert	|Selection	|Quick	|Merge Recursive|Merge iterative
 *  |10 random			|0		|0			|0		|0				|0
 *  |100 random			|0.33	|0.67		|0.33	|0				|0
 *  |1000 random		|15		|7			|2		|0.33			|0
 *  |1000 few unique	|5.67	|1.33		|0.67	|0.33			|0.33
 *  |1000 nearly ordered|7.67	|1			|1		|8.67			|0
 *  |1000 reverse order	|2.67	|2.33		|0.67	|0.67			|0
 *  |1000 sorted		|3		|1.33		|0.33	|0				|0.33
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double test[] = new double[0];
    	
    	assertEquals(null, test, SortComparison.insertionSort(test));
    	assertEquals(null, test, SortComparison.selectionSort(test));
    	assertEquals(null, test, SortComparison.quickSort(test));
    	assertEquals(null, test, SortComparison.mergeSortIterative(test));
    	assertEquals(null, test, SortComparison.mergeSortRecursive(test));
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testOneItem()
    {
    	double test[] = {1};
    	assertEquals("1", test, SortComparison.insertionSort(test));
    	assertEquals("1", test, SortComparison.selectionSort(test));
    	assertEquals("1", test, SortComparison.quickSort(test));
    	assertEquals("1", test, SortComparison.mergeSortIterative(test));
    	assertEquals("1", test, SortComparison.mergeSortRecursive(test));
    }
    
    @Test
    public void testMultipleItemsInOrder()
    {
    	double test[] = {1,2,3};
    	assertEquals("1,2,3", test, SortComparison.insertionSort(test));
    	assertEquals("1,2,3", test, SortComparison.selectionSort(test));
    	assertEquals("1,2,3", test, SortComparison.quickSort(test));
    	assertEquals("1,2,3", test, SortComparison.mergeSortIterative(test));
    	assertEquals("1,2,3", test, SortComparison.mergeSortRecursive(test));
    }
    
    @Test
    public void testMultipleItemsOutOfOrder() throws Exception
    {
    	double test[] = {2,4,3,1};
    	assertEquals("1,2,3,4", test, SortComparison.insertionSort(test));
    	assertEquals("1,2,3,4", test, SortComparison.selectionSort(test));
    	assertEquals("1,2,3,4", test, SortComparison.quickSort(test));
    	assertEquals("1,2,3,4", test, SortComparison.mergeSortIterative(test));
    	assertEquals("1,2,3,4", test, SortComparison.mergeSortRecursive(test));
    	//main(null);
    }
    

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     */
    public static void main(String[] args) throws Exception
    {
    	System.out.println("10 NUMBERS");
    	Scanner scanner = new Scanner(new File("numbers10.txt"));
    	double[] a = new double[10];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "100 NUMBERS");    	
    	scanner = new Scanner(new File("numbers100.txt"));
    	a = new double[100];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "1000 NUMBERS");    	
    	scanner = new Scanner(new File("numbers1000.txt"));
    	a = new double[1000];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "1000 NUMBERS WITH DUPLICATES");    	
    	scanner = new Scanner(new File("numbers1000Duplicates.txt"));
    	a = new double[1000];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "1000 NUMBERS NEARLY ORDERED");    	
    	scanner = new Scanner(new File("numbersNearlyOrdered1000.txt"));
    	a = new double[1000];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "1000 NUMBERS REVERSED");    	
    	scanner = new Scanner(new File("numbersReverse1000.txt"));
    	a = new double[1000];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    	System.out.println('\n' + "1000 NUMBERS SORTED");    	
    	scanner = new Scanner(new File("numbersSorted1000.txt"));
    	a = new double[1000];
    	for(int i = 0; scanner.hasNextLine(); i++) {
    		a[i] = Double.parseDouble(scanner.nextLine());
    	}
    	measureFileRuntime(a, "insertionSort");
    	measureFileRuntime(a, "selectionSort");
    	measureFileRuntime(a, "quickSort");
    	measureFileRuntime(a, "mergeSortRecursive");
    	measureFileRuntime(a, "mergeSortIterative");
    	
    }
    
    public static void measureFileRuntime(double a[], String sortType) {
    	long start = System.currentTimeMillis();
        switch(sortType){
        	case "insertionSort":
        		SortComparison.insertionSort(a);
        	case "selectionSort":
        		SortComparison.selectionSort(a);
        	case "quickSort":
        		SortComparison.quickSort(a);
        	case "mergeSortRecursive":
        		SortComparison.mergeSortRecursive(a);
        	case "mergeSortIterative":
        		SortComparison.mergeSortIterative(a);
        }
        long end = System.currentTimeMillis();
        long finalTime = end - start;
        
        System.out.println(sortType + " " + finalTime);
    }

}
