
import java.math.BigInteger;
/**
 * Doubly Linked List with 5 sorting methods, each method has two versions: 
 * one version for a speed run and one version to measure statistics such as 
 * the number of loop assignments and data assignments.
 * @author Erica
 * @version 11/24/2013
 */
public class DoublyLinkedList {
	
	/**
	 * Node for Doubly Linked List
	 */
	private class Node {
		BigInteger value; 
		Node next;
		Node prev;
		
		/**
		 * Creates the dummy head node. Takes no parameters.
		 */
		public Node() {
			this.value = null; 
			this.next = null; 
			this.prev = null;
		}
		
		/** 
		 * Creates a node with a big integer value.
		 * @param the_value The big integer value to use with the node. 
		 */
		public Node(final BigInteger the_value) {
			next = null; 
			prev = null;
	
			value = the_value;
		}
		
		@Override
		public boolean equals(Object other) {
			boolean equal = false;
			if (other instanceof Node) {
				Node node = (Node)other;
				
				if (this.value.compareTo(node.value) == 0 && this.next.equals(node.next) && this.prev.equals(node.prev)) {
					equal = true;
				}
			}
			return equal;
		}
		
		@Override
		public String toString() {
			return this.value.toString();
		}
		
	} // end Node class
	
	Node dummyHead;
	long dataCompares = 0, loopCompares = 0, dataAssigns = 0, loopAssigns = 0, 
			otherOps = 0, totalOps = 0;
	int size; 
	long timeElapsed = 0;
	BigInteger[] mergeSortNums, mergeSortHelp;
	
	/**
	 * Constructor for DoublyLinkedList
	 */
	public DoublyLinkedList() {
		dummyHead = new Node();
	}
	
	/**
	 * Populates the list with a specified number of random Big Integers.
	 * @param number The number of elements to create.
	 */
	public void populateListRandom(final int number) {
		for (int i = 0; i < number; i++) {
			int r = (int)(Math.random() * (number));
			add(BigInteger.valueOf(r));
		}
		size = number;
	}
	
	/**
	 * Populates the list with a specified number of Big Integers in ascending order.
	 * @param number The number of elements to create.
	 */
	public void populateListAsc(final int number) {
		for (int i = 0; i < number; i++) {
			add(BigInteger.valueOf(i + 1));
		}
		size = number;
	}
	
	/**
	 * Populates the list with a specified number of Big Integers in descending order.
	 * @param number The number of elements to create.
	 */
	public void populateListDesc(final int number) {
		for (int i = number; i > 0; i--) {
			add(BigInteger.valueOf(i));
		}
		size = number;
	}
	
	/**
	 * Adds a node to the list.
	 * @param value The value to give the node.
	 */
	public void add(final BigInteger value) {
		if (dummyHead.next == null) {
			Node newNode = new Node(value); 
			newNode.next = dummyHead;
			newNode.prev = dummyHead;
			
			dummyHead.next = newNode;
			dummyHead.prev = newNode;
		} else {
			Node newNode = new Node(value); 
			newNode.next = dummyHead; 
			newNode.prev = dummyHead.prev;
			
			dummyHead.prev.next = newNode; 
			dummyHead.prev = newNode;
		}
	}
	
	public void remove(final BigInteger value) {
		Node pos = dummyHead.next;
		Node temp;
		while (pos.value != null) {
			// remove node by value, works because order doesn't matter
			if (pos.value.compareTo(value) == 0) {
				temp = pos;
				pos = pos.prev;
				
				temp.next.prev = pos;
				pos.next = temp.next;
			}
			pos = pos.next;
		}
	}
	
