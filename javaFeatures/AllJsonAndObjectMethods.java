import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.stream.*;
import java.util.regex.*;

/**
 * Program to demonstrate all Object class methods and JSON handling
 * This version eliminates all unchecked warnings
 */
public class AllJsonAndObjectMethods {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=".repeat(100));
        System.out.println("COMPREHENSIVE DEMONSTRATION OF OBJECT AND JSON METHODS");
        System.out.println("=".repeat(100));
        
        // PART 1: java.lang.Object Class Methods (11 methods)
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 1: JAVA.LANG.OBJECT CLASS METHODS (11 Methods)");
        System.out.println("#".repeat(80));
        
        demonstrateObjectClassMethods();
        demonstrateCloneMethod();
        demonstrateWaitNotifyMethods();
        
        // PART 2: JSON Handling with Java Collections (Type-Safe)
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 2: TYPE-SAFE JSON HANDLING WITH JAVA COLLECTIONS");
        System.out.println("#".repeat(80));
        
        demonstrateJsonWithTypeSafeMaps();
        demonstrateJsonWithCustomObject();
        demonstrateJsonParsing();
        demonstrateJsonGeneration();
        demonstrateJsonValidation();
        demonstrateJsonPathQueries();
        demonstrateJsonTransformation();
        demonstrateJsonComparison();
        
        // PART 3: JSON Schema and Validation
        System.out.println("\n" + "#".repeat(80));
        System.out.println("PART 3: JSON SCHEMA AND VALIDATION");
        System.out.println("#".repeat(80));
        
        demonstrateJsonSchema();
        // demonstrateJsonSchemaValidation();
        
