# Core Java Basics
-
-
-
-
-
-
-
---
### InHeritance:
---
#### 1. Association:
   -  Association can be considered a generic term to indicate the relationship between two independent classes.
   -  The relationship may be one-to-one, one-to-many, or many-to-many, but it need not indicate ownership.
   -  **Types of Association:**<br />
     - **Unidirectional Association:** In this association if we consider a parent class and it is aware of a child class but the child doen't have ay idea regarding the parent.<br />
     - **Bidirectional Association:**  In this association both the parent and child knows about each other.
```java
  // Java Program to illustrate the Concept of Association. Importing required classes
  import java.io.*;
  import java.util.*;
  // Class 1
  // Bank class
  class Bank {
    // Attributes of bank
    private String bankName;
    private Set<Employee> employees;
    // Constructor of Bank class
    public Bank(String bankName)
    {
        this.bankName = bankName;
    }
    // Method of Bank class
    public String getBankName()
    {
        // Returning name of bank
        return this.bankName;
    }
    public void setEmployees(Set<Employee> employees)
    {
        this.employees = employees;
    }
    public Set<Employee> getEmployees()
    {
        return this.employees;
    }
  }
  // Class 2
  // Employee class
  class Employee {
    // Attributes of employee
    private String name;
    // Constructor of Employee class
    public Employee(String name)
    {
        // this keyword refers to current instance
        this.name = name;
    }
    // Method of Employee class
    public String getEmployeeName()
    {
        // returning the name of employee
        return this.name;
    }
  }
  // Class 3
  // Association between both the
  // classes in main method
  class AssociationExample {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating Employee objects
        Employee emp1 = new Employee("Ridhi");
          Employee emp2 = new Employee("Vijay");
          // adding the employees to a set
        Set<Employee> employees = new HashSet<>();
        employees.add(emp1);
          employees.add(emp2);
          // Creating a Bank object
          Bank bank = new Bank("ICICI");
          // setting the employees for the Bank object
        bank.setEmployees(employees);
          // traversing and displaying the bank employees 
          for (Employee emp : bank.getEmployees()) {
              System.out.println(emp.getEmployeeName()
                                 + " belongs to bank "
                                 + bank.getBankName());
          }
      }
  }
```
![image](https://github.com/user-attachments/assets/09ad5856-0551-41b7-953b-a2c2fa739b2e)

#### Aggregation:
- Aggregation is a type of association that represents a relationship where one class is a collection or container of another class.
- It depicts a "has-a" relationship, where the container object can exist independently of its contents, and the contained objects can exist independently of the container.
- **It is a special form of Association where:**
    - It represents Has-A's relationship.
    - It is a unidirectional association i.e. a one-way relationship.
    - For example, a department can have students but vice versa is not possible and thus unidirectional in nature.
- In Aggregation, both entries can survive individually which means ending one entity will not affect the other entity.
![image](https://github.com/user-attachments/assets/7494befc-90c9-45ce-9fbd-b4e1d6d74405)

```java
// Java program to illustrate
// Concept of Aggregation
// Importing required classes
import java.io.*;
import java.util.*;
// Class 1
// Student class
class Student {
    // Attributes of Student
    private String studentName;
    private int studentId;
    // Constructor of Student class
    public Student(String studentName, int studentId)
    {
        this.studentName = studentName;
        this.studentId = studentId;
    }
    public int getstudentId() { 
      return studentId; 
    }
    public String getstudentName() {
      return studentName; 
    }
}
// Class 2
// Department class 
// Department class contains list of Students
class Department {
    // Attributes of Department class
    private String deptName;
    private List<Student> students;
    // Constructor of Department class
    public Department(String deptName, List<Student> students)
    {
        this.deptName = deptName;
        this.students = students;
    }
    public List<Student> getStudents() {
      return students; 
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
}
// Class 3
// Institute class
// Institute class contains the list of Departments
class Institute {
    // Attributes of Institute
    private String instituteName;
    private List<Department> departments;
    // Constructor of Institute class
    public Institute(String instituteName,
                     List<Department> departments)
    {
        // This keyword refers to current instance itself
        this.instituteName = instituteName;
        this.departments = departments;
    }
    public void addDepartment(Department department)
    {
        departments.add(department);
    }
    // Method of Institute class
    // Counting total students in the institute
    public int getTotalStudentsInInstitute()
    {
        int noOfStudents = 0;
        List<Student> students = null;

        for (Department dept : departments) {
            students = dept.getStudents();

            for (Student s : students) {
                noOfStudents++;
            }
        }
        return noOfStudents;
    }
}
// Class 4
// main class
class AggregationExample {
    // main driver method
    public static void main(String[] args)
    {
        // Creating independent Student objects
        Student s1 = new Student("Parul", 1);
        Student s2 = new Student("Sachin", 2);
        Student s3 = new Student("Priya", 1);
        Student s4 = new Student("Rahul", 2);
        // Creating an list of CSE Students
        List<Student> cse_students = new ArrayList<Student>();
        cse_students.add(s1);
        cse_students.add(s2);
        // Creating an initial list of EE Students
        List<Student> ee_students = new ArrayList<Student>();
        ee_students.add(s3);
        ee_students.add(s4);
        // Creating Department object with a Students list
        // using Aggregation (Department "has" students)
        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);
        // Creating an initial list of Departments
        List<Department> departments = new ArrayList<Department>();
        departments.add(CSE);
        departments.add(EE);
        // Creating an Institute object with Departments list
        // using Aggregation (Institute "has" Departments)
        Institute institute = new Institute("BITS", departments);
        // Display message for better readability
        System.out.print("Total students in institute: ");
        // Calling method to get total number of students
        // in the institute and printing on console
        System.out.print(
            institute.getTotalStudentsInInstitute());
    }
}
```
![image](https://github.com/user-attachments/assets/20988caa-572d-4126-91b6-d8d2d3d8a73b)

## Sorting Techniques:
#### 1.Bubble Sort:
  - This algorithm is not suitable for large data sets as its average and worst-case time complexity are quite high.<br />
![image](https://github.com/user-attachments/assets/c6a3f61c-cbef-466c-939f-1ab55d924d75) <br />
![image](https://github.com/user-attachments/assets/0eaa3c9c-3682-4c63-96b4-197983abb019) <br />
![image](https://github.com/user-attachments/assets/7039d964-2c7b-4b48-8346-9558f0f49562) <br />
##### Execution:
```java
   // Optimized java implementation of Bubble sort
   import java.io.*;
   class GFG { 
       // An optimized version of Bubble Sort
       static void bubbleSort(int arr[], int n){
           int i, j, temp;
           boolean swapped;
           for (i = 0; i < n - 1; i++) {
               swapped = false;
               for (j = 0; j < n - i - 1; j++) {
                   if (arr[j] > arr[j + 1]) {  
                       // Swap arr[j] and arr[j+1]
                       temp = arr[j];
                       arr[j] = arr[j + 1];
                       arr[j + 1] = temp;
                       swapped = true;
                     }
                  }
         // If no two elements were
         // swapped by inner loop, then break
               if (swapped == false) break;
           }
       }
       // Function to print an array
       static void printArray(int arr[], int size){
           int i;
           for (i = 0; i < size; i++)
               System.out.print(arr[i] + " ");
           System.out.println();
         }
       // Driver program
       public static void main(String args[]){
           int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
           int n = arr.length;
           bubbleSort(arr, n);
           System.out.println("Sorted array: ");
           printArray(arr, n);
       }
   }
```
* Output: <br />
  ![image](https://github.com/user-attachments/assets/927bdb4b-02ed-46f1-b317-4da2290bd132) <br />
##### Complexity Analysis of Bubble Sort:
- Time Complexity: O(n2)
- Auxiliary Space: O(1)
---
#### 2.Insertion Sort:
Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its correct position in a sorted portion of the list.

- We start with the second element of the array as the first element is assumed to be sorted.
- Compare the second element with the first element if the second element is smaller then swap them.
- Move to the third element, compare it with the first two elements, and put it in its correct position
- Repeat until the entire array is sorted.<br />
![image](https://github.com/user-attachments/assets/9d1869cb-0334-4bf3-b407-84a1d926cb05) <br />
![image](https://github.com/user-attachments/assets/0c3a1df4-a885-4051-93d9-8df9e87dbb2e) <br />
![image](https://github.com/user-attachments/assets/3d713164-8b1f-46f9-8dab-e9405f7caaa9) <br />
![image](https://github.com/user-attachments/assets/731ff891-4084-4022-8f1e-7ff1398ac08f) <br />
![image](https://github.com/user-attachments/assets/542343a9-811b-401d-b5b8-a230eea63382) <br />
##### Execution:
```java
   // Java program for implementation of Insertion Sort
   public class InsertionSort {
       /* Function to sort array using insertion sort */
       void sort(int arr[])
       {
           int n = arr.length;
            for (int i = 1; i < n; ++i) {
               int key = arr[i];
               int j = i - 1;
               /* Move elements of arr[0..i-1], that are
                  greater than key, to one position ahead
                  of their current position */
               while (j >= 0 && arr[j] > key) {
                   arr[j + 1] = arr[j];
                   j = j - 1;
               }
               arr[j + 1] = key;
           }
       }
       /* A utility function to print array of size n */
       static void printArray(int arr[])
       {
           int n = arr.length;
           for (int i = 0; i < n; ++i)
               System.out.print(arr[i] + " ");
           System.out.println();
       }
       // Driver method
       public static void main(String args[])
       {
           int arr[] = { 12, 11, 13, 5, 6 };
           InsertionSort ob = new InsertionSort();
           ob.sort(arr);
           printArray(arr);
       }
   }
```
##### Output:
![image](https://github.com/user-attachments/assets/48e7c571-9768-4308-a766-9d150b3b6ce3) <br />
##### Illustration:
![image](https://github.com/user-attachments/assets/c5e5f1d7-7dff-4805-b70b-58a49f43ce86) <br />
##### Complexity Analysis of Bubble Sort:
- Worst Case: O(n2)
- Best case: O(n)
- Average case: O(n2)
- Auxiliary Space: O(1)
---

