# Object-Oriented Programming in Java: Lab Solutions

Solutions to every exercise in Labs 1 to 10 and the Lab 11 mini-project.
Requires **JDK 17 or later** (tested on JDK 21).

## How to run

```
./run-all.sh                          # compile and run everything
cd lab05 && javac *.java && java PayrollDemo      # or one lab at a time
cd lab11 && javac *.java && java LibraryApp       # the interactive mini-project
```

Each lab has its own folder because several labs reuse class names (`Student`, `BankAccount`, `Temperature`).
Always compile with `javac *.java` inside the lab folder.

## Exercise map (run the class named in the last column)

| Lab | Exercise | Run |
|---|---|---|
| 1 | Car, isAntique() | `CarDemo` |
| 1 | Rectangle array, largest area; aliasing r2 = r1 | `RectangleDemo` |
| 1 | Address / Person, chained dot, null | `PersonDemo` |
| 2 | Circle constructors + static counter | `CircleDemo` |
| 2 | Employee: static id, 3 overloads, copy constructor | `EmployeeDemo` |
| 2 | Two static + two instance blocks | `StaticBlocksDemo` |
| 2 | Temperature static factories | `TemperatureDemo` |
| 3 | Student with validation + getGrade() | `StudentDemo` |
| 3 | BankAccount history, unmodifiable copy | `BankDemo` |
| 3 | ImmutablePerson | `ImmutablePersonDemo` |
| 3 | Temperature stored in kelvin | `TemperatureDemo` |
| 4 | Person / Student / Teacher | `PersonDemo` |
| 4 | Vehicle / Car / ElectricCar constructor order | `VehicleDemo` |
| 4 | Dog extends Animal(String) | `DogDemo` (explanation in `Dog.java`) |
| 4 | Stack: inheritance vs composition | `StackDemo` |
| 5 | Overloaded print | `PrintDemo` |
| 5 | Animal[] polymorphism | `AnimalDemo` |
| 5 | Payroll with Intern | `PayrollDemo` |
| 5 | Field vs method through a superclass reference | `FieldVsMethodDemo` |
| 5 | PaymentProcessor: instanceof vs polymorphism | `BankPaymentDemo` |
| 6 | Abstract Shape | `ShapeDemo` |
| 6 | Flyable interface | `FlyDemo` |
| 6 | Abstract Account | `AccountDemo` |
| 6 | Comparable + Comparator | `StudentSortDemo` |
| 6 | Conflicting default methods | `DefaultConflictDemo` |
| 7 | Divide with Scanner | `DivideDemo` (type input) |
| 7 | ArrayIndexOutOfBounds | `ArrayAccessDemo` |
| 7 | InvalidAgeException | `AgeValidator` |
| 7 | InsufficientFundsException | `BankDemo` |
| 7 | return inside try + finally | `FinallyDemo` |
| 8 | ArrayList sum / max / reverse | `ListStats` |
| 8 | Remove duplicates with a Set | `RemoveDuplicates` |
| 8 | Generic Stack<T> | `MyStackDemo` |
| 8 | Word frequency, sorted | `WordFrequency` |
| 8 | Generic bubbleSort | `BubbleSortDemo` |
| 9 | enum Level + switch | `LevelDemo` |
| 9 | record Student | `RecordDemo` |
| 9 | Book equals/hashCode in a HashSet | `BookSetDemo` |
| 9 | LinkedList with nested Node + inner iterator | `LinkedListDemo` |
| 9 | Coin enum, fewest coins | `CoinDemo` |
| 10 | Save 5 lines and read back | `FileEchoDemo` (type 5 lines) |
| 10 | removeIf with Predicate | `RemoveEvenDemo` |
| 10 | Lines / words / characters of a file | `FileStats [file]` |
| 10 | Streams: above-average names, sorted | `AboveAverageDemo` |
| 10 | learners.csv grouped by band, one report each | `LearnerReport` |
| 11 | Library management mini-project | `LibraryApp` (interactive), `LibraryDemo` (scripted) |

## Written answers for the lab record

**1. Aliasing (Lab 1).** `Rectangle r2 = r1;` copies the *reference*, not the object. Both variables point to the same
object on the heap, so `r2.width = 99` is visible through `r1`, and the program prints `99.0`.

**2. Static and instance blocks (Lab 2).** Static blocks run once, in written order, when the class loads (before `main`).
Instance blocks run for every `new`, in written order, before the constructor body.

