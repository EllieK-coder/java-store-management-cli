# TechStore — Inventory & Sales Management CLI

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Maven](https://img.shields.io/badge/build-Maven-blue?logo=apachemaven)
![Type](https://img.shields.io/badge/app-console%20(CLI)-lightgrey)

A Java console application for running a small electronics store: product inventory, manufacturers, sales transactions and sales analytics, with data saved to disk between sessions.

> Built as an MSc coursework project at the University of West Attica, in collaboration with Nektarios Mertinos. Later restructured as a standard Maven project.

---

## Demo

The user interface is in Greek. Main menu on startup:

```text
Καλωσορίσατε στο Μενού του καταστήματος!
Παρακαλώ επιλέξτε ένα από τα παρακάτω:
1. Διαχείριση Ηλεκτρονικών Υπολογιστών
2. Διαχείριση Κινητών Τηλεφώνων
3. Διαχείριση Κατασκευαστών
4. Λειτουργίες Πωλήσεων & Στατιστικών
5. Έξοδος
```

*(1. Manage computers · 2. Manage mobile phones · 3. Manage manufacturers · 4. Sales & statistics · 5. Exit)*

---

## Features

| Area | What it does |
| --- | --- |
| **Inventory management** | Full CRUD for two product categories, computers and mobile phones, each with its own attributes (RAM/storage, camera resolution/colour) inherited from a shared `Product` base class. |
| **Manufacturer management** | CRUD for manufacturers, with referential integrity: a product cannot be registered against a manufacturer code that does not exist. |
| **Sales processing** | Sell products by code with automatic stock decrement, guarded against insufficient stock and non-positive quantities. Every transaction is timestamped and logged. |
| **Sales analytics** | Receipt history per transaction, total revenue, units sold per category, and revenue per manufacturer. |
| **Persistence** | Inventory and manufacturers are loaded from delimited text files at startup and saved on every change. If no data files exist, the app seeds itself with demo data. |

---

## Architecture

| Class | Responsibility |
| --- | --- |
| `Product` | Base class: code, description, price, quantity |
| `Computers` | Extends `Product`: adds manufacturer, RAM, storage |
| `MobilePhones` | Extends `Product`: adds manufacturer, camera resolution, colour |
| `Manufacturers` | Manufacturer code, name, contact email |
| `Sales` | A single transaction: product, quantity, computed total, timestamp |
| `Registry` | Owns the inventory and manufacturer collections; lookup and seeding |
| `Main` | Menu-driven UI, input validation, persistence, analytics |

Demonstrates **inheritance**, **polymorphism** (`instanceof` dispatch across a mixed collection), **encapsulation**, and separation of the domain model from control flow.

---

## Input validation & edge cases

All input comes from a console user, so the app is written defensively:

- **Malformed numbers** (price, quantity, RAM, storage) are caught via `NumberFormatException` and re-prompted instead of crashing.
- **Sales quantity** is checked against available stock; zero or negative quantities are rejected.
- **Product codes** are matched case-insensitively, so lookups behave consistently.
- **Unknown manufacturers** cannot be attached to a product.
- **Seeding** checks for existing records first, so repeated runs don't create duplicates.
- **Missing or empty data files** fall back to seed data rather than failing at startup.

---

## Project structure

```text
java-store-management-cli/
├── pom.xml
├── README.md
└── src/main/java/
    ├── Main.java
    ├── Registry.java
    ├── Product.java
    ├── Computers.java
    ├── MobilePhones.java
    ├── Manufacturers.java
    └── Sales.java
```

---

## Running

**Requirements:** JDK 21+ and Maven (or an IDE with Maven support, such as VS Code with the Java extension pack or IntelliJ IDEA).

```bash
git clone https://github.com/EllieK-coder/java-store-management-cli.git
cd java-store-management-cli
mvn package
java -jar target/techstore.jar
```

Or open the folder in VS Code / IntelliJ and run `Main`.

The data files `inventory.txt` and `manufacturers.txt` are created in the working directory on first save.

> **Windows tip:** the UI uses Greek characters. If they appear garbled, switch the terminal to UTF-8 first:
> ```powershell
> chcp 65001
> java "-Dstdout.encoding=UTF-8" -jar target/techstore.jar
> ```

---

## Roadmap

- [x] Restructure into a standard Maven project
- [ ] JUnit 5 test suite for the sales and validation logic
- [ ] Extract validation into a testable service layer, decoupled from `System.in`
- [ ] Split `Main` into smaller classes (menus, persistence, analytics)
- [ ] English UI option
- [ ] Replace flat-file persistence with SQLite
