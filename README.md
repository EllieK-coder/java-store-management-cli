TechStore — Inventory & Sales Management System

A Java console application for managing an electronics store: product inventory, manufacturers, sales transactions, and sales analytics, with data persisted to disk between sessions.

Built as a university project (MSc, University of West Attica) in collaboration with Nektarios Mertinos.

Features

Inventory management Full CRUD for two product categories — computers and mobile phones — each with category-specific attributes (RAM/storage for computers, camera resolution/colour for phones) inherited from a shared Product base class.

Manufacturer management CRUD for manufacturers, with referential integrity enforced: a product cannot be registered against a manufacturer code that does not exist.

Sales processing Sell products by code with automatic stock decrement, guarded against insufficient stock and non-positive quantities. Each transaction is timestamped and logged.

Sales analytics Per-transaction receipt history, total revenue, unit counts per category, and revenue aggregated per manufacturer.

Persistence Inventory and manufacturer data are loaded from delimited text files at startup and written back on every structural change, so state survives restarts. If no data files are found, the application seeds itself with initial demo data.

Architecture
Class	Responsibility
Product	Base class — code, description, price, quantity
Computers	Extends Product — adds manufacturer, RAM, storage
MobilePhones	Extends Product — adds manufacturer, camera resolution, colour
Manufacturers	Manufacturer code, name, contact email
Sales	A single transaction — product, quantity, computed total, timestamp
Registry	Owns the inventory and manufacturer collections; lookup and seeding
Main	Menu-driven UI, input validation, persistence, analytics

Demonstrates inheritance, polymorphism (instanceof dispatch across mixed collections), encapsulation, and separation of domain model from control flow.

Input validation & edge cases handled

The application was written defensively, since all input arrives from an untrusted console user:

Numeric fields (price, quantity, RAM, storage) reject malformed input via NumberFormatException handling and re-prompt rather than crashing.
Sales quantity is validated against available stock, and non-positive quantities are rejected.
Product codes are matched case-insensitively so lookups behave consistently.
Products cannot be attached to a non-existent manufacturer.
Seeding logic checks for existing records before inserting, preventing duplicate entries on repeated runs.
Missing or empty data files fall back to seed data rather than failing at startup.
Running

Requires JDK 8+.

bash
# from the project directory
ant clean jar
java -jar dist/TechStore.jar

Or open the project in NetBeans and run Main.

Data files (inventory.txt, manufacturers.txt) are created in the working directory on first save.

Roadmap
 JUnit 5 test suite covering the sales and validation logic
 Extract validation into a testable service layer, decoupled from System.in
 Replace flat-file persistence with SQLite
