# Multi Threading
### What is Thread?
-

- We can create thread by extending the thread class and the other method is by implementing runnable interface.
- **Implementing runnable interface is better to use instead of extending thread class** because runnable is a funtional interface, so only run method will be extended but when it comes to thread class there are many methods when extended it comes with big bag of all methods.
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
  1. Process syn

### Locks:
- The Lock interface provides more flexibility than the synchronized keyword. It allows explicit locking and unlocking.
- Synchronization is actually built arround the lock.
- Every object has a lock associated with it.
#### Mutual Execution lock.
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
