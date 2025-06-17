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
- 
     

