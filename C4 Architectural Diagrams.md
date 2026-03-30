## C4 Architectural Diagrams

## Project Title: 
SimpleSpend: Personal Expense Tracker

## Domain: 
Personal Finance

## Problem Statement: 
To provide a secure and simple way for users to track spending 
without external bank integrations.

## Individual Scope: 
Feasibility is maintained by using a monolithic 
architecture with a single backend service and a local database.

## Level 1: System Context Diagram
How the SimpleSpend system interacts with the User and external things like the Currency API or Backup Storage:
```mermaid
graph LR
    User[Primary User] --- SS[SimpleSpend System]
    SS --- CurrencyAPI[External Currency API]
    SS --- Backup[Local or Cloud Backup]

    style SS fill:#f9f,stroke:#333,stroke-width:4px
```

## Level 2: Container Diagram
Shows the high-level technical building blocks. It explains that the system is split into a Frontend (UI), a Backend (API/Logic), and a Database (Storage):
```mermaid
graph TD
    subgraph Client_Browser [Client Device]
        UI[Web or Mobile UI]
    end

    subgraph SimpleSpend_Backend [Backend Container]
        API[Backend API App]
        Logic[Business Logic and Calculations]
    end

    subgraph Storage_Container [Data Storage]
        DB[(SQLite Database)]
    end

    UI --> API
    API --> Logic
    Logic --> DB
```
