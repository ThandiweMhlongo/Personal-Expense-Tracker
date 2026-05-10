# Personal-Expense-Tracker

## Introduction
SimpleSpend is a lightweight, web-based application designed to help individuals regain control of their financial health. The system allows users to log daily expenses, categorize them, and visualize their spending habits through a clean, intuitive interface. By providing a centralized place for financial tracking, SimpleSpend eliminates the need for messy spreadsheets or manual paper logging.

## 1. Language Choice
Language: Java 17

Build Tool: Maven

Rationale: I chose Java because it is a strongly typed language, which means it helps catch mistakes early. Maven is used to manage dependencies like JUnit 5, ensuring that the testing environment is consistent for all developers.

## 2. Design Patterns & Rationales
|Pattern| Where its used|Why it was used|
|-------|------------|------------------|
|Singleton|DatabaseSingleton|We only ever need one DatabaseManager to talk to our data. This prevents multiple connections from getting tangled up.|
|Simple Factory|CategoryFactory|Instead of creating "General" or "Custom" categories everywhere, we have one factory that knows how to make them perfectly.|
|Factory Method|ExporterProvider|This allows the system to support different ways to save data (like CSV) without changing the core expense code.| 
|Abstract Factory|UserAccountFactory|When a new person joins SimpleSpend, we need to make a "Matching Set" of a User and a Budget at the exact same time.|
|Builder|ExpenseBuilder|The Expense class has many parts (ID, amount, date, description). The Builder lets us add them one-by-one so we don't mix them up.|
|Prototype|ExpenseRegistry|For repeating costs (like Rent), we use a "Copy Cat" to clone an existing expense instead of typing it all over again.|

## 3. Key Design Decisions
Encapsulation: All attributes in the model classes (like amount in Expense) are private. This keeps our data safe from being changed by accident.

Separation of Concerns: We put our "Toys" (Models) in one drawer and our "Machines" (Creational Patterns) in another drawer to keep the project organized.

Testing-First: We implemented Unit Tests for every pattern to ensure that when we "press a button," the right object comes out.

## 4. How to Run the Project
Ensure you have Java 17 and IntelliJ installed.

Open the project and wait for Maven to load the pom.xml.

To run tests: Right-click the src/test/java folder and select "Run All Tests".

## Assignment 11: Implementing a Persistence Repository Layer

## Repository Interdace Design Justification

## Use of Generics:
I implemented a base generic interface Repository<T, ID> located in the com.simplespend.repositories package.

## Avoidance of Duplication: 
Instead of defining save(), findById(), findAll(), and delete() separately for Expense, Category, and Budget, I used a generic type <T> for the entity and <ID> for the primary key.

## Consistency: 
This ensures that all repository implementations follow a uniform CRUD (Create, Read, Update, Delete) contract, making the system easier to maintain and extend.

## Entity-Specific Interfaces
I created specific interfaces like ExpenseRepository and CategoryRepository that extend the generic Repository.

## Type Safety: 
By extending the generic interface (e.g., ExpenseRepository extends Repository<Expense, String>), I ensure that the repository only handles the correct domain objects, preventing runtime type errors.

## Extensibility: 
If a specific entity requires a unique query (for example, findByDate() for Expenses), it can be added to the specific interface without cluttering the base generic repository.

By placing these interfaces in a dedicated repositories package, the domain logic (Models) remains completely unaware of how data is stored. This allows the storage mechanism (In-Memory, File System, or SQL) to be swapped out via the RepositoryFactory without changing a single line of business logic in the Expense or User classes.

## Storage-Abstraction Mechanism Justification

## Pattern Choice: Factory Pattern
For this implementation, I chose the Factory Pattern (implemented in RepositoryFactory.java) to handle storage abstraction.

## Why Factory Pattern over Dependency Injection (DI):

Simplicity & Reduced Overhead: Since this project is a standalone Java application without a heavy framework like Spring or Guice, implementing a full DI container would add unnecessary complexity. The Factory Pattern provides a clean, "pojo-friendly" way to swap implementations.

Centralized Control: The RepositoryFactory acts as a single point of truth. If we decide to move from InMemory to Database storage, we only need to update the logic inside the Factory methods.

Dynamic Selection: The Factory allows the application to choose a storage backend at runtime based on a configuration string (e.g., "MEMORY" or "DATABASE"). This is highly effective for testing environments where you might want to use In-Memory storage while using SQL for production.

Decoupling: The client code (the Services or UI) only ever interacts with the interfaces (e.g., ExpenseRepository). It has zero knowledge of the concrete classes like InMemoryExpenseRepository, ensuring a true separation of concerns.

## How it Works:
The RepositoryFactory uses a switch or if-else logic to return the requested implementation:

Calling RepositoryFactory.getExpenseRepository("MEMORY") returns the HashMap based storage.

The system is "Future-Proofed" because adding a new storage type (like JSON or MySQL) simply requires adding a new case to the Factory without breaking existing code.

## Project Links
[SPECIFACTION.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/5f1017936b849cdfcb745ac3efd442b7e36adef9/SPECIFICATION.md)

[ARCHITECTURE.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/51bac2b144d4d2e0ad6ca310c357fad3d4fa2068/C4%20Architectural%20Diagrams.md)

[STAKEHOLDERS.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/41fff5ca03dd330438ceb8d84cbcb5ff6ca43660/Stakeholders.md)

[REQUIREMENTS.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/fd4d5a3427908ef7d3796d65261f484b96b2c41a/REQUIREMENTS.md)

[REFLECTION.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/e244a42f9c5913abe778693ba11acaf2c9316048/Reflection.md)

[Test and Use Case Document.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/bcae817744853f176ec5881cdb7f7aa35ceca05e/Test%20and%20Use%20Case%20Document.md)

[Agile User Stories, Backlog and Sprint Planning](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/910b4f6f4d1f3baf21281a1ee7ad59f051eb04bd/Assignment%206%3A%20Agile%20User%20Stories%2C%20Backlog%2C%20and%20Sprint%20Planning%20for%20the%20System%20%20Objective%20.md)

[Assignment 6: Agile User Stories, Backlog, and Sprint Planning for the System Objective .md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/5cfd92cb62ce06e867af5bb25d85d49371ccc3a8/Assignment%206%3A%20Agile%20User%20Stories%2C%20Backlog%2C%20and%20Sprint%20Planning%20for%20the%20System%20%20Objective%20.md)

[Assignment 7: GitHub Project Templates and Kanban Board Implementation Objective .md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/5cfd92cb62ce06e867af5bb25d85d49371ccc3a8/Assignment%207%3A%20GitHub%20Project%20Templates%20and%20Kanban%20Board%20Implementation%20%20Objective.md)

[Assignment 8: Object State Modeling and Activity Workflow Modeling Objective and Reflection.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/b7c766f4a277cf671f8b093822483f916f8e755d/Assignment%208%3A%20Object%20State%20Modeling%20and%20Activity%20Workflow%20Modeling%20Objective%20and%20Reflection.md)

[Assignment 9: Domain Modeling and Class Diagram Development.md](https://github.com/ThandiweMhlongo/Personal-Expense-Tracker/blob/dc7d1ebabfe8cc1a9d6661d04e40895219c146ff/Assignment%209%3A%20Domain%20Modeling%20and%20Class%20Diagram%20Development.md)
