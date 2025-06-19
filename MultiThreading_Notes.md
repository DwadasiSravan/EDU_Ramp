# Multi Threading
- Multithreading is a programming technique where multiple threads run concurrently within a single process. Each thread represents a separate path of execution, allowing tasks to be performed in parallel or asynchronously.

 #### Key points:
 - Improves application performance by utilizing CPU resources efficiently.
 - Enables simultaneous execution of two or more parts of a program.
 - Threads share the same memory space, making communication easier but requiring synchronization.
   
### What is Thread?
- A Thread in Java is a lightweight process and the smallest unit of execution. It represents an independent path of execution within a program, allowing multiple operations to run concurrently. Each thread runs in parallel (or appears to, depending on CPU cores) and shares the process’s memory space with other threads.
  
 #### Key points:
 - Created by extending the **Thread class** or **implementing the Runnable interface**.
 - Supports multitasking and parallelism.
 - Shares resources with other threads in the same process.
 - Managed by the Java Virtual Machine (JVM).
 - **Implementing runnable interface is better to use instead of extending thread class** because runnable is a funtional interface, so only run method will be extended but     when it comes to thread class there are many methods when extended it comes with big bag of all methods.
   
  ```
  class MyThread extends Thread {
     public void run() {
         System.out.println("Thread is running");
     }
  } 

  public class Main {
      public static void main(String[] args) {
          MyThread t = new MyThread();
          t.start(); // Starts the thread
      }
  }
  ```

### Synchronisation:
- When multiple threads are accessing same object then it helps to allow only one thread accessing it at one time.
- The `synchronized keyword` can be used to lock a method or block of code, ensuring that only one thread can execute it at a time.
- Synchronized Method:
 
  ```
  public synchronized void synchronizedMethod() {
    // Critical section
    System.out.println("Thread-safe method execution");
  }

  ```
  ### Two types of Synchroniztion:
  #### 1. Process Synchronization:
  - Coordination between multiple processes (outside Java, at OS level).
  #### 2. Thread Synchronization:
  - Coordination between multiple threads within the same process. In Java, this is most common and includes:
  - Mutual Exclusive Synchronization
     - Synchronized Method:
        Only one thread can execute a synchronized method of an object at a time.
     - Synchronized Block:
        Only one thread can execute a synchronized block of code on a given object at a time.
     - Static Synchronization:
        Synchronized static methods lock on the class object, not the instance.
  - Inter-thread Communication:
    - Uses methods like wait(), notify(), and notifyAll() to coordinate thread actions.
    
### Locks:
- The Lock interface provides more flexibility than the synchronized keyword. It allows explicit locking and unlocking.
- Synchronization is actually built arround the lock.
- Every object has a lock associated with it.
 #### 1. Mutual Execution lock:
  - A mutual exclusion lock (often called a mutex) is a synchronization mechanism used to ensure that only one thread at a time can access a shared resource or critical section of code. This prevents race conditions and ensures data consistency in concurrent programming.<br>
  **Key points:**
    - Only one thread can hold the lock at any given time.
    - Other threads attempting to acquire the lock are blocked until it is released.
    - In Java, mutual exclusion can be achieved using the synchronized keyword or explicit Lock objects from java.util.concurrent.locks.
  ##### Example using synchronized:
  ```
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
}
  ```


#### Dead Lock
#### Try Lock
#### Re-Entrent Lock
1. Lock
2. UnLock

#### Time out in lock.

### Semaphore:
- A semaphore is a synchronization primitive used in programming to control access to a shared resource by multiple threads or processes. It acts as a counter that tracks how many units of a resource are available.

  #### Purpose:
  - Prevents race conditions by limiting the number of threads that can access a resource at the same time.
- Manages resource allocation in concurrent programming.
#### Real-time use case:
Suppose you have a database connection pool with 5 connections. You can use a semaphore initialized to 5. Each thread must acquire the semaphore before using a connection and release it after use. This ensures that no more than 5 threads use the database at once.

#### Methods: 
1. **.acquire() :**  TO get the permission we can say that means if we want the thread to work and the permits will be **decreased by 1**.
2. **.release() :** After aquiring the permits and completing the Threads execution, we will use it so that the permits count get **increased by 1**.

#### Syntax:
```
Semaphore sema = new Semaphore(3);
```
- We will create an object for the Semaphore class and then use it's methods. We need to sepcify the number of permits we need to limit.

#### There are two tyoes of Semaphore:
1. **Counting Semaphore :**
- Multiple threads can acquire permits up to the limit.
- *Example:* `Semaphore sem = new Semaphore(5);`

2. **Binary Semaphore :**
- Special case of counting semaphore with only one permit (value 1).
- Functions like a mutex (mutual exclusion lock).
- *Example:* `Semaphore sem = new Semaphore(1);`

### Thread Pool :
- A thread pool is a collection of pre-instantiated, reusable threads managed by a framework or library to perform tasks efficiently.
- Instead of creating and destroying threads for every task, a thread pool maintains a pool of worker threads that are reused for multiple tasks, improving performance and resource management.