**3. Why static factories can be clearer (Lab 2).** They have names (`fromCelsius(100)` vs an ambiguous `new Temperature(100)`),
two constructors cannot share the signature `(double)`, they can validate or convert first, and they can return cached
objects or subclasses.

**4. Immutable class design (Lab 3).** `final` class (no subclass can add mutable behaviour), `private final` fields
(set once), no setters, defensive copy of the mutable list on the way in, and an unmodifiable list on the way out.
"Changes" return a new object (`withAge`).

**5. Hidden unit (Lab 3).** `TemperatureDemo.report()` only calls public methods, and works unchanged with a kelvin-based
class and a Celsius-based class. The stored unit is a private detail.

**6. Dog extends Animal (Lab 4).** Every constructor must begin with a `super(...)` call; if you do not write one the
compiler inserts `super()`. `Animal(String)` is the only constructor, so there is no no-arg version to call and
compilation fails. Fix: `Dog(String n) { super(n); }`.

**7. Stack extends ArrayList (Lab 4).** It exposes `add(index, x)`, `remove(index)`, `get(i)`, `sort`, `clear` and more, so
the last-in-first-out rule can be broken, and a stack is not really a kind of list. Composition exposes only
`push / pop / peek / isEmpty`.

**8. Fields are not polymorphic (Lab 5).** Instance methods are chosen at run time from the real object's class, but fields and
static methods are chosen at compile time from the reference's declared type. `Parent p = new Child();` gives
`p.who()` = Child's, `p.label` = Parent's.

**9. instanceof vs polymorphism (Lab 5).** `instanceof` centralises the logic but forces you to edit the processor for every new
payment type, and the compiler cannot warn you about a missing branch. A polymorphic `process()` lets new types be added
without touching existing code, and the compiler forces each subclass to implement it. Prefer polymorphism when you own
the hierarchy; use `instanceof` for types you cannot change.

**10. Default method conflict (Lab 6).** A class method beats an interface default; a more specific interface beats a
less specific one; if two unrelated interfaces provide the same default, the class must override and may choose with
`InterfaceName.super.hello()`.

**11. boolean vs exception for withdraw (Lab 7).** A boolean is simple and cheap, but callers can ignore it and it carries no
reason. An exception cannot be silently ignored and carries details (shortfall), but is more verbose and slower. Use
exceptions for exceptional conditions, booleans/results for routine outcomes.

**12. finally (Lab 7).** `return` evaluates the value, then the `finally` block runs, then the method returns. `finally`
runs on normal completion, return or exception. Only `System.exit()` or a JVM crash prevents it. A returned
primitive is copied first, so changing the variable in `finally` does not change what was returned.

**13. int[] and generics (Lab 8).** Generics work only with reference types (type arguments are erased to `Object`). `int` is a
primitive and `int[]` is not a `T[]`; use `Integer[]`.

## Mini-project design (Lab 11)

```
Borrowable (interface)            LibraryException (checked)
    ^                                 ^-- ItemNotAvailableException
    |                                 ^-- LoanLimitExceededException
LibraryItem (abstract)                ^-- NotFoundException
   ^        ^
 Book      Dvd        ItemFactory (Factory)      Loan (record)      Member (limit 3)

Library (core logic: maps, borrow/return, overdue, stream search)
LibraryStorage (CSV: data/items.csv, members.csv, loans.csv)
LibraryApp (menu)   LibraryDemo (scripted)
```

| Requirement | Where |
|---|---|
| Abstract `LibraryItem`, subclasses `Book`, `Dvd` | `LibraryItem.java`, `Book.java`, `Dvd.java` |
| `Borrowable` interface | `Borrowable.java`, implemented by `LibraryItem` |
| Custom exceptions | `LibraryException` family |
| Max 3 loans per member | `Member.MAX_LOANS`, `LoanLimitExceededException` |
| Maps | `Library` (`LinkedHashMap` for items, members, loans) |
| CSV persistence | `LibraryStorage` (saved on exit, loaded on start) |
| Menu: add, register, borrow, return, overdue, search | `LibraryApp` options 1 to 4, 7, 8 |
| Stream-based title search | `Library.searchByTitle` |
| Polymorphism | per-type loan period: Book 14 days, DVD 7 days |

Notes: commas are replaced by spaces on input so they cannot break the CSV format. Menu option 9
advances a simulated clock so you can demonstrate the overdue list without waiting days.
#   o o p _ l a b s  
 #   o o p _ l a b s  
 