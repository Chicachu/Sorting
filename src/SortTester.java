import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/** 
 * TCSS 342 - Data Structures with Edwin Armstrong
 * 
 * @author Erica Putsche
 * @version 11/22/2013
 */

/**
 * This class tests DoublyLinkedList class and its sorting methods, collects data and saves
 * that data to txt files.
 * @author Erica Putsche
 *
 */
public class SortTester {
	public static void main(String[] args) {
		DoublyLinkedList asc100 = new DoublyLinkedList(); 
		asc100.populateListAsc(100);
		DoublyLinkedList asc500= new DoublyLinkedList(); 
		asc500.populateListAsc(500);
		DoublyLinkedList asc1000= new DoublyLinkedList(); 
		asc1000.populateListAsc(1000);
		DoublyLinkedList asc5000= new DoublyLinkedList(); 
		asc5000.populateListAsc(5000);
		
		DoublyLinkedList desc100 = new DoublyLinkedList(); 
		desc100.populateListDesc(100);
		DoublyLinkedList desc500= new DoublyLinkedList(); 
		desc500.populateListDesc(500);
		DoublyLinkedList desc1000= new DoublyLinkedList(); 
		desc1000.populateListDesc(1000);
		DoublyLinkedList desc5000= new DoublyLinkedList(); 
		desc5000.populateListDesc(5000);
		
		DoublyLinkedList rand100 = new DoublyLinkedList(); 
		rand100.populateListRandom(100);
		DoublyLinkedList rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		DoublyLinkedList rand1000= new DoublyLinkedList(); 
		rand1000.populateListRandom(1000);
		DoublyLinkedList rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		long asc100TotalBubble, asc1000TotalBubble, asc10000TotalBubble, asc100000TotalBubble;
		long desc100TotalBubble, desc1000TotalBubble, desc10000TotalBubble, desc100000TotalBubble;
		long rand100TotalBubble, rand1000TotalBubble, rand10000TotalBubble, rand100000TotalBubble;
		
		long asc100TotalSelect, asc1000TotalSelect, asc10000TotalSelect, asc100000TotalSelect;
		long desc100TotalSelect, desc1000TotalSelect, desc10000TotalSelect, desc100000TotalSelect;
		long rand100TotalSelect, rand1000TotalSelect, rand10000TotalSelect, rand100000TotalSelect;
		
		long asc100TotalInsertArray, asc1000TotalInsertArray, asc10000TotalInsertArray, asc100000TotalInsertArray;
		long desc100TotalInsertArray, desc1000TotalInsertArray, desc10000TotalInsertArray, desc100000TotalInsertArray;
		long rand100TotalInsertArray, rand1000TotalInsertArray, rand10000TotalInsertArray, rand100000TotalInsertArray;
		
		long asc100TotalInsertList, asc1000TotalInsertList, asc10000TotalInsertList, asc100000TotalInsertList;
		long desc100TotalInsertList, desc1000TotalInsertList, desc10000TotalInsertList, desc100000TotalInsertList;
		long rand100TotalInsertList, rand1000TotalInsertList, rand10000TotalInsertList, rand100000TotalInsertList;
		
		long asc100TotalMerge, asc1000TotalMerge, asc10000TotalMerge, asc100000TotalMerge;
		long desc100TotalMerge, desc1000TotalMerge, desc10000TotalMerge, desc100000TotalMerge;
		long rand100TotalMerge, rand1000TotalMerge, rand10000TotalMerge, rand100000TotalMerge;
		
		long asc100TotalRadix, asc1000TotalRadix, asc10000TotalRadix, asc100000TotalRadix;
		long desc100TotalRadix, desc1000TotalRadix, desc10000TotalRadix, desc100000TotalRadix;
		long rand100TotalRadix, rand1000TotalRadix, rand10000TotalRadix, rand100000TotalRadix;
		
		
		try {
			File dataAsc = new File("AscDataAssignments.txt");
			PrintWriter writer = new PrintWriter(dataAsc);
			
			// ~*~ BUBBLE SORT ON ASCENDING
			asc100.bubbleSortStats();
			asc500.bubbleSortStats();
			asc1000.bubbleSortStats();
			asc5000.bubbleSortStats(); 
			
			asc100TotalBubble = calculateTotal(asc100);
			asc1000TotalBubble = calculateTotal(asc500);
			asc10000TotalBubble = calculateTotal(asc1000);
			asc100000TotalBubble = calculateTotal(asc5000);
			
			System.out.println("Done Bubble sort");
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble," + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
			+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			// ~*~ SELECT SORT ON ASCENDING
			asc100.selectionSortStats();
			asc500.selectionSortStats();
			asc1000.selectionSortStats();
			asc5000.selectionSortStats();
			
			System.out.println("Done Select Sort");
			
			asc100TotalSelect = calculateTotal(asc100);
			asc1000TotalSelect = calculateTotal(asc500);
			asc10000TotalSelect = calculateTotal(asc1000);
			asc100000TotalSelect = calculateTotal(asc5000);
			
			writer.write("Select," + + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
			+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			// ~*~ Insert SORT with Arrays ON ASCENDING
			asc100.insertSortArrayStats();
			asc500.insertSortArrayStats();
			asc1000.insertSortArrayStats();
			asc5000.insertSortArrayStats();
			
			System.out.println("Done Insert Array Sort");
			
			asc100TotalInsertArray = calculateTotal(asc100);
			asc1000TotalInsertArray = calculateTotal(asc500);
			asc10000TotalInsertArray = calculateTotal(asc1000);
			asc100000TotalInsertArray = calculateTotal(asc5000);
			
			writer.write("InsertArray," + + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
					+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			// ~*~ Insert SORT with Arrays ON ASCENDING
			asc100.insertSortListStats();
			asc500.insertSortListStats();
			asc1000.insertSortListStats();
			asc5000.insertSortListStats();
			
			System.out.println("Done Insert List Sort");
			
			asc100TotalInsertList = calculateTotal(asc100);
			asc1000TotalInsertList = calculateTotal(asc500);
			asc10000TotalInsertList = calculateTotal(asc1000);
			asc100000TotalInsertList = calculateTotal(asc5000);
			
			writer.write("InsertList," + + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
					+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			// ~*~ Insert SORT with Arrays ON ASCENDING
			asc100.mergeInitStats();
			asc500.mergeInitStats();
			asc1000.mergeInitStats();
			asc5000.mergeInitStats();
			
			System.out.println("Done merge Sort");
			
			asc100TotalMerge = calculateTotal(asc100);
			asc1000TotalMerge = calculateTotal(asc500);
			asc10000TotalMerge = calculateTotal(asc1000);
			asc100000TotalMerge = calculateTotal(asc5000);
			
			writer.write("Merge," + + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
					+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			// ~*~ Insert SORT with Arrays ON ASCENDING
			asc100.radixSortStats();
			asc500.radixSortStats();
			asc1000.radixSortStats();
			asc5000.radixSortStats();
			
			asc100TotalRadix = calculateTotal(asc100);
			asc1000TotalRadix = calculateTotal(asc500);
			asc10000TotalRadix = calculateTotal(asc1000);
			asc100000TotalRadix = calculateTotal(asc5000);
			
			writer.write("Radix," + + asc100.dataAssigns + "," + asc500.dataAssigns + "," 
					+ asc1000.dataAssigns + "," + asc5000.dataAssigns+"\n");
			
			System.out.println("Done Radix Sort");
			
			writer.close();
			
			File ascTotal = new File("AscTotal.txt");
			writer = new PrintWriter(ascTotal);
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble,"+asc100TotalBubble +"," +asc1000TotalBubble + "," 
					+asc10000TotalBubble +"," +asc100000TotalBubble+"\n");
			writer.write("Select,"+asc100TotalSelect +"," +asc1000TotalSelect + "," 
					+asc10000TotalSelect +"," +asc100000TotalSelect+"\n");
			writer.write("InsertArray,"+asc100TotalInsertArray +"," +asc1000TotalInsertArray + "," 
					+asc10000TotalInsertArray +"," +asc100000TotalInsertArray+"\n");
			writer.write("InsertList,"+asc100TotalInsertList +"," +asc1000TotalInsertList + "," 
					+asc10000TotalInsertList +"," +asc100000TotalInsertList+"\n");
			writer.write("Merge,"+asc100TotalMerge +"," +asc1000TotalMerge + "," 
					+asc10000TotalMerge +"," +asc100000TotalMerge+"\n");
			writer.write("Radix,"+asc100TotalRadix +"," +asc1000TotalRadix + "," 
					+asc10000TotalRadix +"," +asc100000TotalRadix+"\n");
			writer.close();
			
			System.out.println("Done Ascending data and totals.");
			
		} catch (Exception e) {
			
		}
		
		try {
			File dataDesc = new File("DescDataAssignments.txt");
			PrintWriter writer = new PrintWriter(dataDesc);
			
			// ~*~ BUBBLE SORT ON descENDING
			desc100.bubbleSortStats();
			desc500.bubbleSortStats();
			desc1000.bubbleSortStats();
			desc5000.bubbleSortStats(); 
			
			desc100TotalBubble = calculateTotal(desc100);
			desc1000TotalBubble = calculateTotal(desc500);
			desc10000TotalBubble = calculateTotal(desc1000);
			desc100000TotalBubble = calculateTotal(desc5000);
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble," + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
			+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			// ~*~ SELECT SORT ON descENDING
			desc100.selectionSortStats();
			desc500.selectionSortStats();
			desc1000.selectionSortStats();
			desc5000.selectionSortStats();
			
			desc100TotalSelect = calculateTotal(desc100);
			desc1000TotalSelect = calculateTotal(desc500);
			desc10000TotalSelect = calculateTotal(desc1000);
			desc100000TotalSelect = calculateTotal(desc5000);
			
			writer.write("Select," + + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
			+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			// ~*~ Insert SORT with Arrays ON descENDING
			desc100.insertSortArrayStats();
			desc500.insertSortArrayStats();
			desc1000.insertSortArrayStats();
			desc5000.insertSortArrayStats();
			
			desc100TotalInsertArray = calculateTotal(desc100);
			desc1000TotalInsertArray = calculateTotal(desc500);
			desc10000TotalInsertArray = calculateTotal(desc1000);
			desc100000TotalInsertArray = calculateTotal(desc5000);
			
			writer.write("InsertArray," + + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
					+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			// ~*~ Insert SORT with Arrays ON descENDING
			desc100.insertSortListStats();
			desc500.insertSortListStats();
			desc1000.insertSortListStats();
			desc5000.insertSortListStats();
			
			desc100TotalInsertList = calculateTotal(desc100);
			desc1000TotalInsertList = calculateTotal(desc500);
			desc10000TotalInsertList = calculateTotal(desc1000);
			desc100000TotalInsertList = calculateTotal(desc5000);
			
			writer.write("InsertList," + + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
					+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			// ~*~ Insert SORT with Arrays ON descENDING
			desc100.mergeInitStats();
			desc500.mergeInitStats();
			desc1000.mergeInitStats();
			desc5000.mergeInitStats();
			
			desc100TotalMerge = calculateTotal(desc100);
			desc1000TotalMerge = calculateTotal(desc500);
			desc10000TotalMerge = calculateTotal(desc1000);
			desc100000TotalMerge = calculateTotal(desc5000);
			
			writer.write("Merge," + + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
					+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			// ~*~ Insert SORT with Arrays ON descENDING
			desc100.radixSortStats();
			desc500.radixSortStats();
			desc1000.radixSortStats();
			desc5000.radixSortStats();
			
			desc100TotalRadix = calculateTotal(desc100);
			desc1000TotalRadix = calculateTotal(desc500);
			desc10000TotalRadix = calculateTotal(desc1000);
			desc100000TotalRadix = calculateTotal(desc5000);
			
			writer.write("Radix," + + desc100.dataAssigns + "," + desc500.dataAssigns + "," 
					+ desc1000.dataAssigns + "," + desc5000.dataAssigns+"\n");
			
			writer.close();
			
			File descTotal = new File("DescTotal.txt");
			writer = new PrintWriter(descTotal);
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble,"+desc100TotalBubble +"," +desc1000TotalBubble + "," 
					+desc10000TotalBubble +"," +desc100000TotalBubble+"\n");
			writer.write("Select,"+desc100TotalSelect +"," +desc1000TotalSelect + "," 
					+desc10000TotalSelect +"," +desc100000TotalSelect+"\n");
			writer.write("InsertArray,"+desc100TotalInsertArray +"," +desc1000TotalInsertArray + "," 
					+desc10000TotalInsertArray +"," +desc100000TotalInsertArray+"\n");
			writer.write("InsertList,"+desc100TotalInsertList +"," +desc1000TotalInsertList + "," 
					+desc10000TotalInsertList +"," +desc100000TotalInsertList+"\n");
			writer.write("Merge,"+desc100TotalMerge +"," +desc1000TotalMerge + "," 
					+desc10000TotalMerge +"," +desc100000TotalMerge+"\n");
			writer.write("Radix,"+desc100TotalRadix +"," +desc1000TotalRadix + "," 
					+desc10000TotalRadix +"," +desc100000TotalRadix+"\n");
			writer.close();
			
			System.out.println("Done descending data and totals.");
		} catch (Exception e) {
			
		}
		
		try {
			File dataRand = new File("RandDataAssignments.txt");
			PrintWriter writer = new PrintWriter(dataRand);
			
			// ~*~ BUBBLE SORT ON randENDING
			rand100.bubbleSortStats();
			rand500.bubbleSortStats();
			rand1000.bubbleSortStats();
			rand5000.bubbleSortStats(); 
			
			rand100TotalBubble = calculateTotal(rand100);
			rand1000TotalBubble = calculateTotal(rand500);
			rand10000TotalBubble = calculateTotal(rand1000);
			rand100000TotalBubble = calculateTotal(rand5000);
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble," + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
			+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done bubble");
			
			rand100 = new DoublyLinkedList();
			rand100.populateListRandom(100);
			rand500= new DoublyLinkedList(); 
			rand500.populateListRandom(500);
			rand1000= new DoublyLinkedList();
			rand1000.populateListRandom(1000);
			rand5000= new DoublyLinkedList(); 
			rand5000.populateListRandom(5000);
			
			// ~*~ SELECT SORT ON randENDING
			rand100.selectionSortStats();
			rand500.selectionSortStats();
			rand1000.selectionSortStats();
			rand5000.selectionSortStats();
			
			rand100TotalSelect = calculateTotal(rand100);
			rand1000TotalSelect = calculateTotal(rand500);
			rand10000TotalSelect = calculateTotal(rand1000);
			rand100000TotalSelect = calculateTotal(rand5000);
			
			writer.write("Select," + + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
			+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done select");
			
			rand100 = new DoublyLinkedList();
			rand100.populateListRandom(100);
			rand500= new DoublyLinkedList(); 
			rand500.populateListRandom(500);
			rand1000= new DoublyLinkedList();
			rand1000.populateListRandom(1000);
			rand5000= new DoublyLinkedList(); 
			rand5000.populateListRandom(5000);
			
			// ~*~ Insert SORT with Arrays ON randENDING
			rand100.insertSortArrayStats();
			rand500.insertSortArrayStats();
			rand1000.insertSortArrayStats();
			rand5000.insertSortArrayStats();
			
			rand100TotalInsertArray = calculateTotal(rand100);
			rand1000TotalInsertArray = calculateTotal(rand500);
			rand10000TotalInsertArray = calculateTotal(rand1000);
			rand100000TotalInsertArray = calculateTotal(rand5000);
			
			writer.write("InsertArray," + + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
					+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done insert array");
			
			rand100 = new DoublyLinkedList();
			rand100.populateListRandom(100);
			rand500= new DoublyLinkedList(); 
			rand500.populateListRandom(500);
			rand1000= new DoublyLinkedList();
			rand1000.populateListRandom(1000);
			rand5000= new DoublyLinkedList(); 
			rand5000.populateListRandom(5000);
			
			// ~*~ Insert SORT with Arrays ON randENDING
			rand100.insertSortListStats();
			rand500.insertSortListStats();
			rand1000.insertSortListStats();
			rand5000.insertSortListStats();
			
			rand100TotalInsertList = calculateTotal(rand100);
			rand1000TotalInsertList = calculateTotal(rand500);
			rand10000TotalInsertList = calculateTotal(rand1000);
			rand100000TotalInsertList = calculateTotal(rand5000);
			
			writer.write("InsertList," + + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
					+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done insert list");
			
			rand100 = new DoublyLinkedList();
			rand100.populateListRandom(100);
			rand500= new DoublyLinkedList(); 
			rand500.populateListRandom(500);
			rand1000= new DoublyLinkedList();
			rand1000.populateListRandom(1000);
			rand5000= new DoublyLinkedList(); 
			rand5000.populateListRandom(5000);
			
			// ~*~ Insert SORT with Arrays ON randENDING
			rand100.mergeInitStats();
			rand500.mergeInitStats();
			rand1000.mergeInitStats();
			rand5000.mergeInitStats();
			
			rand100TotalMerge = calculateTotal(rand100);
			rand1000TotalMerge = calculateTotal(rand500);
			rand10000TotalMerge = calculateTotal(rand1000);
			rand100000TotalMerge = calculateTotal(rand5000);
			
			writer.write("Merge," + + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
					+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done merge");
			
			rand100 = new DoublyLinkedList();
			rand100.populateListRandom(100);
			rand500= new DoublyLinkedList(); 
			rand500.populateListRandom(500);
			rand1000= new DoublyLinkedList();
			rand1000.populateListRandom(1000);
			rand5000= new DoublyLinkedList(); 
			rand5000.populateListRandom(5000);
			
			// ~*~ Insert SORT with Arrays ON randENDING
			rand100.radixSortStats();
			rand500.radixSortStats();
			rand1000.radixSortStats();
			rand5000.radixSortStats();
			
			rand100TotalRadix = calculateTotal(rand100);
			rand1000TotalRadix = calculateTotal(rand500);
			rand10000TotalRadix = calculateTotal(rand1000);
			rand100000TotalRadix = calculateTotal(rand5000);
			
			writer.write("Radix," + + rand100.dataAssigns + "," + rand500.dataAssigns + "," 
					+ rand1000.dataAssigns + "," + rand5000.dataAssigns+"\n");
			
			System.out.println("Done radix");
			
			writer.close();
			
			File randTotal = new File("RandTotal.txt");
			writer = new PrintWriter(randTotal);
			
			writer.write("Sort,100,500,1000,5000\n");
			writer.write("Bubble,"+rand100TotalBubble +"," +rand1000TotalBubble + "," 
					+rand10000TotalBubble +"," +rand100000TotalBubble+"\n");
			writer.write("Select,"+rand100TotalSelect +"," +rand1000TotalSelect + "," 
					+rand10000TotalSelect +"," +rand100000TotalSelect+"\n");
			writer.write("InsertArray,"+rand100TotalInsertArray +"," +rand1000TotalInsertArray + "," 
					+rand10000TotalInsertArray +"," +rand100000TotalInsertArray+"\n");
			writer.write("InsertList,"+rand100TotalInsertList +"," +rand1000TotalInsertList + "," 
					+rand10000TotalInsertList +"," +rand100000TotalInsertList+"\n");
			writer.write("Merge,"+rand100TotalMerge +"," +rand1000TotalMerge + "," 
					+rand10000TotalMerge +"," +rand100000TotalMerge+"\n");
			writer.write("Radix,"+rand100TotalRadix +"," +rand1000TotalRadix + "," 
					+rand10000TotalRadix +"," +rand100000TotalRadix+"\n");
			writer.close();
			
			System.out.println("Done random data and totals.");
		} catch (Exception e) {
			
		}
		
		// ~*~ SPEED FILES
			// ASCENDING
		try {
			File ascSpeed = new File("AscSpeed.txt");
			PrintWriter writer = new PrintWriter(ascSpeed);
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			asc100.bubbleSort(); 
			asc500.bubbleSort();
			asc1000.bubbleSort();
			asc5000.bubbleSort();
			
			writer.write("Sort,100,500,1000,5000\n");
			
			String speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			String speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			String speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			String speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("Bubble,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			asc100.selectionSort();
			asc500.selectionSort();
			asc1000.selectionSort();
			asc5000.selectionSort();
			
			speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("Select,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			asc100.insertSortArray();
			asc500.insertSortArray();
			asc1000.insertSortArray();
			asc5000.insertSortArray();
			
			speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("InsertArray,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			asc100.insertSortList();
			asc500.insertSortList();
			asc1000.insertSortList();
			asc5000.insertSortList();
			
			speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("InsertList,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			asc100.mergeInit();
			asc500.mergeInit();
			asc1000.mergeInit();
			asc5000.mergeInit();
			
			speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("Merge,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			asc100 = new DoublyLinkedList();
			asc100.populateListAsc(100);
			asc500= new DoublyLinkedList(); 
			asc500.populateListAsc(500);
			asc1000= new DoublyLinkedList();
			asc1000.populateListAsc(1000);
			asc5000= new DoublyLinkedList(); 
			asc5000.populateListAsc(5000);
			
			asc100.radixSort();
			asc500.radixSort();
			asc1000.radixSort();
			asc5000.radixSort();
			
			speed100 = String.format("%.9f", (float)asc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)asc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)asc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)asc5000.timeElapsed / 1000000000.0);
			writer.write("Radix,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			writer.close();
			
			System.out.println("Done ascending speed.");
		} catch (Exception e) {
			
		}
		
		// DESCENDING

		
		try {
			File descSpeed = new File("DescSpeed.txt");
			PrintWriter writer = new PrintWriter(descSpeed);
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.bubbleSort(); 
			desc500.bubbleSort();
			desc1000.bubbleSort();
			desc5000.bubbleSort();
			
			writer.write("Sort,100,500,1000,5000\n");
			
			String speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			String speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			String speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			String speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("Bubble,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.selectionSort();
			desc500.selectionSort();
			desc1000.selectionSort();
			desc5000.selectionSort();
			
			speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("Select,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.insertSortArray();
			desc500.insertSortArray();
			desc1000.insertSortArray();
			desc5000.insertSortArray();
			
			speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("InsertArray,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.insertSortList();
			desc500.insertSortList();
			desc1000.insertSortList();
			desc5000.insertSortList();
			
			speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("InsertList,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.mergeInit();
			desc500.mergeInit();
			desc1000.mergeInit();
			desc5000.mergeInit();
			
			speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("Merge,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			desc100 = new DoublyLinkedList();
			desc100.populateListDesc(100);
			desc500= new DoublyLinkedList(); 
			desc500.populateListDesc(500);
			desc1000= new DoublyLinkedList();
			desc1000.populateListDesc(1000);
			desc5000= new DoublyLinkedList(); 
			desc5000.populateListDesc(5000);
			
			desc100.radixSort();
			desc500.radixSort();
			desc1000.radixSort();
			desc5000.radixSort();
			
			speed100 = String.format("%.9f", (float)desc100.timeElapsed / 1000000000.0);
			speed500= String.format("%.9f", (float)desc500.timeElapsed / 1000000000.0);
			speed1000= String.format("%.9f", (float)desc1000.timeElapsed / 1000000000.0);
			speed5000= String.format("%.9f", (float)desc5000.timeElapsed / 1000000000.0);
			writer.write("Radix,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
			
			writer.close();
			
			System.out.println("Done descending speed.");
		} catch (Exception e) {
			
		}
			

		// RANDOM
		try {
		File randSpeed = new File("RandSpeed.txt");
		PrintWriter writer = new PrintWriter(randSpeed);
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.bubbleSort(); 
		rand500.bubbleSort();
		rand1000.bubbleSort();
		rand5000.bubbleSort();
		
		writer.write("Sort,100,500,1000,5000\n");
		
		String speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		String speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		String speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		String speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("Bubble,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.selectionSort();
		rand500.selectionSort();
		rand1000.selectionSort();
		rand5000.selectionSort();
		
		speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("Select,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.insertSortArray();
		rand500.insertSortArray();
		rand1000.insertSortArray();
		rand5000.insertSortArray();
		
		speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("InsertArray,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.insertSortList();
		rand500.insertSortList();
		rand1000.insertSortList();
		rand5000.insertSortList();
		
		speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("InsertList,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.mergeInit();
		rand500.mergeInit();
		rand1000.mergeInit();
		rand5000.mergeInit();
		
		speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("Merge,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		rand100 = new DoublyLinkedList();
		rand100.populateListRandom(100);
		rand500= new DoublyLinkedList(); 
		rand500.populateListRandom(500);
		rand1000= new DoublyLinkedList();
		rand1000.populateListRandom(1000);
		rand5000= new DoublyLinkedList(); 
		rand5000.populateListRandom(5000);
		
		rand100.radixSort();
		rand500.radixSort();
		rand1000.radixSort();
		rand5000.radixSort();
		
		speed100 = String.format("%.9f", (float)rand100.timeElapsed / 1000000000.0);
		speed500= String.format("%.9f", (float)rand500.timeElapsed / 1000000000.0);
		speed1000= String.format("%.9f", (float)rand1000.timeElapsed / 1000000000.0);
		speed5000= String.format("%.9f", (float)rand5000.timeElapsed / 1000000000.0);
		writer.write("Radix,"+speed100+","+speed500+","+speed1000+","+speed5000+"\n");
		
		writer.close();
		
		System.out.println("Done random speed.");
	} catch (Exception e) {
		
	}
	
	}
	
	public static long calculateTotal(DoublyLinkedList the_list) {
		return the_list.dataAssigns + the_list.dataCompares + the_list.loopAssigns 
				+ the_list.loopCompares + the_list.otherOps;
	}
	
}

