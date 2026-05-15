Library Management System

Student: Khush tailor

Student ID: 257 3549

Package: org.khush

Project Overview
This Library Management System is a Java-based application designed to manage digital and physical assets
(Books, DVDs, Magazines) and user accounts (Students, Teachers, Admins). The system features automated ID
 generation, persistent CSV storage, and advanced searching capabilities using both recursive and stream-based logic.

Technical Specifications
Language: Java 23
Build Tool: Maven
Core Libraries:

Project Lombok: For automated boilerplate reduction (Getters, Setters, ToString).

JUnit 5: For unit testing domain logic.

Persistence: CSV flat-file storage for items and users.

System Architecture
Domain Hierarchy
Item (Abstract): Base class for all library assets.

Automatically generates 4-digit IDs (e.g., 0001).

Subclasses: Book (Author, ISBN, Genre), DVD (Director, Duration), and Magazine (Issue Number, Publisher).

Tracks availability via Item.Status enum (IN_STORE, BORROWED, LOST).

User (Abstract): Base class for library members.

Automatically generates 5-digit IDs (e.g., 00001).

Subclasses: Student, Teacher, and Admin.

Reportable (Interface): Implemented by the Admin class to provide system-wide reporting.

Business Rules (Borrow & Return)
The system enforces strict borrowing limits and role-based restrictions within the Library.java service. Violations trigger a LibraryOperationException.
User Role,Item Limit,Specific Restrictions
Admin,	10000000,	Prohibited from borrowing any items.
Student,	5,	Can borrow Books only.
Teacher,	10,	Can borrow any item type (Book, DVD, Magazine).

Key Features
Advanced Searching
Stream Search: Case-insensitive title searching using the Java Stream API for high performance.

Recursive Search: A deep-search method implemented recursively to find all Book objects by a specific author.

Data Persistence
CSV Loading: The system parses items.csv and users.csv, resolving item IDs into object references to maintain relationship integrity.

CSV Exporting: Users and items (including their specific subclass metadata) can be exported back to CSV files to save state.

Reporting
Admins can generate three types of formatted reports:

List of items by a specific status.

All items grouped into sections by status.

A comprehensive listing of all library users.

Project Structure

src/main/java/org/khush/
  ├── domain/                # Main entities (Book, DVD, Magazine, Student, etc.)
  ├── Library.java           # Core controller and logic
  ├── Reportable.java        # Reporting interface
  ├── LibraryOperationException.java # Custom error handling
  └── Main.java              # Application entry point
src/main/resources/
  ├── items.csv              # Asset database
  └── users.csv              # User database

Setup & Execution
Ensure JDK 23 and Maven are installed.

Enable Annotation Processing in your IDE (required for Lombok).

CSV files must be placed in src/main/resources/ for the loadAll() and exportAll() methods to function.
	


