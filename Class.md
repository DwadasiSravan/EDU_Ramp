# Class
In Java, a class is a blueprint for creating objects. It defines properties (fields) and behaviors (methods) that the objects created from the class will have. Classes are fundamental to Java's object-oriented programming (OOP) paradigm.
- We can say Class is a logical construct.

---
## Types of Classes in Java

### 1. Concrete Class
- A regular class that can be instantiated to create objects.
- It contains fields, methods, constructors, and can implement interfaces.

#### Example:
```java
public class Car {
    String brand;
    int speed;

    public void drive() {
        System.out.println("Driving at " + speed + " km/h");
    }
}
```
---

### 2. Abstract Class
- A class that cannot be instantiated directly. It is meant to be extended by other classes.
- It can have both abstract methods (without implementation) and concrete methods (with implementation).

#### Example:
```java
abstract class Animal {
    abstract void sound();
    void eat() {
        System.out.println("This animal eats food.");
    }
}
```
---

### 3. Final Class
- A class declared with the final keyword cannot be extended (inherited).
- It is used to prevent further modification of the class.

#### Example:
```java
public final class Constants {
    public static final double PI = 3.14159;
}
```
---

### 4. Static Nested Class
- A class defined within another class and declared as static.
- It can be accessed without creating an instance of the outer class.

#### Example:
```java
class Outer {
    static class Nested {
        void display() {
            System.out.println("Static nested class");
        }
    }
}
```
---

### 5. Inner Class (Non-Static Nested Class)
- A class defined within another class but without the static keyword.
- It is associated with an instance of the outer class.
  
#### Example:
```java
class Outer {
    class Inner {
        void display() {
            System.out.println("Inner class");
        }
    }
}
```
---

### 6. Anonymous Class
- A class without a name, typically used for implementing interfaces or extending classes on the fly.
- It is declared and instantiated in a single statement.
- 
#### Example:
```java
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };
        greeting.sayHello();
    }
}
```
---

### 7. Enum Class
- A special type of class used to define a fixed set of constants.
#### Example:
```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```
---
### 8. Singleton Class
- A class designed to have only one instance throughout the application.
#### Example:
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
---

These types of classes allow Java developers to structure their programs effectively, depending on the requirements of the application.
