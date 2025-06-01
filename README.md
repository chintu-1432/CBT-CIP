# 📚 Library Catalog System (Java)

A beginner-friendly Java mini project that allows users to manage a catalog of books through a console interface. This application enables users to add books, view the complete library, and search books by title or author. It uses *file-based storage* (books.txt) to maintain book data between sessions — making it practical for real-world learning and simple deployment.

---

## 🔍 Project Overview

The *Library Catalog System* is a console-based Java program built for educational use or as a mini-project submission. It follows a modular object-oriented design, separating book logic, catalog management, and user interface into different Java classes.

Unlike other examples found online, this project is *100% custom-coded* with user-friendly features like emoji prompts, clear menu-driven input, and structured output formatting. It does not require any frameworks or databases — making it ideal for Java beginners.

---

## ✨ Key Features

- ➕ Add new books (title, author, ISBN)
- 📖 Display all stored books in a formatted list
- 🔎 Search for books by *title*
- 🔍 Search for books by *author*
- 💾 File-based data persistence using books.txt
- 🧼 Clean user interface with input validation
- 🗃 Simple folder structure (no src/ folder)

---

## 🗂 File Structure

LibraryCatalogSystem/
├── Book.java                 # Book class (title, author, isbn)
├── LibraryCatalog.java       # Manages book list and file operations
├── LibraryCatalogSystem.java # Main class with interactive menu
├── books.txt                 # Auto-created file storing book data


> 📌 Note: books.txt is created automatically after adding the first book.

---

## 🛠 Technologies Used

- *Java* (JDK 8 or later)
- File I/O (FileWriter, Scanner)
- Object-Oriented Programming (OOP)
- Console-based user input/output

---

## 🚀 How to Compile and Run

### 💻 Step-by-Step:

1. Make sure all .java files are in the same folder (e.g., LibraryCatalogSystem/).
2. Open terminal or command prompt inside that folder.

3. Compile all Java files:

```bash
javac *.java

Run main program:
java LibraryCatalogSystem

Sample Console output:


Welcome to the Library Catalog System
======= MENU =======
1  Add Book
2  Show All Books
3  Search by Title
4  Search by Author
0  Exit
Choose an option:


 Use Cases
	• College mini projects or lab assignments
	• Java learners practicing file handling and OOP
	• Simple backend for library or inventory systems
	• Resume or GitHub portfolio demonstration


Learning Outcomes

By working with this project, you will understand:
	• How to design clean Java classes using constructors and methods.
	• How to store and retrieve data from a file (persistence).
	• How to create a command-line user interface.
	• How to use Scanner, exception handling, and conditionals.

License

This project is open-source and free to use for educational or personal purposes. No external libraries or templates have been used.

AUTHOR & CREDITS

Developed by: A.Mallaiah Chowdary
Email: mallaiahchowdhary2432@gmail.com



