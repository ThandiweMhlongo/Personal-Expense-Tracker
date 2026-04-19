## 1. Object State Modeling with State Transition Diagrams: 

Object 1: Expense Entry
This object tracks the lifecycle of a single transaction.

```mermaid
stateDiagram-v2
    [*] --> Draft: User opens "Add Expense"
    Draft --> Saved: User clicks "Save"
    Saved --> Edited: User modifies details (FR-8)
    Edited --> Saved: Save changes
    Saved --> Deleted: User deletes entry (FR-8)
    Deleted --> [*]
```

Key States: Draft (unsaved data), Saved (stored in DB), Deleted (removed from view).
Traceability: Maps to FR-2 (Log Expense) and FR-8 (Edit/Delete transactions).

Object 2: User Account
Focuses on security and session management.

```mermaid
stateDiagram-v2
    [*] --> Unauthenticated
    Unauthenticated --> Authenticated: Successful Login (Bcrypt Match)
    Authenticated --> Locked: 3 Failed Attempts
    Locked --> Unauthenticated: Admin Reset
    Authenticated --> TimedOut: 15 mins Inactivity (NFR-6)
    TimedOut --> Unauthenticated: Redirect to Login
    Authenticated --> [*]: User Logs Out
```
  
Key States: Authenticated, Locked (security measure), TimedOut.
Traceability: Maps to FR-1 (Create Account) and NFR-6 (15-minute auto-logout).

Object 3: Monthly Budget
Controls the status of category limits.

```mermaid
stateDiagram-v2
    [*] --> Inactive: No limit set
    Inactive --> Active: User sets budget (FR-5)
    Active --> Warning: Spending > 80% of limit
    Warning --> Exceeded: Spending > 100% of limit
    Exceeded --> Active: User increases limit
    Active --> Inactive: User removes limit
```

Key States: Active, Warning, Exceeded.
Traceability: Maps to FR-5 (Set monthly budget limit).

Object 4: Spending Chart
Ensures the UI stays synchronized with data.

```mermaid
stateDiagram-v2
    [*] --> Empty: No data logged
    Empty --> Rendered: Data entry saved (FR-7)
    Rendered --> Stale: New expense added
    Stale --> Rendered: Auto-refresh triggered (Acceptance Criteria)
    Rendered --> Empty: All data deleted
```

Key States: Stale (needs update), Rendered (current).
Traceability: Maps to FR-7 (Visual charts update immediately).

Object 5: Database Connection (Docker Environment)
Handles the technical availability of the system.

```mermaid
stateDiagram-v2
    [*] --> Initializing: Docker Compose Up
    Initializing --> Connected: Handshake successful
    Connected --> Disconnected: Network Error / Container Stop
    Disconnected --> Initializing: Auto-restart policy
    Connected --> Terminated: Docker Compose Down
```

Traceability: Maps to NFR-2 (Containerized with Docker).

Object 6: CSV Export Job
The temporary process of data extraction.

```mermaid
stateDiagram-v2
    [*] --> Pending: User clicks "Export"
    Pending --> Processing: Formatting data (FR-9)
    Processing --> Ready: File generated
    Ready --> Downloaded: User saves file
    Ready --> Failed: IO Error
    Downloaded --> [*]
```

Traceability: Maps to FR-9 (Export to CSV).

Object 7: Category List
Manages the user's custom classification system.

```mermaid
stateDiagram-v2
    [*] --> DefaultState: System defaults (Food, Rent)
    DefaultState --> Customized: User adds new category (FR-3)
    Customized --> Modified: User edits label
    Modified --> [*]: User deletes category

    state "Default" as DefaultState
```

Traceability: Maps to FR-3 (Editable categories).

Object 8: Currency Context
Handles the global state of displayed values.

```mermaid
stateDiagram-v2
    [*] --> Default_ZAR
    Default_ZAR --> USD_Mode: Switch to USD (FR-10)
    USD_Mode --> EUR_Mode: Switch to EUR
    EUR_Mode --> Default_ZAR: Reset to ZAR
```
Traceability: Maps to FR-10 (Switch between currencies).    

## 2. Activity Workflow Modeling with Activity Diagrams

1. User Registration & Secure Setup
Maps to FR-1 and NFR-5.

```mermaid
graph TD
    A[Start] --> B[Enter username and password]
    B --> C{Username available?}
    C -- Yes --> D[Hash password using Bcrypt]
    D --> E[Save User Record]
    E --> F[Display Success Message]
    F --> G[Stop]
    C -- No --> H[Show 'Username Taken' Error]
    H --> I[Stop]
```

2. Logging a New Expense
Maps to FR-2, FR-3, and NFR-8 (Performance).

```mermaid
graph TD
    subgraph User
        A[Start] --> B[Input Amount, Date, and Category]
        H[View updated History] --> I[End]
    end

    subgraph System
        B --> C{Parallel Tasks}
        subgraph Parallel Processing
            C --> D[Validate data types]
            C --> E[Check Category limits]
            C --> F[Format date string]
        end
        D & E & F --> G[Save transaction to Database]
    end

    G --> H
```  

3. Setting and Monitoring a Budget
Maps to FR-5.

```mermaid
graph TD
    subgraph User_Action
        A([start]) --> B[Select category and enter limit]
    end

    subgraph System_Process
        B --> C[Calculate current spending for category]
        C --> D{Spending > Limit?}
    end

    subgraph User_Feedback
        D -- yes --> E[Show 'Budget Exceeded' Warning]
        D -- no --> F[Show 'Budget Set' Confirmation]
        E --> G([stop])
        F --> G
    end
``` 