	/**
	 * Sorts the linked list using Bubble Sort
	 */
	public void bubbleSort() {
		long startTime = System.nanoTime();
		Node pos = dummyHead.next;
		
		boolean swapped; 
		do {
			swapped = false; 
			while (pos.next.next.value != null) {
				if (pos.value.compareTo(pos.next.value) > 0) {
					BigInteger temp = pos.next.value;
					pos.next.value = pos.value;    
  					pos.value = temp;	
					swapped = true;
				}
				pos = pos.next;
			}
			pos = dummyHead.next;
			// if a swap hasn't occured in inner loop, sorting is finished. 
		} while (swapped);
		
		timeElapsed = System.nanoTime() - startTime;
	}
	
public void bubbleSortStats() {
	// data assignment
	Node pos = dummyHead.next;
	dataAssigns++;
	
	boolean swapped; 
	do {
		// data assignment to swapped
		swapped = false; 
		dataAssigns++; 
		
		// loop compare 
		while (pos.next.next.value != null) {
			loopCompares++;
			
			// data compares 
			if (pos.value.compareTo(pos.next.value) > 0) {
				dataCompares++;
				
				// data assignment into temp
				BigInteger temp = pos.next.value;
				dataAssigns++;
				
				// 3 data assignments
				pos.next.value = pos.value;    
				pos.value = temp;	
				swapped = true;
				dataAssigns+=3;
			}
			// other operation
			pos = pos.next;
			otherOps++;
		}
		pos = dummyHead.next;
		otherOps++;
		
		// if a swap hasn't occured in inner loop, sorting is finished. 
		loopCompares++;
	} while (swapped);
}
	
	public DoublyLinkedList selectionSort() {
		long startTime = System.nanoTime();
		DoublyLinkedList sortedList = null; 
		Node pos = dummyHead.next;
		BigInteger min = pos.value;
		boolean minChanged = false; 
		
		do {
			minChanged = false;
			while (pos.value != null) {
				// if min > value, value is new min.
				if (pos.next.value != null && min.compareTo(pos.next.value) > 0) {
					min = pos.next.value; 
					minChanged = true;
				} else {
					min = pos.value;
					minChanged = true;
				}
				pos = pos.next;
			}
			if (minChanged) {
				if (sortedList == null) {
					sortedList = new DoublyLinkedList(); 
				}
				sortedList.add(min);
				remove(min);
			} 
			pos = pos.next; 
			min = pos.value;
			
			// if the min never changed, the list is sorted
		} while (minChanged);
		if (sortedList == null) {
			sortedList = this;
		} 

		timeElapsed = System.nanoTime() - startTime;
		
		return sortedList;
		
	}
	
	public DoublyLinkedList selectionSortStats() {
		// other assignment
		DoublyLinkedList sortedList = null; 
		otherOps++;
		
		// data assignment into pos, min, and minChanged
		Node pos = dummyHead.next;
		BigInteger min = pos.value;
		boolean minChanged = false; 
		dataAssigns+=3;
		
		do {
			// data assignment into minChanged
			minChanged = false;
			dataAssigns++;
			
			// loop comparison
			while (pos.value != null) {
				loopCompares++;
				// if min > value, value is new min.
					// 2 data compares on pos.next.value
				if (pos.next.value != null && min.compareTo(pos.next.value) > 0) {
					dataCompares+=2;
					
					// data assignment to min and minChanged
					min = pos.next.value; 
					minChanged = true;
					dataAssigns+=2;
					
				} else {
					// data assignments to min and minChanged
					min = pos.value;
					minChanged = true;
					dataAssigns+=2;
				}
				// other
				pos = pos.next;
				otherOps++;
			}
			// data compare on minChanged
			if (minChanged) {
				dataCompares++; 
				
				// data compare on sortedList
				if (sortedList == null) {
					dataCompares++;
					sortedList = new DoublyLinkedList(); 
					dataAssigns++;
				}
				// other x2
				sortedList.add(min);
				remove(min);
				otherOps+=2;
			} 
			// other and data assignment
			pos = pos.next; 
			otherOps++;
			min = pos.value;
			dataAssigns++;
			
			// if the min never changed, the list is sorted
			// loop compare
			loopCompares++;
		} while (minChanged);
		// data compare on sortedList
		if (sortedList == null) {
			dataCompares++;
			sortedList = this;
			dataAssigns++;
		} 

		return sortedList;
	}
	
	public void insertSortArrayStats() {
		Node pos, temp;
		BigInteger temp_value;
		boolean inserted;
		
		do {
			inserted = false;
			
			// loop assign, loop compare and data compare
			for (pos = dummyHead.next; pos.value != null; pos = pos.next) {
				loopAssigns++;
				loopCompares++; 
				dataCompares++;
				
				// two data compares
				if (pos.next.value != null && pos.value.compareTo(pos.next.value) > 0) {
					dataCompares+=2;
					
					// data assigns
					temp_value = pos.next.value; 
					temp = pos.next;
					dataAssigns+=2;
					
					// loop compare and 2 data assigns
					while (temp.prev.value != null) {
						loopCompares++;
						temp.value = temp.prev.value;
						temp = temp.prev;
						dataAssigns+=2;
					}
					
					temp.value = temp_value;
					inserted = true;
					dataAssigns+=2;
				}
			}
			// loop compare
			loopCompares++; 
		} while (inserted); 
		
	}
	
