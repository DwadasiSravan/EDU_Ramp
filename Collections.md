# Collections

In Java, Collections are frameworks that provide architecture to store and manipulate groups of objects. The main interfaces in the Java Collections Framework are:
  * Collection: The root interface for most collection classes.
  * List: Ordered collection (e.g., ArrayList, LinkedList)
  * Set: No duplicate elements (e.g., HashSet, TreeSet)
  * Queue: Elements processed in a specific order (e.g., PriorityQueue, LinkedList)
  * Map: Key-value pairs (e.g., HashMap, TreeMap)<br />
  ---
  * Example: *Using ArrayList*
    ```java
    import java.util.ArrayList;
    import java.util.List;
    
    public class Example {
      public static void main(String[] args) {
          List<String> names = new ArrayList<>();
          names.add("Alice");
          names.add("Bob");
          System.out.println(names); // Output: [Alice, Bob]
      }
    }
    ```
---
- **Key Points:**
  - Collections are in java.util package.
  - They support operations like add, remove, iterate, and search.
  - Use generics for type safety (e.g., List<String>).

## List: 
- In Java, the List interface is a part of the Collections Framework and represents an ordered collection (also known as a sequence). Lists can contain duplicate elements and allow positional access and insertion of elements.
---
* Main Implementations of List <br />
### 1. ArrayList:
 - Backed by a dynamic array.
 - Fast random access (get/set).
 - Slower insertions/removals (except at the end).
 - Thread Safety: Not thread-safe (multiple threads modifying it simultaneously can cause issues)
 - Threading Info: If you need to use it in a multi-threaded environment, wrap it with Collections.synchronizedList() or use CopyOnWriteArrayList (from java.util.concurrent).
---
* Array List General Implementation Example: <br />
```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);
    }
}
```
---
* ArrayList Thread Unsafe Implementation Example: <br />
```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListThreadUnsafe {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Size: " + list.size()); // May not be 2000!
    }
}
```
---
* ArrayList Thread Safe Implementation Example: <br />
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Size: " + list.size()); // Should be 2000
    }
}
```
---
### How to choose between Array and ArrayList : 
#### Array: 
- An array in Java is a fixed-size, ordered collection of elements of the same data type. Each element is accessed by its index, starting from 0.<br />
  * Key Points:
    - Arrays can store primitives (like int, char) or objects (like String).
    - The size of an array is set when it is created and cannot be changed.<br />
  * Syntax for declaration and initialization:
```java
int[] numbers = new int[5]; // Array of 5 integers
numbers[0] = 10;            // Assign value to first element

