# 1.Java Collections Framework (JCF) – Complete Deep Explanation

## 1. What is Java Collection Framework?

The **Java Collections Framework (JCF)** is a set of **classes** and **interfaces** used to store, manage, process, and manipulate groups of objects dynamically.

Before collections, Java mainly used **arrays**.

Problem with arrays:

* Fixed size
* Cannot grow dynamically
* Difficult insertion/deletion
* Limited built-in methods

Collections solve these problems.

---

# Real-Life Example

Imagine:

* **Array** = fixed-size apartment
* **Collection** = expandable hotel

Collections can:

* Add data dynamically
* Remove data
* Search data
* Sort data
* Store duplicates or unique values
* Store data in key-value format

---

# 2. Collection Framework Hierarchy

## Main Interfaces

```text
Iterable
   |
Collection
   |
------------------------------------------------
|               |               |              |
List            Set             Queue          Deque
|
ArrayList
LinkedList
Vector
Stack

Set
|
HashSet
LinkedHashSet
TreeSet

Queue
|
PriorityQueue
ArrayDeque

Map (Separate hierarchy)
|
HashMap
LinkedHashMap
TreeMap
Hashtable
ConcurrentHashMap
```

---

# 3. Difference Between Collection and Collections

| Feature | Collection                  | Collections              |
| ------- | --------------------------- | ------------------------ |
| Type    | Interface                   | Utility class            |
| Package | java.util                   | java.util                |
| Purpose | Represents group of objects | Provides utility methods |
| Example | List, Set                   | sort(), reverse()        |

Example:

```java
Collections.sort(list);
```

---

# 4. Iterable Interface

Parent of Collection interface.

Methods:

```java
iterator()
forEach()
spliterator()
```

Example:

```java
for(String name : list){
    System.out.println(name);
}
```

---

# 5. Collection Interface

Root interface of JCF.

Common methods:

| Method     | Purpose         |
| ---------- | --------------- |
| add()      | Add element     |
| remove()   | Remove element  |
| size()     | Collection size |
| clear()    | Remove all      |
| contains() | Check element   |
| isEmpty()  | Empty or not    |

Example:

```java
Collection<String> names = new ArrayList<>();

names.add("Java");
names.add("Spring");

System.out.println(names);
```

---

# 6. LIST Interface

## What is List?

Ordered collection.

Features:

* Maintains insertion order
* Allows duplicates
* Index-based access

Example:

```java
List<String> list = new ArrayList<>();
```

---

# 7. ArrayList

## What is ArrayList?

Dynamic array implementation.

### Internal Working

* Uses resizable array internally
* Default capacity = 10
* Grows automatically

Growth formula:

```text
newCapacity = oldCapacity + (oldCapacity / 2)
```

---

## Features

✅ Fast random access
✅ Maintains order
✅ Allows duplicates
❌ Slow insertion/deletion in middle

---

## Syntax

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## Example

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Spring");
        list.add("React");

        System.out.println(list);

        System.out.println(list.get(1));

        list.remove("Spring");

        System.out.println(list);
    }
}
```

Output:

```text
[Java, Spring, React]
Spring
[Java, React]
```

---

# Internal Structure of ArrayList

```text
Index:   0       1       2
       ----------------------
       | Java | Spring | React |
       ----------------------
```

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| add()     | O(1)       |
| get()     | O(1)       |
| remove()  | O(n)       |
| search()  | O(n)       |

---

# When to Use ArrayList?

Use when:

* Frequent searching
* More read operations
* Random access required

---

# 8. LinkedList

## What is LinkedList?

Uses doubly linked list internally.

Each node contains:

```text
Previous Address | Data | Next Address
```

---

## Structure

```text
null <- [10] <-> [20] <-> [30] -> null
```

---

## Features

✅ Fast insertion/deletion
✅ Maintains order
✅ Allows duplicates
❌ Slow random access

---

## Example

```java
LinkedList<String> list = new LinkedList<>();

list.add("A");
list.add("B");
list.addFirst("Start");
list.addLast("End");