	public void insertSortArray() {
		long startTime = System.nanoTime();
		Node pos, temp;
		BigInteger temp_value;
		boolean inserted;
		
		do {
			inserted = false;
			
			for (pos = dummyHead.next; pos.value != null; pos = pos.next) {
				if (pos.next.value != null && pos.value.compareTo(pos.next.value) > 0) {
					temp_value = pos.next.value; 
					temp = pos.next;
					
					while (temp.prev.value != null) {
						temp.value = temp.prev.value;
						temp = temp.prev;
					}
					
					temp.value = temp_value;
					inserted = true;
				}
			}
		} while (inserted); 

		timeElapsed = System.nanoTime() - startTime;
	}
	
	public void insertSortList() {
		long startTime = System.nanoTime();
		Node pos, temp, inner;
		boolean inserted; 
		
		do {
			inserted = false; 
			for (pos = dummyHead.next; pos.value != null & !inserted; pos = pos.next) {
				if (pos.next.value != null && pos.value.compareTo(pos.next.value) > 0) {
					temp = pos.next; 
					
					pos.next = temp.next; 
					temp.next.prev = pos;
					
					for (inner = dummyHead.next; inner.next.value != null && !inserted; inner = inner.next) {
						if (temp.value.compareTo(inner.value) <= 0) {
							temp.next = inner;
							temp.prev = inner.prev; 
							inner.prev.next = temp; 
							inner.prev = temp;
							
							inserted = true;
						}
					}
				}
			}
		} while (inserted);
		timeElapsed = System.nanoTime() - startTime;
	}
	
	public void insertSortListStats() {
		Node pos, temp, inner;
		boolean inserted; 
		
		do {
			// data assign
			inserted = false; 
			dataAssigns++; 
			
			// loop assign, loop compare, and data compare
			for (pos = dummyHead.next; pos.value != null & !inserted; pos = pos.next) {
				loopAssigns++;
				loopCompares++;
				dataCompares++;
				
				// two data compares
				if (pos.next.value != null && pos.value.compareTo(pos.next.value) > 0) {
					dataCompares+=2;
					
					// data assign
					temp = pos.next; 
					dataAssigns++;
					
					pos.next = temp.next; 
					temp.next.prev = pos;
					dataAssigns+=2;
					
					for (inner = dummyHead.next; inner.next.value != null && !inserted; inner = inner.next) {
						loopAssigns++;
						loopCompares++;
						dataCompares++;
						
						// data compare
						if (temp.value.compareTo(inner.value) <= 0) {
							dataCompares++;
							temp.next = inner;
							temp.prev = inner.prev; 
							inner.prev.next = temp; 
							inner.prev = temp;
							dataAssigns+=4;
							
							inserted = true;
							dataAssigns++;
						}
					}
				}
			}
			// loop compares in while 
			loopCompares++;
		} while (inserted);
	}
	
	public DoublyLinkedList radixSort() {
		long startTime = System.nanoTime();
		
		DoublyLinkedList[] bucket1 = new DoublyLinkedList[10]; 
		DoublyLinkedList[] bucket2 = new DoublyLinkedList[10];
		
		bucket1[0] = this;
		bucket2[0] = new DoublyLinkedList();
		
		// initialize buckets
		for (int i = 1; i < 10; i++) {
			bucket1[i] = new DoublyLinkedList(); 
			bucket2[i] = new DoublyLinkedList();
		}
		
		int itrs = (int)(Math.log10(size) + 2);
		Node pos;
		
		// loop to control % 10^i / 10^(i-1)
		for (int i = 1; i <= itrs; i++) {
			if (i % 2 == 1) { // use bucket1 -> bucket2
				// loop to go through the 10 buckets 0-9
				for (int index = 0; index < 10; index++) {
					if (bucket1[index].dummyHead.next != null) {
						pos = bucket1[index].dummyHead.next;
						
						while(pos.value != null) {
							int radix = (int)((pos.value.intValue() % Math.pow(10, i)) 
									/ Math.pow(10, (i-1)));
							bucket2[radix].add(pos.value);
							BigInteger value = pos.value; 
							pos = pos.next; 
							bucket1[index].remove(value);
						} // end while
					} // end if 
				} // end for
			} else { // use bucket2 -> bucket1
				for (int index = 0; index < 10; index++) {
					if (bucket2[index].dummyHead.next != null) {
						pos = bucket2[index].dummyHead.next;
						
						while(pos.value != null) {
							int radix = (int)((pos.value.intValue() % Math.pow(10, i)) 
									/ Math.pow(10, (i-1)));
							bucket1[radix].add(pos.value);
							BigInteger value = pos.value; 
							pos = pos.next; 
							bucket2[index].remove(value);
						} // end while
					}// end if
				}// end for
			} // end else if
		} // end for 
		DoublyLinkedList sorted;
		if (itrs %2 == 1) {
			sorted = bucket2[0];
		} else {
			sorted = bucket1[0];
		}
		
		timeElapsed = System.nanoTime() - startTime;
		return sorted;
	}