        // Summary
        printSummary();
    }
    
    // =========================================================================
    // PART 1: java.lang.Object CLASS METHODS
    // =========================================================================
    
    /**
     * Demonstrates all 11 methods from java.lang.Object class
     */
    private static void demonstrateObjectClassMethods() {
        System.out.println("\n--- Object Class Methods ---");
        
        // Create test objects
        Person person1 = new Person("John", 30);
        Person person2 = new Person("John", 30);
        Person person3 = new Person("Jane", 25);
        
        // Method 1: getClass() - Returns runtime class
        System.out.println("\n1. getClass(): " + person1.getClass().getName());
        System.out.println("   Simple name: " + person1.getClass().getSimpleName());
        System.out.println("   Is array? " + person1.getClass().isArray());
        
        // Method 2: toString() - String representation
        System.out.println("\n2. toString():");
        System.out.println("   Custom: " + person1.toString());
        System.out.println("   Object default: " + new Object().toString());
        
        // Method 3: equals(Object obj) - Object equality
        System.out.println("\n3. equals():");
        System.out.println("   person1.equals(person2): " + person1.equals(person2));
        System.out.println("   person1.equals(person3): " + person1.equals(person3));
        System.out.println("   person1.equals(null): " + person1.equals(null));
        
        // Method 4: hashCode() - Hash code for collections
        System.out.println("\n4. hashCode():");
        System.out.println("   person1.hashCode(): " + person1.hashCode());
        System.out.println("   person2.hashCode(): " + person2.hashCode());
        System.out.println("   person3.hashCode(): " + person3.hashCode());
        
        // Demonstrate hash code contract
        System.out.println("   Hash code contract: equal objects have equal hash codes: " + 
            (person1.hashCode() == person2.hashCode()));
        
        // Method 5: notify() - Wakes up single waiting thread
        System.out.println("\n5. notify() - Thread notification method");
        
        // Method 6: notifyAll() - Wakes up all waiting threads
        System.out.println("6. notifyAll() - Wakes up all waiting threads");
        
        // Method 7-9: wait() methods - Thread waiting
        System.out.println("7. wait() - Causes thread to wait");
        System.out.println("8. wait(long timeout) - Wait with timeout");
        System.out.println("9. wait(long timeout, int nanos) - Wait with nanos precision");
        
        // Method 10: clone() - Object copying (demonstrated separately)
        System.out.println("10. clone() - Creates object copy (see separate demo)");
        
        // Method 11: finalize() - Deprecated cleanup method
        System.out.println("11. finalize() - Deprecated, called by GC before collection");
    }
    
    /**
     * Person class demonstrating proper Object method overrides
     */
    static class Person implements Cloneable {
        private final String name;
        private final int age;
        private Address address;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = new Address("Unknown");
        }
        
        public Person(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        
        // Getters
        public String getName() { return name; }
        public int getAge() { return age; }
        public Address getAddress() { return address; }
        public void setAddress(Address address) { this.address = address; }
        
        // Proper toString override
        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d, address=%s}", name, age, address);
        }
        
        // Proper equals override
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && 
                   Objects.equals(name, person.name) &&
                   Objects.equals(address, person.address);
        }
        
        // Proper hashCode override (must match equals)
        @Override
        public int hashCode() {
            return Objects.hash(name, age, address);
        }
        
        // Clone method - supports shallow and deep cloning
        @Override
        public Person clone() {
            try {
                Person cloned = (Person) super.clone();
                // For deep clone, also clone mutable objects
                if (this.address != null) {
                    cloned.address = this.address.clone();
                }
                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("Clone not supported", e);
            }
        }
        
        // Manual copy method alternative to clone()
        public Person copy() {
            Person copy = new Person(this.name, this.age);
            if (this.address != null) {
                copy.address = new Address(this.address.getCity());
            }
            return copy;
        }
        
        // Convert to Map (JSON-like structure) - Type-safe version
        public Map<String, Object> toMap() {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("name", name);
            map.put("age", age);
            map.put("address", address.toMap());
            return Collections.unmodifiableMap(map);
        }
        
        // Create from Map - with type safety
        @SuppressWarnings("unchecked")
        public static Person fromMap(Map<String, Object> map) {
            Objects.requireNonNull(map, "Map cannot be null");
            
            String name = (String) map.get("name");
            if (name == null) throw new IllegalArgumentException("name is required");
            
            Number ageNum = (Number) map.get("age");
            if (ageNum == null) throw new IllegalArgumentException("age is required");
            int age = ageNum.intValue();
            
            Map<String, Object> addressMap = (Map<String, Object>) map.get("address");
            Address address = addressMap != null ? Address.fromMap(addressMap) : new Address("Unknown");
            
            return new Person(name, age, address);
        }
    }
    
    /**
     * Address class for demonstrating deep cloning
     */
    static class Address implements Cloneable {
        private String city;
        
        public Address(String city) {
            this.city = city;
        }
        
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        
        @Override
        public String toString() {
            return String.format("Address{city='%s'}", city);
        }
        
        @Override
        public Address clone() {
            try {
                return (Address) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(city, address.city);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(city);
        }
        
        public Map<String, Object> toMap() {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("city", city);
            return Collections.unmodifiableMap(map);
        }
        
        public static Address fromMap(Map<String, Object> map) {
            Objects.requireNonNull(map, "Map cannot be null");
            String city = (String) map.get("city");
            return new Address(city != null ? city : "Unknown");
        }
    }
    
    /**
     * Demonstrates clone() method with shallow and deep cloning
     */
    private static void demonstrateCloneMethod() {
        System.out.println("\n--- Clone Method Deep Dive ---");
        
        // Basic cloning with primitive fields
        class Data implements Cloneable {
            int value;
            
            Data(int value) { this.value = value; }
            
            @Override
            public Data clone() {
                try {
                    return (Data) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }
        
        Data d1 = new Data(42);
        Data d2 = d1.clone();
        System.out.println("   Primitive clone - d1.value: " + d1.value + ", d2.value: " + d2.value);
        d2.value = 100;
        System.out.println("   After modifying clone: d1.value: " + d1.value + ", d2.value: " + d2.value);
        
        // Shallow vs Deep clone demonstration
        System.out.println("\n   --- Shallow vs Deep Clone ---");
        Address addr = new Address("New York");
        Person original = new Person("Alice", 28, addr);
        Person deepClone = original.clone(); // Deep clone by default in our implementation
        
        System.out.println("   Original: " + original);
        System.out.println("   Deep Clone: " + deepClone);
        
        // Modify the address in original
        original.getAddress().setCity("Boston");
        System.out.println("\n   After modifying original's address to Boston:");
        System.out.println("   Original: " + original);
        System.out.println("   Deep Clone (unchanged): " + deepClone);
        
        // Show shallow clone alternative
        class ShallowPerson implements Cloneable {
            String name;
            Address address;
            
            ShallowPerson(String name, Address address) {
                this.name = name;
                this.address = address;
            }
            
            @Override
            public ShallowPerson clone() {
                try {
                    return (ShallowPerson) super.clone(); // Shallow clone only
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
            
            @Override
            public String toString() {
                return String.format("ShallowPerson{name='%s', address=%s}", name, address);
            }
        }
        
        ShallowPerson sp1 = new ShallowPerson("Bob", new Address("Chicago"));
        ShallowPerson sp2 = sp1.clone();
        
        System.out.println("\n   --- Shallow Clone Example ---");
        System.out.println("   sp1: " + sp1);
        System.out.println("   sp2 (shallow clone): " + sp2);
        
        sp1.address.setCity("Detroit");
        System.out.println("   After modifying sp1 address to Detroit:");
        System.out.println("   sp1: " + sp1);
        System.out.println("   sp2 (affected by change): " + sp2);
        
        // Alternative to clone - copy constructor
        System.out.println("\n   --- Copy Constructor Alternative ---");
        Person copy = original.copy();
        System.out.println("   Copy via copy constructor: " + copy);
    }
    
    /**
     * Demonstrates wait/notify methods with a simple producer-consumer
     */
    private static void demonstrateWaitNotifyMethods() {
        System.out.println("\n--- wait/notify/notifyAll Methods ---");
        
        class MessageQueue {
            private final List<String> messages = new ArrayList<>();
            private final int CAPACITY = 5;
            
            public synchronized void produce(String message) throws InterruptedException {
                while (messages.size() == CAPACITY) {
                    System.out.println("   Queue full, producer waiting...");
                    wait(); // Method 7: wait() - releases lock and waits
                }
                messages.add(message);
                System.out.println("   Produced: " + message + ", queue size: " + messages.size());
                notifyAll(); // Method 6: notifyAll() - wakes all waiting threads
            }
            
            public synchronized String consume() throws InterruptedException {
                while (messages.isEmpty()) {
                    System.out.println("   Queue empty, consumer waiting...");
                    wait(1000); // Method 8: wait(long timeout) - wait with timeout
                }
                String message = messages.remove(0);
                System.out.println("   Consumed: " + message + ", queue size: " + messages.size());
                notify(); // Method 5: notify() - wakes one waiting thread
                return message;
            }
            
            public synchronized void waitWithNanos() throws InterruptedException {
                wait(100, 500); // Method 9: wait(long timeout, int nanos)
            }
        }
        
        MessageQueue queue = new MessageQueue();
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.produce("Message-" + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("   Starting producer-consumer demo...");
        producer.start();
        consumer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("   Producer-consumer demo completed");
    }
    
    // =========================================================================
    // PART 2: TYPE-SAFE JSON HANDLING WITH JAVA COLLECTIONS
    // =========================================================================
    
    // Type-safe JSON value wrapper
    static class JsonValue {
        private final Object value;
        private final JsonType type;
        
        enum JsonType {
            OBJECT, ARRAY, STRING, NUMBER, BOOLEAN, NULL
        }
        
        private JsonValue(Object value, JsonType type) {
            this.value = value;
            this.type = type;
        }
        
        public static JsonValue of(Map<String, JsonValue> map) {
            return new JsonValue(new LinkedHashMap<>(map), JsonType.OBJECT);
        }
        
        public static JsonValue of(List<JsonValue> list) {
            return new JsonValue(new ArrayList<>(list), JsonType.ARRAY);
        }
        
        public static JsonValue of(String s) {
            return new JsonValue(s, JsonType.STRING);
        }
        
        public static JsonValue of(Number n) {
            return new JsonValue(n, JsonType.NUMBER);
        }
        
        public static JsonValue of(Boolean b) {
            return new JsonValue(b, JsonType.BOOLEAN);
        }
        
        public static JsonValue nullValue() {
            return new JsonValue(null, JsonType.NULL);
        }
        
        public JsonType getType() { return type; }
        
        @SuppressWarnings("unchecked")
        public Map<String, JsonValue> asObject() {
            if (type != JsonType.OBJECT) throw new IllegalStateException("Not an object");
            return (Map<String, JsonValue>) value;
        }
        
        @SuppressWarnings("unchecked")
        public List<JsonValue> asArray() {
            if (type != JsonType.ARRAY) throw new IllegalStateException("Not an array");
            return (List<JsonValue>) value;
        }
        
        public String asString() {
            if (type != JsonType.STRING) throw new IllegalStateException("Not a string");
            return (String) value;
        }
        
        public Number asNumber() {
            if (type != JsonType.NUMBER) throw new IllegalStateException("Not a number");
            return (Number) value;
        }
        
        public Boolean asBoolean() {
            if (type != JsonType.BOOLEAN) throw new IllegalStateException("Not a boolean");
            return (Boolean) value;
        }
        
        public boolean isNull() {
            return type == JsonType.NULL;
        }
        
        public String toString() {
            return toJsonString();
        }
        
        private String toJsonString() {
            switch (type) {
                case OBJECT: return objectToString();
                case ARRAY: return arrayToString();
                case STRING: return "\"" + escapeString((String) value) + "\"";
                case NUMBER: return value.toString();
                case BOOLEAN: return value.toString();
                case NULL: return "null";
                default: return "null";
            }
        }
        
        private String objectToString() {
            Map<String, JsonValue> map = asObject();
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<String, JsonValue> entry : map.entrySet()) {
                if (!first) sb.append(",");
                first = false;
                sb.append("\"").append(escapeString(entry.getKey())).append("\":");
                sb.append(entry.getValue().toJsonString());
            }
            sb.append("}");
            return sb.toString();
        }
        
        private String arrayToString() {
            List<JsonValue> list = asArray();
            StringBuilder sb = new StringBuilder("[");
            boolean first = true;
            for (JsonValue val : list) {
                if (!first) sb.append(",");
                first = false;
                sb.append(val.toJsonString());
            }
            sb.append("]");
            return sb.toString();
        }
        
        private String escapeString(String s) {
            return s.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
        }
    }
    
    /**
     * Demonstrates JSON-like structures using type-safe Java Collections
     */
    private static void demonstrateJsonWithTypeSafeMaps() {
        System.out.println("\n--- Type-Safe JSON with Java Collections ---");
        
        // Create a JSON-like structure using our type-safe wrapper
        Map<String, JsonValue> personMap = new LinkedHashMap<>();
        personMap.put("firstName", JsonValue.of("John"));
        personMap.put("lastName", JsonValue.of("Doe"));
        personMap.put("age", JsonValue.of(30));
        personMap.put("isEmployed", JsonValue.of(true));
        personMap.put("salary", JsonValue.of(75000.50));
        
        // Nested object
        Map<String, JsonValue> addressMap = new LinkedHashMap<>();
        addressMap.put("street", JsonValue.of("123 Main St"));
        addressMap.put("city", JsonValue.of("New York"));
        addressMap.put("zip", JsonValue.of(10001));
        personMap.put("address", JsonValue.of(addressMap));
        
        // Array of strings
        List<JsonValue> hobbiesList = new ArrayList<>();
        hobbiesList.add(JsonValue.of("reading"));
        hobbiesList.add(JsonValue.of("swimming"));
        hobbiesList.add(JsonValue.of("coding"));
        personMap.put("hobbies", JsonValue.of(hobbiesList));
        
        // Array of objects
        List<JsonValue> phonesList = new ArrayList<>();
        
        Map<String, JsonValue> phone1 = new LinkedHashMap<>();
        phone1.put("type", JsonValue.of("home"));
        phone1.put("number", JsonValue.of("212-555-1234"));
        phonesList.add(JsonValue.of(phone1));
        
        Map<String, JsonValue> phone2 = new LinkedHashMap<>();
        phone2.put("type", JsonValue.of("work"));
        phone2.put("number", JsonValue.of("646-555-4567"));
        phonesList.add(JsonValue.of(phone2));
        
        personMap.put("phoneNumbers", JsonValue.of(phonesList));
        
        JsonValue json = JsonValue.of(personMap);
        System.out.println("   JSON Structure created with type-safe wrapper:");
        System.out.println(json);
        
        // Access data in type-safe way
        System.out.println("\n   Accessing data type-safely:");
        Map<String, JsonValue> person = json.asObject();
        System.out.println("   First name: " + person.get("firstName").asString());
        System.out.println("   Age: " + person.get("age").asNumber().intValue());
        
        Map<String, JsonValue> address = person.get("address").asObject();
        System.out.println("   City: " + address.get("city").asString());
        
        List<JsonValue> hobbies = person.get("hobbies").asArray();
        System.out.println("   First hobby: " + hobbies.get(0).asString());
        
        List<JsonValue> phones = person.get("phoneNumbers").asArray();
        JsonValue firstPhone = phones.get(0);
        System.out.println("   First phone type: " + firstPhone.asObject().get("type").asString());
    }
    
    /**
     * Demonstrates JSON with custom Java objects
     */
    private static void demonstrateJsonWithCustomObject() {
        System.out.println("\n--- JSON with Custom Java Objects ---");
        
        Person person = new Person("Alice Smith", 28);
        person.setAddress(new Address("San Francisco"));
        
        // Convert to Map (JSON-like structure)
        Map<String, Object> personMap = person.toMap();
        
        // Convert to JSON string
        String jsonString = convertMapToJson(personMap);
        System.out.println("   Person as JSON:");
        System.out.println(jsonString);
        
        // Reconstruct object from Map
        Person reconstructed = Person.fromMap(personMap);
        System.out.println("\n   Reconstructed Person: " + reconstructed);
        System.out.println("   Original equals reconstructed: " + person.equals(reconstructed));
    }
    
    /**
     * Convert Map to JSON string (type-safe version)
     */
    private static String convertMapToJson(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!first) sb.append(",");
            first = false;
            sb.append("\"").append(escapeJson(entry.getKey())).append("\":");
            sb.append(valueToJson(entry.getValue()));
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Convert any value to JSON string (type-safe version)
     */
    @SuppressWarnings("unchecked")
    private static String valueToJson(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "\"" + escapeJson((String) value) + "\"";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Map) {
            return convertMapToJson((Map<String, Object>) value);
        } else if (value instanceof List) {
            StringBuilder sb = new StringBuilder("[");
            List<?> list = (List<?>) value;
            boolean first = true;
            for (Object item : list) {
                if (!first) sb.append(",");
                first = false;
                sb.append(valueToJson(item));
            }
            sb.append("]");
            return sb.toString();
        } else {
            return "\"" + escapeJson(value.toString()) + "\"";
        }
    }
    
    /**
     * Escape JSON string
     */
    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
    
    /**
     * Demonstrates JSON parsing techniques
     */
    private static void demonstrateJsonParsing() {
        System.out.println("\n--- JSON Parsing Techniques ---");
        
        String jsonData = """
            {
                "employees": [
                    {
                        "id": 1,
                        "name": "John Doe",
                        "department": "Engineering",
                        "skills": ["Java", "Spring", "SQL"]
                    },
                    {
                        "id": 2,
                        "name": "Jane Smith",
                        "department": "Product",
                        "skills": ["Agile", "Scrum", "UX"]
                    }
                ],
                "total": 2,
                "company": "Tech Corp"
            }
            """;
        
        System.out.println("   Parsing employee JSON data:");
        
        // Parse using regex patterns
        parseJsonWithPatterns(jsonData);
        
        // Using Scanner for token-based parsing
        parseJsonWithScanner(jsonData);
    }
    
    private static void parseJsonWithPatterns(String json) {
        System.out.println("\n   Parsing with regex patterns:");
        
        // Pattern for extracting key-value pairs
        Pattern pattern = Pattern.compile("\"(\\w+)\"\\s*:\\s*(\"[^\"]*\"|\\d+|true|false|null)");
        Matcher matcher = pattern.matcher(json);
        
        Map<String, String> extracted = new LinkedHashMap<>();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            extracted.put(key, value);
            System.out.println("   Found: " + key + " = " + value);
        }
        
        // Extract company name specifically
        Pattern companyPattern = Pattern.compile("\"company\"\\s*:\\s*\"([^\"]+)\"");
        Matcher companyMatcher = companyPattern.matcher(json);
        if (companyMatcher.find()) {
            System.out.println("   Company: " + companyMatcher.group(1));
        }
        
        // Extract total
        Pattern totalPattern = Pattern.compile("\"total\"\\s*:\\s*(\\d+)");
        Matcher totalMatcher = totalPattern.matcher(json);
        if (totalMatcher.find()) {
            System.out.println("   Total: " + totalMatcher.group(1));
        }
    }
    
    private static void parseJsonWithScanner(String json) {
        System.out.println("\n   Token-based parsing with Scanner:");
        try (Scanner scanner = new Scanner(json)) {
            scanner.useDelimiter("[{}\\[\\],:\"]+");
            List<String> tokens = new ArrayList<>();
            while (scanner.hasNext()) {
                String token = scanner.next().trim();
                if (!token.isEmpty() && !token.matches("\\s+")) {
                    tokens.add(token);
                }
            }
            System.out.println("   Tokens: " + tokens);
        }
    }
    
    /**
     * Demonstrates JSON generation techniques
     */
    private static void demonstrateJsonGeneration() {
        System.out.println("\n--- JSON Generation Techniques ---");
        
        // Method 1: Using StringBuilder
        System.out.println("\n   Method 1: StringBuilder JSON generation:");
        String json1 = generateJsonWithStringBuilder();
        System.out.println(json1);
        
        // Method 2: Using Formatter
        System.out.println("\n   Method 2: Formatter JSON generation:");
        String json2 = generateJsonWithFormatter();
        System.out.println(json2);
        
        // Method 3: Using Stream API
        System.out.println("\n   Method 3: Stream API JSON generation:");
        String json3 = generateJsonWithStreams();
        System.out.println(json3);
        
        // Method 4: Template-based (Java 13+ text blocks)
        System.out.println("\n   Method 4: Template-based (Text Blocks):");
        String json4 = generateJsonWithTemplate();
        System.out.println(json4);
        
        // Method 5: Using our type-safe wrapper
        System.out.println("\n   Method 5: Type-safe wrapper JSON generation:");
        String json5 = generateJsonWithWrapper();
        System.out.println(json5);
    }
    
    private static String generateJsonWithStringBuilder() {
        return new StringBuilder()
            .append("{\n")
            .append("  \"name\": \"Product\",\n")
            .append("  \"price\": 29.99,\n")
            .append("  \"inStock\": true,\n")
            .append("  \"tags\": [\"electronics\", \"gadget\"],\n")
            .append("  \"dimensions\": {\n")
            .append("    \"width\": 10,\n")
            .append("    \"height\": 5,\n")
            .append("    \"depth\": 2\n")
            .append("  }\n")
            .append("}")
            .toString();
    }
    
    private static String generateJsonWithFormatter() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("{\n");
        formatter.format("  \"name\": \"%s\",\n", "Product");
        formatter.format("  \"price\": %.2f,\n", 29.99);
        formatter.format("  \"inStock\": %b,\n", true);
        formatter.format("  \"tags\": [\"electronics\", \"gadget\"],\n");
        formatter.format("  \"dimensions\": {\n");
        formatter.format("    \"width\": %d,\n", 10);
        formatter.format("    \"height\": %d,\n", 5);
        formatter.format("    \"depth\": %d\n", 2);
        formatter.format("  }\n");
        formatter.format("}");
        formatter.close();
        return sb.toString();
    }
    
    private static String generateJsonWithStreams() {
        List<String> keys = Arrays.asList("name", "price", "inStock");
        List<Object> values = Arrays.asList("Product", 29.99, true);
        
        return IntStream.range(0, keys.size())
            .mapToObj(i -> {
                String key = keys.get(i);
                Object val = values.get(i);
                String valueStr = val instanceof String ? "\"" + val + "\"" : val.toString();
                return String.format("  \"%s\": %s", key, valueStr);
            })
            .collect(Collectors.joining(",\n", "{\n", "\n}"));
    }
    
    private static String generateJsonWithTemplate() {
        return """
            {
              "name": "Product",
              "price": 29.99,
              "inStock": true,
              "tags": ["electronics", "gadget"],
              "dimensions": {
                "width": 10,
                "height": 5,
                "depth": 2
              }
            }
            """;
    }
    
    private static String generateJsonWithWrapper() {
        Map<String, JsonValue> product = new LinkedHashMap<>();
        product.put("name", JsonValue.of("Product"));
        product.put("price", JsonValue.of(29.99));
        product.put("inStock", JsonValue.of(true));
        
        List<JsonValue> tags = new ArrayList<>();
        tags.add(JsonValue.of("electronics"));
        tags.add(JsonValue.of("gadget"));
        product.put("tags", JsonValue.of(tags));
        
        Map<String, JsonValue> dimensions = new LinkedHashMap<>();
        dimensions.put("width", JsonValue.of(10));
        dimensions.put("height", JsonValue.of(5));
        dimensions.put("depth", JsonValue.of(2));
        product.put("dimensions", JsonValue.of(dimensions));
        
        return JsonValue.of(product).toString();
    }
    
    /**
     * Demonstrates JSON validation techniques
     */
    private static void demonstrateJsonValidation() {
        System.out.println("\n--- JSON Validation Techniques ---");
        
        String[] testJsons = {
            "{\"name\":\"John\",\"age\":30}",
            "{name:John,age:30}",
            "{\"name\":\"John\",\"age\":30",
            "{\"name\":\"John\",\"age\":30}",
            ""
        };
        
        for (int i = 0; i < testJsons.length; i++) {
            String json = testJsons[i];
            System.out.println("\n   Testing JSON " + (i+1) + ": " + json);
            System.out.println("   Valid: " + isValidJson(json));
            System.out.println("   Balanced braces: " + hasBalancedBraces(json));
            System.out.println("   Balanced quotes: " + hasBalancedQuotes(json));
        }
    }
    
    private static boolean isValidJson(String json) {
        if (json == null || json.trim().isEmpty()) return false;
        
        // Basic validation - check for balanced braces and quotes
        return hasBalancedBraces(json) && hasBalancedQuotes(json) && 
               json.trim().startsWith("{") && json.trim().endsWith("}");
    }
    
    private static boolean hasBalancedBraces(String s) {
        int count = 0;
        boolean inString = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '"' && (i == 0 || s.charAt(i-1) != '\\')) {
                inString = !inString;
            }
            
            if (!inString) {
                if (c == '{' || c == '[') count++;
                if (c == '}' || c == ']') count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
    
    private static boolean hasBalancedQuotes(String s) {
        int count = 0;
        boolean escaped = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '\\' && !escaped) {
                escaped = true;
                continue;
            }
            
            if (c == '"' && !escaped) {
                count++;
            }
            
            escaped = false;
        }
        return count % 2 == 0;
    }
    
    /**
     * Demonstrates JSON Path-like queries
     */
    private static void demonstrateJsonPathQueries() {
        System.out.println("\n--- JSON Path Queries ---");
        
        // Create a complex JSON structure
        Map<String, JsonValue> company = new LinkedHashMap<>();
        company.put("name", JsonValue.of("Tech Corp"));
        
        List<JsonValue> employees = new ArrayList<>();
        
        // Employee 1
        Map<String, JsonValue> emp1 = new LinkedHashMap<>();
        emp1.put("id", JsonValue.of(1));
        emp1.put("name", JsonValue.of("John Doe"));
        emp1.put("department", JsonValue.of("Engineering"));
        
        List<JsonValue> emp1Skills = new ArrayList<>();
        emp1Skills.add(JsonValue.of("Java"));
        emp1Skills.add(JsonValue.of("Spring"));
        emp1Skills.add(JsonValue.of("SQL"));
        emp1.put("skills", JsonValue.of(emp1Skills));
        
        // Employee 2
        Map<String, JsonValue> emp2 = new LinkedHashMap<>();
        emp2.put("id", JsonValue.of(2));
        emp2.put("name", JsonValue.of("Jane Smith"));
        emp2.put("department", JsonValue.of("Product"));
        
        List<JsonValue> emp2Skills = new ArrayList<>();
        emp2Skills.add(JsonValue.of("Agile"));
        emp2Skills.add(JsonValue.of("Scrum"));
        emp2Skills.add(JsonValue.of("UX"));
        emp2.put("skills", JsonValue.of(emp2Skills));
        
        employees.add(JsonValue.of(emp1));
        employees.add(JsonValue.of(emp2));
        
        company.put("employees", JsonValue.of(employees));
        
        JsonValue json = JsonValue.of(company);
        System.out.println("   Company JSON:\n" + json);
        
        // Query using our path methods
        System.out.println("\n   JSON Path queries:");
        
        // Get company name
        JsonValue name = getValueAtPath(json, "name");
        System.out.println("   $.name: " + (name != null ? name.asString() : "not found"));
        
        // Get first employee name
        JsonValue firstEmpName = getValueAtPath(json, "employees", "0", "name");
        System.out.println("   $.employees[0].name: " + 
            (firstEmpName != null ? firstEmpName.asString() : "not found"));
        
        // Get first employee skills
        JsonValue firstEmpSkills = getValueAtPath(json, "employees", "0", "skills");
        System.out.println("   $.employees[0].skills: " + 
            (firstEmpSkills != null ? firstEmpSkills.asArray() : "not found"));
        
        // Get second employee department
        JsonValue secondEmpDept = getValueAtPath(json, "employees", "1", "department");
        System.out.println("   $.employees[1].department: " + 
            (secondEmpDept != null ? secondEmpDept.asString() : "not found"));
        
        // Query all employees in Engineering
        List<String> engineers = queryEmployeesByDepartment(json, "Engineering");
        System.out.println("   Employees in Engineering: " + engineers);
    }
    
    private static JsonValue getValueAtPath(JsonValue root, String... path) {
        JsonValue current = root;
        
        for (String segment : path) {
            if (current == null) return null;
            
            if (current.getType() == JsonValue.JsonType.OBJECT) {
                Map<String, JsonValue> obj = current.asObject();
                current = obj.get(segment);
            } else if (current.getType() == JsonValue.JsonType.ARRAY) {
                try {
                    int index = Integer.parseInt(segment);
                    List<JsonValue> array = current.asArray();
                    if (index >= 0 && index < array.size()) {
                        current = array.get(index);
                    } else {
                        return null;
                    }
                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                return null;
            }
        }
        
        return current;
    }
    
    private static List<String> queryEmployeesByDepartment(JsonValue root, String department) {
        List<String> result = new ArrayList<>();
        
        JsonValue employees = getValueAtPath(root, "employees");
        if (employees != null && employees.getType() == JsonValue.JsonType.ARRAY) {
            for (JsonValue emp : employees.asArray()) {
                JsonValue dept = getValueAtPath(emp, "department");
                if (dept != null && department.equals(dept.asString())) {
                    JsonValue name = getValueAtPath(emp, "name");
                    if (name != null) {
                        result.add(name.asString());
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
     * Demonstrates JSON transformation
     */
    private static void demonstrateJsonTransformation() {
        System.out.println("\n--- JSON Transformation ---");
        
        // Original JSON
        Map<String, JsonValue> original = new LinkedHashMap<>();
        original.put("firstName", JsonValue.of("John"));
        original.put("lastName", JsonValue.of("Doe"));
        original.put("age", JsonValue.of(30));
        
        JsonValue json = JsonValue.of(original);
        System.out.println("   Original: " + json);
        
        // Transform - add full name
        JsonValue transformed = transformJson(json, new JsonTransformer() {
            @Override
            public JsonValue transform(JsonValue input) {
                if (input.getType() != JsonValue.JsonType.OBJECT) return input;
                
                Map<String, JsonValue> obj = new LinkedHashMap<>(input.asObject());
                
                // Add fullName field
                String firstName = obj.containsKey("firstName") ? 
                    obj.get("firstName").asString() : "";
                String lastName = obj.containsKey("lastName") ? 
                    obj.get("lastName").asString() : "";
                String fullName = (firstName + " " + lastName).trim();
                obj.put("fullName", JsonValue.of(fullName));
                
                // Remove firstName and lastName
                obj.remove("firstName");
                obj.remove("lastName");
                
                return JsonValue.of(obj);
            }
        });
        
        System.out.println("   Transformed (added fullName): " + transformed);
        
        // Filter - keep only certain fields
        JsonValue filtered = filterJson(json, Arrays.asList("firstName", "age"));
        System.out.println("   Filtered (keep firstName, age): " + filtered);
        
        // Map - convert all strings to uppercase
        JsonValue mapped = mapJson(json, new JsonMapper() {
            @Override
            public JsonValue map(JsonValue value) {
                if (value.getType() == JsonValue.JsonType.STRING) {
                    return JsonValue.of(value.asString().toUpperCase());
                }
                return value;
            }
        });
        
        System.out.println("   Mapped (uppercase strings): " + mapped);
    }
    
    interface JsonTransformer {
        JsonValue transform(JsonValue input);
    }
    
    interface JsonMapper {
        JsonValue map(JsonValue value);
    }
    
    @SuppressWarnings("unchecked")
    private static JsonValue transformJson(JsonValue input, JsonTransformer transformer) {
        if (input.getType() == JsonValue.JsonType.OBJECT) {
            Map<String, JsonValue> obj = input.asObject();
            Map<String, JsonValue> newObj = new LinkedHashMap<>();
            for (Map.Entry<String, JsonValue> entry : obj.entrySet()) {
                newObj.put(entry.getKey(), transformJson(entry.getValue(), transformer));
            }
            return transformer.transform(JsonValue.of(newObj));
        } else if (input.getType() == JsonValue.JsonType.ARRAY) {
            List<JsonValue> list = input.asArray();
            List<JsonValue> newList = new ArrayList<>();
            for (JsonValue val : list) {
                newList.add(transformJson(val, transformer));
            }
            return JsonValue.of(newList);
        } else {
            return transformer.transform(input);
        }
    }
    
    @SuppressWarnings("unchecked")
    private static JsonValue filterJson(JsonValue input, List<String> keepFields) {
        if (input.getType() != JsonValue.JsonType.OBJECT) return input;
        
        Map<String, JsonValue> obj = input.asObject();
        Map<String, JsonValue> filtered = new LinkedHashMap<>();
        
        for (String field : keepFields) {
            if (obj.containsKey(field)) {
                filtered.put(field, obj.get(field));
            }
        }
        
        return JsonValue.of(filtered);
    }
    
    @SuppressWarnings("unchecked")
    private static JsonValue mapJson(JsonValue input, JsonMapper mapper) {
        if (input.getType() == JsonValue.JsonType.OBJECT) {
            Map<String, JsonValue> obj = input.asObject();
            Map<String, JsonValue> newObj = new LinkedHashMap<>();
            for (Map.Entry<String, JsonValue> entry : obj.entrySet()) {
                newObj.put(entry.getKey(), mapJson(entry.getValue(), mapper));
            }
            return JsonValue.of(newObj);
        } else if (input.getType() == JsonValue.JsonType.ARRAY) {
            List<JsonValue> list = input.asArray();
            List<JsonValue> newList = new ArrayList<>();
            for (JsonValue val : list) {
                newList.add(mapJson(val, mapper));
            }
            return JsonValue.of(newList);
        } else {
            return mapper.map(input);
        }
    }
    
    /**
     * Demonstrates JSON comparison
     */
    private static void demonstrateJsonComparison() {
        System.out.println("\n--- JSON Comparison ---");
        
        Map<String, JsonValue> map1 = new LinkedHashMap<>();
        map1.put("name", JsonValue.of("John"));
        map1.put("age", JsonValue.of(30));
        JsonValue json1 = JsonValue.of(map1);
        
        Map<String, JsonValue> map2 = new LinkedHashMap<>();
        map2.put("name", JsonValue.of("John"));
        map2.put("age", JsonValue.of(30));
        JsonValue json2 = JsonValue.of(map2);
        
        Map<String, JsonValue> map3 = new LinkedHashMap<>();
        map3.put("name", JsonValue.of("Jane"));
        map3.put("age", JsonValue.of(25));
        JsonValue json3 = JsonValue.of(map3);
        
        System.out.println("   json1: " + json1);
        System.out.println("   json2: " + json2);
        System.out.println("   json3: " + json3);
        
        // Structural equality
        System.out.println("\n   Structural equality:");
        System.out.println("   json1 equals json2: " + json1.toString().equals(json2.toString()));
        System.out.println("   json1 equals json3: " + json1.toString().equals(json3.toString()));
        
        // Deep comparison
        System.out.println("\n   Deep comparison:");
        System.out.println("   json1 deep equals json2: " + deepEquals(json1, json2));
        System.out.println("   json1 deep equals json3: " + deepEquals(json1, json3));
        
        // Diff
        System.out.println("\n   Differences:");
        Map<String, String> diff = computeDiff(json1, json3);
        for (Map.Entry<String, String> entry : diff.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    private static boolean deepEquals(JsonValue a, JsonValue b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        if (a.getType() != b.getType()) return false;
        
        switch (a.getType()) {
            case OBJECT:
                Map<String, JsonValue> mapA = a.asObject();
                Map<String, JsonValue> mapB = b.asObject();
                if (mapA.size() != mapB.size()) return false;
                for (Map.Entry<String, JsonValue> entry : mapA.entrySet()) {
                    if (!mapB.containsKey(entry.getKey())) return false;
                    if (!deepEquals(entry.getValue(), mapB.get(entry.getKey()))) return false;
                }
                return true;
                
            case ARRAY:
                List<JsonValue> listA = a.asArray();
                List<JsonValue> listB = b.asArray();
                if (listA.size() != listB.size()) return false;
                for (int i = 0; i < listA.size(); i++) {
                    if (!deepEquals(listA.get(i), listB.get(i))) return false;
                }
                return true;
                
            case STRING:
                return a.asString().equals(b.asString());
                
            case NUMBER:
                return a.asNumber().equals(b.asNumber());
                
            case BOOLEAN:
                return a.asBoolean().equals(b.asBoolean());
                
            case NULL:
                return true;
                
            default:
                return false;
        }
    }
    
    private static Map<String, String> computeDiff(JsonValue a, JsonValue b) {
        Map<String, String> diff = new LinkedHashMap<>();
        
        if (a.getType() != b.getType()) {
            diff.put("type", a.getType() + " vs " + b.getType());
            return diff;
        }
        
        if (a.getType() == JsonValue.JsonType.OBJECT) {
            Map<String, JsonValue> mapA = a.asObject();
            Map<String, JsonValue> mapB = b.asObject();
            
            // Keys in A but not in B
            for (String key : mapA.keySet()) {
                if (!mapB.containsKey(key)) {
                    diff.put(key, "only in first: " + mapA.get(key));
                }
            }
            
            // Keys in B but not in A
            for (String key : mapB.keySet()) {
                if (!mapA.containsKey(key)) {
                    diff.put(key, "only in second: " + mapB.get(key));
                }
            }
            
            // Common keys with different values
            for (String key : mapA.keySet()) {
                if (mapB.containsKey(key)) {
                    if (!deepEquals(mapA.get(key), mapB.get(key))) {
                        diff.put(key, mapA.get(key) + " != " + mapB.get(key));
                    }
                }
            }
        }
        
        return diff;
    }
    
    // =========================================================================
    // PART 3: JSON SCHEMA AND VALIDATION
    // =========================================================================
    
    static class JsonSchema {
        private final Map<String, Object> schema;
        
        public JsonSchema(Map<String, Object> schema) {
            this.schema = new LinkedHashMap<>(schema);
        }
        
        public boolean validate(Map<String, Object> data) {
            return validateWithErrors(data).isEmpty();
        }
        
        @SuppressWarnings("unchecked")
        public List<String> validateWithErrors(Map<String, Object> data) {
            List<String> errors = new ArrayList<>();
            
            // Check type
            String type = (String) schema.get("type");
            if (type != null && !"object".equals(type)) {
                errors.add("Schema type must be object for this validator");
            }
            
            // Check required fields
            List<String> required = (List<String>) schema.get("required");
            if (required != null) {
                for (String field : required) {
                    if (!data.containsKey(field)) {
                        errors.add("Missing required field: " + field);
                    }
                }
            }
            
            // Validate properties
            Map<String, Map<String, Object>> properties = 
                (Map<String, Map<String, Object>>) schema.get("properties");
            
            if (properties != null) {
                for (Map.Entry<String, Map<String, Object>> prop : properties.entrySet()) {
                    String field = prop.getKey();
                    Map<String, Object> constraints = prop.getValue();
                    
                    if (data.containsKey(field)) {
                        Object value = data.get(field);
                        validateField(field, value, constraints, errors);
                    }
                }
            }
            
            return errors;
        }
        
        private void validateField(String field, Object value, 
                                   Map<String, Object> constraints, 
                                   List<String> errors) {
            String type = (String) constraints.get("type");
            
            // Type validation
            if ("string".equals(type)) {
                if (!(value instanceof String)) {
                    errors.add(field + " should be a string");
                } else {
                    String strVal = (String) value;
                    
                    // String length validation
                    if (constraints.containsKey("minLength")) {
                        int min = ((Number) constraints.get("minLength")).intValue();
                        if (strVal.length() < min) {
                            errors.add(field + " is too short (min: " + min + ")");
                        }
                    }
                    
                    if (constraints.containsKey("maxLength")) {
                        int max = ((Number) constraints.get("maxLength")).intValue();
                        if (strVal.length() > max) {
                            errors.add(field + " is too long (max: " + max + ")");
                        }
                    }
                    
                    // Pattern validation
                    if (constraints.containsKey("pattern")) {
                        String pattern = (String) constraints.get("pattern");
                        if (!strVal.matches(pattern)) {
                            errors.add(field + " does not match pattern: " + pattern);
                        }
                    }
                }
            } else if ("integer".equals(type)) {
                if (!(value instanceof Number)) {
                    errors.add(field + " should be a number");
                } else {
                    Number numVal = (Number) value;
                    
                    // Range validation
                    if (constraints.containsKey("minimum")) {
                        double min = ((Number) constraints.get("minimum")).doubleValue();
                        if (numVal.doubleValue() < min) {
                            errors.add(field + " is below minimum (min: " + min + ")");
                        }
                    }
                    
                    if (constraints.containsKey("maximum")) {
                        double max = ((Number) constraints.get("maximum")).doubleValue();
                        if (numVal.doubleValue() > max) {
                            errors.add(field + " is above maximum (max: " + max + ")");
                        }
                    }
                }
            } else if ("boolean".equals(type)) {
                if (!(value instanceof Boolean)) {
                    errors.add(field + " should be a boolean");
                }
            } else if ("array".equals(type)) {
                if (!(value instanceof List)) {
                    errors.add(field + " should be an array");
                }
            }
        }
    }
    
    /**
     * Demonstrates JSON schema concepts
     */
    private static void demonstrateJsonSchema() {
        System.out.println("\n--- JSON Schema Concepts ---");
        
        // Define a schema
        Map<String, Object> personSchema = new LinkedHashMap<>();
        personSchema.put("type", "object");
        
        Map<String, Object> properties = new LinkedHashMap<>();
        
        Map<String, Object> nameProp = new LinkedHashMap<>();
        nameProp.put("type", "string");
        nameProp.put("minLength", 2);
        nameProp.put("maxLength", 50);
        nameProp.put("pattern", "^[A-Za-z ]+$");
        properties.put("name", nameProp);
        
        Map<String, Object> ageProp = new LinkedHashMap<>();
        ageProp.put("type", "integer");
        ageProp.put("minimum", 0);
        ageProp.put("maximum", 150);
        properties.put("age", ageProp);
        
        Map<String, Object> emailProp = new LinkedHashMap<>();
        emailProp.put("type", "string");
        emailProp.put("pattern", "^[A-Za-z0-9+_.-]+@(.+)$");
        properties.put("email", emailProp);
        
        personSchema.put("properties", properties);
        personSchema.put("required", Arrays.asList("name", "age"));
        
        System.out.println("   JSON Schema defined:");
        System.out.println(convertMapToJson(personSchema));
        
        JsonSchema schema = new JsonSchema(personSchema);
        
        // Test data
        List<Map<String, Object>> testData = new ArrayList<>();
        
        Map<String, Object> validPerson = new LinkedHashMap<>();
        validPerson.put("name", "John Doe");
        validPerson.put("age", 30);
        validPerson.put("email", "john@example.com");
        testData.add(validPerson);
        
        Map<String, Object> invalidPerson1 = new LinkedHashMap<>();
        invalidPerson1.put("name", "J"); // Too short
        invalidPerson1.put("age", 30);
        testData.add(invalidPerson1);
        
        Map<String, Object> invalidPerson2 = new LinkedHashMap<>();
        invalidPerson2.put("name", "Jane123"); // Contains numbers
        invalidPerson2.put("age", -5); // Negative age
        testData.add(invalidPerson2);
        
        Map<String, Object> invalidPerson3 = new LinkedHashMap<>();
        invalidPerson3.put("name", "Bob");
        // Missing age (required)
        testData.add(invalidPerson3);
        
        Map<String, Object> invalidPerson4 = new LinkedHashMap<>();
        invalidPerson4.put("name", "Alice");
        invalidPerson4.put("age", 25);
        invalidPerson4.put("email", "invalid-email"); // Invalid email
        testData.add(invalidPerson4);
        
        demonstrateJsonSchemaValidation(schema, testData);
    }
    
    private static void demonstrateJsonSchemaValidation(JsonSchema schema, 
                                                       List<Map<String, Object>> testData) {
        System.out.println("\n   Validating against schema:");
        for (int i = 0; i < testData.size(); i++) {
            Map<String, Object> data = testData.get(i);
            System.out.println("\n   Person " + (i+1) + ": " + convertMapToJson(data));
            
            List<String> errors = schema.validateWithErrors(data);
            if (errors.isEmpty()) {
                System.out.println("   ✓ Valid");
            } else {
                System.out.println("   ✗ Invalid:");
                for (String error : errors) {
                    System.out.println("     - " + error);
                }
            }
        }
    }
    
    /**
     * Prints summary of all methods covered
     */
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("SUMMARY OF ALL OBJECT AND JSON METHODS");
        System.out.println("=".repeat(100));
        
        String[][] summary = {
            {"1-11", "java.lang.Object", "11 core object methods"},
            {"12-15", "Object Cloning", "clone(), shallow/deep copy, copy constructor"},
            {"16-20", "Thread Coordination", "wait(), notify(), notifyAll() variants"},
            {"21-25", "Type-safe JSON", "JsonValue wrapper with type safety"},
            {"26-30", "JSON Generation", "StringBuilder, Formatter, Streams, Templates"},
            {"31-35", "JSON Parsing", "Pattern matching, Scanner, token parsing"},
            {"36-40", "JSON Validation", "Braces balance, quote balance, structure"},
            {"41-45", "JSON Path Queries", "Nested value access, array indexing"},
            {"46-50", "JSON Transformation", "transform(), filter(), map()"},
            {"51-55", "JSON Comparison", "deepEquals(), diff computation"},
            {"56-60", "JSON Schema", "type validation, required fields, patterns"}
        };
        
        System.out.println("\nMethod Categories:");
        for (String[] row : summary) {
            System.out.printf("   %-8s | %-25s | %s%n", row[0], row[1], row[2]);
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.println("TOTAL: Over 60 Object and JSON methods demonstrated");
        System.out.println("=".repeat(100));
    }
}