System.out.println(list);
```

Output:

```text
[Start, A, B, End]
```

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| add()     | O(1)       |
| remove()  | O(1)       |
| get()     | O(n)       |

---

# ArrayList vs LinkedList

| Feature   | ArrayList     | LinkedList         |
| --------- | ------------- | ------------------ |
| Structure | Dynamic Array | Doubly Linked List |
| Access    | Fast          | Slow               |
| Insertion | Slow          | Fast               |
| Memory    | Less          | More               |
| Best Use  | Search        | Frequent insertion |

---

# 9. Vector

Legacy class.

Features:

* Synchronized
* Thread-safe

Example:

```java
Vector<Integer> v = new Vector<>();
```

---

# ArrayList vs Vector

| Feature     | ArrayList | Vector   |
| ----------- | --------- | -------- |
| Thread Safe | No        | Yes      |
| Performance | Fast      | Slow     |
| Introduced  | Java 1.2  | Java 1.0 |

---

# 10. Stack

LIFO (Last In First Out)

Example:

```text
Top
 |
30
20
10
```

Operations:

* push()
* pop()
* peek()

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());
```

Output:

```text
30
```

---

# Stack Applications

* Undo operation
* Browser history
* Expression evaluation
* DFS algorithm

---

# 11. Queue Interface

FIFO (First In First Out)

```text
Front -> 10 20 30 <- Rear
```

---

# PriorityQueue

Stores elements based on priority.

Example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(30);
pq.add(10);
pq.add(20);

System.out.println(pq);
```

Output:

```text
[10, 30, 20]
```

---

# Queue Methods

| Method  | Purpose  |
| ------- | -------- |
| offer() | Add      |
| poll()  | Remove   |
| peek()  | View top |

---

# 12. Deque

Double-ended queue.

Can insert/remove from both ends.

Example:

```java
Deque<Integer> dq = new ArrayDeque<>();

dq.addFirst(10);
dq.addLast(20);
```

---

# 13. SET Interface

## What is Set?

Stores unique elements.

Features:

* No duplicates
* No index
* Faster searching

---

# 14. HashSet

Uses HashMap internally.

Features:

* No duplicates
* Unordered
* Allows one null

---

## Internal Working

Uses:

* Hashing
* Hash table
* Buckets

---

# Hashing Concept

Hash function converts object into integer hashcode.

```java
hashCode()
equals()
```

---

## Example

```java
HashSet<String> set = new HashSet<>();

set.add("Java");
set.add("Java");
set.add("Spring");

System.out.println(set);
```

Output:

```text
[Java, Spring]
```

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| add()     | O(1)       |
| remove()  | O(1)       |
| search()  | O(1)       |

---

# 15. LinkedHashSet

Maintains insertion order.

Example:

```java
LinkedHashSet<Integer> set = new LinkedHashSet<>();
```

---

# 16. TreeSet

Stores sorted data.

Uses:

* Red-Black Tree

Example:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);

System.out.println(set);
```

Output:

```text
[10, 20, 30]
```

---

# HashSet vs LinkedHashSet vs TreeSet

| Feature      | HashSet | LinkedHashSet | TreeSet |
| ------------ | ------- | ------------- | ------- |
| Order        | No      | Insertion     | Sorted  |
| Performance  | Fastest | Medium        | Slow    |
| Null Allowed | Yes     | Yes           | No      |

---

# 17. MAP Interface

Stores key-value pairs.

```text
101 -> Java
102 -> Spring
```

---

# HashMap

Most used Map implementation.

Features:

* Key-value storage
* Unique keys
* One null key
* Multiple null values

---

# Internal Working of HashMap

Uses:

* Hash table
* Buckets
* Linked list
* Red-black tree (Java 8)

---

# HashMap Structure

```text
Bucket 0 -> null
Bucket 1 -> [101=Java]
Bucket 2 -> [102=Spring]
```

---

# Example

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Java");
map.put(102, "Spring");

System.out.println(map);