	public DoublyLinkedList radixSortStats() {
		// initialization on buckets
		DoublyLinkedList[] bucket1 = new DoublyLinkedList[10]; 
		DoublyLinkedList[] bucket2 = new DoublyLinkedList[10];
		otherOps+=2;
		
		// data assign and initialization
		bucket1[0] = this;
		dataAssigns++;
		bucket2[0] = new DoublyLinkedList();
		otherOps++;
		
		// initialize buckets
		for (int i = 1; i < 10; i++) {
			loopAssigns++;
			loopCompares++;
			dataCompares++;
			
			bucket1[i] = new DoublyLinkedList(); 
			bucket2[i] = new DoublyLinkedList();
			otherOps+=2;
		}
		// data assigns to itrs
		int itrs = (int)(Math.log10(size) + 2);
		dataAssigns++;
		Node pos;
		
		// loop to control % 10^i / 10^(i-1)
		for (int i = 1; i <= itrs; i++) {
			loopAssigns++;
			loopCompares++;
			dataCompares++;
			
			// data compare  in if
			if (i % 2 == 1) { // use bucket1 -> bucket2
				dataCompares++;
				// loop to go through the 10 buckets 0-9
				for (int index = 0; index < 10; index++) {
					loopAssigns++;
					loopCompares++;
					dataCompares++;
					
					// data compare in if
					if (bucket1[index].dummyHead.next != null) {
						dataCompares++;
						
						// data assignment to pos
						pos = bucket1[index].dummyHead.next;
						dataAssigns++;
						
						// loop compare in while
						while(pos.value != null) {
							loopCompares++;
							
							// data assignment to radix
							int radix = (int)((pos.value.intValue() % Math.pow(10, i)) 
									/ Math.pow(10, (i-1)));
							dataAssigns++;
							bucket2[radix].add(pos.value);
							otherOps++;
							BigInteger value = pos.value; 
							pos = pos.next; 
							dataAssigns+=2;
							bucket1[index].remove(value);
							otherOps++;
						} // end while
					} // end if 
				} // end for
			} else { // use bucket2 -> bucket1
				for (int index = 0; index < 10; index++) {
					loopAssigns++;
					loopCompares++;
					dataCompares++;
					
					// data compare in if
					if (bucket2[index].dummyHead.next != null) {
						dataCompares++;
						pos = bucket2[index].dummyHead.next;
						dataAssigns++;
						
						// data compare
						while(pos.value != null) {
							dataCompares++;
							
							int radix = (int)((pos.value.intValue() % Math.pow(10, i)) 
									/ Math.pow(10, (i-1)));
							dataAssigns++;
							bucket1[radix].add(pos.value);
							otherOps++;
							BigInteger value = pos.value; 
							pos = pos.next; 
							dataAssigns+=2;
							bucket2[index].remove(value);
							otherOps++;
						} // end while
					}// end if
				}// end for
			} // end else if
		} // end for 
		DoublyLinkedList sorted;
		
		// data compare in if 
		if (itrs %2 == 1) {
			dataCompares++;
			sorted = bucket2[0];
			dataAssigns++;
		} else {
			sorted = bucket1[0];
			dataAssigns++;
		}
		return sorted;
	}
	