4. Visual Chart Refresh Workflow
Maps to FR-7 and NFR-7 (Performance).


```mermaid
graph TD
    subgraph System
        Start([Start]) --> Saved[New expense saved]
    end

    subgraph User
        Saved --> Refresh[Request dashboard refresh]
    end

    subgraph System_Parallel[System Processing]
        Refresh --> ForkNode(( ))
        ForkNode --> Fetch[Fetch category totals]
        Fetch --> Calc[Calculate percentages]
        ForkNode --> Select[Select Chart Type Pie/Bar]
        
        Calc --> JoinNode(( ))
        Select --> JoinNode
        JoinNode --> Render[Render Chart SVG]
    end

    subgraph User_View
        Render --> View[View updated visual distribution]
        View --> End([Stop])
    end
```

5. Exporting Data to CSV
Maps to FR-9.

```mermaid
graph TD
    subgraph User
        A([start]) --> B[Click 'Export to CSV']
    end

    subgraph System
        B --> C[Query all user transactions]
        C --> D[Format data into CSV strings]
        D --> E[Generate temporary file link]
    end

    subgraph User_Action[User]
        E --> F[Download file]
        F --> G([stop])
    end
```

6. Automated Security Timeout
Maps to NFR-6.

```mermaid
graph TD
    subgraph System
        A([start]) --> B[Monitor user activity]
        B --> C{Inactivity > 15 mins?}
        C -- no --> D[Maintain Session]
        D --> E([stop])
        C -- yes --> F[Clear Session Tokens]
        F --> G[Redirect to Login Page]
    end

    subgraph User
        G --> H[See 'Session Expired' message]
        H --> I([stop])
    end
```

7. Editing an Existing Transaction
Maps to FR-8.

```mermaid
graph TD
    subgraph User
        A([start]) --> B[Select transaction to edit]
        B --> C[Update fields]
    end

    subgraph System
        C --> D[Validate new inputs]
        D --> E{Valid?}
        E -- yes --> F[Update Database record]
        F --> G[Refresh monthly totals]
        G --> H([stop])
    end

    subgraph User_Feedback
        E -- no --> I[Show validation errors]
        I --> J([stop])
    end
```

8. Currency Context Switching
Maps to FR-10.

```mermaid
graph TD
    subgraph User
        A([start]) --> B[Select new currency e.g., USD]
    end

    subgraph System
        B --> C[Identify current Exchange Rate]
        C --> D[Convert all stored values for display]
        D --> E[Update Currency Symbols in UI]
    end

    subgraph User_Result[User]
        E --> F[View totals in selected currency]
        F --> G([stop])
    end
```

## 3. Integration with Prior Work:

| Diagram Name | Type | Requirement Link (Assignment 4) | User Story Link (Assignment 6) |
|--------| ---------| ------------| ------------| 
|Expense Lifecycle| State| FR-2, FR-8 | US-002 (Log Expense)|
|User Account Security| State| FR-1, NFR-5, NFR-6 |US-001 (Secure Account)|
|Budget Status| State| FR-5| US-004 (Monthly Budget)|
|Registration Workflow| Activity| FR-1, NFR-5| US-001 (Sign up)|
|Log Expense Workflow| Activity | FR-2, FR-3 |US-002, US-003 (Categorization)|
|Visual Chart Refresh|Activity|FR-7, NFR-7|US-006 (Spending Charts)|
|CSV Export Process| Activity| FR-9| US-007 (Data Export) |
|Docker Deployment| State|NFR-2|US-012 (Containerization)|

## Reflection:
Challenges in Choosing Granularity
The hardest part of this assignment was finding the right balance for granularity. 
When I started the Activity Diagrams, I wanted to map every single click, like "User clicks button" or "System highlights field." 
I quickly realized that this made the diagrams impossible to read and didn't actually explain how the system worked. 
I had to learn to "zoom out." I focused on high-level actions (e.g., "Validate Data") rather than tiny UI steps. This made the 
diagrams much cleaner and more useful for a developer to follow.

Aligning Diagrams with Agile User Stories
Aligning these formal UML diagrams with my Agile User Stories was another challenge. 
User stories are usually very simple and focused on the "why," while these diagrams are technical and focused on the "how."
For example, the user story for logging an expense sounds easy, but the Activity Diagram showed that the system actually 
performs several parallel tasks, like checking budget limits and formatting dates at the same time. 
This alignment helped me realize that some of my Effort Estimates from Assignment 6 were a bit low because 
I hadn't considered all these hidden technical steps.

Comparison: State Diagrams vs. Activity Diagrams
Through this process, I discovered that these two diagrams serve very different purposes:

State Diagrams (Object Behavior): These are about the "status" of a piece of data over its entire life.
For example, an Expense Entry isn't just a row in a table; it moves from a Draft to Saved, and potentially to Deleted. 
It’s about the "what."

Activity Diagrams (Process Flow): These are about the "logic" and the "timer." 
They show the step-by-step path a user takes to achieve a goal. It’s about the "how."

Conclusion
Using Mermaid in my GitHub README made these diagrams feel like a real part of the development process rather than just a school drawing. 
Even though I am the only stakeholder, seeing the User Account state diagram forced me to think about security states (like Locked or Timed Out) 
that I might have forgotten if I had only relied on my original list of requirements.