String[] names = {"Alice", "Bob", "Charlie"}; // Array with 3 strings
```
---
- So, when we know the length then we use **Array** but when we want that dynamic nature then we use **Array List**.
- But, when there is a chance try to use array because array uses primitive data types but Array list uses Wrapper classes. When comes to Wrapper classes they use a system called padding which is when we talk about **INT** it's size is 4bytes and when padded 4 types the memory held by wrapper class will be 16bytes. So it is a mammoth kind of memory occupancy when compare to any primitive.
- The initial **capacity of an Array List is 10**. Then when needed it tops up by 50% of the previous capacity.
- Capacity is different form the memory because if we talk about capacity memory occupancy. 
- **ArrayList Overhead + (primitive size * 4) + (size * 16)**. So this is a huge number.
---
#### Methods in ArrayList:
- .add(element)
- .put(index, element)
- .add(index, element)
- when we use **.add(index, element)** when we use some index like 20 in it, and we try to add element there it throws Index out of bound exception.
- Because, even though it has capacity of 10 it won't initialise or block the memory block to it when initialised but does it only when we add something to it. So, till we add something till 19th index we cannot add something at 20th index.
- But when we can add at any index under the specified length because, when we initialise an array of some size it allocated and blocks the memory in the space so in that memory we can add at any index.
- When we come to **.put()** we feel it is actually replacing the element at that particular index but what happens in the background is a new object will be created and then the reference pointer of that index will be now pointing to the new object in the heap and the previous object will be cleared if unused by Garbage collector.
---
### 2. Linked List:
- A Linked List is a linear data structure where elements (called nodes) are stored in separate memory locations and connected using pointers. Each node contains data and a reference (pointer) to the next node in the sequence.<br />

  * Key Points: <br />
    - Non-contiguous storage: Nodes can be scattered in memory.
    - Dynamic size: Can grow or shrink easily by adding/removing nodes.
    - Efficient insertions/deletions: Especially at the beginning or middle (no shifting needed).
    - Slower random access: Accessing an element by index requires traversing from the head node.
  * Types: <br />
    - Singly Linked List: Each node points to the next node.
    - Doubly Linked List: Each node points to both the next and previous nodes.
    - Circular Linked List: Last node points back to the first node.
---
## Queue:
In Java, the `Queue` interface (in `java.util`) has several key implementations, each suited for specific use cases. Here's a breakdown of the main types of queues, their behaviors, and typical use cases.

---

#### 1. LinkedList (implements Queue)

* Behavior: FIFO (First-In-First-Out)
* Allows null: Yes
* Use case: Simple queue implementations, order-sensitive processing

```java
Queue<String> queue = new LinkedList<>();
```

---

#### 2. PriorityQueue

* Behavior: Orders elements based on natural ordering or custom comparator.
* Not FIFO: Elements are ordered by priority, not insertion order.
* Allows null: No
* Use case: Task scheduling, job processing with priority

```java
Queue<Integer> pq = new PriorityQueue<>();
```
---
* When to use Priority Queue:
- You want to always get the highest (or lowest) priority item first.
- By default, PriorityQueue in Java is a min-heap.
- You're solving problems like:
  - Dijkstra’s algorithm (shortest path)
  - A* algorithm (pathfinding)
  - Job/task schedulers (e.g., CPU scheduling)
  - Huffman Encoding (greedy algorithms)
---
* **Example** – Min-Heap (default behavior)
  ```java
  import java.util.PriorityQueue;
  public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(10);
        pq.add(30);
        System.out.println("Priority Queue (Min Heap): " + pq);
        // Removing elements based on priority (smallest first)
        while (!pq.isEmpty()) {
            System.out.println("Polled: " + pq.poll());
        }
    }
  }
  ```
  ---
**What is Min-Heap:**
- When you frequently need to extract the smallest element efficiently. The root will always be the smallest element.<br />

**How It Works Internally:**
  * Stored as an array:
      - **Parent** at index **i**
      - **Left child** at **2*i + 1**
      - **Right child** at **2*i + 2**
  - During insert/remove, the tree is rebalanced (heapified) using **bubble up** or **bubble down**.
---
- In a heap (like a min heap or max heap), when you insert or remove an element, the heap property may get violated. To restore it, we use bubble up or bubble down operations (also called heapify up/down).
---
- **Bubble Up:** (a.k.a. Heapify Up / Sift Up)
  - Used when you insert a new element at the bottom (last position). Move the element up the tree until the heap property is restored.
  - **Pseudocode:**
    ```java
      while (child < parent) {
        swap(child, parent);
        child = parent index;
      }
    ```
    ![image](https://github.com/user-attachments/assets/e0630c08-39fa-4843-a94c-68c977cc68a1)
    
---
- **Bubble Down:** (a.k.a. Heapify Down / Sift Down)
    - Used when you remove the root (usually min in min-heap), and move the last element to root.
    - **Pseudocode:**
      ```java
       while (parent > any child) {
          swap(parent, smallest child);
          parent = child index;
        }
      ```
      ![image](https://github.com/user-attachments/assets/f5bd26e5-3fb8-4f79-81a6-8c2e1060d595)
---    
| Operation   | When It's Used        | Direction   | Purpose                        |
| ----------- | --------------------- | ----------- | ------------------------------ |
| Bubble Up   | After insertion       | Bottom → Up | Fix heap property after insert |
| Bubble Down | After deletion (root) | Top → Down  | Fix heap after replacing root  |

---
#### 3. ArrayDeque (implements Deque, also used as Queue)

* Behavior: Faster than LinkedList, supports queue and stack operations
* Allows null: No
* Use case: High-performance queue or double-ended queue

```java
Queue<String> deque = new ArrayDeque<>();
```

---

#### 4. ConcurrentLinkedQueue

* Behavior: Thread-safe, non-blocking FIFO queue
* Allows null: No
* Use case: Concurrent access in multi-threaded environments

```java
Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
```

---

#### 5. BlockingQueue (Interface, part of java.util.concurrent)

##### Implementations:

| Class                 | Behavior                                    |
| --------------------- | ------------------------------------------- |
| ArrayBlockingQueue    | Bounded, FIFO, thread-safe                  |
| LinkedBlockingQueue   | Optional capacity, FIFO, thread-safe        |
| PriorityBlockingQueue | Unbounded, priority-based                   |
| DelayQueue            | Only releases elements after delay expires  |
| SynchronousQueue      | No storage; direct hand-off between threads |

##### Example:

```java
BlockingQueue<String> queue = new LinkedBlockingQueue<>();
```

---

#### 6. Deque (Double-Ended Queue)

* Can be used as a queue (FIFO) or stack (LIFO).
* Implementations: ArrayDeque, LinkedList

```java
Deque<String> deque = new ArrayDeque<>();
```

---

#### Summary Table

| Queue Type            | Ordered | Thread-Safe | Priority-Based       | Allows null |
| --------------------- | ------- | ----------- | -------------------- | ----------- |
| LinkedList            | Yes     | No          | No                   | Yes         |
| PriorityQueue         | No      | No          | Yes                  | No          |
| ArrayDeque            | Yes     | No          | No                   | No          |
| ConcurrentLinkedQueue | Yes     | Yes         | No                   | No          |
| BlockingQueue types   | Yes     | Yes         | Some (e.g. Priority) | No          |
| Deque                 | Yes     | No          | No                   | No          |

---
## Set:
- Types in set.
- Linked Hash Set
- entry Set

## Hash Map
---
## Vector:
- A Vector is a legacy interface in Java which is a resizable array (just like ArrayList), but with one key difference: it is synchronized, meaning it is thread-safe.
- But,in single threaded environment it is slower than Arraylist due to synchronization.
#### Basic usage example:
```java
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        // Add elements
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Get and print elements
        for (String fruit : vector) {
            System.out.println(fruit);
        }

        // Remove
        vector.remove("Banana");

        System.out.println("After removal: " + vector);
    }
}
```
#### Summary:
- Use Vector only if you need thread-safety without external synchronization.
- Prefer ArrayList for most use cases (faster and lighter).
- For thread-safe lists in modern code, prefer:
```java
List<E> list = Collections.synchronizedList(new ArrayList<>());
```
#### 🔄 Growth Comparison: Vector vs ArrayList
| Feature        | Vector       | ArrayList                  |
| -------------- | ------------ | -------------------------- |
| Initial growth | Doubles size | Grows by 50%               |
| Thread-safe    | ✅ Yes        | ❌ No (unless synchronized) |

---
## Sorting in Collections:
In Collections we use .sort() method is used which internally uses **TIM SORT** where it uses Insertion sort and merge sort combined.
- **TimSort is a hybrid sorting algorithm that combines:**
  - Merge Sort (for its stability and divide-and-conquer power)
  - Insertion Sort (for fast performance on small or nearly sorted data)
#### How TimSort Works (Simplified)
- Divide array into runs (small sorted sub-arrays)
- Use Insertion Sort for each run
- Size of run = 32 to 64 (depends on implementation)
- Merge the runs using Merge Sort logic
- Use binary search and other optimizations internally
```java
Arrays.sort(Object[] array);
```
#### Example with explination:
-  **Let's consider the following array as an example: arr[] = {4, 2, 8, 6, 1, 5, 9, 3, 7}.**
- **Step 1:** Define the size of the run <br />
  - Minimum run size: 32 (we'll ignore this step since our array is small)
- **Step 2:** Divide the array into runs <br />
  - In this step, we'll use insertion sort to sort the small subsequences (runs) within the array.
  - The initial array: [4, 2, 8, 6, 1, 5, 9, 3, 7.
  - No initial runs are present, so we'll create runs using insertion sort.
  - Sorted runs: [2, 4], [6, 8], [1, 5, 9], [3, 7]
  - Updated array: [2, 4, 6, 8, 1, 5, 9, 3, 7]
- **Step 3:** Merge the runs
  - In this step, we'll merge the sorted runs using a modified merge sort algorithm.
  - Merge the runs until the entire array is sorted.
  - Merged runs: [2, 4, 6, 8], [1, 3, 5, 7, 9]
  - Updated array: [2, 4, 6, 8, 1, 3, 5, 7, 9]
- **Step 4:** Adjust the run size
  - After each merge operation, we double the size of the run until it exceeds the length of the array.
  - The run size doubles: 32, 64, 128 (we'll ignore this step since our array is small)
- **Step 5:** Continue merging
  - Repeat the merging process until the entire array is sorted.
  - Final merged run: [1, 2, 3, 4, 5, 6, 7, 8, 9] <br />
The final sorted array is **[1, 2, 3, 4, 5, 6, 7, 8, 9]**.

---
