# Collections

In Java, Collections are frameworks that provide architecture to store and manipulate groups of objects. The main interfaces in the Java Collections Framework are:
  - **Collection:** The root interface for most collection classes.
    - **List:** Ordered collection (e.g., ArrayList, LinkedList)
    - **Set:** No duplicate elements (e.g., HashSet, TreeSet)
    - **Queue:** Elements processed in a specific order (e.g., PriorityQueue, LinkedList)
  - **Map:** Key-value pairs (e.g., HashMap, TreeMap)<br />
  - **Example:** *Using ArrayList*
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
- **Key Points:**
  - Collections are in java.util package.
  - They support operations like add, remove, iterate, and search.
  - Use generics for type safety (e.g., List<String>).

## List: 
- In Java, the List interface is a part of the Collections Framework and represents an ordered collection (also known as a sequence). Lists can contain duplicate elements and allow positional access and insertion of elements.
---
**Main Implementations of List** <br />
### 1. ArrayList:
 - Backed by a dynamic array.
 - Fast random access (get/set).
 - Slower insertions/removals (except at the end).
 - Thread Safety: Not thread-safe (multiple threads modifying it simultaneously can cause issues)
 - Threading Info: If you need to use it in a multi-threaded environment, wrap it with Collections.synchronizedList() or use CopyOnWriteArrayList (from java.util.concurrent).
---
**Array List General Implementation Example:** <br />
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
**ArrayList Thread Unsafe Implementation Example:** <br />
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
**ArrayList Thread Safe Implementation Example:** <br />
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
- **Key Points:**
    - Arrays can store primitives (like int, char) or objects (like String).
    - The size of an array is set when it is created and cannot be changed.<br />
- **Syntax for declaration and initialization:**
```java
int[] numbers = new int[5]; // Array of 5 integers
numbers[0] = 10;            // Assign value to first element

String[] names = {"Alice", "Bob", "Charlie"}; // Array with 3 strings
```
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

- **Key Points:** <br />
    - Non-contiguous storage: Nodes can be scattered in memory.
    - Dynamic size: Can grow or shrink easily by adding/removing nodes.
    - Efficient insertions/deletions: Especially at the beginning or middle (no shifting needed).
    - Slower random access: Accessing an element by index requires traversing from the head node.
- **Types:** <br />
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
