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