System.out.println(map.get(101));
```

---

# Important HashMap Concepts

## hashCode()

Generates hash value.

## equals()

Checks equality.

Both are important for:

* HashMap
* HashSet

---

# Collision in HashMap

When two keys map to same bucket.

Handled using:

* Linked List
* Red-Black Tree

---

# HashMap Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| put()     | O(1)       |
| get()     | O(1)       |
| remove()  | O(1)       |

---

# 18. LinkedHashMap

Maintains insertion order.

Example:

```java
LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
```

---

# 19. TreeMap

Sorted keys.

Uses Red-Black Tree.

Example:

```java
TreeMap<Integer, String> map = new TreeMap<>();
```

---

# HashMap vs TreeMap vs LinkedHashMap

| Feature     | HashMap | LinkedHashMap | TreeMap |
| ----------- | ------- | ------------- | ------- |
| Order       | Random  | Insertion     | Sorted  |
| Performance | Fast    | Medium        | Slow    |
| Null Key    | Yes     | Yes           | No      |

---

# 20. Hashtable

Legacy synchronized map.

Thread-safe but slower.

---

# 21. ConcurrentHashMap

Used in multithreading.

Better than Hashtable.

Example:

```java
ConcurrentHashMap<Integer, String> map =
        new ConcurrentHashMap<>();
```

---

# 22. Iterator

Used to traverse collection.

Example:

```java
Iterator<String> it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

---

# 23. ListIterator

Can move both directions.

```java
ListIterator<String> li = list.listIterator();
```

---

# 24. Comparable vs Comparator

## Comparable

Natural sorting.

```java
class Student implements Comparable<Student>
```

---

## Comparator

Custom sorting.

```java
Comparator<Student> byAge
```

---

# Example Comparator

```java
Collections.sort(list, (a,b) -> a.age - b.age);
```

---

# 25. Collections Utility Methods

| Method    | Purpose |
| --------- | ------- |
| sort()    | Sorting |
| reverse() | Reverse |
| shuffle() | Random  |
| max()     | Maximum |
| min()     | Minimum |

---

# Example

```java
Collections.sort(list);
Collections.reverse(list);
```

---

# 26. Fail Fast vs Fail Safe

## Fail Fast

Throws exception if collection modified during iteration.

Example:

```java
ArrayList
HashMap
```

Exception:

```text
ConcurrentModificationException
```

---

## Fail Safe

Works on cloned copy.

Example:

```java
ConcurrentHashMap
CopyOnWriteArrayList
```

---

# 27. Synchronization in Collections

Thread-safe collection:

```java
Collections.synchronizedList(list);
```

---

# 28. Immutable Collections

Java 9 introduced:

```java
List.of()
Set.of()
Map.of()
```

Example:

```java
List<String> list = List.of("A", "B");
```

Cannot modify.

---

# 29. Stream API with Collections

Example:

```java
list.stream()
    .filter(x -> x > 10)
    .forEach(System.out::println);
```

---

# 30. Best Collection Selection Guide

| Requirement        | Best Choice       |
| ------------------ | ----------------- |
| Fast search        | HashSet           |
| Sorted data        | TreeSet           |
| Key-value          | HashMap           |
| Thread-safe        | ConcurrentHashMap |
| Frequent insertion | LinkedList        |
| Random access      | ArrayList         |

---

# 31. Collection Interview Questions

## Q1. Difference between ArrayList and LinkedList?

| ArrayList     | LinkedList         |
| ------------- | ------------------ |
| Fast access   | Fast insertion     |
| Dynamic array | Doubly linked list |

---

## Q2. Why HashMap is fast?

Because it uses:

* Hashing
* Buckets
* O(1) lookup

---

## Q3. Difference between fail-fast and fail-safe?

| Fail Fast           | Fail Safe    |
| ------------------- | ------------ |
| Throws exception    | No exception |
| Original collection | Cloned copy  |

---

## Q4. Why equals() and hashCode() important?

Used for:

* Duplicate checking
* Bucket identification

---

# 32. Common Collection Algorithms

## Sorting

```java
Collections.sort(list);
```

---

## Binary Search

```java
Collections.binarySearch(list, key);
```

---

## Reverse

```java
Collections.reverse(list);
```

---

# 33. Java 8 Collection Features

## forEach()

```java
list.forEach(System.out::println);
```

---

## removeIf()

