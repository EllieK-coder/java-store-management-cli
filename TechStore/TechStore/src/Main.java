
/**
 * Εφαρμογή Διαχείρισης Αποθέματος και Πωλήσεων Καταστήματος Ηλεκτρονικών.
 * * @author  Eυαγγελία Αννα Καλοδημου, Μερτινός Νεκτάριος
 * @version 1.0
 * 
 * @since Ιούνιος 2026
 */




import java.util.ArrayList;
import java.util.Scanner;
/**
 * Κύρια κλάση της εφαρμογής διαχείρισης καταστήματος ηλεκτρονικών ειδών.
 *
 * Η εφαρμογή παρέχει δυνατότητες:
 * 
 * Διαχείρισης ηλεκτρονικών υπολογιστών.</li>
 * Διαχείρισης κινητών τηλεφώνων.</li>
 * Διαχείρισης κατασκευαστών.</li>
 * Πωλήσεων και στατιστικών στοιχείων.</li>
 * Αποθήκευσης και φόρτωσης δεδομένων από αρχεία κειμένου.</li>
 * 
 *
 * 
 * @version 1.0
 */
public class Main {

/**
 * Εκκινεί την εφαρμογή.
 *
 * Δημιουργεί το αντικείμενο Registry, φορτώνει τα δεδομένα,
 * εμφανίζει το κεντρικό μενού και διαχειρίζεται όλες τις επιλογές
 * μέχρι τον τερματισμό της εφαρμογής.
 *
 *
 */    
    public static void main(String[] args) {
        
        Registry reg = new Registry();
        ArrayList<Sales> salesLog = new ArrayList<>(); 

        // Load data from text files at application startup
        loadData(reg.getStoreInventory(), reg.getManufacturerList());
        
        // If files were empty or missing, load fallback mock data
        if (reg.getManufacturerList().isEmpty() && reg.getStoreInventory().isEmpty()) {
            System.out.println(" Δεν βρέθηκαν αρχεία δεδομένων. Φόρτωση αρχικών δοκιμαστικών στοιχείων...");
            reg.InitialData(); 
        }
        
        Scanner menuScanner = new Scanner(System.in);
        boolean running = true;

        // MAIN APPLICATION LOOP
        while (running) {
            System.out.println("\nΚαλωσορίσατε στο Μενού του καταστήματος!");
            System.out.println("Παρακαλώ επιλέξτε ένα από τα παρακάτω:");
            System.out.println("1. Διαχείρηση Ηλεκτρονικών Υπολογιστων");
            System.out.println("2. Διαχείρηση Κινητών Τηλεφώνων");
            System.out.println("3. Διαχείρηση Κατασκευαστών");
            System.out.println("4. Λειτουργίες Πωλήσεων & Στατιστικών");
            System.out.println("5. Έξοδος");
            System.out.print("Παρακαλώ επιλέξτε μια λειτουργία (1-5) : ");
            
            String choice = menuScanner.nextLine().trim();
            switch (choice) {
                
                case "1": // COMPUTER MANAGEMENT SUBMENU
                    boolean inComputerMenu = true;
                    while (inComputerMenu) {
                        System.out.println("\nΜΕΝΟΥ ΥΠΟΛΟΓΙΣΤΩΝ");
                        System.out.println("1. Προβολή");
                        System.out.println("2. Προσθήκη");
                        System.out.println("3. Διόρθωση");
                        System.out.println("4. Διαγραφή");
                        System.out.println("5. Επιστροφή");
                        System.out.print("Επιλογή: ");
                        String compChoice = menuScanner.nextLine().trim();
                        
                        if (compChoice.equals("1")) { 
                            System.out.println("\nΛΙΣΤΑ ΥΠΟΛΟΓΙΣΤΩΝ ");
                            boolean found = false;
                            for (Product p : reg.getStoreInventory()) {
                                if (p instanceof Computers) {
                                    System.out.println("Κωδικός: " + p.code + " | " + p.description + " | Τιμή: " + p.price + "€ | Απόθεμα: " + p.quantity);
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Δεν υπάρχουν καταχωρημένοι υπολογιστές.");
                            }
                        } 
                        else if (compChoice.equals("2")) {
                            System.out.println("\n ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΥΠΟΛΟΓΙΣΤΗ ");
                            System.out.print("Κωδικός: ");
                            String newCode = menuScanner.nextLine().trim();
                            System.out.print("Λεκτικό/Περιγραφή: ");
                            String newDesc = menuScanner.nextLine();
                            
                            double newPrice = 0;
                            while (true) {
                                System.out.print("Τιμή (€): ");
                                try {
                                    newPrice = Double.parseDouble(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println("Λάθος μορφή! Εισάγετε αριθμό."); }
                            }
                                                      
                            int newQty = 0;
                            while (true) {
                                System.out.print("Ποσότητα Αποθέματος: ");
                                try {
                                    newQty = Integer.parseInt(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println(" Λάθος μορφή! Εισάγετε ακέραιο."); }
                            }
                            
                            int newRam = 0;
                            while (true) {
                                System.out.print("Μέγεθος RAM (GB): ");
                                try {
                                    newRam = Integer.parseInt(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println(" Λάθος μορφή! Εισάγετε ακέραιο."); }
                            }
                            
                            int newStorage = 0;
                            while (true) {
                                System.out.print("Αποθηκευτικός Χώρος (GB): ");
                                try {
                                    newStorage = Integer.parseInt(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println(" Λάθος μορφή! Εισάγετε ακέραιο."); }
                            }
                            
                            System.out.print("Κωδικός Κατασκευαστή (e.g. M04): ");
                            String manufCode = menuScanner.nextLine().trim();
                            Manufacturers userManuf = reg.GetManufacturerbyCode(manufCode);
                            
                            if (userManuf == null) {
                                System.out.println(" Δεν υπάρχει κατασκευαστής με αυτόν τον κωδικό! Η καταχώρηση ακυρώθηκε.");
                            } else {
                                Computers userComputer = new Computers(newCode, newDesc, newPrice, newQty, userManuf, newRam, newStorage);
                                reg.getStoreInventory().add(userComputer);
                                System.out.println(" Ο υπολογιστής καταχωρήθηκε επιτυχώς!");
                                // Save data instantly on structural changes
                                saveData(reg.getStoreInventory(), reg.getManufacturerList());
                            }
                        } 
                        else if (compChoice.equals("3")) {
                            // Updated argument signature list to enable internal automatic saving
                            MenuUpdatePC(reg.getStoreInventory(), reg.getManufacturerList(), menuScanner);
                        } 
                        else if (compChoice.equals("4")) {
                            System.out.println("\nΔΙΑΓΡΑΦΗ ΥΠΟΛΟΓΙΣΤΗ ");
                            System.out.print("Εισάγετε τον κωδικό του υπολογιστή προς διαγραφή: ");
                            String deleteCode = menuScanner.nextLine().trim();
                            Product productToDelete = null;
                            
                            for (Product p : reg.getStoreInventory()) {
                                if (p instanceof Computers && p.code.equalsIgnoreCase(deleteCode)) {
                                    productToDelete = p;
                                    break; 
                                }
                            }
                            if (productToDelete != null) {
                                reg.getStoreInventory().remove(productToDelete);
                                System.out.println(" Το προϊόν διαγράφηκε με επιτυχία!");
                                // Sync deletion update with disk
                                saveData(reg.getStoreInventory(), reg.getManufacturerList());
                            } else {
                                System.out.println(" Δεν βρέθηκε υπολογιστής με αυτόν τον κωδικό."); 
                            }
                        } 
                        else if (compChoice.equals("5")) {
                            inComputerMenu = false; 
                        } else {
                            System.out.println(" Μη έγκυρη επιλογή στο υπομενού!");
                        }
                    } 
                    break;
                    
                case "2": // MOBILE PHONE MANAGEMENT SUBMENU
                    boolean inPhoneMenu = true;
                    while (inPhoneMenu) {
                        System.out.println("\n ΜΕΝΟΥ ΚΙΝΗΤΩΝ ΤΗΛΕΦΩΝΩΝ ");
                        System.out.println("1. Προβολή");
                        System.out.println("2. Προσθήκη");
                        System.out.println("3. Διόρθωση");
                        System.out.println("4. Διαγραφή");
                        System.out.println("5. Επιστροφή");
                        System.out.print("Επιλογή: ");
                                                
                        String phoneChoice = menuScanner.nextLine().trim();
                                                
                        if (phoneChoice.equals("1")) {
                            System.out.println("\nΛΙΣΤΑ ΚΙΝΗΤΩΝ ΤΗΛΕΦΩΝΩΝ ");
                            boolean found = false;
                            for (Product p : reg.getStoreInventory()) {
                                if (p instanceof MobilePhones) {
                                    System.out.println("Κωδικός: " + p.code + " | " + p.description + " | Τιμή: " + p.price + "€ | Απόθεμα: " + p.quantity);
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Δεν υπάρχουν καταχωρημένα κινητά τηλέφωνα.");
                            }
                        } 
                        else if (phoneChoice.equals("2")) {
                            System.out.println("\n ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΚΙΝΗΤΟΥ ΤΗΛΕΦΩΝΟΥ");
                            System.out.print("Κωδικός: ");
                            String newCode = menuScanner.nextLine().trim();
                            System.out.print("Λεκτικό/Περιγραφή: ");
                            String newDesc = menuScanner.nextLine();
                            
                            double newPrice = 0;
                            while (true) {
                                System.out.print("Τιμή (€): ");
                                try {
                                    newPrice = Double.parseDouble(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println(" Λάθος μορφή! Εισάγετε αριθμό."); }
                            }
                            
                            int newQty = 0;
                            while (true) {
                                System.out.print("Ποσότητα Αποθέματος: ");
                                try {
                                    newQty = Integer.parseInt(menuScanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) { System.out.println(" Λάθος μορφή! Εισάγετε ακέραιο."); }
                            }
                                                    
                            System.out.print("Ανάλυση Κάμερας: ");
                            String newCamera = menuScanner.nextLine();
                            System.out.print("Χρώμα: ");
                            String newColor = menuScanner.nextLine();
                            System.out.print("Κωδικός Κατασκευαστή (e.g. M01): ");
                            String manufCode = menuScanner.nextLine().trim();         
                            Manufacturers userManuf = reg.GetManufacturerbyCode(manufCode);
                            
                            if (userManuf == null) {
                                System.out.println("Δεν υπάρχει κατασκευαστής με αυτόν τον κωδικό! Η καταχώρηση ακυρώθηκε.");
                            } else {
                                MobilePhones userPhone = new MobilePhones(newCode, newDesc, newPrice, newQty, userManuf, newCamera, newColor);
                                reg.getStoreInventory().add(userPhone);
                                System.out.println(" Το κινητό τηλέφωνο καταχωρήθηκε επιτυχώς!");
                                // Sync addition update with disk
                                saveData(reg.getStoreInventory(), reg.getManufacturerList());
                            }
                                                    
                        } 
                        else if (phoneChoice.equals("3")) {
                            // Updated signature to pass manufacturer inventory array for saving pipeline
                            MenuUpdatePhone(reg.getStoreInventory(), reg.getManufacturerList(), menuScanner);
                        } 
                        else if (phoneChoice.equals("4")) {
                            System.out.println("\n ΔΙΑΓΡΑΦΗ ΚΙΝΗΤΟΥ ΤΗΛΕΦΩΝΟΥ ");
                            System.out.print("Εισάγετε τον κωδικό του κινητού προς διαγραφή: ");
                            String deleteCode = menuScanner.nextLine().trim();
                            Product productToDelete = null;
                            
                            for (Product p : reg.getStoreInventory()) {
                                if (p instanceof MobilePhones && p.code.equalsIgnoreCase(deleteCode)) {
                                    productToDelete = p;
                                    break; 
                                }
                            }
                            if (productToDelete != null) {
                                reg.getStoreInventory().remove(productToDelete);
                                System.out.println(" Το προϊόν διαγράφηκε με επιτυχία!");
                                // Sync deletion change to disk
                                saveData(reg.getStoreInventory(), reg.getManufacturerList());
                            } else {
                                System.out.println("Δεν βρέθηκε κινητό τηλέφωνο με αυτόν τον κωδικό.");
                            }
                        } 
                        else if (phoneChoice.equals("5")) {
                            inPhoneMenu = false; 
                        } else {
                            System.out.println(" Μη έγκυρη επιλογή στο υπομενού!");
                        }
                    } 
                    break;
                    
                case "3": // MANUFACTURER MANAGEMENT SUBMENU
                    boolean inManufMenu = true;
                    while (inManufMenu) {
                        System.out.println("\n ΜΕΝΟΥ ΚΑΤΑΣΚΕΥΑΣΤΩΝ ");
                        System.out.println("1. Προβολή");
                        System.out.println("2. Προσθήκη");
                        System.out.println("3. Διόρθωση");
                        System.out.println("4. Διαγραφή");
                        System.out.println("5. Eπιστροφή");
                        System.out.print("Επιλογή : ");
                        String manufChoice = menuScanner.nextLine().trim();
                        
                        if (manufChoice.equals("1")) {
                            System.out.println("\n ΛΙΣΤΑ ΚΑΤΑΣΚΕΥΑΣΤΩΝ");
                            for (Manufacturers m : reg.getManufacturerList()) {
                                System.out.println("Κωδικός: " + m.code + " | Επωνυμία: " + m.name + " | Email: " + m.email);
                            }
                        } 
                        else if (manufChoice.equals("2")) {
                            System.out.println("\n ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΚΑΤΑΣΚΕΥΑΣΤΗ ");
                            System.out.print("Κωδικός Κατασκευαστή: ");
                            String newManufCode = menuScanner.nextLine().trim();
                            System.out.print("Επωνυμία: ");
                            String newManufName = menuScanner.nextLine();
                            System.out.print("Email επικοινωνίας: ");
                            String newManufEmail = menuScanner.nextLine().trim();
                            
                            Manufacturers userManuf = new Manufacturers(newManufCode, newManufName, newManufEmail);
                            reg.getManufacturerList().add(userManuf);
                            System.out.println(" Ο κατασκευαστής καταχωρήθηκε επιτυχώς!");  
                            saveData(reg.getStoreInventory(), reg.getManufacturerList());
                        } 
                        else if (manufChoice.equals("3")) {
                            // Routed correctly to match the 3-parameter function signature
                            MenuUpdateManufacturer(reg.getStoreInventory(), reg.getManufacturerList(), menuScanner);
                        } 
                        else if (manufChoice.equals("4")) {
                            System.out.println("\nΔΙΑΓΡΑΦΗ ΚΑΤΑΣΚΕΥΑΣΤΗ ");
                            System.out.print("Εισάγετε τον κωδικό του κατασκευαστή προς διαγραφή: ");
                            String deleteCode = menuScanner.nextLine().trim();
                            Manufacturers manufToDelete = null;
                            
                            for (Manufacturers m : reg.getManufacturerList()) {
                                if (m.code.equalsIgnoreCase(deleteCode)) {
                                    manufToDelete = m;
                                    break;
                                }
                            }
                            if (manufToDelete != null) {
                                reg.getManufacturerList().remove(manufToDelete);
                                System.out.println(" Ο κατασκευαστής διαγράφηκε με επιτυχία!");
                                saveData(reg.getStoreInventory(), reg.getManufacturerList());
                            } else {
                                System.out.println(" Δεν βρέθηκε κατασκευαστής με αυτόν τον κωδικό.");
                            }
                        }
                        else if (manufChoice.equals("5")) {
                            inManufMenu = false; 
                        }
                        else {
                            System.out.println(" Μη έγκυρη επιλογή στο υπομενού!");
                        }
                    } 
                    break; 
                    
                case "4": // SALES MANAGEMENT AND ANALYTICS LOGIC
                    boolean inSalesMenu = true;
                    while (inSalesMenu) {
                        System.out.println("\nΛΕΙΤΟΥΡΓΙΕΣ ΠΩΛΗΣΕΩΝ & ΣΤΑΤΙΣΤΙΚΩΝ ---");
                        System.out.println("1. Πώληση Ηλεκτρονικού Υπολογιστή");
                        System.out.println("2. Πώληση Κινητού Τηλεφώνου");
                        System.out.println("3. Εμφάνιση Στατιστικών Στοιχείων Πωλήσεων");
                        System.out.println("4. Επιστροφή στο Κεντρικό Μενού");
                        System.out.print("Επιλογή: ");
                        String salesChoice = menuScanner.nextLine().trim();
                        
                        if (salesChoice.equals("1") || salesChoice.equals("2")) {
                            System.out.print("Εισάγετε τον κωδικό του προϊόντος προς πώληση: ");
                            String searchCode = menuScanner.nextLine().trim();
                            Product foundProduct = null;
                            
                            for (Product p : reg.getStoreInventory()) {
                                if (p.code.equalsIgnoreCase(searchCode)) {
                                    if (salesChoice.equals("1") && p instanceof Computers) foundProduct = p;
                                    if (salesChoice.equals("2") && p instanceof MobilePhones) foundProduct = p;
                                }
                            }
                            if (foundProduct == null) {
                                System.out.println(" Το προϊόν δεν βρέθηκε ή δεν ανήκει σε αυτή την κατηγορία.");
                            } else {
                                System.out.print("Εισάγετε ποσότητα πώλησης (Διαθέσιμο απόθεμα: " + foundProduct.quantity + "): ");
                                int qtyToBuy = 0;
                                try {
                                    qtyToBuy = Integer.parseInt(menuScanner.nextLine());
                                } catch (NumberFormatException e) { qtyToBuy = -1; }
                                
                                if (qtyToBuy <= 0) {
                                    System.out.println(" Μη έγκυρη ποσότητα.");
                                } else if (qtyToBuy > foundProduct.quantity) {
                                    System.out.println(" Ανεπαρκές απόθεμα στο κατάστημα!");
                                } else {
                                    foundProduct.quantity -= qtyToBuy;
                                    Sales newSale = new Sales(foundProduct, qtyToBuy); 
                                    salesLog.add(newSale);
                                    System.out.println(" Η πώληση ολοκληρώθηκε επιτυχώς!");
                                    System.out.println("Συνολικό Κόστος: " + newSale.getTotalAmount() + "€");
                                    // Persistent storage save because current structural stock values decreased
                                    saveData(reg.getStoreInventory(), reg.getManufacturerList());
                                }
                            }
                        } 
                        else if (salesChoice.equals("3")) {
                            System.out.println("\n Στατιστικά Στοιχεία Πωλήσεων ");
                            if (salesLog.isEmpty()) {
                                System.out.println("Δεν έχουν πραγματοποιηθεί πωλήσεις ακόμα.");
                            } else {
                                double totalEarnings = 0;
                                int computerSalesCount = 0;
                                int phoneSalesCount = 0;
                                System.out.println("\n ΙΣΤΟΡΙΚΟ ΑΠΟΔΕΙΞΕΩΝ");
                                
                                for (int i = 0; i < salesLog.size(); i++) {
                                    Sales s = salesLog.get(i);
                                    System.out.println((i + 1) + ". " + s.getProductSold().description 
                                            + " | Τεμάχια: " + s.getQuantitySold()
                                            + " | Είσπραξη: " + s.getTotalAmount() + "€");
                                     totalEarnings += s.getTotalAmount();
                                     if (s.getProductSold() instanceof Computers) computerSalesCount += s.getQuantitySold();
                                     if (s.getProductSold() instanceof MobilePhones) phoneSalesCount += s.getQuantitySold();
                                }
                                System.out.println("\nΣΤΑΤΙΣΤΙΚΑ ΑΝΑ ΚΑΤΗΓΟΡΙΑ =");
                                System.out.println(" Συνολικά Τεμάχια Υπολογιστών: " + computerSalesCount);
                                System.out.println("Συνολικά Τεμάχια Κινητών: " + phoneSalesCount);

                                System.out.println("\nΣΤΑΤΙΣΤΙΚΑ ΑΝΑ ΚΑΤΑΣΚΕΥΑΣΤΗ");
                                for (Manufacturers m : reg.getManufacturerList()) {
                                    int brandQty = 0;
                                    double brandEarnings = 0;
                                    for (Sales s : salesLog) {
                                        Product p = s.getProductSold();
                                        if (p == null) continue;
                                        String currentProductManufCode = "";
                                        if (p instanceof Computers) {
                                            Computers comp = (Computers) p;
                                            if (comp.manufacturer != null) {
                                                currentProductManufCode = comp.manufacturer.code;
                                            }
                                        } else if (p instanceof MobilePhones) {
                                            MobilePhones phone = (MobilePhones) p;
                                            if (phone.manufacturer != null) {
                                                currentProductManufCode = phone.manufacturer.code;
                                            }
                                        }
                                         
                                        if (!currentProductManufCode.isEmpty() && currentProductManufCode.equalsIgnoreCase(m.code)) {
                                            brandQty += s.getQuantitySold();
                                            brandEarnings += s.getTotalAmount();
                                        }
                                    }
                                    System.out.printf(" %s -> Πουλήθηκαν: %d τεμ. | Έσοδα: %.2f€\n", m.name, brandQty, brandEarnings);
                                }
                               System.out.printf(" Συνολικά Έσοδα Καταστήματος: %.2f€\n", totalEarnings);
                            }
                        } 
                        else if (salesChoice.equals("4")) {
                            inSalesMenu = false; 
                        } else {
                            System.out.println(" Μη έγκυρη επιλογή στο υπομενού!");
                        }
                    } 
                    break; 
                    
                case "5": // APPLICATION TERMINATION
                    System.out.println("Έξοδος από την εφαρμογή...");
                    saveData(reg.getStoreInventory(), reg.getManufacturerList());
                    System.out.println("Αντίο!");
                    running = false; 
                    break;
                    
                default:
                    System.out.println(" Μη έγκυρη επιλογή! Παρακαλώ επιλέξτε από 1 έως 5.");
            } 
        } 
        menuScanner.close();
    } 
/**
 * Ενημερώνει τα στοιχεία ενός ηλεκτρονικού υπολογιστή.
 *
 * Ο χρήστης εισάγει τον κωδικό του προϊόντος και μπορεί να
 * τροποποιήσει τα στοιχεία του. Αν κάποιο πεδίο παραμείνει κενό,
 * διατηρείται η προηγούμενη τιμή.
 *
 * @param storeInventory λίστα όλων των προϊόντων του καταστήματος
 * @param manufacturerList λίστα όλων των κατασκευαστών
 * @param menuScanner αντικείμενο Scanner για εισαγωγή δεδομένων
 */

    // COMPUTER OBJECT RECORD MODIFICATION METHOD
    private static void MenuUpdatePC(ArrayList<Product> storeInventory, ArrayList<Manufacturers> manufacturerList, Scanner menuScanner) {
        System.out.println("\n ΔΙΟΡΘΩΣΗ ΚΑΡΤΕΛΑΣ ΥΠΟΛΟΓΙΣΤΗ ");
        System.out.print("Εισάγετε τον Κωδικό του υπολογιστή προς διόρθωση: ");
        String searchCode = menuScanner.nextLine().trim();

        Computers tmp = null;
        for (Product p : storeInventory) {
            if (p instanceof Computers && p.code.equalsIgnoreCase(searchCode)) {
                tmp = (Computers) p;
                break;
            }
        }

        if (tmp == null) {
            System.out.println(" Δεν υπάρχει τέτοιο PC στην αποθήκη!");
            return;
        }

        System.out.println("\n(Πιέστε απλά [Enter] αν δεν θέλετε να αλλάξετε κάποιο πεδίο)");

        System.out.print(" Περιγραφή -> Παλαιά: " + tmp.description + " | Νέα: ");
        String newDesc = menuScanner.nextLine();
        if (!newDesc.trim().isEmpty()) tmp.description = newDesc;

        System.out.print(" Τιμή -> Παλαιά: " + tmp.price + "€ | Νέα: ");
        String newPriceStr = menuScanner.nextLine();
        if (!newPriceStr.trim().isEmpty()) tmp.price = Double.parseDouble(newPriceStr);

        System.out.print(" Απόθεμα -> Παλαιό: " + tmp.quantity + " | Νέο: ");
        String newQtyStr = menuScanner.nextLine();
        if (!newQtyStr.trim().isEmpty()) tmp.quantity = Integer.parseInt(newQtyStr);

        System.out.print(" RAM (GB) -> Παλαιά: " + tmp.ram + " | Νέα: ");
        String newRamStr = menuScanner.nextLine();
        if (!newRamStr.trim().isEmpty()) tmp.ram = Integer.parseInt(newRamStr);

        System.out.print(" Χώρος (GB) -> Παλαιός: " + tmp.storage + " | Νέος: ");
        String newStorageStr = menuScanner.nextLine();
        if (!newStorageStr.trim().isEmpty()) tmp.storage = Integer.parseInt(newStorageStr);

        System.out.println(" Η καρτέλα του υπολογιστή ενημερώθηκε επιτυχώς!");
        
        // Save execution triggered immediately to capture updates safely
        saveData(storeInventory, manufacturerList);
    }
/**
 * Ενημερώνει τα στοιχεία ενός κινητού τηλεφώνου.
 *
 * Δίνει τη δυνατότητα τροποποιησης των χαρακτηριστικών του κινητού τηλεφώνου.
 *
 * @param storeInventory λίστα προϊόντων
 * @param manufacturerList λίστα κατασκευαστών
 * @param menuScanner Scanner για εισαγωγή στοιχείων
 */
    // PHONE OBJECT RECORD MODIFICATION METHOD
    private static void MenuUpdatePhone(ArrayList<Product> storeInventory, ArrayList<Manufacturers> manufacturerList, Scanner menuScanner) {
        System.out.println("\nΔΙΟΡΘΩΣΗ ΚΑΡΤΕΛΑΣ ΚΙΝΗΤΟΥ ");
        System.out.print("Εισάγετε τον Κωδικό του κινητού προς διόρθωση: ");
        String searchCode = menuScanner.nextLine().trim();

        MobilePhones tmp = null;
        for (Product p : storeInventory) {
            if (p instanceof MobilePhones && p.code.equalsIgnoreCase(searchCode)) {
                tmp = (MobilePhones) p;
                break;
            }
        }

        if (tmp == null) {
            System.out.println(" Δεν υπάρχει τέτοιο κινητό στην αποθήκη!");
            return;
        }

        System.out.println("\n (Πιέστε απλά [Enter] αν δεν θέλετε να αλλάξετε κάποιο πεδίο)");

        System.out.print(" Περιγραφή -> Παλαιά: " + tmp.description + " | Νέα: ");
        String newDesc = menuScanner.nextLine();
        if (!newDesc.trim().isEmpty()) tmp.description = newDesc;

        System.out.print("Τιμή -> Παλαιά: " + tmp.price + "€ | Νέα: ");
        String newPriceStr = menuScanner.nextLine();
        if (!newPriceStr.trim().isEmpty()) tmp.price = Double.parseDouble(newPriceStr);

        System.out.print(" Απόθεμα -> Παλαιό: " + tmp.quantity + " | Νέο: ");
        String newQtyStr = menuScanner.nextLine();
        if (!newQtyStr.trim().isEmpty()) tmp.quantity = Integer.parseInt(newQtyStr);

        System.out.print(" Κάμερα -> Παλαιά: " + tmp.cameraRes + " | Νέα: ");
        String newCam = menuScanner.nextLine();
        if (!newCam.trim().isEmpty()) tmp.cameraRes = newCam;

        System.out.print(" Χρώμα -> Παλαιό: " + tmp.color + " | Νέο: ");
        String newColor = menuScanner.nextLine();
        if (!newColor.trim().isEmpty()) tmp.color = newColor;

        System.out.println("Η καρτέλα του κινητού ενημερώθηκε επιτυχώς!");
        
        // Save execution triggered immediately to capture updates safely
        saveData(storeInventory, manufacturerList);
    }
/**
 * Ενημερώνει τα στοιχεία ενός κατασκευαστή.
 *
 * Ο χρήστης μπορεί να τροποποιήσει την επωνυμία και
 * το email επικοινωνίας του κατασκευαστή.
 *
 * @param storeInventory λίστα προϊόντων
 * @param manufacturerList λίστα κατασκευαστών
 * @param menuScanner Scanner εισαγωγής δεδομένων
 */
    // MANUFACTURER OBJECT RECORD MODIFICATION METHOD
    private static void MenuUpdateManufacturer(ArrayList<Product> storeInventory, ArrayList<Manufacturers> manufacturerList, Scanner menuScanner) {
        System.out.println("\nΔΙΟΡΘΩΣΗ ΚΑΡΤΕΛΑΣ ΚΑΤΑΣΚΕΥΑΣΤΗ ");
        System.out.print("Εισάγετε τον Κωδικό του κατασκευαστή προς διόρθωση (π.χ. M01): ");
        String searchCode = menuScanner.nextLine().trim();

        Manufacturers tmp = null;
        for (Manufacturers m : manufacturerList) {
            if (m.code.equalsIgnoreCase(searchCode)) {
                tmp = m;
                break;
            }
        }

        if (tmp == null) {
            System.out.println(" Δεν συνεργάζεστε με αυτόν τον κατασκευαστή!");
            return;
        }

        System.out.println("\n (Πιέστε απλά [Enter] αν δεν θέλετε να αλλάξετε κάποιο πεδίο)");

        System.out.print(" Επωνυμία -> Παλαιά: " + tmp.name + " | Νέα: ");
        String newName = menuScanner.nextLine();
        if (!newName.trim().isEmpty()) tmp.name = newName;

        System.out.print(" Email -> Παλαιό: " + tmp.email + " | Νέο: ");
        String newEmail = menuScanner.nextLine();
        if (!newEmail.trim().isEmpty()) tmp.email = newEmail;

        System.out.println(" Η καρτέλα του κατασκευαστή ενημερώθηκε επιτυχώς!");
        
        saveData(storeInventory, manufacturerList);
    }
/**
 * Αποθηκεύει όλα τα δεδομένα της εφαρμογής σε αρχεία txt.
 *
 * Η μέθοδος δημιουργεί ή ενημερώνει τα αρχεία:
 *
 * manufacturers.txt</li>
 * inventory.txt</li>
 * 
 *
 * 
 *
 * @param storeInventory λίστα προϊόντων
 * @param manufacturerList λίστα κατασκευαστών
 */
 
    // FILE IO: PERSIST IN-MEMORY RUNTIME ARRAYLISTS TO TEXT FILES
    private static void saveData(ArrayList<Product> storeInventory, ArrayList<Manufacturers> manufacturerList) {
        try {
            // Write manufacturers data out line by line
            java.io.PrintWriter manufWriter = new java.io.PrintWriter(new java.io.FileWriter("manufacturers.txt"));
            for (Manufacturers m : manufacturerList) {
                manufWriter.println(m.code + "," + m.name + "," + m.email);
            }
            manufWriter.close();

            // Write inventory details tracking instances polymorphisms
            java.io.PrintWriter prodWriter = new java.io.PrintWriter(new java.io.FileWriter("inventory.txt"));
            for (Product p : storeInventory) {
                String mCode = (p instanceof Computers && ((Computers)p).manufacturer != null) ? ((Computers)p).manufacturer.code : 
                               (p instanceof MobilePhones && ((MobilePhones)p).manufacturer != null) ? ((MobilePhones)p).manufacturer.code : "null";
                               
                if (p instanceof Computers) {
                    Computers c = (Computers) p;
                    prodWriter.println("COMPUTER," + c.code + "," + c.description + "," + c.price + "," + c.quantity + "," + c.ram + "," + c.storage + "," + mCode);
                } else if (p instanceof MobilePhones) {
                    MobilePhones mp = (MobilePhones) p;
                    prodWriter.println("PHONE," + mp.code + "," + mp.description + "," + mp.price + "," + mp.quantity + "," + mp.cameraRes + "," + mp.color + "," + mCode);
                }
            }
            prodWriter.close();
            System.out.println(" Τα δεδομένα αποθηκεύτηκαν επιτυχώς στα αρχεία κειμένου!");

        } catch (java.io.IOException e) {
            System.out.println("Σφάλμα κατά την αποθήκευση δεδομένων: " + e.getMessage());
        }
    }
/**
 * Φορτώνει τα δεδομένα της εφαρμογής από τα αρχεία txt .
 *
 * 
 *
 * Μη ύπαρξη αρχείου δεν εμποδίζει την εκτέλεση της εφαρμογής.
 *
 * @param storeInventory λίστα προϊόντων
 * @param manufacturerList λίστα κατασκευαστών
 */
    // FILE IO: RECONSTRUCT RUNTIME INSTANCES FROM DISK TEXT FILES
    private static void loadData(ArrayList<Product> storeInventory, ArrayList<Manufacturers> manufacturerList) {
         java.io.File manufFile = new java.io.File("manufacturers.txt");
         if (manufFile.exists()) {
              try (Scanner fileScanner = new Scanner(manufFile)) {
                   while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] tokens = line.split(",");
                        if (tokens.length == 3) {
                             manufacturerList.add(new Manufacturers(tokens[0], tokens[1], tokens[2]));
                        }
                   }
              } catch (java.io.FileNotFoundException e) { 
                   System.out.println("Το αρχείο κατασκευαστών δεν βρέθηκε."); 
              }
         }

         java.io.File invFile = new java.io.File("inventory.txt");
         if (invFile.exists()) {
              try (Scanner fileScanner = new Scanner(invFile)) {
                   while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] tokens = line.split(",");
                        if (tokens.length >= 8) {
                             String type = tokens[0];
                             String code = tokens[1];
                             String desc = tokens[2];
                             double price = Double.parseDouble(tokens[3]);
                             int qty = Integer.parseInt(tokens[4]);
                             String mCode = tokens[7]; 

                             Manufacturers matchedManuf = null;
                             for (Manufacturers m : manufacturerList) {
                                  if (m.code.equalsIgnoreCase(mCode)) {
                                       matchedManuf = m;
                                       break;
                                  }
                             }

                             if (type.equals("COMPUTER")) {
                                  int ram = Integer.parseInt(tokens[5]);
                                  int storage = Integer.parseInt(tokens[6]);
                                  storeInventory.add(new Computers(code, desc, price, qty, matchedManuf, ram, storage));
                             } else if (type.equals("PHONE")) {
                                  String camera = tokens[5];
                                  String color = tokens[6];
                                  storeInventory.add(new MobilePhones(code, desc, price, qty, matchedManuf, camera, color));
                             }
                        }
                   }
              } catch (Exception e) { System.out.println("Σφάλμα κατά τη φόρτωση του αποθέματος: " + e.getMessage()); }
         }
    }
}