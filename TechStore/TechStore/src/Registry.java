
/**
 * Εφαρμογή Διαχείρισης Αποθέματος και Πωλήσεων Καταστήματος Ηλεκτρονικών.
 * * @author  Eυαγγελία Αννα Καλοδημου, Μεριτινός Νεκτάριος
 * @version 1.0
 * @since Ιούνιος 2026
 */



import java.util.ArrayList;

/**
 * 
 * Η κλάση Registry αποθηκεύει και διαχειρίζεται τις βασικές λίστες
 * της εφαρμογής, δηλαδή τη λίστα προϊόντων και τη λίστα κατασκευαστών.
 *
 * Παρέχει μεθόδους για:
 * επιστροφή της λίστας προϊόντων,
 *   επιστροφή της λίστας κατασκευαστών,
 *   αναζήτηση κατασκευαστή με βάση τον κωδικό,
 *   εισαγωγή αρχικών δοκιμαστικών δεδομένων.
 * 
 */
public class Registry {
    
    private ArrayList<Product> storeInventory;
    private ArrayList<Manufacturers> manufacturerList;
/**
 * Δημιουργεί ένα νέο αντικείμενο Registry.
 *
 * Αρχικοποιεί τη λίστα προϊόντων και τη λίστα κατασκευαστών
 * ως κενές λίστες τύπου ArrayList.
 */
    public Registry() {
        storeInventory = new ArrayList<>();
        manufacturerList = new ArrayList<>();
        
    }
/**
 * Επιστρέφει τη λίστα προϊόντων του καταστήματος.
 *
 */
  
    public ArrayList<Product> getStoreInventory() {
        return storeInventory;
    }
/**
 * Επιστρέφει τη λίστα των κατασκευαστών.
 *
 */
    public ArrayList<Manufacturers> getManufacturerList() {
        return manufacturerList;
    }

 /**
 * Αναζητά κατασκευαστή με βάση τον κωδικό του.
 *
 * Η αναζήτηση δεν κάνει διάκριση πεζών και κεφαλαίων γραμμάτων.
 *
 * @param searchCode ο κωδικός του κατασκευαστή που αναζητείται
 * @return το αντικείμενο Manufacturers αν βρεθεί, αλλιώς null
 */ 
    public Manufacturers GetManufacturerbyCode(String searchCode) {
        for (Manufacturers m : manufacturerList) {
            if (m.code.equalsIgnoreCase(searchCode)) {
                return m;
            }
        }
        return null;
    }
/**
 * Εισάγει αρχικά δεδομένα στην εφαρμογή.
 *
 * Η μέθοδος δημιουργεί ενδεικτικούς κατασκευαστές και προϊόντα,
 * όπως κινητό τηλέφωνο και ηλεκτρονικό υπολογιστή. Πριν την εισαγωγή
 * υπάρχει έλεγχος, ώστε να αποφύγουμε διπλές εγγραφές στις λίστες.
 */
  public void InitialData() {
        Manufacturers apple = new Manufacturers("M01", "Apple", "info@apple.com");
        Manufacturers xiaomi = new Manufacturers("M02", "Xiaomi", "info@xiaomi.com");
        Manufacturers nokia = new Manufacturers("M03", "Nokia", "info@nokia.com");
        Manufacturers dell = new Manufacturers("M04", "Dell", "info@dell.com");

        
        if (GetManufacturerbyCode(apple.code) == null) manufacturerList.add(apple);
        if (GetManufacturerbyCode(xiaomi.code) == null) manufacturerList.add(xiaomi);
        if (GetManufacturerbyCode(nokia.code) == null) manufacturerList.add(nokia);
        if (GetManufacturerbyCode(dell.code) == null) manufacturerList.add(dell);

       
        MobilePhones iphone17 = new MobilePhones("P001", "Apple iPhone 17 (8/256GB)", 999.00, 10, apple, "48MP", "Black");
        Computers dellLaptop = new Computers("C001", "Dell Pro 15 Essential", 750.00, 5, dell, 16, 512);
        
       
        boolean hasIphone = false;
        boolean hasDell = false;
        for (Product p : storeInventory) {
            if (p.code.equalsIgnoreCase("P001")) hasIphone = true;
            if (p.code.equalsIgnoreCase("C001")) hasDell = true;
        }
        
        if (!hasIphone) storeInventory.add(iphone17);
        if (!hasDell) storeInventory.add(dellLaptop);
    }
}