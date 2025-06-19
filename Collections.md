# Collections

In Java, Collections are frameworks that provide architecture to store and manipulate groups of objects. The main interfaces in the Java Collections Framework are:
  - Collection: The root interface for most collection classes.
    - List: Ordered collection (e.g., ArrayList, LinkedList)
    - Set: No duplicate elements (e.g., HashSet, TreeSet)
    - Queue: Elements processed in a specific order (e.g., PriorityQueue, LinkedList)
  - Map: Key-value pairs (e.g., HashMap, TreeMap)<br />
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
