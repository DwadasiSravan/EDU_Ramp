# Multi Threading
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
     

