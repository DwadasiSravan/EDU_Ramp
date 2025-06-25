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



