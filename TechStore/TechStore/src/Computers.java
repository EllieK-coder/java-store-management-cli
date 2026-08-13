/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Αναπαριστά έναν ηλεκτρονικό υπολογιστή του καταστήματος.
 *
 * Η κλάση επεκτείνει την πατρική κλάση  Product και περιλαμβάνει
 * επιπλέον χαρακτηριστικά που αφορούν έναν υπολογιστή, όπως
 * τον κατασκευαστή, τη μνήμη RAM και τον αποθηκευτικό χώρο.
 *
 * @author Ευαγγελία Άννα Καλοδήμου, Μερτινός Νεκτάριος
 * 
 */
public class Computers extends Product {
/** Ο κατασκευαστής του υπολογιστή. */    
    public Manufacturers manufacturer;
/** Η χωρητικότητα της μνήμης RAM σε Gigabytes (GB). */
    public int ram;
 /** Ο διαθέσιμος αποθηκευτικός χώρος σε Gigabytes (GB). */   
    public int storage;
/**
 * Δημιουργεί ένα νέο αντικείμενο το Computers.
 *
 * @param code ο μοναδικός κωδικός του προϊόντος
 * @param description η περιγραφή του pc
 * @param price η τιμή πώλησης του προϊόντος
 * @param newQuantity η διαθέσιμη ποσότητα στο απόθεμα
 * @param manufacturer ο κατασκευαστής του υπολογιστή
 * @param ram το μέγεθος της μνήμης RAM σε GB
 * @param storage ο διαθέσιμος αποθηκευτικός χώρος σε GB
 */
    public Computers(String code, String description, double price, int newQuantity, Manufacturers manufacturer, int ram, int storage) {
        super(code, description, price, newQuantity); 
        this.manufacturer = manufacturer;
        this.ram = ram;
        this.storage = storage;
    }
}