	public DoublyLinkedList mergeInit() {
		long startTime = System.nanoTime();
		mergeSortNums = new BigInteger[size];
		mergeSortHelp = new BigInteger[size];
		Node pos = dummyHead.next; 
		int counter = 0;
		
		while (pos.value != null) {
			mergeSortNums[counter] = pos.value;
			
			pos = pos.next;
			counter++;
		}
		
		mergeSort(0, mergeSortNums.length - 1);
		
		DoublyLinkedList sorted = new DoublyLinkedList();
		for (int i = 0; i < mergeSortNums.length; i++) {
			sorted.add(mergeSortNums[i]);
		}
		timeElapsed = System.nanoTime() - startTime;
		return sorted;
	}
	
	private void mergeSort(int low, int high) {
		int mid;
		if (low >= high) {
			return; 
		} else {
			mid = low + (high - low) / 2; 
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			
			merge(low, mid, high);
		}
	}
	
	private void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			mergeSortHelp[i] = mergeSortNums[i];
		}
		int i = low; 
		int j = mid + 1; 
		int k = low; 
		
		while (i <= mid && j <= high) {
			if (mergeSortHelp[i].compareTo(mergeSortHelp[j]) <= 0) {
				mergeSortNums[k] = mergeSortHelp[i];
				i++;
			} else {
				mergeSortNums[k] = mergeSortHelp[j];
				j++;
			}
			k++;
		}
			
		while (i <= mid) {
			mergeSortNums[k] = mergeSortHelp[i];
			i++;
			k++;
		}
		
		
	}
	
	public DoublyLinkedList mergeInitStats() {
		long startTime = System.nanoTime();
		// initiaization x2
		mergeSortNums = new BigInteger[size];
		mergeSortHelp = new BigInteger[size];
		otherOps+=2;
		
		Node pos = dummyHead.next; 
		int counter = 0;
		dataAssigns+=2;
		
		// loop compare on while
		while (pos.value != null) {
			loopCompares++;
			mergeSortNums[counter] = pos.value;
			dataAssigns++;
			
			// data assigns on pos and counter;
			pos = pos.next;
			counter++;
			dataAssigns+=2;
		}
		
		mergeSort(0, mergeSortNums.length - 1);
		otherOps++;
		
		DoublyLinkedList sorted = new DoublyLinkedList();
		otherOps++;
		
		for (int i = 0; i < mergeSortNums.length; i++) {
			loopAssigns++;
			loopCompares++;
			dataCompares++;
			
			sorted.add(mergeSortNums[i]);
			otherOps++;
		}
		
		timeElapsed = System.nanoTime() - startTime;
		return sorted;
	}
	
	private void mergeSortStats(int low, int high) {
		int mid;
		
		// data compare in if
		if (low >= high) {
			dataCompares++;
			return; 
		} else {
			mid = low + (high - low) / 2; 
			dataAssigns++;
			mergeSortStats(low, mid);
			mergeSortStats(mid + 1, high);
			
			mergeStats(low, mid, high);
			
			otherOps+=3; // for 3 function calls
		}
	}
	
	private void mergeStats(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			loopAssigns++;
			loopCompares++;
			dataCompares++;
			
			mergeSortHelp[i] = mergeSortNums[i];
			dataAssigns++;
		}
		int i = low; 
		int j = mid + 1; 
		int k = low; 
		dataAssigns+=3;
		
		// loop compares x 2
		while (i <= mid && j <= high) {
			loopCompares+=2;
			
			// data compare and assign

			dataCompares++;
			if (mergeSortHelp[i].compareTo(mergeSortHelp[j]) <= 0) {
				mergeSortNums[k] = mergeSortHelp[i];
				dataAssigns++;
				i++;
				dataAssigns++;
			} else {
				dataAssigns++;
				mergeSortNums[k] = mergeSortHelp[j];
				j++;
				dataAssigns++;
			}
			k++;
			dataAssigns++;
		}
		// loop compares
		while (i <= mid) {
			loopCompares++;
			mergeSortNums[k] = mergeSortHelp[i];
			i++;
			k++;
			dataAssigns+=3;
		}
	}
	
	public void printList() {
		Node pos = dummyHead.next;
		while (pos.value != null) {
			System.out.println(pos.value.intValue());
			pos = pos.next;
		}
	}
	
	@Override
	public String toString() {
		return this.dummyHead.value.toString();
	}
}