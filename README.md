# Profiling Tools
- Java VisualVM
- JProfiler or Yourkit
- Thread Dumps and Logs
- Thread Activity
- CPU Profiling
- Memory Profiling
- Lock Contention

# Java Collections — Complete Hierarchy + Explanations

## 1. Iterable
Iterable  
└── **Collection**  
  ├── **List**  
  │  ├── **ArrayList**  
  │  │  - Dynamic array implementation  
  │  │  - Fast random access  
  │  │  - Most commonly used list  
  │  ├── **LinkedList**  
  │  │  - Doubly linked list  
  │  │  - Fast insertion/deletion in middle  
  │  │  - Slower random access  
  │  ├── **Vector** (legacy)  
  │  │  - Synchronized ArrayList  
  │  └── **Stack** (legacy)  
  │    - LIFO stack  
  │    - Use ArrayDeque instead  
  │  
  ├── **Set**  
  │  ├── **HashSet**  
  │  │  - Fast add/remove/contains  
  │  │  - No ordering  
  │  ├── **LinkedHashSet**  
  │  │  - Keeps insertion order  
  │  └── **TreeSet**  
  │    - Sorted set (natural/comparator)  
  │    - Slower but ordered  
  │  
  └── **Queue**  
    ├── **PriorityQueue**  
    │  - Heap-based priority ordering  
    │  - Not FIFO  
    └── **ArrayDeque**  
      - Recommended for Queue and Stack  
      - Faster than LinkedList

---

## 2. Map (Not part of Collection)
Map  
├── **HashMap**  
│  - Fastest key–value store  
│  - No ordering guarantees  
│  └── **LinkedHashMap**  
│    - Maintains insertion order  
│  
├── **TreeMap**  
│  - Sorted map (by key)  
│  - Slower but ordered  
│  
├── **Hashtable** (legacy)  
│  - Synchronized HashMap  
│  
└── **ConcurrentHashMap**  
  - High-performance thread-safe map  
  - Used in multi-threaded environments

---

## 3. Useful Utility Classes
- **Collections**
    - Utility class with static helper methods:
        - sort(), shuffle(), min(), max(), synchronized wrappers
- **Arrays**
    - Utility methods for arrays
    - asList(), sort(), binarySearch()

---

## Quick Summary Table

| Type         | Common Implementations     | Ordered | Sorted | Thread-Safe | Notes |
|--------------|-----------------------------|---------|---------|--------------|-------|
| List         | ArrayList, LinkedList       | Yes*    | No      | No           | ArrayList most used |
| Set          | HashSet, LinkedHashSet, TreeSet | LH only | TS only | No | HashSet is fastest |
| Queue        | ArrayDeque, PriorityQueue   | No      | PQ only | No           | ArrayDeque recommended |
| Map          | HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap | LH only | TM only | CHM only | HashMap most used |

\* List preserves index order by definition.

---

# Java Functional Interfaces (Overview)

Java provides many built-in functional interfaces for lambda expressions.
They are organized into four main categories.

---

# 1. Supplier Family (Provide Values)

## Supplier<T>
- Input: none
- Output: T
- Method: `T get()`

## BooleanSupplier
- Input: none
- Output: boolean
- Method: `boolean getAsBoolean()`

## IntSupplier / LongSupplier / DoubleSupplier
- Return primitive types without boxing.

---

# 2. Consumer Family (Consume Values)

## Consumer<T>
- Input: T
- Output: void
- Method: `void accept(T t)`

## BiConsumer<T, U>
- Input: T, U
- Output: void

## Primitive Consumers
- IntConsumer, LongConsumer, DoubleConsumer
    - Input: primitive
    - Output: void

## ObjIntConsumer<T> / ObjLongConsumer<T> / ObjDoubleConsumer<T>
- Input: (object, primitive)
- Output: void

---

# 3. Predicate Family (Return boolean)

## Predicate<T>
- Input: T
- Output: boolean
- Method: `boolean test(T t)`

## BiPredicate<T, U>
- Input: T, U
- Output: boolean

## Primitive Predicates (not available as built-in)
- Use IntPredicate in Java 11+ if available in your environment.

---

# 4. Function Family (Transform Values)

## Function<T, R>
- Input: T
- Output: R
- Method: `R apply(T t)`

## BiFunction<T, U, R>
- Input: T, U
- Output: R

## Primitive Functions
- IntFunction<R>
- LongFunction<R>
- DoubleFunction<R>

## ToXxxFunction<T>
- ToIntFunction<T>
- ToLongFunction<T>
- ToDoubleFunction<T>

## XxxToYyyFunction
- IntToLongFunction
- IntToDoubleFunction
- LongToIntFunction
- LongToDoubleFunction
- DoubleToIntFunction
- DoubleToLongFunction

## UnaryOperator<T>
- Subtype of Function: (T → T)

## BinaryOperator<T>
- Subtype of BiFunction: (T, T → T)

## Primitive Operators
- IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
- IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator

---

# 5. Additional Useful Interfaces

## Runnable  *(not in java.util.function, but widely used with lambdas)*
- Input: none
- Output: void
- Method: `void run()`

## Callable<V>
- Input: none
- Output: V (can throw Exception)

---

# Quick Summary Table

| Category     | Example Interface | Input | Output | Notes |
|--------------|-------------------|--------|--------|-------|
| Supplier     | Supplier<T> | none | T | Produces values |
| Consumer     | Consumer<T> | T | void | Consumes values |
| Predicate    | Predicate<T> | T | boolean | Used for filtering |
| Function     | Function<T, R> | T | R | Transforms values |
| Operators    | UnaryOperator<T> | T | T | Same input/output |
| Bi-Types     | BiFunction, BiConsumer, BiPredicate | 2 params | varies | Two-argument versions |
| Primitive Versions | IntFunction, IntConsumer, etc. | primitives | primitives | Avoid boxing |

---

# Short Examples

```java
Supplier<String> s = () -> "Hello";
Consumer<String> c = x -> System.out.println(x);
Predicate<Integer> p = n -> n > 10;
Function<String, Integer> f = str -> str.length();
UnaryOperator<Integer> u = n -> n * n;
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