```java
list.removeIf(x -> x > 10);
```

---

## Stream API

```java
list.stream().sorted().collect(Collectors.toList());
```

---

# 34. Real-Time Usage in Spring Boot

| Collection        | Usage          |
| ----------------- | -------------- |
| List              | API response   |
| Map               | JSON data      |
| Set               | Unique roles   |
| Queue             | Kafka/RabbitMQ |
| ConcurrentHashMap | Caching        |

---

# 35. Important Internal Data Structures

| Collection    | Internal DS        |
| ------------- | ------------------ |
| ArrayList     | Dynamic Array      |
| LinkedList    | Doubly Linked List |
| HashMap       | Hash Table         |
| TreeMap       | Red-Black Tree     |
| TreeSet       | Red-Black Tree     |
| PriorityQueue | Heap               |

---

# 36. Memory Concepts

## Load Factor

Default:

```text
0.75
```

Used in:

* HashMap
* HashSet

---

## Capacity

Initial bucket size.

Default:

```text
16
```

---

# 37. Advanced Topics

## CopyOnWriteArrayList

Thread-safe ArrayList.

Best for:

* More read operations

---

## BlockingQueue

Used in producer-consumer problems.

---

# 38. Collection Best Practices

✅ Use interface reference:

```java
List<String> list = new ArrayList<>();
```

✅ Choose correct collection

✅ Override equals/hashCode properly

✅ Prefer ConcurrentHashMap over Hashtable

---

# 39. Complete Collection Summary Table

| Collection    | Ordered | Sorted | Duplicate | Null    | Thread Safe |
| ------------- | ------- | ------ | --------- | ------- | ----------- |
| ArrayList     | Yes     | No     | Yes       | Yes     | No          |
| LinkedList    | Yes     | No     | Yes       | Yes     | No          |
| HashSet       | No      | No     | No        | One     | No          |
| LinkedHashSet | Yes     | No     | No        | One     | No          |
| TreeSet       | Sorted  | Yes    | No        | No      | No          |
| HashMap       | No      | No     | Key No    | One Key | No          |
| TreeMap       | Sorted  | Yes    | Key No    | No      | No          |

---

# 40. Conclusion

Java Collections Framework is one of the most important concepts in Java because:

* Used in almost every project
* Core of Spring Boot applications
* Important for DSA
* Frequently asked in interviews

Master these deeply:

1. ArrayList
2. LinkedList
3. HashMap
4. HashSet
5. TreeMap
6. Comparator
7. Iterator
8. Concurrent Collections
9. Stream API
10. Internal working of HashMap






# 2.Java 8+ Features (Java 8 to Java 21) – Complete Deep Guide

Java 8 introduced the biggest revolution in Java history.
After Java 8, every version added modern features to improve:

* Performance
* Readability
* Functional programming
* Concurrency
* Memory management
* Developer productivity

---

# Java Version Timeline

| Version    | Major Features                                           |
| ---------- | -------------------------------------------------------- |
| Java 8     | Lambda, Stream API, Optional, Functional Interface       |
| Java 9     | Module System, JShell                                    |
| Java 10    | var keyword                                              |
| Java 11    | HTTP Client API, String methods                          |
| Java 12-14 | Switch expressions, Text Blocks                          |
| Java 15    | Sealed Classes (preview)                                 |
| Java 16    | Records                                                  |
| Java 17    | Pattern Matching, Sealed Classes stable                  |
| Java 18-21 | Virtual Threads, Structured Concurrency, Record Patterns |

---

# PART 1 — JAVA 8 FEATURES

# 1. Lambda Expressions

## What is Lambda?

Lambda expression is an anonymous function.

Before Java 8:

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
```

After Java 8:

```java
Runnable r = () -> System.out.println("Hello");
```

---

# Purpose of Lambda

✅ Reduce boilerplate code
✅ Functional programming
✅ Cleaner code
✅ Used with Streams/API

---

# Syntax

```java
(parameters) -> expression
```

Example:

```java
(a, b) -> a + b
```

---

# Lambda Internal Working

Java converts lambda into:

* Functional interface object
* Uses invokedynamic internally

---

# Real Example

```java
interface Calculator {
    int add(int a, int b);
}

public class Demo {
    public static void main(String[] args) {

        Calculator c = (a, b) -> a + b;

        System.out.println(c.add(10, 20));
    }
}
```

Output:

```text
30
```

---

# Alternative Before Java 8

| Before          | After  |
| --------------- | ------ |
| Anonymous class | Lambda |

---

# When to Use?

✅ Event handling
✅ Stream operations
✅ Sorting
✅ Multithreading

---

# 2. Functional Interface

## What is Functional Interface?

Interface having only ONE abstract method.

Example:

```java
@FunctionalInterface
interface Test {
    void show();
}
```

---

# Purpose

Used for:

* Lambda expressions
* Method references

---

# Built-in Functional Interfaces

| Interface | Purpose       |
| --------- | ------------- |
| Predicate | Boolean check |
| Function  | Transform     |
| Consumer  | Consume data  |
| Supplier  | Supply data   |

---

# Predicate Example

```java
Predicate<Integer> p = x -> x > 10;

System.out.println(p.test(20));
```

Output:

```text
true
```

---

# Function Example

```java
Function<String, Integer> f = s -> s.length();

System.out.println(f.apply("Java"));
```

---

# Consumer Example

```java
Consumer<String> c = x -> System.out.println(x);

c.accept("Hello");
```

---

# Supplier Example

```java
Supplier<Double> s = () -> Math.random();

System.out.println(s.get());
```

---

# Alternative Before Java 8

Create custom interfaces manually.

---

# 3. Method Reference

Shortcut for lambda expression.

---

# Types

| Type            | Example       |
| --------------- | ------------- |
| Static method   | Class::method |
| Instance method | obj::method   |
| Constructor     | Class::new    |

---

# Example

```java
list.forEach(System.out::println);
```

Equivalent:

```java
list.forEach(x -> System.out.println(x));
```

---

# Purpose

✅ Cleaner code
✅ Reusability
✅ Readability

---

# 4. Stream API

One of the most important Java 8 features.

---

# What is Stream?

Used for processing collections in functional style.

---

# Stream Pipeline

```text
Source → Intermediate → Terminal
```

---

# Example

```java
List<Integer> list =
        Arrays.asList(10,20,30,40);

list.stream()
    .filter(x -> x > 20)
    .forEach(System.out::println);
```

Output:

```text
30
40
```

---

# Common Stream Methods

| Method     | Purpose           |
| ---------- | ----------------- |
| filter()   | Filtering         |
| map()      | Transformation    |
| sorted()   | Sorting           |
| distinct() | Remove duplicates |
| limit()    | Limit data        |
| collect()  | Convert result    |

---

# filter()

```java
list.stream()
    .filter(x -> x % 2 == 0)
```

---

# map()

```java
list.stream()
    .map(x -> x * 2)
```

---

# collect()

```java
List<Integer> result =
    list.stream()
        .collect(Collectors.toList());
```

---

# Stream Internal Working

Uses:

* Lazy evaluation
* Pipeline processing
* Internal iteration

---

# Advantages

✅ Parallel processing
✅ Cleaner code
✅ Less loops
✅ Better readability

---

# Alternative Before Java 8

Traditional loops.

---

# Example Comparison

Before:

```java
List<Integer> result = new ArrayList<>();

for(int x : list){
    if(x > 10){
        result.add(x);
    }
}
```

After:

```java
list.stream()
    .filter(x -> x > 10)
    .collect(Collectors.toList());
```

---

# Parallel Stream

```java
list.parallelStream()
```

Uses multithreading automatically.

---

# When NOT to Use Streams

❌ Complex debugging
❌ Small/simple loops
❌ Performance critical tiny operations

---

# 5. Optional Class

## Problem Before Java 8

NullPointerException.

---

# Example

Before:

```java
String name = null;

System.out.println(name.length());
```

Exception:

```text
NullPointerException
```

---

# Optional Solution

```java
Optional<String> name =
        Optional.ofNullable(null);

System.out.println(name.orElse("Default"));
```

Output:

```text
Default
```

---

# Important Methods

| Method       | Purpose   |
| ------------ | --------- |
| of()         | Non-null  |
| ofNullable() | Nullable  |
| isPresent()  | Check     |
| get()        | Get value |
| orElse()     | Default   |
| ifPresent()  | Execute   |

---

# Example

```java
Optional<String> op =
        Optional.of("Java");

op.ifPresent(System.out::println);
```

---

# Alternative Before Java 8

Manual null checks.

---

# 6. Default Methods

Before Java 8:

* Cannot add method to interface
* Breaks implementations

---

# Solution

Default methods.

---

# Example

```java
interface Test {

    default void show() {
        System.out.println("Default");
    }
}
```

---

# Purpose

✅ Backward compatibility
✅ Interface evolution

---

# 7. Static Methods in Interface

```java
interface Demo {

    static void display() {
        System.out.println("Hello");
    }
}
```

Call:

```java
Demo.display();
```

---

# 8. Date and Time API

Old API problems:
❌ Not thread-safe
❌ Confusing

---

# New Package

```text
java.time
```

---

# Important Classes

| Class         | Purpose         |
| ------------- | --------------- |
| LocalDate     | Date            |
| LocalTime     | Time            |
| LocalDateTime | Date+Time       |
| Period        | Date difference |
| Duration      | Time difference |

---

# Example

```java
LocalDate date = LocalDate.now();

System.out.println(date);
```

---

# Date Addition

```java
LocalDate.now().plusDays(5);
```

---

# Period Example

```java
Period p = Period.between(
    LocalDate.of(2000,1,1),
    LocalDate.now()
);

System.out.println(p.getYears());
```

---

# 9. forEach()

```java
list.forEach(System.out::println);
```

Alternative:

```java
for(String s : list){
    System.out.println(s);
}
```

---

# 10. Nashorn JavaScript Engine

Run JavaScript inside Java.

Deprecated later.

---

# PART 2 — JAVA 9 FEATURES

# 11. Module System (Jigsaw)

## Problem

Large monolithic JDK.

---

# Solution

Modules.

---

# Example

```java
module mymodule {
    requires java.sql;
}
```

---

# Purpose

✅ Better security
✅ Faster startup
✅ Smaller applications

---

# 12. JShell

Interactive Java shell.

```text
jshell> 10 + 20
30
```

---

# 13. Private Methods in Interface

```java
interface Test {

    private void helper() {
    }
}
```

---

# PART 3 — JAVA 10 FEATURES

# 14. var Keyword

Type inference.

---

# Example

Before:

```java
ArrayList<String> list =
        new ArrayList<>();
```

After:

```java
var list = new ArrayList<String>();
```

---

# Purpose

✅ Reduce verbosity

---

# Limitations

❌ Only local variables

---

# PART 4 — JAVA 11 FEATURES

# 15. New String Methods

## isBlank()

```java
" ".isBlank();
```

---

## lines()

```java
str.lines()
```

---

## repeat()

```java
"Java".repeat(3);
```

Output:

```text
JavaJavaJava
```

---

# 16. HTTP Client API

Modern HTTP requests.

---

# Example

```java
HttpClient client =
    HttpClient.newHttpClient();
```

---

# Alternative

| Old               | New        |
| ----------------- | ---------- |
| HttpURLConnection | HttpClient |

---

# 17. Lambda Local Variable Syntax

```java
(var x, var y) -> x + y
```

---

# PART 5 — JAVA 12–14 FEATURES

# 18. Switch Expressions

Old switch:

```java
switch(day){
    case "MON":
        result = 1;
}
```

New switch:

```java
int result = switch(day){
    case "MON" -> 1;
    default -> 0;
};
```

---

# Purpose

✅ Cleaner
✅ No break needed

---

# 19. Text Blocks

Multi-line strings.

```java
String json = """
{
   "name":"Java"
}
""";
```

---

# Alternative

Before:

```java
String s = "{\n" +
"\"name\":\"Java\"";
```

---

# PART 6 — JAVA 15–17 FEATURES

# 20. Sealed Classes

Restrict inheritance.

---

# Example

```java
sealed class Vehicle
permits Car, Bike {
}
```

---

# Purpose

✅ Controlled hierarchy
✅ Better security

---

# 21. Records

Immutable data class.

---

# Before Records

```java
class Employee {

