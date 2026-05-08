// Encapsulation using private fields and public getters/setters
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter method for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Setter method for balance (Ensuring validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("1234567890", 5000);

        // Accessing private fields using methods
        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Balance: " + acc.getBalance());

        // Depositing money
        acc.deposit(1000);

        // Withdrawing money
        acc.withdraw(2000); // 2000
    }
}

// // 4. Constructor Overloading

// class Car {
// String brand;
// int speed;

// // Default Constructor
// Car() {
// brand = "Unknown";
// speed = 0;
// }

// // Parameterized Constructor
// Car(String b) {
// brand = b;
// speed = 100;
// }

// // Another Parameterized Constructor
// Car(String b, int s) {
// brand = b;
// speed = s;
// }

// void display() {
// System.out.println("Brand: " + brand + ", Speed: " + speed);
// }
// }

// public class Main {
// public static void main(String[] args) {
// Car car1 = new Car();
// Car car2 = new Car("Honda");
// Car car3 = new Car("Audi", 250);

// car1.display();
// car2.display();
// car3.display();
// }
// }

// // Example-4 Copy Constructor
// class Car {
// String brand;
// int speed;

// // Parameterized Constructor
// Car(String b, int s) {
// brand = b;
// speed = s;
// }

// // Copy Constructor
// Car(Car obj) {
// brand = obj.brand;
// speed = obj.speed;
// }

// void display() {
// System.out.println("Brand: " + brand + ", Speed: " + speed);
// }
// }

// public class Main {
// public static void main(String[] args) {
// Car car1 = new Car("Ford", 180);
// Car car2 = new Car(car1); // Copy constructor used

// car1.display();
// car2.display();
// }
// }

// //example-3 Default Constructor and Parameterized Constructor

// class Person {
// String name;
// int age;

// // Default Constructor
// Person() {
// System.out.println("Default Constructor Called");
// }

// // Parameterized Constructor
// Person(String n, int a) {
// name = n;
// age = a;
// }

// void display() {
// System.out.println("Name: " + name + ", Age: " + age);
// }
// }

// public class Main {
// public static void main(String[] args) {
// Person p1 = new Person();
// Person p2 = new Person("Alice", 25);
// p2.display();
// }
// }

// example-2 Object and class java

// class Car {
// String brand;
// int speed;

// void showDetails() {
// System.out.println("Brand: " + brand + ", Speed: " + speed);
// }
// }

// public class HelloWorld {
// public static void main(String[] args) {
// Car car1 = new Car(); // Creating an object
// car1.brand = "Toyota";
// car1.speed = 120;
// car1.showDetails();
// }
// }

// example-1 HelloWorld Java
// public class HelloWorld {
// public static void main(String[] args) {
// System.out.println("Hello, Java!");
// }
// }