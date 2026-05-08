import java.util.*;

// ==================== PART 1: IMPLEMENTING COMPARABLE ====================
// Student class implements Comparable for natural ordering (by ID)
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int age;
    private double marks;
    
    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
    
    // Override toString for easy printing
    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, marks=%.2f}", 
                            id, name, age, marks);
    }
    
    // ========== COMPARABLE IMPLEMENTATION ==========
    // Natural ordering: Sort by ID (ascending)
    @Override
    public int compareTo(Student other) {
        // Return negative if this.id < other.id
        // Return zero if equal
        // Return positive if this.id > other.id
        return Integer.compare(this.id, other.id);
        
        // Alternative manual implementation:
        // if (this.id < other.id) return -1;
        // if (this.id > other.id) return 1;
        // return 0;
    }
}

// ==================== PART 2: COMPARATOR IMPLEMENTATIONS ====================

// Comparator 1: Sort by Name (Alphabetical order)
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

// Comparator 2: Sort by Age (Ascending)
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

// Comparator 3: Sort by Marks (Descending order)
class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Descending order: higher marks first
        return Double.compare(s2.getMarks(), s1.getMarks());
    }
}

// Comparator 4: Sort by Name, then Age (Multiple fields)
class NameThenAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // First compare by name
        int nameCompare = s1.getName().compareTo(s2.getName());
        
        // If names are same, compare by age
        if (nameCompare == 0) {
            return Integer.compare(s1.getAge(), s2.getAge());
        }
        return nameCompare;
    }
}

// ==================== PART 3: DEMONSTRATION ====================

public class ComparatorVsComparable {
    
    public static void main(String[] args) {
        // Create list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Charlie", 22, 85.5));
        students.add(new Student(101, "Alice", 20, 92.3));
        students.add(new Student(105, "Bob", 23, 78.9));
        students.add(new Student(102, "David", 21, 88.7));
        students.add(new Student(104, "Alice", 19, 95.0));
        
        System.out.println("========== COMPARABLE (Natural Ordering) ==========");
        System.out.println("Original List:");
        printStudents(students);
        
        // Using Comparable - sorts by ID (natural ordering)
        Collections.sort(students);
        System.out.println("\nAfter Sorting by ID (Comparable):");
        printStudents(students);
        
        System.out.println("\n========== COMPARATOR (Custom Ordering) ==========");
        
        // 1. Sort by Name
        Collections.sort(students, new NameComparator());
        System.out.println("\n1. Sorting by Name (Alphabetical):");
        printStudents(students);
        
        // 2. Sort by Age
        Collections.sort(students, new AgeComparator());
        System.out.println("\n2. Sorting by Age (Ascending):");
        printStudents(students);
        
        // 3. Sort by Marks (Descending)
        Collections.sort(students, new MarksComparator());
        System.out.println("\n3. Sorting by Marks (Highest to Lowest):");
        printStudents(students);
        
        // 4. Sort by Name, then Age
        Collections.sort(students, new NameThenAgeComparator());
        System.out.println("\n4. Sorting by Name, then Age:");
        printStudents(students);
        
        System.out.println("\n========== COMPARATOR USING LAMBDA EXPRESSIONS ==========");
        
        // Using lambda expressions (Java 8+)
        
        // Sort by ID in descending order
        students.sort((s1, s2) -> Integer.compare(s2.getId(), s1.getId()));
        System.out.println("\nSort by ID Descending (Lambda):");
        printStudents(students);
        
        // Sort by Name
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\nSort by Name (Lambda):");
        printStudents(students);
        
        // Sort by Marks (Ascending)
        students.sort(Comparator.comparingDouble(Student::getMarks));
        System.out.println("\nSort by Marks Ascending (Method Reference):");
        printStudents(students);
        
        // Sort by Marks (Descending)
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("\nSort by Marks Descending (Method Reference):");
        printStudents(students);
        
        // Sort by Name, then Marks
        students.sort(Comparator
            .comparing(Student::getName)
            .thenComparingDouble(Student::getMarks));
        System.out.println("\nSort by Name, then Marks:");
        printStudents(students);
        
        System.out.println("\n========== REVERSE ORDER ==========");
        
        // Reverse natural order
        Collections.sort(students, Collections.reverseOrder());
        System.out.println("\nReverse of Natural Order (ID Descending):");
        printStudents(students);
        
        // Reverse custom comparator
        Collections.sort(students, new NameComparator().reversed());
        System.out.println("\nReverse of Name Order (Z to A):");
        printStudents(students);
    }
    
    // Helper method to print students
    private static void printStudents(List<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}


// One-Liner for Interview
// "Comparable defines natural ordering inside the class with compareTo(), while Comparator provides external custom ordering with compare() without modifying the original class."

// Summary - Key Takeaways for Interview
// Point	Comparable	     Comparator
// What	   Natural ordering	    Custom ordering
// When	 Single sorting logic	Multiple sorting strategies
// Where	Inside class	External class/lambda
// How	 Implement compareTo()	Implement compare()
// Java 8	No change	        Lambda, method references
// Example	String, Integer, Date	    Custom sorting by different fields


// 7. Quick Comparison Table - Interview Ready
// Aspect	Comparable	Comparator
// Package	java.lang	java.util
// Method	compareTo(T o)	compare(T o1, T o2)
// Parameters	1	2
// Sorting	Natural order	Custom order
// Class Modification	Required	Not required
// Multiple Strategies	No	Yes
// Lambda Support	No	Yes (Java 8+)
// Usage	Collections.sort(list)	Collections.sort(list, comp)
// Example	String, Integer, Date	Custom sorting by name/age
