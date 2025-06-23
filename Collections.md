# Collections

In Java, Collections are frameworks that provide architecture to store and manipulate groups of objects. The main interfaces in the Java Collections Framework are:
  - **Collection:** The root interface for most collection classes.
    - **List:** Ordered collection (e.g., ArrayList, LinkedList)
    - **Set:** No duplicate elements (e.g., HashSet, TreeSet)
    - **Queue:** Elements processed in a specific order (e.g., PriorityQueue, LinkedList)
  - **Map:** Key-value pairs (e.g., HashMap, TreeMap)<br />
  - **Example:** *Using ArrayList*
    ```
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

**Main Implementations of List** <br />
### 1. ArrayList:
 - Backed by a dynamic array.
 - Fast random access (get/set).
 - Slower insertions/removals (except at the end).
 - Thread Safety: Not thread-safe (multiple threads modifying it simultaneously can cause issues)
 - Threading Info: If you need to use it in a multi-threaded environment, wrap it with Collections.synchronizedList() or use CopyOnWriteArrayList (from java.util.concurrent).

**Array List General Implementation Example:** <br />
```
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
**ArrayList Thread Unsafe Implementation Example:** <br />
```
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
**ArrayList Thread Safe Implementation Example:** <br />
```
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
### How to choose between Array and ArrayList : 
#### Array: 
- An array in Java is a fixed-size, ordered collection of elements of the same data type. Each element is accessed by its index, starting from 0.<br />
- **Key Points:**
    - Arrays can store primitives (like int, char) or objects (like String).
    - The size of an array is set when it is created and cannot be changed.<br />
- **Syntax for declaration and initialization:**
```
int[] numbers = new int[5]; // Array of 5 integers
numbers[0] = 10;            // Assign value to first element

String[] names = {"Alice", "Bob", "Charlie"}; // Array with 3 strings
```
- So, when we know the length then we use **Array** but when we want that dynamic nature then we use **Array List**.
- But, when there is a chance try to use array because array uses primitive data types but Array list uses Wrapper classes. When comes to Wrapper classes they use a system called padding which is when we talk about **INT** it's size is 4bytes and when padded 4 types the memory held by wrapper class will be 16bytes. So it is a mammoth kind of memory occupancy when compare to any primitive.
- The initial **capacity of an Array List is 10**. Then when needed it tops up by 50% of the previous capacity.
- Capacity is different form the memory because if we talk about capacity memory occupancy. 
- **ArrayList Overhead + (primitive size * 4) + (size * 16)**. So this is a huge number.

#### Methods in ArrayList:
- .add(element)
- .put(index, element)
- .add(index, element)
- when we use **.add(index, element)** when we use some index like 20 in it, and we try to add element there it throws Index out of bound exception.
- Because, even though it has capacity of 10 it won't initialise or block the memory block to it when initialised but does it only when we add something to it. So, till we add something till 19th index we cannot add something at 20th index.
- But when we can add at any index under the specified length because, when we initialise an array of some size it allocated and blocks the memory in the space so in that memory we can add at any index.
- When we come to **.put()** we feel it is actually replacing the element at that particular index but what happens in the background is a new object will be created and then the reference pointer of that index will be now pointing to the new object in the heap and the previous object will be cleared if unused by Garbage collector.

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
### 3. Queue:

### 4. Set:
