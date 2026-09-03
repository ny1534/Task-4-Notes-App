import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NotesApp {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to Simple Notes App ===");

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Write a Note");
            System.out.println("2. Read All Notes");
            System.out.println("3. Clear All Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (1-4): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    clearNotes();
                    break;
                case 4:
                    System.out.println("Exiting... Notes saved in notes.txt");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    
    private static void writeNote(Scanner scanner) {
        System.out.println("\nEnter your note (press Enter to save):");
        String note = scanner.nextLine();

        if (note.trim().isEmpty()) {
            System.out.println("Note cannot be empty!");
            return;
        }

   
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String timeStamp = dtf.format(LocalDateTime.now());

        
        try (FileWriter writer = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write("[" + timeStamp + "] " + note);
            bw.newLine(); 
            System.out.println(">>> Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    
    private static void readNotes() {
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("\nNo notes found! File is empty.");
            return;
        }

        System.out.println("\n--- Your Notes from " + FILE_NAME + " ---");
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--- End of Notes ---");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    
    private static void clearNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) { // false = overwrite
            writer.write(""); 
            System.out.println("All notes cleared!");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
}