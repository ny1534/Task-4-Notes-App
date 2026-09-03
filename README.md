# Task-4: Simple Notes App - Java File I/O

A simple console-based Notes application that stores notes permanently using Java File I/O concepts.

### Objective
To learn how to persist data in Java using `FileWriter` and `FileReader`. The notes remain saved even after the program is closed.

### Features
1.  **Write Note:** Appends a new note to `notes.txt` file with a Timestamp.
2.  **Read Notes:** Reads and displays all saved notes from the file.
3.  **Clear Notes:** Deletes all notes from the file.
4.  **Menu Driven:** User-friendly loop until user exits.

### Concepts Used
- **FileWriter with Append Mode:** `new FileWriter(FILE_NAME, true)` is used so that old notes are not overwritten.
- **BufferedReader & BufferedWriter:** For efficient reading/writing of text.
- **Try-with-Resources:** Automatically closes the file resources to prevent memory leaks.
- **Exception Handling:** `IOException` is handled for file errors.
- **Timestamp:** `LocalDateTime` is used to add date & time to each note.

### How to Run
1. Compile the file:
   ```bash
   javac NotesApp.java
