# Objects
- In Java, objects are instances of classes that encapsulate data (fields) and behavior (methods).
- Objects are the building blocks of object-oriented programming (OOP) in Java. They allow you to model real-world entities and their interactions.
- We can say Object as physical reality.
---
## Types of Objects in Java
Objects in Java can be categorized based on their characteristics and usage:

### 1. Based on Creation
#### User-Defined Objects:
These are objects created from user-defined classes. <br />
**For example:**
```java
class Car {
    String brand;
    int speed;
}

Car myCar = new Car(); // User-defined object
```
#### Predefined Objects:
These are objects provided by Java's standard library, such as String, Scanner, ArrayList, etc.
```java
String message = "Hello, World!"; // Predefined object
```
---
### 2. Based on Mutability
#### Mutable Objects:
Objects whose state (fields) can be changed after creation. <br />
**Example:** ArrayList.
```java
ArrayList<String> list = new ArrayList<>();
list.add("Java"); // State of the object changes
```
#### Immutable Objects: 
Objects whose state cannot be changed after creation. <br />
**Example:** String.
```java
String str = "Hello";
str = str.concat(" World"); // Creates a new object, original remains unchanged
```
---
### 3. Based on Persistence
#### Transient Objects: 
Objects that exist temporarily during program execution and are not saved to storage.
#### Persistent Objects:
Objects that are stored in a database or file system and can be retrieved later.

---
### 4. Based on Context
#### Local Objects: 
Objects created within a method and accessible only within that method.
```java
void display() {
    Car localCar = new Car(); // Local object
}
```
---
#### Global Objects:
Objects created as class-level fields and accessible throughout the class.
```java
class Example {
    Car globalCar = new Car(); // Global object
}
```
---
### 5. Based on Usage
#### Data Objects:
Objects that primarily store data, such as POJOs (Plain Old Java Objects).
#### Service Objects: 
Objects that provide specific functionality or services, such as utility classes.

---
**Objects in Java are versatile and can be tailored to suit various programming needs, making them a cornerstone of Java's OOP paradigm.**