    private final int id;

    Employee(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
```

---

# Record

```java
record Employee(int id) {
}
```

---

# Benefits

✅ Less boilerplate
✅ Immutable
✅ Auto-generated methods

---

# Auto-generated

* Constructor
* getter
* toString()
* equals()
* hashCode()

---

# 22. Pattern Matching for instanceof

Before:

```java
if(obj instanceof String){
    String s = (String)obj;
}
```

After:

```java
if(obj instanceof String s){
    System.out.println(s);
}
```

---

# PART 7 — JAVA 18–21 FEATURES

# 23. Virtual Threads (Java 21)

Massive concurrency feature.

---

# Problem with Traditional Threads

* Heavyweight
* Expensive memory

---

# Solution

Virtual threads.

---

# Example

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello");
});
```

---

# Benefits

✅ Millions of threads
✅ Lightweight
✅ Better scalability

---

# Traditional vs Virtual Thread

| Feature       | Traditional | Virtual |
| ------------- | ----------- | ------- |
| Memory        | High        | Low     |
| Scalability   | Limited     | Huge    |
| Creation Cost | High        | Low     |

---

# 24. Structured Concurrency

Better async programming.

---

# 25. Record Patterns

```java
if(obj instanceof Point(int x, int y)){
}
```

---

# 26. String Templates (Preview)

```java
STR."Hello \{name}"
```

---

# Important Java 8+ Interview Topics

# Stream API Questions

* Difference between map() and flatMap()
* findFirst() vs findAny()
* reduce()
* groupingBy()
* parallelStream()

---

# Optional Questions

* Why Optional?
* Why Optional.get() dangerous?

---

# Lambda Questions

* Effectively final variable
* Functional interface rules

---

# Record Questions

* Are records immutable?
* Can record extend class?

---

# Virtual Thread Questions

* Difference from normal threads
* Use cases

---

# Most Important Features for Interviews

## MUST MASTER

### Java 8

1. Lambda
2. Stream API
3. Functional Interfaces
4. Optional
5. Method References
6. Date API

### Java 11

7. HttpClient
8. String methods

### Java 17

9. Records
10. Sealed Classes
11. Pattern Matching

### Java 21

12. Virtual Threads

---

# Real-Time Spring Boot Usage

| Feature           | Usage            |
| ----------------- | ---------------- |
| Streams           | Data processing  |
| Optional          | Repository layer |
| Lambda            | Callbacks        |
| CompletableFuture | Async APIs       |
| Virtual Threads   | High concurrency |
| Records           | DTOs             |
| Pattern Matching  | Clean code       |

---

# Java 8+ Summary Table

| Feature           | Purpose           | Alternative     |
| ----------------- | ----------------- | --------------- |
| Lambda            | Functional code   | Anonymous class |
| Stream API        | Data processing   | Loops           |
| Optional          | Null safety       | Null checks     |
| Records           | DTO class         | POJO            |
| Virtual Threads   | Concurrency       | Normal threads  |
| Switch Expression | Cleaner switch    | Old switch      |
| Text Blocks       | Multi-line string | Concatenation   |
| var               | Type inference    | Explicit type   |

---

# Best Learning Order

## Step 1

* Lambda
* Functional Interface
* Method Reference

## Step 2

* Stream API
* Optional

## Step 3

* Date API
* Collections with Streams

## Step 4

* Records
* Sealed Classes
* Pattern Matching

## Step 5

* Virtual Threads
* CompletableFuture

---

# Final Conclusion

Java 8+ transformed Java into:

* Functional
* Concurrent
* Cleaner
* More scalable
* Cloud-ready

Most important modern features:

1. Stream API
2. Lambda
3. Optional
4. Records
5. Virtual Threads
6. CompletableFuture
7. Pattern Matching
8. Sealed Classes

These are heavily used in:

* Spring Boot
* Microservices
* Enterprise applications
* Cloud-native systems
* High-performance APIs
